package com.doublechain.flowable;

public class FlowableListOfViewScope extends BaseFlowableListOfViewScope {

	protected static FlowableListOfViewScope instance = new FlowableListOfViewScope();
	static {
		instance.initAllViewScope();
	}
	public static FlowableListOfViewScope getInstance() {
		return instance;
	}
}






