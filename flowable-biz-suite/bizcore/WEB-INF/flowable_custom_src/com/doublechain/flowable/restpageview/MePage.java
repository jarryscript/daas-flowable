package com.doublechain.flowable.restpageview;

import com.terapico.caf.viewpage.SerializeScope;

import java.util.List;

import org.flowable.task.api.Task;

import com.doublechain.flowable.BaseViewPage;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.CustomFlowableUserContextImpl;
import com.doublechain.flowable.FlowableViewScope;
import com.doublechain.flowable.SmartList;
import com.doublechain.flowable.leaverecord.LeaveRecord;
import com.doublechain.flowable.leaverecord.LeaveRecordTokens;
import com.doublechain.flowable.role.Role;

public class MePage extends BaseViewPage {
	private static final long serialVersionUID = 1L;
	protected static final SerializeScope SCOPE = SerializeScope
			.INCLUDE()
				.field("title")
				.field("popup")
				.field("toast", SerializeScope.EXCLUDE())
				.field("refreshAction")
				.field("actions", SerializeScope.EXCLUDE())
				.field("actionList");

	@Override
	protected SerializeScope getSerializeScope() {
		return SCOPE;
	}

	@Override
	public String getPageTitle() {
		if (pageTitle == null) {
			return "me";
		}
		return pageTitle;
	}

	@Override
	protected void afterDoRendering() {
		super.afterDoRendering();
		userContext.forceResponseXClassHeader("com.terapico.appview.MePage");
	}

	@Override
	public void assemblerContent(FlowableUserContext userContext, String requestName) throws Exception {
//		CustomFlowableUserContextImpl ctx = (CustomFlowableUserContextImpl) userContext;
//		setPageTitle("主页");
//		if (ctx.is(Role.BOSS) || ctx.is(Role.MANAGER)) {
//			assembleApprovals(ctx);
//		}
//		assembleMyApplications(ctx);
	}

	protected void assembleMyApplications(CustomFlowableUserContextImpl ctx) {
		SmartList<LeaveRecord> leaveRecords = ctx.getDAOGroup().getLeaveRecordDAO().findLeaveRecordByUser(ctx.getCurrentUserInfo().getId(), LeaveRecordTokens.all());

		set("leaveRecords", leaveRecords);
	}

	protected void assembleApprovals(CustomFlowableUserContextImpl ctx) {
		List<Task> tasks = ctx.getFlowableService().getTasks(ctx.getCurrentUserInfo().getId());
		set("tasks", tasks);

	}
}
