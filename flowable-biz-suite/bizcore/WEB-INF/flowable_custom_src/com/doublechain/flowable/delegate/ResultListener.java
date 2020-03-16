package com.doublechain.flowable.delegate;

import org.apache.commons.lang3.BooleanUtils;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;

public class ResultListener implements TaskListener {

	@Override
	public void notify(DelegateTask delegateTask) {
		boolean agree = BooleanUtils.isTrue((Boolean) delegateTask.getVariableLocal("userAgree"));
		Object variable = delegateTask.getVariable("agree");

		boolean result = Boolean.TRUE==variable||variable==null;
			delegateTask.setVariable("agree",result&&agree);

		System.out.println("✅✅✅"+delegateTask.getAssignee()+"验收结果: "+agree);
	}

}
