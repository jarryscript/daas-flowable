package com.doublechain.flowable.listener;

import org.flowable.common.engine.api.delegate.event.FlowableEngineEntityEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.engine.TaskService;
import org.flowable.engine.delegate.event.AbstractFlowableEngineEventListener;
import org.flowable.engine.delegate.event.FlowableProcessStartedEvent;
import org.flowable.engine.delegate.event.FlowableSequenceFlowTakenEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.doublechain.flowable.FlowableService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GlobalEventListener extends AbstractFlowableEngineEventListener  {
	@Autowired
	private FlowableService flowableService;

	@Override
	public void onEvent(FlowableEvent flowableEvent) {
		super.onEvent(flowableEvent);
	}

	@Override
	protected void taskAssigned(FlowableEngineEntityEvent event) {
		super.taskAssigned(event);
	}

	@Override
	protected void taskCreated(FlowableEngineEntityEvent event) {
		super.taskCreated(event);
	}

	@Override
	protected void taskCompleted(FlowableEngineEntityEvent event) {
		super.taskCompleted(event);
		String executionId = event.getExecutionId();
		TaskService taskService = getFlowableService().getProcessEngine().getTaskService();

	}


	@Override
	protected void processStarted(FlowableProcessStartedEvent event) {
		super.processStarted(event);
	}

	@Override
	protected void sequenceFlowTaken(FlowableSequenceFlowTakenEvent event) {
		super.sequenceFlowTaken(event);
		String sourceActivityId = event.getSourceActivityId();
		String sourceActivityName = event.getSourceActivityName();
		String sourceActivityType = event.getSourceActivityType();

		String targetActivityId = event.getTargetActivityId();
		String targetActivityName = event.getTargetActivityName();
		String targetActivityType = event.getTargetActivityType();
		System.out.println();
		System.out.println("✅✅✅从");
		System.out.println(sourceActivityType+":"+sourceActivityName+":"+sourceActivityId);
		System.out.println("✅✅✅到");
		System.out.println(targetActivityType+":"+targetActivityName+":"+targetActivityId);
		System.out.println("的检查");
		System.out.println();
	}





}
