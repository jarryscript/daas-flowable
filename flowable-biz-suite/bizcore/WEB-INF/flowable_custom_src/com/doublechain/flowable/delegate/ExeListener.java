package com.doublechain.flowable.delegate;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;
import org.flowable.engine.impl.persistence.entity.ExecutionEntityImpl;

public class ExeListener implements ExecutionListener {

	@Override
	public void notify(DelegateExecution execution) {
		ExecutionEntityImpl impl = (ExecutionEntityImpl) execution;
		System.out.println(impl.getVariables());
	}

}
