
package com.doublechain.flowable.formaction;

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


import com.doublechain.flowable.genericform.GenericForm;

import com.doublechain.flowable.genericform.CandidateGenericForm;







public class FormActionManagerImpl extends CustomFlowableCheckerManager implements FormActionManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "FormAction";
	@Override
	public FormActionDAO daoOf(FlowableUserContext userContext) {
		return formActionDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws FormActionManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new FormActionManagerException(message);

	}



 	protected FormAction saveFormAction(FlowableUserContext userContext, FormAction formAction, String [] tokensExpr) throws Exception{	
 		//return getFormActionDAO().save(formAction, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveFormAction(userContext, formAction, tokens);
 	}
 	
 	protected FormAction saveFormActionDetail(FlowableUserContext userContext, FormAction formAction) throws Exception{	

 		
 		return saveFormAction(userContext, formAction, allTokens());
 	}
 	
 	public FormAction loadFormAction(FlowableUserContext userContext, String formActionId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFormAction(formActionId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormActionManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		FormAction formAction = loadFormAction( userContext, formActionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formAction, tokens);
 	}
 	
 	
 	 public FormAction searchFormAction(FlowableUserContext userContext, String formActionId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFormAction(formActionId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormActionManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		FormAction formAction = loadFormAction( userContext, formActionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formAction, tokens);
 	}
 	
 	

 	protected FormAction present(FlowableUserContext userContext, FormAction formAction, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,formAction,tokens);
		
		
		FormAction  formActionToPresent = formActionDaoOf(userContext).present(formAction, tokens);
		
		List<BaseEntity> entityListToNaming = formActionToPresent.collectRefercencesFromLists();
		formActionDaoOf(userContext).alias(entityListToNaming);
		
		return  formActionToPresent;
		
		
	}
 
 	
 	
 	public FormAction loadFormActionDetail(FlowableUserContext userContext, String formActionId) throws Exception{	
 		FormAction formAction = loadFormAction( userContext, formActionId, allTokens());
 		return present(userContext,formAction, allTokens());
		
 	}
 	
 	public Object view(FlowableUserContext userContext, String formActionId) throws Exception{	
 		FormAction formAction = loadFormAction( userContext, formActionId, viewTokens());
 		return present(userContext,formAction, allTokens());
		
 	}
 	protected FormAction saveFormAction(FlowableUserContext userContext, FormAction formAction, Map<String,Object>tokens) throws Exception{	
 		return formActionDaoOf(userContext).save(formAction, tokens);
 	}
 	protected FormAction loadFormAction(FlowableUserContext userContext, String formActionId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfFormAction(formActionId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormActionManagerException.class);

 
 		return formActionDaoOf(userContext).load(formActionId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(FlowableUserContext userContext, FormAction formAction, Map<String, Object> tokens){
		super.addActions(userContext, formAction, tokens);
		
		addAction(userContext, formAction, tokens,"@create","createFormAction","createFormAction/","main","primary");
		addAction(userContext, formAction, tokens,"@update","updateFormAction","updateFormAction/"+formAction.getId()+"/","main","primary");
		addAction(userContext, formAction, tokens,"@copy","cloneFormAction","cloneFormAction/"+formAction.getId()+"/","main","primary");
		
		addAction(userContext, formAction, tokens,"form_action.transfer_to_form","transferToAnotherForm","transferToAnotherForm/"+formAction.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(FlowableUserContext userContext, FormAction formAction, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public FormAction createFormAction(FlowableUserContext userContext, String label,String localeKey,String actionKey,String level,String url,String formId) throws Exception
	//public FormAction createFormAction(FlowableUserContext userContext,String label, String localeKey, String actionKey, String level, String url, String formId) throws Exception
	{

		

		

		checkerOf(userContext).checkLabelOfFormAction(label);
		checkerOf(userContext).checkLocaleKeyOfFormAction(localeKey);
		checkerOf(userContext).checkActionKeyOfFormAction(actionKey);
		checkerOf(userContext).checkLevelOfFormAction(level);
		checkerOf(userContext).checkUrlOfFormAction(url);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FormActionManagerException.class);


		FormAction formAction=createNewFormAction();	

		formAction.setLabel(label);
		formAction.setLocaleKey(localeKey);
		formAction.setActionKey(actionKey);
		formAction.setLevel(level);
		formAction.setUrl(url);
			
		GenericForm form = loadGenericForm(userContext, formId,emptyOptions());
		formAction.setForm(form);
		
		

		formAction = saveFormAction(userContext, formAction, emptyOptions());
		
		onNewInstanceCreated(userContext, formAction);
		return formAction;


	}
	protected FormAction createNewFormAction()
	{

		return new FormAction();
	}

	protected void checkParamsForUpdatingFormAction(FlowableUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfFormAction(formActionId);
		checkerOf(userContext).checkVersionOfFormAction( formActionVersion);
		

		if(FormAction.LABEL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLabelOfFormAction(parseString(newValueExpr));
		
			
		}
		if(FormAction.LOCALE_KEY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLocaleKeyOfFormAction(parseString(newValueExpr));
		
			
		}
		if(FormAction.ACTION_KEY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkActionKeyOfFormAction(parseString(newValueExpr));
		
			
		}
		if(FormAction.LEVEL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLevelOfFormAction(parseString(newValueExpr));
		
			
		}
		if(FormAction.URL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkUrlOfFormAction(parseString(newValueExpr));
		
			
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(FormActionManagerException.class);


	}



	public FormAction clone(FlowableUserContext userContext, String fromFormActionId) throws Exception{

		return formActionDaoOf(userContext).clone(fromFormActionId, this.allTokens());
	}

	public FormAction internalSaveFormAction(FlowableUserContext userContext, FormAction formAction) throws Exception
	{
		return internalSaveFormAction(userContext, formAction, allTokens());

	}
	public FormAction internalSaveFormAction(FlowableUserContext userContext, FormAction formAction, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingFormAction(userContext, formActionId, formActionVersion, property, newValueExpr, tokensExpr);


		synchronized(formAction){
			//will be good when the formAction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormAction.
			if (formAction.isChanged()){
			
			}
			formAction = saveFormAction(userContext, formAction, options);
			return formAction;

		}

	}

	public FormAction updateFormAction(FlowableUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFormAction(userContext, formActionId, formActionVersion, property, newValueExpr, tokensExpr);



		FormAction formAction = loadFormAction(userContext, formActionId, allTokens());
		if(formAction.getVersion() != formActionVersion){
			String message = "The target version("+formAction.getVersion()+") is not equals to version("+formActionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formAction){
			//will be good when the formAction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormAction.
			
			formAction.changeProperty(property, newValueExpr);
			formAction = saveFormAction(userContext, formAction, tokens().done());
			return present(userContext,formAction, mergedAllTokens(tokensExpr));
			//return saveFormAction(userContext, formAction, tokens().done());
		}

	}

	public FormAction updateFormActionProperty(FlowableUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingFormAction(userContext, formActionId, formActionVersion, property, newValueExpr, tokensExpr);

		FormAction formAction = loadFormAction(userContext, formActionId, allTokens());
		if(formAction.getVersion() != formActionVersion){
			String message = "The target version("+formAction.getVersion()+") is not equals to version("+formActionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formAction){
			//will be good when the formAction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormAction.

			formAction.changeProperty(property, newValueExpr);
			
			formAction = saveFormAction(userContext, formAction, tokens().done());
			return present(userContext,formAction, mergedAllTokens(tokensExpr));
			//return saveFormAction(userContext, formAction, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected FormActionTokens tokens(){
		return FormActionTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return FormActionTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return FormActionTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherForm(FlowableUserContext userContext, String formActionId, String anotherFormId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfFormAction(formActionId);
 		checkerOf(userContext).checkIdOfGenericForm(anotherFormId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(FormActionManagerException.class);

 	}
 	public FormAction transferToAnotherForm(FlowableUserContext userContext, String formActionId, String anotherFormId) throws Exception
 	{
 		checkParamsForTransferingAnotherForm(userContext, formActionId,anotherFormId);
 
		FormAction formAction = loadFormAction(userContext, formActionId, allTokens());	
		synchronized(formAction){
			//will be good when the formAction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GenericForm form = loadGenericForm(userContext, anotherFormId, emptyOptions());		
			formAction.updateForm(form);		
			formAction = saveFormAction(userContext, formAction, emptyOptions());
			
			return present(userContext,formAction, allTokens());
			
		}

 	}

	


	public CandidateGenericForm requestCandidateForm(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateGenericForm result = new CandidateGenericForm();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<GenericForm> candidateList = genericFormDaoOf(userContext).requestCandidateGenericFormForFormAction(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected GenericForm loadGenericForm(FlowableUserContext userContext, String newFormId, Map<String,Object> options) throws Exception
 	{

 		return genericFormDaoOf(userContext).load(newFormId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(FlowableUserContext userContext, String formActionId, int formActionVersion) throws Exception {
		//deleteInternal(userContext, formActionId, formActionVersion);
	}
	protected void deleteInternal(FlowableUserContext userContext,
			String formActionId, int formActionVersion) throws Exception{

		formActionDaoOf(userContext).delete(formActionId, formActionVersion);
	}

	public FormAction forgetByAll(FlowableUserContext userContext, String formActionId, int formActionVersion) throws Exception {
		return forgetByAllInternal(userContext, formActionId, formActionVersion);
	}
	protected FormAction forgetByAllInternal(FlowableUserContext userContext,
			String formActionId, int formActionVersion) throws Exception{

		return formActionDaoOf(userContext).disconnectFromAll(formActionId, formActionVersion);
	}




	public int deleteAll(FlowableUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new FormActionManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(FlowableUserContext userContext) throws Exception{
		return formActionDaoOf(userContext).deleteAll();
	}








	public void onNewInstanceCreated(FlowableUserContext userContext, FormAction newCreated) throws Exception{
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, FormAction.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(FlowableUserContext userContext,SmartList<FormAction> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<GenericForm> formList = FlowableBaseUtils.collectReferencedObjectWithType(userContext, list, GenericForm.class);
		userContext.getDAOGroup().enhanceList(formList, GenericForm.class);

	
    }
	
	public Object listByForm(FlowableUserContext userContext,String formId) throws Exception {
		return listPageByForm(userContext, formId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByForm(FlowableUserContext userContext,String formId, int start, int count) throws Exception {
		SmartList<FormAction> list = formActionDaoOf(userContext).findFormActionByForm(formId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		FlowableCommonListOfViewPage page = new FlowableCommonListOfViewPage();
		page.setClassOfList(FormAction.class);
		page.setContainerObject(GenericForm.withId(formId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("形式列表");
		page.setRequestName("listByForm");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		
		page.assemblerContent(userContext, "listByForm");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------
}


