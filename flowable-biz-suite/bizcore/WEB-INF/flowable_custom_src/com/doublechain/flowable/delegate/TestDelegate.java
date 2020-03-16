package com.doublechain.flowable.delegate;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class TestDelegate implements JavaDelegate {
	private String test;



	public String getTest() {
		return test;
	}



	public void setTest(String test) {
		this.test = test;
	}



	@Override
	public void execute(DelegateExecution execution) {
		System.out.println("✅✅✅"+test);
	}

}
