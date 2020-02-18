package com.doublechain.flowable.rest;

import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.CustomFlowableUserContextImpl;
import com.doublechain.flowable.Footprint;
import com.doublechain.flowable.FootprintProducer;

/**
 * 此类负责：所有的基础设施服务。 例如重复提交的基础方法，权限认证，异常包装，本服务内的通用工具方法等。
 * @author clariones
 *
 */
public abstract class BasicRestViewBizService extends RestViewService implements FootprintProducer {
	protected void getCurrentUserInfo(CustomFlowableUserContextImpl ctx) {
		// 从redis的数据中获得当前用户. 默认已经在checkAccess/loginXXX中完成, 如果有特别处理,可以在此完成
	}
	protected void ensureCurrentUserInfo(CustomFlowableUserContextImpl ctx) throws Exception{
		getCurrentUserInfo(ctx);
		if (ctx.getCurrentUserInfo() == null){
			throw new Exception("请先登录");
		}
	}
	@Override
	public boolean canReplaceFootPrint(Footprint fp1, Footprint fp2) {
		if (!fp1.getMethodName().equals(fp2.getMethodName())) {
			return false;
		}
		return true;
	}

	@Override
	public boolean clearTop() {
		return true;
	}
}