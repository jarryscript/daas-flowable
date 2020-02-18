package com.doublechain.flowable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.terapico.caf.form.ImageInfo;
import com.terapico.utils.DebugUtil;

public class BaseFlowableFormProcessor extends BaseFormProcessor{
	protected FlowableUserContext userContext;
	
	public FlowableUserContext getUserContext() {
		return userContext;
	}
	public void setUserContext(FlowableUserContext userContext) {
		this.userContext = userContext;
	}
	protected void addMessageToException(FlowableException e, String msg) {
		Message message = new Message();
		message.setBody(msg);
		e.addErrorMessage(message);
	}
	public Map<String, Object> mapToUiForm(FlowableUserContext userContext) {
		return null; 
	}
}





















