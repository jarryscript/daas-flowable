package com.doublechain.flowable;

public interface FlowableUserContext extends UserContext{
    //define the domain specific user model
	String getLocaleKey(String subject);
	void setChecker(FlowableObjectChecker checker);
	FlowableObjectChecker getChecker();

	void saveAccessInfo(String beanName, String methodName, Object[] parameters);
	void addFootprint(FootprintProducer helper) throws Exception;
	Object getPreviousViewPage() throws Exception;
	Object getLastViewPage() throws Exception;
	Object goback() throws Exception;
}

