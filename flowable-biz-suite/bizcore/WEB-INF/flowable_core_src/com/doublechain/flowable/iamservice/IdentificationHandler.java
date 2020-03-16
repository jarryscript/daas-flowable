package com.doublechain.flowable.iamservice;

import com.doublechain.flowable.FlowableUserContext;

public interface IdentificationHandler {

	/** 完成认证 */
	LoginResult authenticate(FlowableUserContext userContext, LoginContext loginContext);
	/** 绑定用户 */
	void bindWithSecUser(FlowableUserContext userContext, LoginContext loginContext) throws Exception;
}







