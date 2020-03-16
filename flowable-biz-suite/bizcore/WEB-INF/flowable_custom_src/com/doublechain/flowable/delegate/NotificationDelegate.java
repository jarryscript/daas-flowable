package com.doublechain.flowable.delegate;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class NotificationDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) {
		System.out.println();
		System.out.println("✅✅✅模拟发送工程验收通知给"+execution.getVariable("auditors"));
		System.out.println();
		execution.setVariable("auditors", execution.getVariable("auditors"));
	}

}
