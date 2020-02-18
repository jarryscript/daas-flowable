package com.doublechain.flowable.rest;

import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.MultipleAccessKey;
import com.doublechain.flowable.SmartList;
import com.doublechain.flowable.rest.BaseRestViewService.BaseLoginHandler;
import com.doublechain.flowable.user.User;
import com.doublechain.flowable.user.UserTokens;
import com.terapico.caf.baseelement.LoginParam;
import com.terapico.utils.MapUtil;

import java.util.Map;
import java.util.Optional;

import com.doublechain.flowable.CustomFlowableUserContextImpl;

/**
 * 此类负责：所有的业务逻辑，例如所有的过滤规则，计算规则
 * 
 * @author clariones
 *
 */
public class RestViewBizService extends BasicRestViewBizService {
	// 处理请求：查看首页. 返回值：PRC_BY_DEFAULT: ;
	@Override
	protected int processRequestViewHomepage(CustomFlowableUserContextImpl ctx) throws Exception {
		// TODO
		return PRC_BY_DEFAULT;
	}

	// 处理请求：默认的客户端登录接口. 返回值：PRC_BY_DEFAULT: ;
	@Override
	protected int processRequestClientLogin(CustomFlowableUserContextImpl ctx) throws Exception {
		// TODO
		return PRC_BY_DEFAULT;
	}


	// 处理请求：这个程序员很懒,什么也没留下. 返回值：PRC_BY_DEFAULT: ;
	@Override
	protected int processRequestCustomerApplyForLeave(CustomFlowableUserContextImpl ctx) throws Exception {
		// TODO
		return PRC_BY_DEFAULT;
	}

	// 处理请求：这个程序员很懒,什么也没留下. 返回值：PRC_BY_DEFAULT: ;
	@Override
	protected int processRequestCustomerSubmitApplication(CustomFlowableUserContextImpl ctx) throws Exception {
		// TODO
		return PRC_BY_DEFAULT;
	}


	protected BaseLoginHandler findLoginHandler(CustomFlowableUserContextImpl ctx, LoginParam loginParam) {
		return new BaseLoginHandler() {
			String did;

			@Override
			public User doLogin(CustomFlowableUserContextImpl ctx, LoginParam loginParam) throws Exception {
				String login = loginParam.getLogin();
				String password = loginParam.getVerifyCode();
				MultipleAccessKey keys = new MultipleAccessKey();
				keys.put(User.MOBILE_PROPERTY,login);
				return Optional.ofNullable( userDaoOf(ctx).findUserWithKey(keys, UserTokens.all())).map(SmartList::first).orElse(null);
			}

			@Override
			public Map<String, Object> getProcessedLoginInfo(CustomFlowableUserContextImpl ctx) {
				return MapUtil.put("loginMethod", BaseLoginHandler.DEBUG).put("id", did).into_map();
			}

			@Override
			public void createLoginInfoForNewTarget(CustomFlowableUserContextImpl ctx, User loginTarget) {
				// 调试登录直接使用ID,无需额外操作
			}
		};
	}


	@Override
	protected void commonLog(CustomFlowableUserContextImpl ctx, String eventCode, String title, String key1, String key2, String key3, Object detailInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	protected User onNewLogin(CustomFlowableUserContextImpl ctx, LoginParam loginParam, BaseLoginHandler loginHandler) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}