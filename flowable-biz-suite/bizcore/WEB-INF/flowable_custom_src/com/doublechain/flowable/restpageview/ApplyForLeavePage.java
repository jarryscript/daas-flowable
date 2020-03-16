package com.doublechain.flowable.restpageview;

import org.flowable.engine.form.StartFormData;
import org.flowable.engine.repository.ProcessDefinition;

import com.doublechain.flowable.BaseViewPage;
import com.doublechain.flowable.CustomFlowableUserContextImpl;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.FlowableViewScope;
import com.terapico.caf.viewpage.SerializeScope;

public class ApplyForLeavePage extends BaseViewPage {
	private static final long serialVersionUID = 1L;
	private static FlowableViewScope ViewScope = FlowableViewScope.getInstance();
	protected static final SerializeScope SCOPE = SerializeScope
			.INCLUDE()
				.field("title")
				.field("popup")
				.field("toast", SerializeScope.EXCLUDE())
				.field("refreshAction")
				.field("actions", SerializeScope.EXCLUDE())
				.field("actionList").field("form");

	@Override
	protected SerializeScope getSerializeScope() {
		return SCOPE;
	}

	@Override
	public String getPageTitle() {
		if (pageTitle == null) {
			return "apply for leave";
		}
		return pageTitle;
	}

	@Override
	public void assemblerContent(FlowableUserContext userContext, String requestName) throws Exception {
		CustomFlowableUserContextImpl ctx = (CustomFlowableUserContextImpl) userContext;
		setPageTitle("请假");
		org.flowable.engine.FormService formService = ctx.getFlowableService().getProcessEngine().getFormService();
//		FormRepositoryService formRepositoryService = ctx.getFlowableService().getFormEngine().getFormRepositoryService();
		ProcessDefinition processDef = ctx.getFlowableService().getProcessEngine().getRepositoryService().createProcessDefinitionQuery().processDefinitionKey("applyForLeave").latestVersion().singleResult();
		StartFormData form = formService.getStartFormData(processDef.getId());

//		FormInfo info = formRepositoryService.getFormModelByKey(form.getFormKey());
//		FormModel formModel = info.getFormModel();
//		set("form",formModel);
	}
}
