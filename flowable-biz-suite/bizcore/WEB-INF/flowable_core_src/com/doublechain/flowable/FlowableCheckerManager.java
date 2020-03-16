package com.doublechain.flowable;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.uccaf.BaseUserContext;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class FlowableCheckerManager extends BaseManagerImpl {
	public SmartList<BaseEntity> requestCandidateValuesForSearch(FlowableUserContext ctx, String ownerMemberName,
			String ownerId, String resultMemberName, String resutlClassName, String targetClassName, String filterKey, int pageNo) {
		return ((BaseDAO)daoOf(ctx)).requestCandidateValuesForSearch(ownerMemberName, ownerId, resultMemberName,
				resutlClassName, targetClassName, filterKey, pageNo);
	}
	
	protected Object daoOf(FlowableUserContext ctx) {
		throw new UnsupportedOperationException("You must implement it in your specific Manager implementation");
	}
	
	protected FlowableObjectChecker checkerOf(FlowableUserContext ctx) {
		return ctx.getChecker();
	}
	private static class AsyncManagerJob extends Thread {
		protected Object me;
		protected Object proxy;
		protected Method method;
		protected Object[] args;
		protected MethodProxy methodProxy;

		public AsyncManagerJob(Object me, Object proxy, Method method, Object[] args, MethodProxy methodProxy) {
			super();
			this.me = me;
			this.proxy = proxy;
			this.method = method;
			this.args = args;
			this.methodProxy = methodProxy;
		}

		@Override
		public void run() {
			try {
				method.setAccessible(true);
				method.invoke(me, args);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
	
	public static final Map<String, Object> EO = new HashMap<>();
	protected Object asyncProxy = null;
	protected Object getAsyncProxy() {
		if (asyncProxy != null) {
			return asyncProxy;
		}
		
		Object me = this;
		MethodInterceptor proxy = new MethodInterceptor() {

			@Override
			public Object intercept(Object proxyObj, Method method, Object[] args, MethodProxy methodProxy)
					throws Throwable {
				new AsyncManagerJob(me, proxyObj, method, args, methodProxy).start();
				return null;
			}
		};
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(me.getClass());
		enhancer.setCallback(proxy);
		return asyncProxy = enhancer.create();
	}
	
	protected void cacheVerifyCode(FlowableUserContext ctx, String mobile, String verifyCode) {
		String cacheKey = "verifyCode:"+mobile;
		ctx.putToCache(cacheKey, verifyCode, FlowableBaseConstants.DEFAULT_CACHE_TIME_FOR_VCODE);
	}

	protected String getVerifyCodeFromCache(FlowableUserContext ctx, String mobile) {
		String cacheKey = "verifyCode:"+mobile;
		return (String) ctx.getCachedObject(cacheKey, String.class);
	}
	protected void checkVerifyCode(FlowableUserContext ctx, String inputVerifyCode, String mobile) throws Exception {
		String cachedVerifyCode = getVerifyCodeFromCache(ctx, mobile);
		if (cachedVerifyCode == null) {
			throw new Exception("请先获取验证码");
		}
		if (!cachedVerifyCode.equals(inputVerifyCode)) {
			throw new Exception("验证码不正确");
		}
	}
	
	public com.doublechain.flowable.platform.PlatformManager platformManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getPlatformManager();
	}
	public com.doublechain.flowable.platform.PlatformDAO platformDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getPlatformDAO();
	}
	public com.doublechain.flowable.user.UserManager userManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getUserManager();
	}
	public com.doublechain.flowable.user.UserDAO userDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getUserDAO();
	}
	public com.doublechain.flowable.role.RoleManager roleManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getRoleManager();
	}
	public com.doublechain.flowable.role.RoleDAO roleDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getRoleDAO();
	}
	public com.doublechain.flowable.leaverecord.LeaveRecordManager leaveRecordManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getLeaveRecordManager();
	}
	public com.doublechain.flowable.leaverecord.LeaveRecordDAO leaveRecordDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getLeaveRecordDAO();
	}
	public com.doublechain.flowable.leaverecordtype.LeaveRecordTypeManager leaveRecordTypeManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getLeaveRecordTypeManager();
	}
	public com.doublechain.flowable.leaverecordtype.LeaveRecordTypeDAO leaveRecordTypeDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getLeaveRecordTypeDAO();
	}
	public com.doublechain.flowable.holydaysetting.HolydaySettingManager holydaySettingManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getHolydaySettingManager();
	}
	public com.doublechain.flowable.holydaysetting.HolydaySettingDAO holydaySettingDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getHolydaySettingDAO();
	}
	public com.doublechain.flowable.province.ProvinceManager provinceManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getProvinceManager();
	}
	public com.doublechain.flowable.province.ProvinceDAO provinceDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getProvinceDAO();
	}
	public com.doublechain.flowable.city.CityManager cityManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getCityManager();
	}
	public com.doublechain.flowable.city.CityDAO cityDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getCityDAO();
	}
	public com.doublechain.flowable.district.DistrictManager districtManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getDistrictManager();
	}
	public com.doublechain.flowable.district.DistrictDAO districtDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getDistrictDAO();
	}
	public com.doublechain.flowable.userdomain.UserDomainManager userDomainManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getUserDomainManager();
	}
	public com.doublechain.flowable.userdomain.UserDomainDAO userDomainDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getUserDomainDAO();
	}
	public com.doublechain.flowable.userwhitelist.UserWhiteListManager userWhiteListManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getUserWhiteListManager();
	}
	public com.doublechain.flowable.userwhitelist.UserWhiteListDAO userWhiteListDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getUserWhiteListDAO();
	}
	public com.doublechain.flowable.secuser.SecUserManager secUserManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getSecUserManager();
	}
	public com.doublechain.flowable.secuser.SecUserDAO secUserDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getSecUserDAO();
	}
	public com.doublechain.flowable.userapp.UserAppManager userAppManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getUserAppManager();
	}
	public com.doublechain.flowable.userapp.UserAppDAO userAppDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getUserAppDAO();
	}
	public com.doublechain.flowable.quicklink.QuickLinkManager quickLinkManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getQuickLinkManager();
	}
	public com.doublechain.flowable.quicklink.QuickLinkDAO quickLinkDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getQuickLinkDAO();
	}
	public com.doublechain.flowable.listaccess.ListAccessManager listAccessManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getListAccessManager();
	}
	public com.doublechain.flowable.listaccess.ListAccessDAO listAccessDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getListAccessDAO();
	}
	public com.doublechain.flowable.objectaccess.ObjectAccessManager objectAccessManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getObjectAccessManager();
	}
	public com.doublechain.flowable.objectaccess.ObjectAccessDAO objectAccessDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getObjectAccessDAO();
	}
	public com.doublechain.flowable.loginhistory.LoginHistoryManager loginHistoryManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getLoginHistoryManager();
	}
	public com.doublechain.flowable.loginhistory.LoginHistoryDAO loginHistoryDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getLoginHistoryDAO();
	}
	public com.doublechain.flowable.genericform.GenericFormManager genericFormManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getGenericFormManager();
	}
	public com.doublechain.flowable.genericform.GenericFormDAO genericFormDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getGenericFormDAO();
	}
	public com.doublechain.flowable.formmessage.FormMessageManager formMessageManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getFormMessageManager();
	}
	public com.doublechain.flowable.formmessage.FormMessageDAO formMessageDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getFormMessageDAO();
	}
	public com.doublechain.flowable.formfieldmessage.FormFieldMessageManager formFieldMessageManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getFormFieldMessageManager();
	}
	public com.doublechain.flowable.formfieldmessage.FormFieldMessageDAO formFieldMessageDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getFormFieldMessageDAO();
	}
	public com.doublechain.flowable.formfield.FormFieldManager formFieldManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getFormFieldManager();
	}
	public com.doublechain.flowable.formfield.FormFieldDAO formFieldDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getFormFieldDAO();
	}
	public com.doublechain.flowable.formaction.FormActionManager formActionManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getFormActionManager();
	}
	public com.doublechain.flowable.formaction.FormActionDAO formActionDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getFormActionDAO();
	}
	public com.doublechain.flowable.candidatecontainer.CandidateContainerManager candidateContainerManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getCandidateContainerManager();
	}
	public com.doublechain.flowable.candidatecontainer.CandidateContainerDAO candidateContainerDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getCandidateContainerDAO();
	}
	public com.doublechain.flowable.candidateelement.CandidateElementManager candidateElementManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getCandidateElementManager();
	}
	public com.doublechain.flowable.candidateelement.CandidateElementDAO candidateElementDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getCandidateElementDAO();
	}
	public com.doublechain.flowable.wechatworkappidentify.WechatWorkappIdentifyManager wechatWorkappIdentifyManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getWechatWorkappIdentifyManager();
	}
	public com.doublechain.flowable.wechatworkappidentify.WechatWorkappIdentifyDAO wechatWorkappIdentifyDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getWechatWorkappIdentifyDAO();
	}
	public com.doublechain.flowable.wechatminiappidentify.WechatMiniappIdentifyManager wechatMiniappIdentifyManagerOf(FlowableUserContext userContext){
		return userContext.getManagerGroup().getWechatMiniappIdentifyManager();
	}
	public com.doublechain.flowable.wechatminiappidentify.WechatMiniappIdentifyDAO wechatMiniappIdentifyDaoOf(FlowableUserContext userContext){
		return userContext.getDAOGroup().getWechatMiniappIdentifyDAO();
	}
	
	
	
	

	protected void checkGender(String gender, int i, int j,String targetFieldName, List<Message> messageList) {
		
		
	}
	
	//for stub only
	protected void checkDateNow(Date likeTime, int i, Object now,
			String targetFieldName, FlowableException exception) {
		
		
	}


	protected Object now() {

		return null;
	}
	
	protected boolean isValidIdentifier(String value){
		return hasVisualChar(value);
		
	}
	
	protected boolean hasVisualChar(String value){
		if(value==null){
			return false;
		}
		if(value.isEmpty()){
			return false;
		}
		if(value.trim().isEmpty()){
			return false;
		}
		return true;
		
	}
	protected void checkBigDecimalRange(BigDecimal projectArea, double i, double j, String projectAreaOfProject,
			List<Message> messageList) {
		
	}
    
}









