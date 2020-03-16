package com.doublechain.flowable.delegate;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class AuditResultDelegate  implements JavaDelegate{

	public void dealWithSuccess(DelegateExecution execution) {
		
		System.out.println("✅✅✅流程结束，验收通过");
	}
	
	
	public void dealWithFailure(DelegateExecution execution) {
		System.out.println("✅✅✅流程结束，验收不通过");
	}


	@Override
	public void execute(DelegateExecution execution) {
	}

}
