package com.doublechain.flowable.delegate;

import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;


/**
 * 只许成功
 * 不许失败
 * @author jarryzhou
 *
 */
public class MustApproveTaskListener implements TaskListener {
	private String localVariableName;
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask delegateTask) {
		Object result = delegateTask.getVariableLocal(getLocalVariableName());
		
	}

	public String getLocalVariableName() {
		return localVariableName;
	}

	public void setLocalVariableName(String localVariableName) {
		this.localVariableName = localVariableName;
	}
	
	

}
