package com.doublechain.flowable.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.flowable.common.engine.impl.identity.Authentication;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;

import com.doublechain.flowable.CustomFlowableUserContextImpl;
import com.doublechain.flowable.FlowableException;
import com.doublechain.flowable.MultipleAccessKey;
import com.doublechain.flowable.SmartList;
import com.doublechain.flowable.user.User;
import com.doublechain.flowable.user.UserTokens;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.terapico.caf.baseelement.LoginParam;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.CollectionUtils;
import com.terapico.utils.DebugUtil;
import com.terapico.utils.MapUtil;

/**
 * 此类负责：所有的业务逻辑，例如所有的过滤规则，计算规则
 *
 * @author clariones
 *
 */
public class RestViewBizService extends BasicRestViewBizService {
	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters) throws IllegalAccessException {
		return null;
	}

	@Override
	protected void ensureCurrentUserInfo(CustomFlowableUserContextImpl ctx) throws Exception {
	}

	// 处理请求：查看首页. 返回值：PRC_BY_DEFAULT: ;
	@Override
	protected int processRequestViewHomepage(CustomFlowableUserContextImpl ctx) throws Exception {
		// TODO
		return PRC_BY_DEFAULT;
	}

	// 处理请求：默认的客户端登录接口. 返回值：PRC_BY_DEFAULT: ;
	@Override
	protected int processRequestClientLogin(CustomFlowableUserContextImpl ctx) throws Exception {
		LoginParam loginParam = ctx.getLoginParam();
		this.processClientLogin(ctx, loginParam);
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
		RuntimeService runtimeService = ctx.getFlowableService().getProcessEngine().getRuntimeService();
		try {
			Authentication.setAuthenticatedUserId("U000001");
			ProcessInstance startProcessInstanceByKey = runtimeService
					.startProcessInstanceByKey("subDivisionalWorksAcceptance",
							MapUtil.put("auditors", CollectionUtils.toList("U000002", "U000003")).put("allSubJobFinished", true).into_map());
			ctx.log("✅✅✅开始流程:" + startProcessInstanceByKey.getId());
		} finally {
			Authentication.setAuthenticatedUserId(null);
		}
		return PRC_BY_DEFAULT;
	}

	@Override
	protected BaseLoginHandler findLoginHandler(CustomFlowableUserContextImpl ctx, LoginParam loginParam) {
		BaseLoginHandler loginHandler = super.findLoginHandler(ctx, loginParam);
		if (loginHandler != null) {
			return loginHandler;
		}
		return new BaseLoginHandler() {
			String did;

			@Override
			public User doLogin(CustomFlowableUserContextImpl ctx, LoginParam loginParam) throws Exception {
				String login = loginParam.getLogin();
				String password = loginParam.getVerifyCode();
				MultipleAccessKey keys = new MultipleAccessKey();
				keys.put(User.MOBILE_PROPERTY, login);
				return Optional.ofNullable(userDaoOf(ctx).findUserWithKey(keys, UserTokens.all())).map(SmartList::first).orElse(null);
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

	public Object loginForTest(CustomFlowableUserContextImpl ctx, String formData) throws Exception {
		LoginParam logp = DebugUtil.getObjectMapper().readValue(formData, LoginParam.class);
		return clientLogin(ctx, logp);
	}

	@Override
	protected void commonLog(CustomFlowableUserContextImpl ctx, String eventCode, String title, String key1, String key2, String key3, Object detailInfo) {

	}

	@Override
	protected User onNewLogin(CustomFlowableUserContextImpl ctx, LoginParam loginParam, BaseLoginHandler loginHandler) throws Exception {
		return null;
	}

	public Object checkStatus(CustomFlowableUserContextImpl ctx) {
		List<ProcessInstance> list = ctx.getFlowableService().getProcessEngine().getRuntimeService().createProcessInstanceQuery().active().list();
		if (list == null || list.isEmpty()) {
			ctx.log("当前没有运行中的流程");
		} else {
			ctx.log("当前运行的流程有:");
			list.forEach(l -> ctx.log(l.getDescription() + l.getId()));
		}

		List<Task> u1Tasks = ctx.getFlowableService().getTasks("U000001");
		List<Task> u2Tasks = ctx.getFlowableService().getTasks("U000002");
		List<Task> u3Tasks = ctx.getFlowableService().getTasks("U000003");

		ctx.log("✅✅✅U000001:");
		logTasks(ctx, u1Tasks);
		ctx.log("✅✅✅U000002:");
		logTasks(ctx, u2Tasks);
		ctx.log("✅✅✅U000003:");
		logTasks(ctx, u3Tasks);
		return null;
	}

	protected void logTasks(CustomFlowableUserContextImpl ctx, List<Task> tasks) {
		if (tasks == null || tasks.isEmpty()) {
			ctx.log("没有任务");
			ctx.log(" ");
			return;
		}
		tasks.forEach(t -> {
			ctx.log("任务id: " + t.getId());
			ctx.log("任务名称" + t.getName());
			ctx.log("所属流程: " + t.getProcessInstanceId());
			ctx.log(" ");
		});
	}

	public void completeTask(CustomFlowableUserContextImpl ctx, String taskId, String vars) throws JsonParseException, JsonMappingException, IOException {
		TaskService taskService = ctx.getFlowableService().getProcessEngine().getTaskService();
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		taskService.saveTask(task);
		Map readValue = new HashMap<String, Object>();
		if (vars != null && !vars.isEmpty()) {
			readValue = new ObjectMapper().readValue(vars, Map.class);
		}
		taskService.complete(taskId, readValue, true);
		ctx.log("✅✅✅ 完成任务" + taskId + ", 任务所属:" + task.getAssignee());
	}



	public void testEvent(CustomFlowableUserContextImpl ctx) throws FlowableException, IOException {
		Object startProcess = ctx.getFlowableService().startProcess(ctx, "eventSample",null);

	}

}