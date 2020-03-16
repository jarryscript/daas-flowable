
package com.doublechain.flowable.holydaysetting;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;

import com.doublechain.flowable.*;
import com.doublechain.flowable.FlowableUserContextImpl;
import com.doublechain.flowable.iamservice.*;
import com.doublechain.flowable.services.IamService;
import com.doublechain.flowable.secuser.SecUser;
import com.doublechain.flowable.userapp.UserApp;
import com.terapico.uccaf.BaseUserContext;


import com.doublechain.flowable.leaverecordtype.LeaveRecordType;

import com.doublechain.flowable.leaverecordtype.CandidateLeaveRecordType;







public class HolydaySettingManagerImpl extends CustomFlowableCheckerManager implements HolydaySettingManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "HolydaySetting";
	@Override
	public HolydaySettingDAO daoOf(FlowableUserContext userContext) {
		return holydaySettingDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws HolydaySettingManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new HolydaySettingManagerException(message);

	}



 	protected HolydaySetting saveHolydaySetting(FlowableUserContext userContext, HolydaySetting holydaySetting, String [] tokensExpr) throws Exception{	
 		//return getHolydaySettingDAO().save(holydaySetting, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveHolydaySetting(userContext, holydaySetting, tokens);
 	}
 	
 	protected HolydaySetting saveHolydaySettingDetail(FlowableUserContext userContext, HolydaySetting holydaySetting) throws Exception{	

 		
 		return saveHolydaySetting(userContext, holydaySetting, allTokens());
 	}
 	
 	public HolydaySetting loadHolydaySetting(FlowableUserContext userContext, String holydaySettingId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfHolydaySetting(holydaySettingId);
		checkerOf(userContext).throwExceptionIfHasErrors( HolydaySettingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		HolydaySetting holydaySetting = loadHolydaySetting( userContext, holydaySettingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,holydaySetting, tokens);
 	}
 	
 	
 	 public HolydaySetting searchHolydaySetting(FlowableUserContext userContext, String holydaySettingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfHolydaySetting(holydaySettingId);
		checkerOf(userContext).throwExceptionIfHasErrors( HolydaySettingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		HolydaySetting holydaySetting = loadHolydaySetting( userContext, holydaySettingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,holydaySetting, tokens);
 	}
 	
 	

 	protected HolydaySetting present(FlowableUserContext userContext, HolydaySetting holydaySetting, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,holydaySetting,tokens);
		
		
		HolydaySetting  holydaySettingToPresent = holydaySettingDaoOf(userContext).present(holydaySetting, tokens);
		
		List<BaseEntity> entityListToNaming = holydaySettingToPresent.collectRefercencesFromLists();
		holydaySettingDaoOf(userContext).alias(entityListToNaming);
		
		return  holydaySettingToPresent;
		
		
	}
 
 	
 	
 	public HolydaySetting loadHolydaySettingDetail(FlowableUserContext userContext, String holydaySettingId) throws Exception{	
 		HolydaySetting holydaySetting = loadHolydaySetting( userContext, holydaySettingId, allTokens());
 		return present(userContext,holydaySetting, allTokens());
		
 	}
 	
 	public Object view(FlowableUserContext userContext, String holydaySettingId) throws Exception{	
 		HolydaySetting holydaySetting = loadHolydaySetting( userContext, holydaySettingId, viewTokens());
 		return present(userContext,holydaySetting, allTokens());
		
 	}
 	protected HolydaySetting saveHolydaySetting(FlowableUserContext userContext, HolydaySetting holydaySetting, Map<String,Object>tokens) throws Exception{	
 		return holydaySettingDaoOf(userContext).save(holydaySetting, tokens);
 	}
 	protected HolydaySetting loadHolydaySetting(FlowableUserContext userContext, String holydaySettingId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfHolydaySetting(holydaySettingId);
		checkerOf(userContext).throwExceptionIfHasErrors( HolydaySettingManagerException.class);

 
 		return holydaySettingDaoOf(userContext).load(holydaySettingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(FlowableUserContext userContext, HolydaySetting holydaySetting, Map<String, Object> tokens){
		super.addActions(userContext, holydaySetting, tokens);
		
		addAction(userContext, holydaySetting, tokens,"@create","createHolydaySetting","createHolydaySetting/","main","primary");
		addAction(userContext, holydaySetting, tokens,"@update","updateHolydaySetting","updateHolydaySetting/"+holydaySetting.getId()+"/","main","primary");
		addAction(userContext, holydaySetting, tokens,"@copy","cloneHolydaySetting","cloneHolydaySetting/"+holydaySetting.getId()+"/","main","primary");
		
		addAction(userContext, holydaySetting, tokens,"holyday_setting.transfer_to_type","transferToAnotherType","transferToAnotherType/"+holydaySetting.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(FlowableUserContext userContext, HolydaySetting holydaySetting, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public HolydaySetting createHolydaySetting(FlowableUserContext userContext, String typeId,int leaveDays) throws Exception
	//public HolydaySetting createHolydaySetting(FlowableUserContext userContext,String typeId, int leaveDays) throws Exception
	{

		

		

		checkerOf(userContext).checkLeaveDaysOfHolydaySetting(leaveDays);
	
		checkerOf(userContext).throwExceptionIfHasErrors(HolydaySettingManagerException.class);


		HolydaySetting holydaySetting=createNewHolydaySetting();	

			
		LeaveRecordType type = loadLeaveRecordType(userContext, typeId,emptyOptions());
		holydaySetting.setType(type);
		
		
		holydaySetting.setLeaveDays(leaveDays);

		holydaySetting = saveHolydaySetting(userContext, holydaySetting, emptyOptions());
		
		onNewInstanceCreated(userContext, holydaySetting);
		return holydaySetting;


	}
	protected HolydaySetting createNewHolydaySetting()
	{

		return new HolydaySetting();
	}

	protected void checkParamsForUpdatingHolydaySetting(FlowableUserContext userContext,String holydaySettingId, int holydaySettingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfHolydaySetting(holydaySettingId);
		checkerOf(userContext).checkVersionOfHolydaySetting( holydaySettingVersion);
		
		

		
		if(HolydaySetting.LEAVE_DAYS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLeaveDaysOfHolydaySetting(parseInt(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(HolydaySettingManagerException.class);


	}



	public HolydaySetting clone(FlowableUserContext userContext, String fromHolydaySettingId) throws Exception{

		return holydaySettingDaoOf(userContext).clone(fromHolydaySettingId, this.allTokens());
	}

	public HolydaySetting internalSaveHolydaySetting(FlowableUserContext userContext, HolydaySetting holydaySetting) throws Exception
	{
		return internalSaveHolydaySetting(userContext, holydaySetting, allTokens());

	}
	public HolydaySetting internalSaveHolydaySetting(FlowableUserContext userContext, HolydaySetting holydaySetting, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingHolydaySetting(userContext, holydaySettingId, holydaySettingVersion, property, newValueExpr, tokensExpr);


		synchronized(holydaySetting){
			//will be good when the holydaySetting loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to HolydaySetting.
			if (holydaySetting.isChanged()){
			
			}
			holydaySetting = saveHolydaySetting(userContext, holydaySetting, options);
			return holydaySetting;

		}

	}

	public HolydaySetting updateHolydaySetting(FlowableUserContext userContext,String holydaySettingId, int holydaySettingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingHolydaySetting(userContext, holydaySettingId, holydaySettingVersion, property, newValueExpr, tokensExpr);



		HolydaySetting holydaySetting = loadHolydaySetting(userContext, holydaySettingId, allTokens());
		if(holydaySetting.getVersion() != holydaySettingVersion){
			String message = "The target version("+holydaySetting.getVersion()+") is not equals to version("+holydaySettingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(holydaySetting){
			//will be good when the holydaySetting loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to HolydaySetting.
			
			holydaySetting.changeProperty(property, newValueExpr);
			holydaySetting = saveHolydaySetting(userContext, holydaySetting, tokens().done());
			return present(userContext,holydaySetting, mergedAllTokens(tokensExpr));
			//return saveHolydaySetting(userContext, holydaySetting, tokens().done());
		}

	}

	public HolydaySetting updateHolydaySettingProperty(FlowableUserContext userContext,String holydaySettingId, int holydaySettingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingHolydaySetting(userContext, holydaySettingId, holydaySettingVersion, property, newValueExpr, tokensExpr);

		HolydaySetting holydaySetting = loadHolydaySetting(userContext, holydaySettingId, allTokens());
		if(holydaySetting.getVersion() != holydaySettingVersion){
			String message = "The target version("+holydaySetting.getVersion()+") is not equals to version("+holydaySettingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(holydaySetting){
			//will be good when the holydaySetting loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to HolydaySetting.

			holydaySetting.changeProperty(property, newValueExpr);
			
			holydaySetting = saveHolydaySetting(userContext, holydaySetting, tokens().done());
			return present(userContext,holydaySetting, mergedAllTokens(tokensExpr));
			//return saveHolydaySetting(userContext, holydaySetting, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected HolydaySettingTokens tokens(){
		return HolydaySettingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return HolydaySettingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return HolydaySettingTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherType(FlowableUserContext userContext, String holydaySettingId, String anotherTypeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfHolydaySetting(holydaySettingId);
 		checkerOf(userContext).checkIdOfLeaveRecordType(anotherTypeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(HolydaySettingManagerException.class);

 	}
 	public HolydaySetting transferToAnotherType(FlowableUserContext userContext, String holydaySettingId, String anotherTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherType(userContext, holydaySettingId,anotherTypeId);
 
		HolydaySetting holydaySetting = loadHolydaySetting(userContext, holydaySettingId, allTokens());	
		synchronized(holydaySetting){
			//will be good when the holydaySetting loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LeaveRecordType type = loadLeaveRecordType(userContext, anotherTypeId, emptyOptions());		
			holydaySetting.updateType(type);		
			holydaySetting = saveHolydaySetting(userContext, holydaySetting, emptyOptions());
			
			return present(userContext,holydaySetting, allTokens());
			
		}

 	}

	

	protected void checkParamsForTransferingAnotherTypeWithCode(FlowableUserContext userContext, String holydaySettingId, String anotherCode) throws Exception
 	{

 		checkerOf(userContext).checkIdOfHolydaySetting(holydaySettingId);
 		checkerOf(userContext).checkCodeOfLeaveRecordType( anotherCode);
 		checkerOf(userContext).throwExceptionIfHasErrors(HolydaySettingManagerException.class);

 	}

 	public HolydaySetting transferToAnotherTypeWithCode(FlowableUserContext userContext, String holydaySettingId, String anotherCode) throws Exception
 	{
 		checkParamsForTransferingAnotherTypeWithCode(userContext, holydaySettingId,anotherCode);
 		HolydaySetting holydaySetting = loadHolydaySetting(userContext, holydaySettingId, allTokens());
		synchronized(holydaySetting){
			//will be good when the holydaySetting loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LeaveRecordType type = loadLeaveRecordTypeWithCode(userContext, anotherCode, emptyOptions());
			holydaySetting.updateType(type);
			holydaySetting = saveHolydaySetting(userContext, holydaySetting, emptyOptions());

			return present(userContext,holydaySetting, allTokens());

		}
 	}

	 


	public CandidateLeaveRecordType requestCandidateType(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLeaveRecordType result = new CandidateLeaveRecordType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<LeaveRecordType> candidateList = leaveRecordTypeDaoOf(userContext).requestCandidateLeaveRecordTypeForHolydaySetting(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected LeaveRecordType loadLeaveRecordType(FlowableUserContext userContext, String newTypeId, Map<String,Object> options) throws Exception
 	{

 		return leaveRecordTypeDaoOf(userContext).load(newTypeId, options);
 	}
 	
 	protected LeaveRecordType loadLeaveRecordTypeWithCode(FlowableUserContext userContext, String newCode, Map<String,Object> options) throws Exception
 	{

 		return leaveRecordTypeDaoOf(userContext).loadByCode(newCode, options);
 	}

 	


	
	//--------------------------------------------------------------

	public void delete(FlowableUserContext userContext, String holydaySettingId, int holydaySettingVersion) throws Exception {
		//deleteInternal(userContext, holydaySettingId, holydaySettingVersion);
	}
	protected void deleteInternal(FlowableUserContext userContext,
			String holydaySettingId, int holydaySettingVersion) throws Exception{

		holydaySettingDaoOf(userContext).delete(holydaySettingId, holydaySettingVersion);
	}

	public HolydaySetting forgetByAll(FlowableUserContext userContext, String holydaySettingId, int holydaySettingVersion) throws Exception {
		return forgetByAllInternal(userContext, holydaySettingId, holydaySettingVersion);
	}
	protected HolydaySetting forgetByAllInternal(FlowableUserContext userContext,
			String holydaySettingId, int holydaySettingVersion) throws Exception{

		return holydaySettingDaoOf(userContext).disconnectFromAll(holydaySettingId, holydaySettingVersion);
	}




	public int deleteAll(FlowableUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new HolydaySettingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(FlowableUserContext userContext) throws Exception{
		return holydaySettingDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(FlowableUserContext userContext, HolydaySetting newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(FlowableUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(FlowableBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(FlowableUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(FlowableBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(FlowableUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(FlowableBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(FlowableUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(FlowableBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(FlowableUserContextImpl userContext, LoginContext loginContext) throws Exception {
		IamService iamService = (IamService) userContext.getBean("iamService");
		LoginResult loginResult = iamService.doLogin(userContext, loginContext, this);
		// 根据登录结果
		if (!loginResult.isAuthenticated()) {
			throw new Exception(loginResult.getMessage());
		}
		if (loginResult.isSuccess()) {
			return onLoginSuccess(userContext, loginResult);
		}
		if (loginResult.isNewUser()) {
			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
		}
		return new LoginForm();
	}
	
	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		FlowableUserContextImpl userContext = (FlowableUserContextImpl)baseUserContext;
		IamService iamService = (IamService) userContext.getBean("iamService");
		Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);
		
		SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
		UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
		if (userApp != null) {
			userApp.setSecUser(secUser);
		}
		afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
		if (!isMethodNeedLogin(userContext, methodName, parameters)) {
			return accessOK();
		}
		
		return super.checkAccess(baseUserContext, methodName, parameters);
	}
	
	// 判断哪些接口需要登录后才能执行. 默认除了loginBy开头的,其他都要登录
	protected boolean isMethodNeedLogin(FlowableUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}
		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(FlowableUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(FlowableUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
	}

	public void onAuthenticationFailed(FlowableUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	public void onAuthenticateNewUserLogged(FlowableUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, should create a account and bind with sec user, BUT, I don't know how to 
		// create new object as of generate this method. It depends on business logical. So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(FlowableUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, HolydaySetting.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(FlowableUserContext userContext,SmartList<HolydaySetting> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<LeaveRecordType> typeList = FlowableBaseUtils.collectReferencedObjectWithType(userContext, list, LeaveRecordType.class);
		userContext.getDAOGroup().enhanceList(typeList, LeaveRecordType.class);

	
    }
	
	public Object listByType(FlowableUserContext userContext,String typeId) throws Exception {
		return listPageByType(userContext, typeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByType(FlowableUserContext userContext,String typeId, int start, int count) throws Exception {
		SmartList<HolydaySetting> list = holydaySettingDaoOf(userContext).findHolydaySettingByType(typeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		FlowableCommonListOfViewPage page = new FlowableCommonListOfViewPage();
		page.setClassOfList(HolydaySetting.class);
		page.setContainerObject(LeaveRecordType.withId(typeId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("类型列表");
		page.setRequestName("listByType");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		
		page.assemblerContent(userContext, "listByType");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------
}


