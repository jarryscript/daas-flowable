package com.doublechain.flowable.restpageview;

import com.terapico.caf.viewpage.SerializeScope;
import com.doublechain.flowable.BaseViewPage;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.CustomFlowableUserContextImpl;
import com.doublechain.flowable.FlowableViewScope;

public class PendingOnMyApprovalPage extends BaseViewPage{
	private static final long serialVersionUID = 1L;
	private static FlowableViewScope ViewScope = FlowableViewScope.getInstance();
	protected static final SerializeScope SCOPE = SerializeScope.INCLUDE()
			.field("title")
			.field("popup")
			.field("toast", SerializeScope.EXCLUDE())
			.field("refreshAction")
			.field("actions", SerializeScope.EXCLUDE())
			.field("actionList")
			;
	@Override
	protected SerializeScope getSerializeScope() {
		return SCOPE;
	}

	public String getPageTitle() {
		if (pageTitle == null) {
			return "pending on my approval";
		}
		return pageTitle;
	}
	@Override
	public void assemblerContent(FlowableUserContext userContext, String requestName)throws Exception {
		CustomFlowableUserContextImpl ctx = (CustomFlowableUserContextImpl)userContext;
		// TODO: 需要实现
		setPageTitle("尚未实现");
	}
}
