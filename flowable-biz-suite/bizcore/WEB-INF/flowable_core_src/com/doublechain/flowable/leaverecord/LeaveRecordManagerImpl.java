
package com.doublechain.flowable.leaverecord;

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


import com.doublechain.flowable.user.User;
import com.doublechain.flowable.leaverecordtype.LeaveRecordType;
import com.doublechain.flowable.platform.Platform;

import com.doublechain.flowable.user.CandidateUser;
import com.doublechain.flowable.leaverecordtype.CandidateLeaveRecordType;
import com.doublechain.flowable.platform.CandidatePlatform;







public class LeaveRecordManagerImpl extends CustomFlowableCheckerManager implements LeaveRecordManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "LeaveRecord";
	@Override
	public LeaveRecordDAO daoOf(FlowableUserContext userContext) {
		return leaveRecordDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws LeaveRecordManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new LeaveRecordManagerException(message);

	}



 	protected LeaveRecord saveLeaveRecord(FlowableUserContext userContext, LeaveRecord leaveRecord, String [] tokensExpr) throws Exception{	
 		//return getLeaveRecordDAO().save(leaveRecord, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLeaveRecord(userContext, leaveRecord, tokens);
 	}
 	
 	protected LeaveRecord saveLeaveRecordDetail(FlowableUserContext userContext, LeaveRecord leaveRecord) throws Exception{	

 		
 		return saveLeaveRecord(userContext, leaveRecord, allTokens());
 	}
 	
 	public LeaveRecord loadLeaveRecord(FlowableUserContext userContext, String leaveRecordId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfLeaveRecord(leaveRecordId);
		checkerOf(userContext).throwExceptionIfHasErrors( LeaveRecordManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LeaveRecord leaveRecord = loadLeaveRecord( userContext, leaveRecordId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,leaveRecord, tokens);
 	}
 	
 	
 	 public LeaveRecord searchLeaveRecord(FlowableUserContext userContext, String leaveRecordId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfLeaveRecord(leaveRecordId);
		checkerOf(userContext).throwExceptionIfHasErrors( LeaveRecordManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		LeaveRecord leaveRecord = loadLeaveRecord( userContext, leaveRecordId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,leaveRecord, tokens);
 	}
 	
 	

 	protected LeaveRecord present(FlowableUserContext userContext, LeaveRecord leaveRecord, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,leaveRecord,tokens);
		
		
		LeaveRecord  leaveRecordToPresent = leaveRecordDaoOf(userContext).present(leaveRecord, tokens);
		
		List<BaseEntity> entityListToNaming = leaveRecordToPresent.collectRefercencesFromLists();
		leaveRecordDaoOf(userContext).alias(entityListToNaming);
		
		return  leaveRecordToPresent;
		
		
	}
 
 	
 	
 	public LeaveRecord loadLeaveRecordDetail(FlowableUserContext userContext, String leaveRecordId) throws Exception{	
 		LeaveRecord leaveRecord = loadLeaveRecord( userContext, leaveRecordId, allTokens());
 		return present(userContext,leaveRecord, allTokens());
		
 	}
 	
 	public Object view(FlowableUserContext userContext, String leaveRecordId) throws Exception{	
 		LeaveRecord leaveRecord = loadLeaveRecord( userContext, leaveRecordId, viewTokens());
 		return present(userContext,leaveRecord, allTokens());
		
 	}
 	protected LeaveRecord saveLeaveRecord(FlowableUserContext userContext, LeaveRecord leaveRecord, Map<String,Object>tokens) throws Exception{	
 		return leaveRecordDaoOf(userContext).save(leaveRecord, tokens);
 	}
 	protected LeaveRecord loadLeaveRecord(FlowableUserContext userContext, String leaveRecordId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfLeaveRecord(leaveRecordId);
		checkerOf(userContext).throwExceptionIfHasErrors( LeaveRecordManagerException.class);

 
 		return leaveRecordDaoOf(userContext).load(leaveRecordId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(FlowableUserContext userContext, LeaveRecord leaveRecord, Map<String, Object> tokens){
		super.addActions(userContext, leaveRecord, tokens);
		
		addAction(userContext, leaveRecord, tokens,"@create","createLeaveRecord","createLeaveRecord/","main","primary");
		addAction(userContext, leaveRecord, tokens,"@update","updateLeaveRecord","updateLeaveRecord/"+leaveRecord.getId()+"/","main","primary");
		addAction(userContext, leaveRecord, tokens,"@copy","cloneLeaveRecord","cloneLeaveRecord/"+leaveRecord.getId()+"/","main","primary");
		
		addAction(userContext, leaveRecord, tokens,"leave_record.transfer_to_user","transferToAnotherUser","transferToAnotherUser/"+leaveRecord.getId()+"/","main","primary");
		addAction(userContext, leaveRecord, tokens,"leave_record.transfer_to_type","transferToAnotherType","transferToAnotherType/"+leaveRecord.getId()+"/","main","primary");
		addAction(userContext, leaveRecord, tokens,"leave_record.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+leaveRecord.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(FlowableUserContext userContext, LeaveRecord leaveRecord, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public LeaveRecord createLeaveRecord(FlowableUserContext userContext, String userId,String typeId,Date fromdate,Date todate,String platformId) throws Exception
	//public LeaveRecord createLeaveRecord(FlowableUserContext userContext,String userId, String typeId, Date fromdate, Date todate, String platformId) throws Exception
	{

		

		

		checkerOf(userContext).checkFromdateOfLeaveRecord(fromdate);
		checkerOf(userContext).checkTodateOfLeaveRecord(todate);
	
		checkerOf(userContext).throwExceptionIfHasErrors(LeaveRecordManagerException.class);


		LeaveRecord leaveRecord=createNewLeaveRecord();	

			
		User user = loadUser(userContext, userId,emptyOptions());
		leaveRecord.setUser(user);
		
		
			
		LeaveRecordType type = loadLeaveRecordType(userContext, typeId,emptyOptions());
		leaveRecord.setType(type);
		
		
		leaveRecord.setFromdate(fromdate);
		leaveRecord.setTodate(todate);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		leaveRecord.setPlatform(platform);
		
		

		leaveRecord = saveLeaveRecord(userContext, leaveRecord, emptyOptions());
		
		onNewInstanceCreated(userContext, leaveRecord);
		return leaveRecord;


	}
	protected LeaveRecord createNewLeaveRecord()
	{

		return new LeaveRecord();
	}

	protected void checkParamsForUpdatingLeaveRecord(FlowableUserContext userContext,String leaveRecordId, int leaveRecordVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfLeaveRecord(leaveRecordId);
		checkerOf(userContext).checkVersionOfLeaveRecord( leaveRecordVersion);
		
		

				

		
		if(LeaveRecord.FROMDATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFromdateOfLeaveRecord(parseDate(newValueExpr));
		
			
		}
		if(LeaveRecord.TODATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTodateOfLeaveRecord(parseDate(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(LeaveRecordManagerException.class);


	}



	public LeaveRecord clone(FlowableUserContext userContext, String fromLeaveRecordId) throws Exception{

		return leaveRecordDaoOf(userContext).clone(fromLeaveRecordId, this.allTokens());
	}

	public LeaveRecord internalSaveLeaveRecord(FlowableUserContext userContext, LeaveRecord leaveRecord) throws Exception
	{
		return internalSaveLeaveRecord(userContext, leaveRecord, allTokens());

	}
	public LeaveRecord internalSaveLeaveRecord(FlowableUserContext userContext, LeaveRecord leaveRecord, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingLeaveRecord(userContext, leaveRecordId, leaveRecordVersion, property, newValueExpr, tokensExpr);


		synchronized(leaveRecord){
			//will be good when the leaveRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LeaveRecord.
			if (leaveRecord.isChanged()){
			
			}
			leaveRecord = saveLeaveRecord(userContext, leaveRecord, options);
			return leaveRecord;

		}

	}

	public LeaveRecord updateLeaveRecord(FlowableUserContext userContext,String leaveRecordId, int leaveRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLeaveRecord(userContext, leaveRecordId, leaveRecordVersion, property, newValueExpr, tokensExpr);



		LeaveRecord leaveRecord = loadLeaveRecord(userContext, leaveRecordId, allTokens());
		if(leaveRecord.getVersion() != leaveRecordVersion){
			String message = "The target version("+leaveRecord.getVersion()+") is not equals to version("+leaveRecordVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(leaveRecord){
			//will be good when the leaveRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LeaveRecord.
			
			leaveRecord.changeProperty(property, newValueExpr);
			leaveRecord = saveLeaveRecord(userContext, leaveRecord, tokens().done());
			return present(userContext,leaveRecord, mergedAllTokens(tokensExpr));
			//return saveLeaveRecord(userContext, leaveRecord, tokens().done());
		}

	}

	public LeaveRecord updateLeaveRecordProperty(FlowableUserContext userContext,String leaveRecordId, int leaveRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLeaveRecord(userContext, leaveRecordId, leaveRecordVersion, property, newValueExpr, tokensExpr);

		LeaveRecord leaveRecord = loadLeaveRecord(userContext, leaveRecordId, allTokens());
		if(leaveRecord.getVersion() != leaveRecordVersion){
			String message = "The target version("+leaveRecord.getVersion()+") is not equals to version("+leaveRecordVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(leaveRecord){
			//will be good when the leaveRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LeaveRecord.

			leaveRecord.changeProperty(property, newValueExpr);
			
			leaveRecord = saveLeaveRecord(userContext, leaveRecord, tokens().done());
			return present(userContext,leaveRecord, mergedAllTokens(tokensExpr));
			//return saveLeaveRecord(userContext, leaveRecord, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected LeaveRecordTokens tokens(){
		return LeaveRecordTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LeaveRecordTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LeaveRecordTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherUser(FlowableUserContext userContext, String leaveRecordId, String anotherUserId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfLeaveRecord(leaveRecordId);
 		checkerOf(userContext).checkIdOfUser(anotherUserId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(LeaveRecordManagerException.class);

 	}
 	public LeaveRecord transferToAnotherUser(FlowableUserContext userContext, String leaveRecordId, String anotherUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherUser(userContext, leaveRecordId,anotherUserId);
 
		LeaveRecord leaveRecord = loadLeaveRecord(userContext, leaveRecordId, allTokens());	
		synchronized(leaveRecord){
			//will be good when the leaveRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			User user = loadUser(userContext, anotherUserId, emptyOptions());		
			leaveRecord.updateUser(user);		
			leaveRecord = saveLeaveRecord(userContext, leaveRecord, emptyOptions());
			
			return present(userContext,leaveRecord, allTokens());
			
		}

 	}

	


	public CandidateUser requestCandidateUser(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateUser result = new CandidateUser();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<User> candidateList = userDaoOf(userContext).requestCandidateUserForLeaveRecord(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherType(FlowableUserContext userContext, String leaveRecordId, String anotherTypeId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfLeaveRecord(leaveRecordId);
 		checkerOf(userContext).checkIdOfLeaveRecordType(anotherTypeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(LeaveRecordManagerException.class);

 	}
 	public LeaveRecord transferToAnotherType(FlowableUserContext userContext, String leaveRecordId, String anotherTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherType(userContext, leaveRecordId,anotherTypeId);
 
		LeaveRecord leaveRecord = loadLeaveRecord(userContext, leaveRecordId, allTokens());	
		synchronized(leaveRecord){
			//will be good when the leaveRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LeaveRecordType type = loadLeaveRecordType(userContext, anotherTypeId, emptyOptions());		
			leaveRecord.updateType(type);		
			leaveRecord = saveLeaveRecord(userContext, leaveRecord, emptyOptions());
			
			return present(userContext,leaveRecord, allTokens());
			
		}

 	}

	

	protected void checkParamsForTransferingAnotherTypeWithCode(FlowableUserContext userContext, String leaveRecordId, String anotherCode) throws Exception
 	{

 		checkerOf(userContext).checkIdOfLeaveRecord(leaveRecordId);
 		checkerOf(userContext).checkCodeOfLeaveRecordType( anotherCode);
 		checkerOf(userContext).throwExceptionIfHasErrors(LeaveRecordManagerException.class);

 	}

 	public LeaveRecord transferToAnotherTypeWithCode(FlowableUserContext userContext, String leaveRecordId, String anotherCode) throws Exception
 	{
 		checkParamsForTransferingAnotherTypeWithCode(userContext, leaveRecordId,anotherCode);
 		LeaveRecord leaveRecord = loadLeaveRecord(userContext, leaveRecordId, allTokens());
		synchronized(leaveRecord){
			//will be good when the leaveRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LeaveRecordType type = loadLeaveRecordTypeWithCode(userContext, anotherCode, emptyOptions());
			leaveRecord.updateType(type);
			leaveRecord = saveLeaveRecord(userContext, leaveRecord, emptyOptions());

			return present(userContext,leaveRecord, allTokens());

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
		SmartList<LeaveRecordType> candidateList = leaveRecordTypeDaoOf(userContext).requestCandidateLeaveRecordTypeForLeaveRecord(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherPlatform(FlowableUserContext userContext, String leaveRecordId, String anotherPlatformId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfLeaveRecord(leaveRecordId);
 		checkerOf(userContext).checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(LeaveRecordManagerException.class);

 	}
 	public LeaveRecord transferToAnotherPlatform(FlowableUserContext userContext, String leaveRecordId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, leaveRecordId,anotherPlatformId);
 
		LeaveRecord leaveRecord = loadLeaveRecord(userContext, leaveRecordId, allTokens());	
		synchronized(leaveRecord){
			//will be good when the leaveRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			leaveRecord.updatePlatform(platform);		
			leaveRecord = saveLeaveRecord(userContext, leaveRecord, emptyOptions());
			
			return present(userContext,leaveRecord, allTokens());
			
		}

 	}

	


	public CandidatePlatform requestCandidatePlatform(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePlatform result = new CandidatePlatform();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Platform> candidateList = platformDaoOf(userContext).requestCandidatePlatformForLeaveRecord(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected User loadUser(FlowableUserContext userContext, String newUserId, Map<String,Object> options) throws Exception
 	{

 		return userDaoOf(userContext).load(newUserId, options);
 	}
 	


	

 	protected LeaveRecordType loadLeaveRecordType(FlowableUserContext userContext, String newTypeId, Map<String,Object> options) throws Exception
 	{

 		return leaveRecordTypeDaoOf(userContext).load(newTypeId, options);
 	}
 	
 	protected LeaveRecordType loadLeaveRecordTypeWithCode(FlowableUserContext userContext, String newCode, Map<String,Object> options) throws Exception
 	{

 		return leaveRecordTypeDaoOf(userContext).loadByCode(newCode, options);
 	}

 	


	

 	protected Platform loadPlatform(FlowableUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{

 		return platformDaoOf(userContext).load(newPlatformId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(FlowableUserContext userContext, String leaveRecordId, int leaveRecordVersion) throws Exception {
		//deleteInternal(userContext, leaveRecordId, leaveRecordVersion);
	}
	protected void deleteInternal(FlowableUserContext userContext,
			String leaveRecordId, int leaveRecordVersion) throws Exception{

		leaveRecordDaoOf(userContext).delete(leaveRecordId, leaveRecordVersion);
	}

	public LeaveRecord forgetByAll(FlowableUserContext userContext, String leaveRecordId, int leaveRecordVersion) throws Exception {
		return forgetByAllInternal(userContext, leaveRecordId, leaveRecordVersion);
	}
	protected LeaveRecord forgetByAllInternal(FlowableUserContext userContext,
			String leaveRecordId, int leaveRecordVersion) throws Exception{

		return leaveRecordDaoOf(userContext).disconnectFromAll(leaveRecordId, leaveRecordVersion);
	}




	public int deleteAll(FlowableUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LeaveRecordManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(FlowableUserContext userContext) throws Exception{
		return leaveRecordDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(FlowableUserContext userContext, LeaveRecord newCreated) throws Exception{
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, LeaveRecord.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(FlowableUserContext userContext,SmartList<LeaveRecord> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<User> userList = FlowableBaseUtils.collectReferencedObjectWithType(userContext, list, User.class);
		userContext.getDAOGroup().enhanceList(userList, User.class);
		List<LeaveRecordType> typeList = FlowableBaseUtils.collectReferencedObjectWithType(userContext, list, LeaveRecordType.class);
		userContext.getDAOGroup().enhanceList(typeList, LeaveRecordType.class);
		List<Platform> platformList = FlowableBaseUtils.collectReferencedObjectWithType(userContext, list, Platform.class);
		userContext.getDAOGroup().enhanceList(platformList, Platform.class);

	
    }
	
	public Object listByUser(FlowableUserContext userContext,String userId) throws Exception {
		return listPageByUser(userContext, userId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByUser(FlowableUserContext userContext,String userId, int start, int count) throws Exception {
		SmartList<LeaveRecord> list = leaveRecordDaoOf(userContext).findLeaveRecordByUser(userId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		FlowableCommonListOfViewPage page = new FlowableCommonListOfViewPage();
		page.setClassOfList(LeaveRecord.class);
		page.setContainerObject(User.withId(userId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("用户列表");
		page.setRequestName("listByUser");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		
		page.assemblerContent(userContext, "listByUser");
		return page.doRender(userContext);
	}
  
	public Object listByType(FlowableUserContext userContext,String typeId) throws Exception {
		return listPageByType(userContext, typeId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByType(FlowableUserContext userContext,String typeId, int start, int count) throws Exception {
		SmartList<LeaveRecord> list = leaveRecordDaoOf(userContext).findLeaveRecordByType(typeId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		FlowableCommonListOfViewPage page = new FlowableCommonListOfViewPage();
		page.setClassOfList(LeaveRecord.class);
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
  
	public Object listByPlatform(FlowableUserContext userContext,String platformId) throws Exception {
		return listPageByPlatform(userContext, platformId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByPlatform(FlowableUserContext userContext,String platformId, int start, int count) throws Exception {
		SmartList<LeaveRecord> list = leaveRecordDaoOf(userContext).findLeaveRecordByPlatform(platformId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		FlowableCommonListOfViewPage page = new FlowableCommonListOfViewPage();
		page.setClassOfList(LeaveRecord.class);
		page.setContainerObject(Platform.withId(platformId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("平台列表");
		page.setRequestName("listByPlatform");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		
		page.assemblerContent(userContext, "listByPlatform");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------
}


