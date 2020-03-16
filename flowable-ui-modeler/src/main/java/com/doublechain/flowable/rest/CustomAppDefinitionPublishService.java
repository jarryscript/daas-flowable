package com.doublechain.flowable.rest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.flowable.bpmn.model.BpmnModel;
import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.FlowNode;
import org.flowable.bpmn.model.Process;
import org.flowable.bpmn.model.SequenceFlow;
import org.flowable.bpmn.model.StartEvent;
import org.flowable.engine.TaskService;
import org.flowable.idm.api.User;
import org.flowable.ui.common.properties.FlowableCommonAppProperties;
import org.flowable.ui.modeler.domain.Model;
import org.flowable.ui.modeler.properties.FlowableModelerAppProperties;
import org.flowable.ui.modeler.service.AppDefinitionPublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import cla.edg.Utils;
import cla.edg.eventscript.EventInfo;
import cla.edg.eventscript.EventProcessResultBranch;
import cla.edg.eventscript.EventScript;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomAppDefinitionPublishService extends AppDefinitionPublishService {

	@Value("codegen.template")
	private String template;

	@Autowired
	private TaskService taskService;

	public CustomAppDefinitionPublishService(FlowableCommonAppProperties properties, FlowableModelerAppProperties modelerAppProperties) {
		super(properties, modelerAppProperties);
	}

	@Override
	public void publishAppDefinition(String comment, Model model, User user) {
		if (isCodeGenModel(model)) {
			try {
				generateCode(model);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			super.publishAppDefinition(comment, model, user);
		}
	}

	protected void generateCode(Model model) throws IOException {
		Map<String, Object> data = buildData(model);
		EventScript script = (EventScript) data.get("script");
		File outputFile = new File(new File(script.output_base_folder()), Utils.packageNameToPath("com.terapico.test.") + "/Base" + "test.java");
		System.out.println("Write to " + outputFile.getCanonicalPath());
		try (Writer out = new FileWriter(outputFile)) {
			loadTemplate().process(data, out);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Map<String, Object> buildData(Model model) {
		String description = model.getDescription();
		String[] splited = description.split("|");

		String projectName = splited[0];
		String basePackage = splited[1];
		String outputDir = splited[2];

		EventScript result = new EventScript();
		result.setBussinessName(projectName);
		result.base_on().output_base_folder(outputDir).base_package_name(basePackage).project_name(projectName);

		String packageName = basePackage + "." + Utils.toCamelCase(result.getBussinessName()).toLowerCase();
		String className = "Base" + Utils.toCamelCase(result.getBussinessName()) + "Service";

		List<Model> models = modelRepository.findByParentModelId(model.getId());
		Model m = models.get(0);
		BpmnModel bpmnModel = modelService.getBpmnModel(m);

		Process process = bpmnModel.getProcesses().get(0);
		List<StartEvent> startEvents = process.findFlowElementsOfType(StartEvent.class);
		StartEvent startEvent = startEvents.get(0);
		EventScript script = dealWithElement(result, bpmnModel, startEvent);

		Map<String, Object> data = new HashMap<>();
		data.put("base_package", packageName);
		data.put("package", packageName);
		data.put("project_name", "test");
		data.put("class_name", className);
		data.put("context_name", Utils.toCamelCase(projectName) + "UserContext");
		data.put("custom_context_name", "Custom" + Utils.toCamelCase(projectName) + "UserContextImpl");
		data.put("script", script);
		data.put("NAMING", new Utils());
		data.put("helper", new EventScriptGeneratorHelper());
		return data;
	}

	protected EventScript dealWithElement(EventScript result, BpmnModel model, FlowNode node) {
		List<SequenceFlow> outgoingFlows = node.getOutgoingFlows();
		if (outgoingFlows == null || outgoingFlows.isEmpty()) {
			result.setInternalEvent(true);
			result.on_event(node.getName());
			return result;
		}
		result.setInternalEvent(false);
		result.on_event(node.getName());
		if (outgoingFlows.size() == 1) {
			FlowElement target = model.getFlowElement(outgoingFlows.get(0).getTargetRef());
			dealWithElement(result, model, (FlowNode) target);
		} else {
			outgoingFlows.forEach(flow -> {
				if(flow.getName()!=null&&!!flow.getName().isEmpty()) {
					result.when(flow.getName());
				}else {
					result.when_others();
				}
				FlowElement target = model.getFlowElement(outgoingFlows.get(0).getTargetRef());
				dealWithElement(result, model, (FlowNode) target);
			});
		}
		return result;
	}

	protected Template loadTemplate() throws IOException {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
		cfg.setDefaultEncoding("utf-8");
		String path = getClass().getResource(getTemplate()).getFile();
		cfg.setDirectoryForTemplateLoading(new File(path));
		return cfg.getTemplate(null);
	}

	protected boolean isCodeGenModel(Model model) {
		return model.getModelType().intValue() == 98;
	}

	public class EventScriptGeneratorHelper {
		public Collection<EventProcessResultBranch> getAllBranch(EventInfo event) {
			return Optional.ofNullable(event).map(EventInfo::getBranches).map(Map::values).orElse(Collections.emptySet());
		}
	}

}
