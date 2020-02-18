
package com.doublechain.flowable.wechatworkappidentify;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Password;

import com.doublechain.flowable.*;
import com.doublechain.flowable.FlowableUserContextImpl;
import com.doublechain.flowable.iamservice.*;
import com.doublechain.flowable.services.IamService;
import com.doublechain.flowable.secuser.SecUser;
import com.doublechain.flowable.userapp.UserApp;
import com.terapico.uccaf.BaseUserContext;


import com.doublechain.flowable.secuser.SecUser;

import com.doublechain.flowable.secuser.CandidateSecUser;







public class WechatWorkappIdentifyManagerImpl extends CustomFlowableCheckerManager implements WechatWorkappIdentifyManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "WechatWorkappIdentify";
	@Override
	public WechatWorkappIdentifyDAO daoOf(FlowableUserContext userContext) {
		return wechatWorkappIdentifyDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws WechatWorkappIdentifyManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new WechatWorkappIdentifyManagerException(message);

	}



 	protected WechatWorkappIdentify saveWechatWorkappIdentify(FlowableUserContext userContext, WechatWorkappIdentify wechatWorkappIdentify, String [] tokensExpr) throws Exception{	
 		//return getWechatWorkappIdentifyDAO().save(wechatWorkappIdentify, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveWechatWorkappIdentify(userContext, wechatWorkappIdentify, tokens);
 	}
 	
 	protected WechatWorkappIdentify saveWechatWorkappIdentifyDetail(FlowableUserContext userContext, WechatWorkappIdentify wechatWorkappIdentify) throws Exception{	

 		
 		return saveWechatWorkappIdentify(userContext, wechatWorkappIdentify, allTokens());
 	}
 	
 	public WechatWorkappIdentify loadWechatWorkappIdentify(FlowableUserContext userContext, String wechatWorkappIdentifyId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfWechatWorkappIdentify(wechatWorkappIdentifyId);
		checkerOf(userContext).throwExceptionIfHasErrors( WechatWorkappIdentifyManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		WechatWorkappIdentify wechatWorkappIdentify = loadWechatWorkappIdentify( userContext, wechatWorkappIdentifyId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,wechatWorkappIdentify, tokens);
 	}
 	
 	
 	 public WechatWorkappIdentify searchWechatWorkappIdentify(FlowableUserContext userContext, String wechatWorkappIdentifyId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfWechatWorkappIdentify(wechatWorkappIdentifyId);
		checkerOf(userContext).throwExceptionIfHasErrors( WechatWorkappIdentifyManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		WechatWorkappIdentify wechatWorkappIdentify = loadWechatWorkappIdentify( userContext, wechatWorkappIdentifyId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,wechatWorkappIdentify, tokens);
 	}
 	
 	

 	protected WechatWorkappIdentify present(FlowableUserContext userContext, WechatWorkappIdentify wechatWorkappIdentify, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,wechatWorkappIdentify,tokens);
		
		
		WechatWorkappIdentify  wechatWorkappIdentifyToPresent = wechatWorkappIdentifyDaoOf(userContext).present(wechatWorkappIdentify, tokens);
		
		List<BaseEntity> entityListToNaming = wechatWorkappIdentifyToPresent.collectRefercencesFromLists();
		wechatWorkappIdentifyDaoOf(userContext).alias(entityListToNaming);
		
		return  wechatWorkappIdentifyToPresent;
		
		
	}
 
 	
 	
 	public WechatWorkappIdentify loadWechatWorkappIdentifyDetail(FlowableUserContext userContext, String wechatWorkappIdentifyId) throws Exception{	
 		WechatWorkappIdentify wechatWorkappIdentify = loadWechatWorkappIdentify( userContext, wechatWorkappIdentifyId, allTokens());
 		return present(userContext,wechatWorkappIdentify, allTokens());
		
 	}
 	
 	public Object view(FlowableUserContext userContext, String wechatWorkappIdentifyId) throws Exception{	
 		WechatWorkappIdentify wechatWorkappIdentify = loadWechatWorkappIdentify( userContext, wechatWorkappIdentifyId, viewTokens());
 		return present(userContext,wechatWorkappIdentify, allTokens());
		
 	}
 	protected WechatWorkappIdentify saveWechatWorkappIdentify(FlowableUserContext userContext, WechatWorkappIdentify wechatWorkappIdentify, Map<String,Object>tokens) throws Exception{	
 		return wechatWorkappIdentifyDaoOf(userContext).save(wechatWorkappIdentify, tokens);
 	}
 	protected WechatWorkappIdentify loadWechatWorkappIdentify(FlowableUserContext userContext, String wechatWorkappIdentifyId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfWechatWorkappIdentify(wechatWorkappIdentifyId);
		checkerOf(userContext).throwExceptionIfHasErrors( WechatWorkappIdentifyManagerException.class);

 
 		return wechatWorkappIdentifyDaoOf(userContext).load(wechatWorkappIdentifyId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(FlowableUserContext userContext, WechatWorkappIdentify wechatWorkappIdentify, Map<String, Object> tokens){
		super.addActions(userContext, wechatWorkappIdentify, tokens);
		
		addAction(userContext, wechatWorkappIdentify, tokens,"@create","createWechatWorkappIdentify","createWechatWorkappIdentify/","main","primary");
		addAction(userContext, wechatWorkappIdentify, tokens,"@update","updateWechatWorkappIdentify","updateWechatWorkappIdentify/"+wechatWorkappIdentify.getId()+"/","main","primary");
		addAction(userContext, wechatWorkappIdentify, tokens,"@copy","cloneWechatWorkappIdentify","cloneWechatWorkappIdentify/"+wechatWorkappIdentify.getId()+"/","main","primary");
		
		addAction(userContext, wechatWorkappIdentify, tokens,"wechat_workapp_identify.transfer_to_sec_user","transferToAnotherSecUser","transferToAnotherSecUser/"+wechatWorkappIdentify.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(FlowableUserContext userContext, WechatWorkappIdentify wechatWorkappIdentify, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public WechatWorkappIdentify createWechatWorkappIdentify(FlowableUserContext userContext, String corpId,String userId,String secUserId,DateTime lastLoginTime) throws Exception
	//public WechatWorkappIdentify createWechatWorkappIdentify(FlowableUserContext userContext,String corpId, String userId, String secUserId, DateTime lastLoginTime) throws Exception
	{

		

		

		checkerOf(userContext).checkCorpIdOfWechatWorkappIdentify(corpId);
		checkerOf(userContext).checkUserIdOfWechatWorkappIdentify(userId);
		checkerOf(userContext).checkLastLoginTimeOfWechatWorkappIdentify(lastLoginTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentifyManagerException.class);


		WechatWorkappIdentify wechatWorkappIdentify=createNewWechatWorkappIdentify();	

		wechatWorkappIdentify.setCorpId(corpId);
		wechatWorkappIdentify.setUserId(userId);
			
		SecUser secUser = loadSecUser(userContext, secUserId,emptyOptions());
		wechatWorkappIdentify.setSecUser(secUser);
		
		
		wechatWorkappIdentify.setCreateTime(userContext.now());
		wechatWorkappIdentify.setLastLoginTime(lastLoginTime);

		wechatWorkappIdentify = saveWechatWorkappIdentify(userContext, wechatWorkappIdentify, emptyOptions());
		
		onNewInstanceCreated(userContext, wechatWorkappIdentify);
		return wechatWorkappIdentify;


	}
	protected WechatWorkappIdentify createNewWechatWorkappIdentify()
	{

		return new WechatWorkappIdentify();
	}

	protected void checkParamsForUpdatingWechatWorkappIdentify(FlowableUserContext userContext,String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfWechatWorkappIdentify(wechatWorkappIdentifyId);
		checkerOf(userContext).checkVersionOfWechatWorkappIdentify( wechatWorkappIdentifyVersion);
		

		if(WechatWorkappIdentify.CORP_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkCorpIdOfWechatWorkappIdentify(parseString(newValueExpr));
		}
		if(WechatWorkappIdentify.USER_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkUserIdOfWechatWorkappIdentify(parseString(newValueExpr));
		}		

		
		if(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY.equals(property)){
			checkerOf(userContext).checkLastLoginTimeOfWechatWorkappIdentify(parseTimestamp(newValueExpr));
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentifyManagerException.class);


	}



	public WechatWorkappIdentify clone(FlowableUserContext userContext, String fromWechatWorkappIdentifyId) throws Exception{

		return wechatWorkappIdentifyDaoOf(userContext).clone(fromWechatWorkappIdentifyId, this.allTokens());
	}

	public WechatWorkappIdentify internalSaveWechatWorkappIdentify(FlowableUserContext userContext, WechatWorkappIdentify wechatWorkappIdentify) throws Exception
	{
		return internalSaveWechatWorkappIdentify(userContext, wechatWorkappIdentify, allTokens());

	}
	public WechatWorkappIdentify internalSaveWechatWorkappIdentify(FlowableUserContext userContext, WechatWorkappIdentify wechatWorkappIdentify, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingWechatWorkappIdentify(userContext, wechatWorkappIdentifyId, wechatWorkappIdentifyVersion, property, newValueExpr, tokensExpr);


		synchronized(wechatWorkappIdentify){
			//will be good when the wechatWorkappIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WechatWorkappIdentify.
			if (wechatWorkappIdentify.isChanged()){
			
			}
			wechatWorkappIdentify = saveWechatWorkappIdentify(userContext, wechatWorkappIdentify, options);
			return wechatWorkappIdentify;

		}

	}

	public WechatWorkappIdentify updateWechatWorkappIdentify(FlowableUserContext userContext,String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingWechatWorkappIdentify(userContext, wechatWorkappIdentifyId, wechatWorkappIdentifyVersion, property, newValueExpr, tokensExpr);



		WechatWorkappIdentify wechatWorkappIdentify = loadWechatWorkappIdentify(userContext, wechatWorkappIdentifyId, allTokens());
		if(wechatWorkappIdentify.getVersion() != wechatWorkappIdentifyVersion){
			String message = "The target version("+wechatWorkappIdentify.getVersion()+") is not equals to version("+wechatWorkappIdentifyVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(wechatWorkappIdentify){
			//will be good when the wechatWorkappIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WechatWorkappIdentify.
			
			wechatWorkappIdentify.changeProperty(property, newValueExpr);
			wechatWorkappIdentify = saveWechatWorkappIdentify(userContext, wechatWorkappIdentify, tokens().done());
			return present(userContext,wechatWorkappIdentify, mergedAllTokens(tokensExpr));
			//return saveWechatWorkappIdentify(userContext, wechatWorkappIdentify, tokens().done());
		}

	}

	public WechatWorkappIdentify updateWechatWorkappIdentifyProperty(FlowableUserContext userContext,String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingWechatWorkappIdentify(userContext, wechatWorkappIdentifyId, wechatWorkappIdentifyVersion, property, newValueExpr, tokensExpr);

		WechatWorkappIdentify wechatWorkappIdentify = loadWechatWorkappIdentify(userContext, wechatWorkappIdentifyId, allTokens());
		if(wechatWorkappIdentify.getVersion() != wechatWorkappIdentifyVersion){
			String message = "The target version("+wechatWorkappIdentify.getVersion()+") is not equals to version("+wechatWorkappIdentifyVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(wechatWorkappIdentify){
			//will be good when the wechatWorkappIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WechatWorkappIdentify.

			wechatWorkappIdentify.changeProperty(property, newValueExpr);
			
			wechatWorkappIdentify = saveWechatWorkappIdentify(userContext, wechatWorkappIdentify, tokens().done());
			return present(userContext,wechatWorkappIdentify, mergedAllTokens(tokensExpr));
			//return saveWechatWorkappIdentify(userContext, wechatWorkappIdentify, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected WechatWorkappIdentifyTokens tokens(){
		return WechatWorkappIdentifyTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return WechatWorkappIdentifyTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return WechatWorkappIdentifyTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherSecUser(FlowableUserContext userContext, String wechatWorkappIdentifyId, String anotherSecUserId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfWechatWorkappIdentify(wechatWorkappIdentifyId);
 		checkerOf(userContext).checkIdOfSecUser(anotherSecUserId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentifyManagerException.class);

 	}
 	public WechatWorkappIdentify transferToAnotherSecUser(FlowableUserContext userContext, String wechatWorkappIdentifyId, String anotherSecUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUser(userContext, wechatWorkappIdentifyId,anotherSecUserId);
 
		WechatWorkappIdentify wechatWorkappIdentify = loadWechatWorkappIdentify(userContext, wechatWorkappIdentifyId, allTokens());	
		synchronized(wechatWorkappIdentify){
			//will be good when the wechatWorkappIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUser(userContext, anotherSecUserId, emptyOptions());		
			wechatWorkappIdentify.updateSecUser(secUser);		
			wechatWorkappIdentify = saveWechatWorkappIdentify(userContext, wechatWorkappIdentify, emptyOptions());
			
			return present(userContext,wechatWorkappIdentify, allTokens());
			
		}

 	}

	

	protected void checkParamsForTransferingAnotherSecUserWithLogin(FlowableUserContext userContext, String wechatWorkappIdentifyId, String anotherLogin) throws Exception
 	{

 		checkerOf(userContext).checkIdOfWechatWorkappIdentify(wechatWorkappIdentifyId);
 		checkerOf(userContext).checkLoginOfSecUser( anotherLogin);
 		checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentifyManagerException.class);

 	}

 	public WechatWorkappIdentify transferToAnotherSecUserWithLogin(FlowableUserContext userContext, String wechatWorkappIdentifyId, String anotherLogin) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithLogin(userContext, wechatWorkappIdentifyId,anotherLogin);
 		WechatWorkappIdentify wechatWorkappIdentify = loadWechatWorkappIdentify(userContext, wechatWorkappIdentifyId, allTokens());
		synchronized(wechatWorkappIdentify){
			//will be good when the wechatWorkappIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithLogin(userContext, anotherLogin, emptyOptions());
			wechatWorkappIdentify.updateSecUser(secUser);
			wechatWorkappIdentify = saveWechatWorkappIdentify(userContext, wechatWorkappIdentify, emptyOptions());

			return present(userContext,wechatWorkappIdentify, allTokens());

		}
 	}

	 

	protected void checkParamsForTransferingAnotherSecUserWithEmail(FlowableUserContext userContext, String wechatWorkappIdentifyId, String anotherEmail) throws Exception
 	{

 		checkerOf(userContext).checkIdOfWechatWorkappIdentify(wechatWorkappIdentifyId);
 		checkerOf(userContext).checkEmailOfSecUser( anotherEmail);
 		checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentifyManagerException.class);

 	}

 	public WechatWorkappIdentify transferToAnotherSecUserWithEmail(FlowableUserContext userContext, String wechatWorkappIdentifyId, String anotherEmail) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithEmail(userContext, wechatWorkappIdentifyId,anotherEmail);
 		WechatWorkappIdentify wechatWorkappIdentify = loadWechatWorkappIdentify(userContext, wechatWorkappIdentifyId, allTokens());
		synchronized(wechatWorkappIdentify){
			//will be good when the wechatWorkappIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithEmail(userContext, anotherEmail, emptyOptions());
			wechatWorkappIdentify.updateSecUser(secUser);
			wechatWorkappIdentify = saveWechatWorkappIdentify(userContext, wechatWorkappIdentify, emptyOptions());

			return present(userContext,wechatWorkappIdentify, allTokens());

		}
 	}

	 

	protected void checkParamsForTransferingAnotherSecUserWithMobile(FlowableUserContext userContext, String wechatWorkappIdentifyId, String anotherMobile) throws Exception
 	{

 		checkerOf(userContext).checkIdOfWechatWorkappIdentify(wechatWorkappIdentifyId);
 		checkerOf(userContext).checkMobileOfSecUser( anotherMobile);
 		checkerOf(userContext).throwExceptionIfHasErrors(WechatWorkappIdentifyManagerException.class);

 	}

 	public WechatWorkappIdentify transferToAnotherSecUserWithMobile(FlowableUserContext userContext, String wechatWorkappIdentifyId, String anotherMobile) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithMobile(userContext, wechatWorkappIdentifyId,anotherMobile);
 		WechatWorkappIdentify wechatWorkappIdentify = loadWechatWorkappIdentify(userContext, wechatWorkappIdentifyId, allTokens());
		synchronized(wechatWorkappIdentify){
			//will be good when the wechatWorkappIdentify loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithMobile(userContext, anotherMobile, emptyOptions());
			wechatWorkappIdentify.updateSecUser(secUser);
			wechatWorkappIdentify = saveWechatWorkappIdentify(userContext, wechatWorkappIdentify, emptyOptions());

			return present(userContext,wechatWorkappIdentify, allTokens());

		}
 	}

	 


	public CandidateSecUser requestCandidateSecUser(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSecUser result = new CandidateSecUser();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("login");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SecUser> candidateList = secUserDaoOf(userContext).requestCandidateSecUserForWechatWorkappIdentify(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected SecUser loadSecUser(FlowableUserContext userContext, String newSecUserId, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).load(newSecUserId, options);
 	}
 	
 	protected SecUser loadSecUserWithLogin(FlowableUserContext userContext, String newLogin, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByLogin(newLogin, options);
 	}

 	
 	protected SecUser loadSecUserWithEmail(FlowableUserContext userContext, String newEmail, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByEmail(newEmail, options);
 	}

 	
 	protected SecUser loadSecUserWithMobile(FlowableUserContext userContext, String newMobile, Map<String,Object> options) throws Exception
 	{

 		return secUserDaoOf(userContext).loadByMobile(newMobile, options);
 	}

 	


	
	//--------------------------------------------------------------

	public void delete(FlowableUserContext userContext, String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion) throws Exception {
		//deleteInternal(userContext, wechatWorkappIdentifyId, wechatWorkappIdentifyVersion);
	}
	protected void deleteInternal(FlowableUserContext userContext,
			String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion) throws Exception{

		wechatWorkappIdentifyDaoOf(userContext).delete(wechatWorkappIdentifyId, wechatWorkappIdentifyVersion);
	}

	public WechatWorkappIdentify forgetByAll(FlowableUserContext userContext, String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion) throws Exception {
		return forgetByAllInternal(userContext, wechatWorkappIdentifyId, wechatWorkappIdentifyVersion);
	}
	protected WechatWorkappIdentify forgetByAllInternal(FlowableUserContext userContext,
			String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion) throws Exception{

		return wechatWorkappIdentifyDaoOf(userContext).disconnectFromAll(wechatWorkappIdentifyId, wechatWorkappIdentifyVersion);
	}




	public int deleteAll(FlowableUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new WechatWorkappIdentifyManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(FlowableUserContext userContext) throws Exception{
		return wechatWorkappIdentifyDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(FlowableUserContext userContext, WechatWorkappIdentify newCreated) throws Exception{
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, WechatWorkappIdentify.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------
}


