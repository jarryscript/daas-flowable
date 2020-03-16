package com.doublechain.flowable.rest;

import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.CustomFlowableUserContextImpl;
import com.doublechain.flowable.BaseViewPage;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;



/**
 * 此类负责：所有的页面入口。 以及页面的组装
 * @author clariones
 *
 */
public abstract class RestViewService extends BaseRestViewService{
	// 查看首页(view homepage)
	public Object viewHomepage(FlowableUserContext userContext) throws Exception {
		String accessUrl = makeUrlF("viewHomepage", false);
		
		CustomFlowableUserContextImpl ctx = (CustomFlowableUserContextImpl) userContext;
		ctx.setAccessUrl(accessUrl);
		getCurrentUserInfo(ctx);
		ctx.addFootprint(this);
		commonLog(ctx, "viewHomepage", "查看首页", ctx.getRemoteIP(), ctx.tokenId(), makeUrlF("", false), null);
		int resultCode = processRequestViewHomepage(ctx);
		if (returnRightNow(resultCode)){
			return ctx.getResultObject();
		}
		BaseViewPage page = assemblerHomePage(ctx, "viewHomepage");
		page.setLinkToUrl(accessUrl);
		return page.doRender(ctx);
	}
	
	// 默认的客户端登录接口(client login)
	public Object clientLogin(FlowableUserContext userContext, com.terapico.caf.baseelement.LoginParam loginParam) throws Exception {
		String accessUrl = makeUrlF("clientLogin", false, loginParam);
		
		CustomFlowableUserContextImpl ctx = (CustomFlowableUserContextImpl) userContext;
		ctx.setAccessUrl(accessUrl);
		getCurrentUserInfo(ctx);
		ctx.setLoginParam(loginParam);
		commonLog(ctx, "clientLogin", "默认的客户端登录接口", ctx.getRemoteIP(), ctx.tokenId(), makeUrlF("", false, loginParam), null);
		int resultCode = processRequestClientLogin(ctx);
		if (returnRightNow(resultCode)){
			return ctx.getResultObject();
		}
		BaseViewPage page = assemblerMePage(ctx, "clientLogin");
		return page.doRender(ctx);
	}
	
	// 这个程序员很懒,什么也没留下(apply for leave)
	public Object customerApplyForLeave(FlowableUserContext userContext) throws Exception {
		String accessUrl = makeUrlF("customerApplyForLeave", false);
		
		CustomFlowableUserContextImpl ctx = (CustomFlowableUserContextImpl) userContext;
		ctx.setAccessUrl(accessUrl);
		ensureCurrentUserInfo(ctx);
		ctx.addFootprint(this);
		commonLog(ctx, "customerApplyForLeave", "这个程序员很懒,什么也没留下", ctx.getRemoteIP(), ctx.tokenId(), makeUrlF("", false), null);
		int resultCode = processRequestCustomerApplyForLeave(ctx);
		if (returnRightNow(resultCode)){
			return ctx.getResultObject();
		}
		BaseViewPage page = assemblerApplyForLeavePage(ctx, "customerApplyForLeave");
		return page.doRender(ctx);
	}
	
	// 这个程序员很懒,什么也没留下(submit application)
	public Object customerSubmitApplication(FlowableUserContext userContext) throws Exception {
		String accessUrl = makeUrlF("customerSubmitApplication", false);
		
		CustomFlowableUserContextImpl ctx = (CustomFlowableUserContextImpl) userContext;
		ctx.setAccessUrl(accessUrl);
		ensureCurrentUserInfo(ctx);
		ctx.addFootprint(this);
		commonLog(ctx, "customerSubmitApplication", "这个程序员很懒,什么也没留下", ctx.getRemoteIP(), ctx.tokenId(), makeUrlF("", false), null);
		int resultCode = processRequestCustomerSubmitApplication(ctx);
		if (returnRightNow(resultCode)){
			return ctx.getResultObject();
		}
		BaseViewPage page = assemblerMePage(ctx, "customerSubmitApplication");
		return page.doRender(ctx);
	}
	
}

