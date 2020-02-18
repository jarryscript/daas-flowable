package com.doublechain.flowable;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.doublechain.flowable.role.Role;
import com.doublechain.flowable.user.User;

public class CustomFlowableUserContextImpl extends FlowableBizUserContextImpl{
	private FlowableService flowableService;
	
	private User currentUserInfo;
	private String applicationForm;
	

	public String getApplicationForm() {
		return applicationForm;
	}

	public void setApplicationForm(String applicationForm) {
		this.applicationForm = applicationForm;
	}

	public User getCurrentUserInfo() {
		return currentUserInfo;
	}

	public void setCurrentUserInfo(User currentUserInfo) {
		this.currentUserInfo = currentUserInfo;
	}
	
	
	
	
	public FlowableService getFlowableService() {
		return flowableService;
	}

	public void setFlowableService(FlowableService flowableService) {
		this.flowableService = flowableService;
	}

	public String getCurrentRole() {
		return Optional.ofNullable(getCurrentUserInfo()).map(User::getRole).map(Role::getId).orElse(Role.EMPLOYEE);
	}
	
	public boolean is(String role) {
		return StringUtils.equals(getCurrentRole(),role);
	}
	

}

