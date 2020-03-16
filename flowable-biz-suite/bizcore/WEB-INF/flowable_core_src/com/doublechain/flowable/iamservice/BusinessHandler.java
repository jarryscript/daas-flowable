package com.doublechain.flowable.iamservice;

import com.doublechain.flowable.FlowableUserContext;

public interface BusinessHandler {

	void onAuthenticationFailed(FlowableUserContext userContext, LoginContext loginContext, LoginResult loginResult,
			IdentificationHandler idHandler, BusinessHandler bizHandler) throws Exception;

	void onAuthenticateNewUserLogged(FlowableUserContext userContext, LoginContext loginContext, LoginResult loginResult,
			IdentificationHandler idHandler, BusinessHandler bizHandler) throws Exception;

	void onAuthenticateUserLogged(FlowableUserContext userContext, LoginContext loginContext, LoginResult loginResult,
			IdentificationHandler idHandler, BusinessHandler bizHandler) throws Exception;

}







