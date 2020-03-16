package com.doublechain.flowable;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.flowable.bpmn.model.BaseElement;
import org.flowable.bpmn.model.FieldExtension;
import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.ImplementationType;
import org.flowable.bpmn.model.ServiceTask;
import org.flowable.editor.language.json.converter.BaseBpmnJsonConverter;
import org.flowable.editor.language.json.converter.ServiceTaskJsonConverter;
import org.flowable.editor.language.json.model.ModelInfo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class EventFlowTaskJsonConverter extends ServiceTaskJsonConverter {
	public static final String EVENT_FOW_TASK_NAME = "EventFlowTask";

	public static void fillCustomJsonTypes(Map<String, Class<? extends BaseBpmnJsonConverter>> convertersToBpmnMap) {
		convertersToBpmnMap.put(EVENT_FOW_TASK_NAME, EventFlowTaskJsonConverter.class);
	}

	public static void fillBpmnTypes(Map<Class<? extends BaseElement>, Class<? extends BaseBpmnJsonConverter>> convertersToJsonMap) {
		convertersToJsonMap.put(EventFlowTask.class, EventFlowTaskJsonConverter.class);
	}

	@Override
	protected String getStencilId(BaseElement baseElement) {
		return EVENT_FOW_TASK_NAME;
	}

	@Override
	protected void convertElementToJson(ObjectNode propertiesNode, BaseElement baseElement) {
		EventFlowTask serviceTask = (EventFlowTask) baseElement;

		if (ImplementationType.IMPLEMENTATION_TYPE_CLASS.equals(serviceTask.getImplementationType())) {
			propertiesNode.put(PROPERTY_SERVICETASK_CLASS, serviceTask.getImplementation());
		} else if (ImplementationType.IMPLEMENTATION_TYPE_EXPRESSION.equals(serviceTask.getImplementationType())) {
			propertiesNode.put(PROPERTY_SERVICETASK_EXPRESSION, serviceTask.getImplementation());
		} else if (ImplementationType.IMPLEMENTATION_TYPE_DELEGATEEXPRESSION.equals(serviceTask.getImplementationType())) {
			propertiesNode.put(PROPERTY_SERVICETASK_DELEGATE_EXPRESSION, serviceTask.getImplementation());
		}

		if (StringUtils.isNotEmpty(serviceTask.getResultVariableName())) {
			propertiesNode.put(PROPERTY_SERVICETASK_RESULT_VARIABLE, serviceTask.getResultVariableName());
		}

		// 使用本地结果变量
		propertiesNode.put(PROPERTY_SERVICETASK_USE_LOCAL_SCOPE_FOR_RESULT_VARIABLE, true);

		addFieldExtensions(serviceTask.getFieldExtensions(), propertiesNode);
	}

	@Override
	protected FlowElement convertJsonToElement(JsonNode elementNode, JsonNode modelNode, Map<String, JsonNode> shapeMap) {
		ServiceTask task = new ServiceTask();

		task.setImplementationType(ImplementationType.IMPLEMENTATION_TYPE_EXPRESSION);
		task.setImplementation(getPropertyValueAsString(PROPERTY_SERVICETASK_EXPRESSION, elementNode));
		task.setResultVariableName(getPropertyValueAsString(PROPERTY_SERVICETASK_RESULT_VARIABLE, elementNode));
		task.setUseLocalScopeForResultVariable(true);


		JsonNode fieldsNode = getProperty(PROPERTY_SERVICETASK_FIELDS, elementNode);
		if (fieldsNode != null) {
			JsonNode itemsArrayNode = fieldsNode.get("fields");
			if (itemsArrayNode != null) {
				for (JsonNode itemNode : itemsArrayNode) {
					JsonNode nameNode = itemNode.get(PROPERTY_SERVICETASK_FIELD_NAME);
					if (nameNode != null && StringUtils.isNotEmpty(nameNode.asText())) {
						FieldExtension field = new FieldExtension();
						field.setFieldName(nameNode.asText());
						if (StringUtils.isNotEmpty(getValueAsString(PROPERTY_SERVICETASK_FIELD_STRING_VALUE, itemNode))) {
							field.setStringValue(getValueAsString(PROPERTY_SERVICETASK_FIELD_STRING_VALUE, itemNode));
						} else if (StringUtils.isNotEmpty(getValueAsString(PROPERTY_SERVICETASK_FIELD_STRING, itemNode))) {
							field.setStringValue(getValueAsString(PROPERTY_SERVICETASK_FIELD_STRING, itemNode));
						} else if (StringUtils.isNotEmpty(getValueAsString(PROPERTY_SERVICETASK_FIELD_EXPRESSION, itemNode))) {
							field.setExpression(getValueAsString(PROPERTY_SERVICETASK_FIELD_EXPRESSION, itemNode));
						}
						task.getFieldExtensions().add(field);
					}
				}
			}
		}
		return task;
	}

	@Override
	protected void setPropertyFieldValue(String name, ServiceTask task, ObjectNode propertiesNode) {
		for (FieldExtension extension : task.getFieldExtensions()) {
			if (name.substring(8).equalsIgnoreCase(extension.getFieldName())) {
				if (StringUtils.isNotEmpty(extension.getStringValue())) {
					setPropertyValue(name, extension.getStringValue(), propertiesNode);
				} else if (StringUtils.isNotEmpty(extension.getExpression())) {
					setPropertyValue(name, extension.getExpression(), propertiesNode);
				}
			}
		}
	}

	@Override
	protected void setPropertyFieldValue(String propertyName, String fieldName, ServiceTask task, ObjectNode propertiesNode) {
		for (FieldExtension extension : task.getFieldExtensions()) {
			if (fieldName.equalsIgnoreCase(extension.getFieldName())) {
				if (StringUtils.isNotEmpty(extension.getStringValue())) {
					setPropertyValue(propertyName, extension.getStringValue(), propertiesNode);
				} else if (StringUtils.isNotEmpty(extension.getExpression())) {
					setPropertyValue(propertyName, extension.getExpression(), propertiesNode);
				}
			}
		}
	}

	@Override
	public void setDecisionTableKeyMap(Map<String, ModelInfo> decisionTableKeyMap) {
		this.decisionTableKeyMap = decisionTableKeyMap;
	}
}
