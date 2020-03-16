package com.doublechain.flowable;

import java.util.Map;

import org.flowable.editor.language.json.converter.BaseBpmnJsonConverter;
import org.flowable.editor.language.json.converter.SequenceFlowJsonConverter;

public class EventSequenceFlowJsonConverter extends SequenceFlowJsonConverter {
	public static final String EVENT_SEQUENCE_FLOW_NAME="EventSequenceFlow";
	public static void fillCustomJsonTypes(Map<String, Class<? extends BaseBpmnJsonConverter>> convertersToBpmnMap) {
		convertersToBpmnMap.put(EVENT_SEQUENCE_FLOW_NAME, EventSequenceFlowJsonConverter.class);
	}

}
