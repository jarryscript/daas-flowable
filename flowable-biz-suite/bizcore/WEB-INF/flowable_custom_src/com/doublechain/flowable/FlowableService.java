package com.doublechain.flowable;

import java.util.List;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;

public class FlowableService extends CustomFlowableCheckerManager {

	private ProcessEngine processEngine;
	
	
	public List<Task> getTasks(String assineeId) {
		return getProcessEngine().getTaskService().createTaskQuery().taskAssignee(assineeId).list();
	}
	
	
	public String startProcess(String processDefinitionId) {
		return getProcessEngine().getRuntimeService().startProcessInstanceById(processDefinitionId).getId();
	}
	
	

	public ProcessEngine getProcessEngine() {;
		return processEngine;
	}

	public void setProcessEngine(ProcessEngine processEngine) {
		this.processEngine = processEngine;
	}

}
