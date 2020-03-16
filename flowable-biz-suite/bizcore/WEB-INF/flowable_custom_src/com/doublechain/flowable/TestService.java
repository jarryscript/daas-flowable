package com.doublechain.flowable;

import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.Task;
import org.flowable.engine.impl.persistence.entity.ExecutionEntityImpl;
import org.flowable.engine.runtime.Execution;

public class TestService {
	public void checkCanDoReturnInkDeed(Execution e) {
		ExecutionEntityImpl impl = (ExecutionEntityImpl) e;
		FlowElement currentFlowElement = impl.getCurrentFlowElement();
		if(currentFlowElement instanceof Task) {
			Task t = (Task) currentFlowElement;
		}
		System.out.println("checkCanDoReturnInkDeed");
		System.out.println("checkCanDoReturnInkDeed");
		System.out.println("checkCanDoReturnInkDeed");

	}


	public void returnInkDeed(Execution e) {
		System.out.println("returnInkDeed");
		System.out.println("returnInkDeed");
		System.out.println("returnInkDeed");
	}


	public void checkCanDoReturnBuyerMoney(Execution e) {
		System.out.println("checkCanDoReturnBuyerMoney");
		System.out.println("checkCanDoReturnBuyerMoney");
		System.out.println("checkCanDoReturnBuyerMoney");

	}


	public void returnBuyerMoney(Execution e) {
		System.out.println("returnBuyerMoney");
		System.out.println("returnBuyerMoney");
		System.out.println("returnBuyerMoney");
	}


	public void checkCanDoSellerDefaultConfirmed(Execution e) {
		System.out.println("checkCanDoSellerDefaultConfirmed");
		System.out.println("checkCanDoSellerDefaultConfirmed");
		System.out.println("checkCanDoSellerDefaultConfirmed");
	}
}
