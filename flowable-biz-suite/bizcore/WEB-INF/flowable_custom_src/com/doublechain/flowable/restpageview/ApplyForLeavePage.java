package com.doublechain.flowable.restpageview;

import com.terapico.caf.viewpage.SerializeScope;
import com.doublechain.flowable.BaseFormProcessor;
import com.doublechain.flowable.BaseViewPage;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.CustomFlowableUserContextImpl;
import com.doublechain.flowable.FlowableCustomConstants;
import com.doublechain.flowable.FlowableViewScope;
import com.doublechain.flowable.rest.RestViewBizService;

public class ApplyForLeavePage extends BaseViewPage{
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
			return "apply for leave";
		}
		return pageTitle;
	}
	@Override
	public void assemblerContent(FlowableUserContext userContext, String requestName)throws Exception {
		CustomFlowableUserContextImpl ctx = (CustomFlowableUserContextImpl)userContext;
		String processInstanceId = ctx.getFlowableService().startProcess(FlowableCustomConstants.PROCESS_APPLY_FOR_LEAVE);
		setPageTitle("请假");
		BaseFormProcessor baseFormProcessor = new BaseFormProcessor();
		baseFormProcessor.addAction("提交申请", "submit", RestViewBizService.makeSubmitApplicationUrl(ctx, null));
		set("form",null);
	}
}
