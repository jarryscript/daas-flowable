
package com.doublechain.flowable.role;

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


import com.doublechain.flowable.district.District;
import com.doublechain.flowable.role.Role;






public class RoleManagerImpl extends CustomFlowableCheckerManager implements RoleManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "Role";
	@Override
	public RoleDAO daoOf(FlowableUserContext userContext) {
		return roleDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws RoleManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RoleManagerException(message);

	}



 	protected Role saveRole(FlowableUserContext userContext, Role role, String [] tokensExpr) throws Exception{	
 		//return getRoleDAO().save(role, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRole(userContext, role, tokens);
 	}
 	
 	protected Role saveRoleDetail(FlowableUserContext userContext, Role role) throws Exception{	

 		
 		return saveRole(userContext, role, allTokens());
 	}
 	
 	public Role loadRole(FlowableUserContext userContext, String roleId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRole(roleId);
		checkerOf(userContext).throwExceptionIfHasErrors( RoleManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Role role = loadRole( userContext, roleId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,role, tokens);
 	}
 	
 	
 	 public Role searchRole(FlowableUserContext userContext, String roleId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRole(roleId);
		checkerOf(userContext).throwExceptionIfHasErrors( RoleManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Role role = loadRole( userContext, roleId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,role, tokens);
 	}
 	
 	

 	protected Role present(FlowableUserContext userContext, Role role, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,role,tokens);
		
		
		Role  roleToPresent = roleDaoOf(userContext).present(role, tokens);
		
		List<BaseEntity> entityListToNaming = roleToPresent.collectRefercencesFromLists();
		roleDaoOf(userContext).alias(entityListToNaming);
		
		return  roleToPresent;
		
		
	}
 
 	
 	
 	public Role loadRoleDetail(FlowableUserContext userContext, String roleId) throws Exception{	
 		Role role = loadRole( userContext, roleId, allTokens());
 		return present(userContext,role, allTokens());
		
 	}
 	
 	public Object view(FlowableUserContext userContext, String roleId) throws Exception{	
 		Role role = loadRole( userContext, roleId, viewTokens());
 		return present(userContext,role, allTokens());
		
 	}
 	protected Role saveRole(FlowableUserContext userContext, Role role, Map<String,Object>tokens) throws Exception{	
 		return roleDaoOf(userContext).save(role, tokens);
 	}
 	protected Role loadRole(FlowableUserContext userContext, String roleId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRole(roleId);
		checkerOf(userContext).throwExceptionIfHasErrors( RoleManagerException.class);

 
 		return roleDaoOf(userContext).load(roleId, tokens);
 	}

	
	

	public Role loadRoleWithCode(FlowableUserContext userContext, String code, Map<String,Object>tokens) throws Exception{	
 		return roleDaoOf(userContext).loadByCode(code, tokens);
 	}

	 


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(FlowableUserContext userContext, Role role, Map<String, Object> tokens){
		super.addActions(userContext, role, tokens);
		
		addAction(userContext, role, tokens,"@create","createRole","createRole/","main","primary");
		addAction(userContext, role, tokens,"@update","updateRole","updateRole/"+role.getId()+"/","main","primary");
		addAction(userContext, role, tokens,"@copy","cloneRole","cloneRole/"+role.getId()+"/","main","primary");
		
		addAction(userContext, role, tokens,"role.addUser","addUser","addUser/"+role.getId()+"/","userList","primary");
		addAction(userContext, role, tokens,"role.removeUser","removeUser","removeUser/"+role.getId()+"/","userList","primary");
		addAction(userContext, role, tokens,"role.updateUser","updateUser","updateUser/"+role.getId()+"/","userList","primary");
		addAction(userContext, role, tokens,"role.copyUserFrom","copyUserFrom","copyUserFrom/"+role.getId()+"/","userList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(FlowableUserContext userContext, Role role, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public Role createRole(FlowableUserContext userContext, String name,String code) throws Exception
	//public Role createRole(FlowableUserContext userContext,String name, String code) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfRole(name);
		checkerOf(userContext).checkCodeOfRole(code);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RoleManagerException.class);


		Role role=createNewRole();	

		role.setName(name);
		role.setCode(code);

		role = saveRole(userContext, role, emptyOptions());
		
		onNewInstanceCreated(userContext, role);
		return role;


	}
	protected Role createNewRole()
	{

		return new Role();
	}

	protected void checkParamsForUpdatingRole(FlowableUserContext userContext,String roleId, int roleVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfRole(roleId);
		checkerOf(userContext).checkVersionOfRole( roleVersion);
		

		if(Role.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfRole(parseString(newValueExpr));
		
			
		}
		if(Role.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfRole(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(RoleManagerException.class);


	}



	public Role clone(FlowableUserContext userContext, String fromRoleId) throws Exception{

		return roleDaoOf(userContext).clone(fromRoleId, this.allTokens());
	}

	public Role internalSaveRole(FlowableUserContext userContext, Role role) throws Exception
	{
		return internalSaveRole(userContext, role, allTokens());

	}
	public Role internalSaveRole(FlowableUserContext userContext, Role role, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRole(userContext, roleId, roleVersion, property, newValueExpr, tokensExpr);


		synchronized(role){
			//will be good when the role loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Role.
			if (role.isChanged()){
			
			}
			role = saveRole(userContext, role, options);
			return role;

		}

	}

	public Role updateRole(FlowableUserContext userContext,String roleId, int roleVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRole(userContext, roleId, roleVersion, property, newValueExpr, tokensExpr);



		Role role = loadRole(userContext, roleId, allTokens());
		if(role.getVersion() != roleVersion){
			String message = "The target version("+role.getVersion()+") is not equals to version("+roleVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(role){
			//will be good when the role loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Role.
			
			role.changeProperty(property, newValueExpr);
			role = saveRole(userContext, role, tokens().done());
			return present(userContext,role, mergedAllTokens(tokensExpr));
			//return saveRole(userContext, role, tokens().done());
		}

	}

	public Role updateRoleProperty(FlowableUserContext userContext,String roleId, int roleVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRole(userContext, roleId, roleVersion, property, newValueExpr, tokensExpr);

		Role role = loadRole(userContext, roleId, allTokens());
		if(role.getVersion() != roleVersion){
			String message = "The target version("+role.getVersion()+") is not equals to version("+roleVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(role){
			//will be good when the role loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Role.

			role.changeProperty(property, newValueExpr);
			
			role = saveRole(userContext, role, tokens().done());
			return present(userContext,role, mergedAllTokens(tokensExpr));
			//return saveRole(userContext, role, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RoleTokens tokens(){
		return RoleTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RoleTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortUserListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RoleTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(FlowableUserContext userContext, String roleId, int roleVersion) throws Exception {
		//deleteInternal(userContext, roleId, roleVersion);
	}
	protected void deleteInternal(FlowableUserContext userContext,
			String roleId, int roleVersion) throws Exception{

		roleDaoOf(userContext).delete(roleId, roleVersion);
	}

	public Role forgetByAll(FlowableUserContext userContext, String roleId, int roleVersion) throws Exception {
		return forgetByAllInternal(userContext, roleId, roleVersion);
	}
	protected Role forgetByAllInternal(FlowableUserContext userContext,
			String roleId, int roleVersion) throws Exception{

		return roleDaoOf(userContext).disconnectFromAll(roleId, roleVersion);
	}




	public int deleteAll(FlowableUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RoleManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(FlowableUserContext userContext) throws Exception{
		return roleDaoOf(userContext).deleteAll();
	}


	//disconnect Role with district in User
	protected Role breakWithUserByDistrict(FlowableUserContext userContext, String roleId, String districtId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Role role = loadRole(userContext, roleId, allTokens());

			synchronized(role){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				roleDaoOf(userContext).planToRemoveUserListWithDistrict(role, districtId, this.emptyOptions());

				role = saveRole(userContext, role, tokens().withUserList().done());
				return role;
			}
	}






	protected void checkParamsForAddingUser(FlowableUserContext userContext, String roleId, String name, String mobile, String avatar, int age, String description, String districtId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRole(roleId);

		
		checkerOf(userContext).checkNameOfUser(name);
		
		checkerOf(userContext).checkMobileOfUser(mobile);
		
		checkerOf(userContext).checkAvatarOfUser(avatar);
		
		checkerOf(userContext).checkAgeOfUser(age);
		
		checkerOf(userContext).checkDescriptionOfUser(description);
		
		checkerOf(userContext).checkDistrictIdOfUser(districtId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RoleManagerException.class);


	}
	public  Role addUser(FlowableUserContext userContext, String roleId, String name, String mobile, String avatar, int age, String description, String districtId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingUser(userContext,roleId,name, mobile, avatar, age, description, districtId,tokensExpr);

		User user = createUser(userContext,name, mobile, avatar, age, description, districtId);

		Role role = loadRole(userContext, roleId, emptyOptions());
		synchronized(role){
			//Will be good when the role loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			role.addUser( user );
			role = saveRole(userContext, role, tokens().withUserList().done());
			
			userContext.getManagerGroup().getUserManager().onNewInstanceCreated(userContext, user);
			return present(userContext,role, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingUserProperties(FlowableUserContext userContext, String roleId,String id,String name,String mobile,String avatar,int age,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRole(roleId);
		checkerOf(userContext).checkIdOfUser(id);

		checkerOf(userContext).checkNameOfUser( name);
		checkerOf(userContext).checkMobileOfUser( mobile);
		checkerOf(userContext).checkAvatarOfUser( avatar);
		checkerOf(userContext).checkAgeOfUser( age);
		checkerOf(userContext).checkDescriptionOfUser( description);

		checkerOf(userContext).throwExceptionIfHasErrors(RoleManagerException.class);

	}
	public  Role updateUserProperties(FlowableUserContext userContext, String roleId, String id,String name,String mobile,String avatar,int age,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingUserProperties(userContext,roleId,id,name,mobile,avatar,age,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withUserListList()
				.searchUserListWith(User.ID_PROPERTY, "is", id).done();

		Role roleToUpdate = loadRole(userContext, roleId, options);

		if(roleToUpdate.getUserList().isEmpty()){
			throw new RoleManagerException("User is NOT FOUND with id: '"+id+"'");
		}

		User item = roleToUpdate.getUserList().first();

		item.updateName( name );
		item.updateMobile( mobile );
		item.updateAvatar( avatar );
		item.updateAge( age );
		item.updateDescription( description );


		//checkParamsForAddingUser(userContext,roleId,name, code, used,tokensExpr);
		Role role = saveRole(userContext, roleToUpdate, tokens().withUserList().done());
		synchronized(role){
			return present(userContext,role, mergedAllTokens(tokensExpr));
		}
	}


	protected User createUser(FlowableUserContext userContext, String name, String mobile, String avatar, int age, String description, String districtId) throws Exception{

		User user = new User();
		
		
		user.setName(name);		
		user.setMobile(mobile);		
		user.setAvatar(avatar);		
		user.setAge(age);		
		user.setDescription(description);		
		District  district = new District();
		district.setId(districtId);		
		user.setDistrict(district);
	
		
		return user;


	}

	protected User createIndexedUser(String id, int version){

		User user = new User();
		user.setId(id);
		user.setVersion(version);
		return user;

	}

	protected void checkParamsForRemovingUserList(FlowableUserContext userContext, String roleId,
			String userIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRole(roleId);
		for(String userIdItem: userIds){
			checkerOf(userContext).checkIdOfUser(userIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RoleManagerException.class);

	}
	public  Role removeUserList(FlowableUserContext userContext, String roleId,
			String userIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingUserList(userContext, roleId,  userIds, tokensExpr);


			Role role = loadRole(userContext, roleId, allTokens());
			synchronized(role){
				//Will be good when the role loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				roleDaoOf(userContext).planToRemoveUserList(role, userIds, allTokens());
				role = saveRole(userContext, role, tokens().withUserList().done());
				deleteRelationListInGraph(userContext, role.getUserList());
				return present(userContext,role, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingUser(FlowableUserContext userContext, String roleId,
		String userId, int userVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRole( roleId);
		checkerOf(userContext).checkIdOfUser(userId);
		checkerOf(userContext).checkVersionOfUser(userVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RoleManagerException.class);

	}
	public  Role removeUser(FlowableUserContext userContext, String roleId,
		String userId, int userVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingUser(userContext,roleId, userId, userVersion,tokensExpr);

		User user = createIndexedUser(userId, userVersion);
		Role role = loadRole(userContext, roleId, allTokens());
		synchronized(role){
			//Will be good when the role loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			role.removeUser( user );
			role = saveRole(userContext, role, tokens().withUserList().done());
			deleteRelationInGraph(userContext, user);
			return present(userContext,role, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingUser(FlowableUserContext userContext, String roleId,
		String userId, int userVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRole( roleId);
		checkerOf(userContext).checkIdOfUser(userId);
		checkerOf(userContext).checkVersionOfUser(userVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RoleManagerException.class);

	}
	public  Role copyUserFrom(FlowableUserContext userContext, String roleId,
		String userId, int userVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingUser(userContext,roleId, userId, userVersion,tokensExpr);

		User user = createIndexedUser(userId, userVersion);
		Role role = loadRole(userContext, roleId, allTokens());
		synchronized(role){
			//Will be good when the role loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			role.copyUserFrom( user );
			role = saveRole(userContext, role, tokens().withUserList().done());
			
			userContext.getManagerGroup().getUserManager().onNewInstanceCreated(userContext, (User)role.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,role, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingUser(FlowableUserContext userContext, String roleId, String userId, int userVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRole(roleId);
		checkerOf(userContext).checkIdOfUser(userId);
		checkerOf(userContext).checkVersionOfUser(userVersion);
		

		if(User.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfUser(parseString(newValueExpr));
		
		}
		
		if(User.MOBILE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMobileOfUser(parseString(newValueExpr));
		
		}
		
		if(User.AVATAR_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAvatarOfUser(parseString(newValueExpr));
		
		}
		
		if(User.AGE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAgeOfUser(parseInt(newValueExpr));
		
		}
		
		if(User.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfUser(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RoleManagerException.class);

	}

	public  Role updateUser(FlowableUserContext userContext, String roleId, String userId, int userVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingUser(userContext, roleId, userId, userVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withUserList().searchUserListWith(User.ID_PROPERTY, "eq", userId).done();



		Role role = loadRole(userContext, roleId, loadTokens);

		synchronized(role){
			//Will be good when the role loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//role.removeUser( user );
			//make changes to AcceleraterAccount.
			User userIndex = createIndexedUser(userId, userVersion);

			User user = role.findTheUser(userIndex);
			if(user == null){
				throw new RoleManagerException(user+" is NOT FOUND" );
			}

			user.changeProperty(property, newValueExpr);
			
			role = saveRole(userContext, role, tokens().withUserList().done());
			return present(userContext,role, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(FlowableUserContext userContext, Role newCreated) throws Exception{
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, Role.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(FlowableUserContext userContext,SmartList<Role> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}

	
    }
	
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------
}


