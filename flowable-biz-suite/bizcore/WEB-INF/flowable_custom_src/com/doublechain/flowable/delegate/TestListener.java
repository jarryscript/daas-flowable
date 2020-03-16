package com.doublechain.flowable.delegate;

import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;

public class TestListener implements TaskListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask delegateTask) {
		// TODO Auto-generated method stub
		System.out.println("✅✅✅"+delegateTask.getAssignee());

	}

}
