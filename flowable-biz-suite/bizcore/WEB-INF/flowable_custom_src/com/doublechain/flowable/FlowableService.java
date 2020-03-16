package com.doublechain.flowable;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.flowable.common.engine.impl.identity.Authentication;
import org.flowable.content.engine.ContentEngine;
import org.flowable.dmn.engine.DmnEngine;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.idm.engine.IdmEngine;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.MapUtil;

import lombok.Getter;
import lombok.Setter;

/**
 * 提供Flowable的常用接口， 包括 Task Process
 *
 * @author jarryzhou
 *
 */
@Getter
@Setter
public class FlowableService extends CustomFlowableCheckerManager {

	@Autowired
	private ProcessEngine processEngine;

	@Autowired
	private ContentEngine contentEngine;

	@Autowired
	private IdmEngine idmEngine;
	@Autowired
	private org.flowable.form.engine.FormEngine formEngine;

	@Autowired
	private DmnEngine dmnEngine;

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters) throws IllegalAccessException {
		return null;//TODO
	}

	public List<Task> getTasks(String assineeId) {
		return getProcessEngine().getTaskService().createTaskQuery().taskCandidateOrAssigned(assineeId).list();
	}

	public Object startProcess(CustomFlowableUserContextImpl ctx, String processDefinitionKey, String formData) throws FlowableException, IOException {
		ProcessDefinition processDef = getProcessEngine()
				.getRepositoryService()
					.createProcessDefinitionQuery()
					.processDefinitionKey(processDefinitionKey)
					.latestVersion()
					.singleResult();
		if (processDef == null) {
			throw new FlowableException("找不到流程定义:" + processDefinitionKey);
		}
		Map<String, Object> params = new ObjectMapper().readValue(formData, new TypeReference<Map<String, Object>>() {
		});
		Optional.ofNullable(params).ifPresent(p->p.put("userContext", ctx));
		try {
			Authentication.setAuthenticatedUserId(ctx.getCurrentUserInfo().getId());
			ProcessInstance startProcessInstanceByKey = getProcessEngine().getRuntimeService().startProcessInstanceByKey(processDefinitionKey, params);
			return getProcessInfo(startProcessInstanceByKey);
		} finally {
			Authentication.setAuthenticatedUserId(null);
		}
	}

	protected Object getProcessInfo(ProcessInstance process) {
		if (process == null) {
			return null;
		}
		TaskService taskService = getProcessEngine().getTaskService();
		List<Task> activeTasks = taskService.createTaskQuery().processInstanceId(process.getId()).active().list();
		List<Map<String, String>> tasks = Collections.emptyList();
		if (activeTasks != null && !activeTasks.isEmpty()) {
			tasks = activeTasks
					.stream()
						.map(t -> MapUtil.put("id", t.getId()).put("任务名", t.getName()).put("分配人:", t.getAssignee()).into_map(String.class))
						.collect(Collectors.toList());
		}
		return MapUtil

				.put("名称", process.getDescription())

					.put("当前进行中的任务:", tasks)
					.put("流程ID:", process.getId())
					.into_map();
	}

	public Object getStatus(CustomFlowableUserContextImpl ctx) {
		return getProcessEngine().getRuntimeService().createProcessInstanceQuery().active().list().stream().map(this::getProcessInfo).collect(Collectors.toList());
	}

	public ProcessEngine getProcessEngine() {
		return processEngine;
	}

	public void setProcessEngine(ProcessEngine processEngine) {
		this.processEngine = processEngine;
	}

}
