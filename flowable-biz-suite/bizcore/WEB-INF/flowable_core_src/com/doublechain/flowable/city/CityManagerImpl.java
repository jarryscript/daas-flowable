
package com.doublechain.flowable.city;

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


import com.doublechain.flowable.province.Province;
import com.doublechain.flowable.district.District;
import com.doublechain.flowable.platform.Platform;

import com.doublechain.flowable.province.CandidateProvince;
import com.doublechain.flowable.platform.CandidatePlatform;

import com.doublechain.flowable.city.City;
import com.doublechain.flowable.platform.Platform;






public class CityManagerImpl extends CustomFlowableCheckerManager implements CityManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "City";
	@Override
	public CityDAO daoOf(FlowableUserContext userContext) {
		return cityDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws CityManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new CityManagerException(message);

	}



 	protected City saveCity(FlowableUserContext userContext, City city, String [] tokensExpr) throws Exception{	
 		//return getCityDAO().save(city, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCity(userContext, city, tokens);
 	}
 	
 	protected City saveCityDetail(FlowableUserContext userContext, City city) throws Exception{	

 		
 		return saveCity(userContext, city, allTokens());
 	}
 	
 	public City loadCity(FlowableUserContext userContext, String cityId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCity(cityId);
		checkerOf(userContext).throwExceptionIfHasErrors( CityManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		City city = loadCity( userContext, cityId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,city, tokens);
 	}
 	
 	
 	 public City searchCity(FlowableUserContext userContext, String cityId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCity(cityId);
		checkerOf(userContext).throwExceptionIfHasErrors( CityManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		City city = loadCity( userContext, cityId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,city, tokens);
 	}
 	
 	

 	protected City present(FlowableUserContext userContext, City city, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,city,tokens);
		
		
		City  cityToPresent = cityDaoOf(userContext).present(city, tokens);
		
		List<BaseEntity> entityListToNaming = cityToPresent.collectRefercencesFromLists();
		cityDaoOf(userContext).alias(entityListToNaming);
		
		return  cityToPresent;
		
		
	}
 
 	
 	
 	public City loadCityDetail(FlowableUserContext userContext, String cityId) throws Exception{	
 		City city = loadCity( userContext, cityId, allTokens());
 		return present(userContext,city, allTokens());
		
 	}
 	
 	public Object view(FlowableUserContext userContext, String cityId) throws Exception{	
 		City city = loadCity( userContext, cityId, viewTokens());
 		return present(userContext,city, allTokens());
		
 	}
 	protected City saveCity(FlowableUserContext userContext, City city, Map<String,Object>tokens) throws Exception{	
 		return cityDaoOf(userContext).save(city, tokens);
 	}
 	protected City loadCity(FlowableUserContext userContext, String cityId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfCity(cityId);
		checkerOf(userContext).throwExceptionIfHasErrors( CityManagerException.class);

 
 		return cityDaoOf(userContext).load(cityId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(FlowableUserContext userContext, City city, Map<String, Object> tokens){
		super.addActions(userContext, city, tokens);
		
		addAction(userContext, city, tokens,"@create","createCity","createCity/","main","primary");
		addAction(userContext, city, tokens,"@update","updateCity","updateCity/"+city.getId()+"/","main","primary");
		addAction(userContext, city, tokens,"@copy","cloneCity","cloneCity/"+city.getId()+"/","main","primary");
		
		addAction(userContext, city, tokens,"city.transfer_to_province","transferToAnotherProvince","transferToAnotherProvince/"+city.getId()+"/","main","primary");
		addAction(userContext, city, tokens,"city.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+city.getId()+"/","main","primary");
		addAction(userContext, city, tokens,"city.addDistrict","addDistrict","addDistrict/"+city.getId()+"/","districtList","primary");
		addAction(userContext, city, tokens,"city.removeDistrict","removeDistrict","removeDistrict/"+city.getId()+"/","districtList","primary");
		addAction(userContext, city, tokens,"city.updateDistrict","updateDistrict","updateDistrict/"+city.getId()+"/","districtList","primary");
		addAction(userContext, city, tokens,"city.copyDistrictFrom","copyDistrictFrom","copyDistrictFrom/"+city.getId()+"/","districtList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(FlowableUserContext userContext, City city, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public City createCity(FlowableUserContext userContext, String name,String provinceId,String platformId) throws Exception
	//public City createCity(FlowableUserContext userContext,String name, String provinceId, String platformId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfCity(name);
	
		checkerOf(userContext).throwExceptionIfHasErrors(CityManagerException.class);


		City city=createNewCity();	

		city.setName(name);
			
		Province province = loadProvince(userContext, provinceId,emptyOptions());
		city.setProvince(province);
		
		
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		city.setPlatform(platform);
		
		

		city = saveCity(userContext, city, emptyOptions());
		
		onNewInstanceCreated(userContext, city);
		return city;


	}
	protected City createNewCity()
	{

		return new City();
	}

	protected void checkParamsForUpdatingCity(FlowableUserContext userContext,String cityId, int cityVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfCity(cityId);
		checkerOf(userContext).checkVersionOfCity( cityVersion);
		

		if(City.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfCity(parseString(newValueExpr));
		
			
		}		

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(CityManagerException.class);


	}



	public City clone(FlowableUserContext userContext, String fromCityId) throws Exception{

		return cityDaoOf(userContext).clone(fromCityId, this.allTokens());
	}

	public City internalSaveCity(FlowableUserContext userContext, City city) throws Exception
	{
		return internalSaveCity(userContext, city, allTokens());

	}
	public City internalSaveCity(FlowableUserContext userContext, City city, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingCity(userContext, cityId, cityVersion, property, newValueExpr, tokensExpr);


		synchronized(city){
			//will be good when the city loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to City.
			if (city.isChanged()){
			
			}
			city = saveCity(userContext, city, options);
			return city;

		}

	}

	public City updateCity(FlowableUserContext userContext,String cityId, int cityVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCity(userContext, cityId, cityVersion, property, newValueExpr, tokensExpr);



		City city = loadCity(userContext, cityId, allTokens());
		if(city.getVersion() != cityVersion){
			String message = "The target version("+city.getVersion()+") is not equals to version("+cityVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(city){
			//will be good when the city loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to City.
			
			city.changeProperty(property, newValueExpr);
			city = saveCity(userContext, city, tokens().done());
			return present(userContext,city, mergedAllTokens(tokensExpr));
			//return saveCity(userContext, city, tokens().done());
		}

	}

	public City updateCityProperty(FlowableUserContext userContext,String cityId, int cityVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCity(userContext, cityId, cityVersion, property, newValueExpr, tokensExpr);

		City city = loadCity(userContext, cityId, allTokens());
		if(city.getVersion() != cityVersion){
			String message = "The target version("+city.getVersion()+") is not equals to version("+cityVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(city){
			//will be good when the city loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to City.

			city.changeProperty(property, newValueExpr);
			
			city = saveCity(userContext, city, tokens().done());
			return present(userContext,city, mergedAllTokens(tokensExpr));
			//return saveCity(userContext, city, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected CityTokens tokens(){
		return CityTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CityTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortDistrictListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CityTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherProvince(FlowableUserContext userContext, String cityId, String anotherProvinceId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfCity(cityId);
 		checkerOf(userContext).checkIdOfProvince(anotherProvinceId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(CityManagerException.class);

 	}
 	public City transferToAnotherProvince(FlowableUserContext userContext, String cityId, String anotherProvinceId) throws Exception
 	{
 		checkParamsForTransferingAnotherProvince(userContext, cityId,anotherProvinceId);
 
		City city = loadCity(userContext, cityId, allTokens());	
		synchronized(city){
			//will be good when the city loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Province province = loadProvince(userContext, anotherProvinceId, emptyOptions());		
			city.updateProvince(province);		
			city = saveCity(userContext, city, emptyOptions());
			
			return present(userContext,city, allTokens());
			
		}

 	}

	


	public CandidateProvince requestCandidateProvince(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateProvince result = new CandidateProvince();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Province> candidateList = provinceDaoOf(userContext).requestCandidateProvinceForCity(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherPlatform(FlowableUserContext userContext, String cityId, String anotherPlatformId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfCity(cityId);
 		checkerOf(userContext).checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(CityManagerException.class);

 	}
 	public City transferToAnotherPlatform(FlowableUserContext userContext, String cityId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, cityId,anotherPlatformId);
 
		City city = loadCity(userContext, cityId, allTokens());	
		synchronized(city){
			//will be good when the city loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			city.updatePlatform(platform);		
			city = saveCity(userContext, city, emptyOptions());
			
			return present(userContext,city, allTokens());
			
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
		SmartList<Platform> candidateList = platformDaoOf(userContext).requestCandidatePlatformForCity(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Province loadProvince(FlowableUserContext userContext, String newProvinceId, Map<String,Object> options) throws Exception
 	{

 		return provinceDaoOf(userContext).load(newProvinceId, options);
 	}
 	


	

 	protected Platform loadPlatform(FlowableUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{

 		return platformDaoOf(userContext).load(newPlatformId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(FlowableUserContext userContext, String cityId, int cityVersion) throws Exception {
		//deleteInternal(userContext, cityId, cityVersion);
	}
	protected void deleteInternal(FlowableUserContext userContext,
			String cityId, int cityVersion) throws Exception{

		cityDaoOf(userContext).delete(cityId, cityVersion);
	}

	public City forgetByAll(FlowableUserContext userContext, String cityId, int cityVersion) throws Exception {
		return forgetByAllInternal(userContext, cityId, cityVersion);
	}
	protected City forgetByAllInternal(FlowableUserContext userContext,
			String cityId, int cityVersion) throws Exception{

		return cityDaoOf(userContext).disconnectFromAll(cityId, cityVersion);
	}




	public int deleteAll(FlowableUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CityManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(FlowableUserContext userContext) throws Exception{
		return cityDaoOf(userContext).deleteAll();
	}


	//disconnect City with platform in District
	protected City breakWithDistrictByPlatform(FlowableUserContext userContext, String cityId, String platformId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			City city = loadCity(userContext, cityId, allTokens());

			synchronized(city){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				cityDaoOf(userContext).planToRemoveDistrictListWithPlatform(city, platformId, this.emptyOptions());

				city = saveCity(userContext, city, tokens().withDistrictList().done());
				return city;
			}
	}






	protected void checkParamsForAddingDistrict(FlowableUserContext userContext, String cityId, String name, String platformId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfCity(cityId);

		
		checkerOf(userContext).checkNameOfDistrict(name);
		
		checkerOf(userContext).checkPlatformIdOfDistrict(platformId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(CityManagerException.class);


	}
	public  City addDistrict(FlowableUserContext userContext, String cityId, String name, String platformId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingDistrict(userContext,cityId,name, platformId,tokensExpr);

		District district = createDistrict(userContext,name, platformId);

		City city = loadCity(userContext, cityId, emptyOptions());
		synchronized(city){
			//Will be good when the city loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			city.addDistrict( district );
			city = saveCity(userContext, city, tokens().withDistrictList().done());
			
			userContext.getManagerGroup().getDistrictManager().onNewInstanceCreated(userContext, district);
			return present(userContext,city, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingDistrictProperties(FlowableUserContext userContext, String cityId,String id,String name,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfCity(cityId);
		checkerOf(userContext).checkIdOfDistrict(id);

		checkerOf(userContext).checkNameOfDistrict( name);

		checkerOf(userContext).throwExceptionIfHasErrors(CityManagerException.class);

	}
	public  City updateDistrictProperties(FlowableUserContext userContext, String cityId, String id,String name, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingDistrictProperties(userContext,cityId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withDistrictListList()
				.searchDistrictListWith(District.ID_PROPERTY, "is", id).done();

		City cityToUpdate = loadCity(userContext, cityId, options);

		if(cityToUpdate.getDistrictList().isEmpty()){
			throw new CityManagerException("District is NOT FOUND with id: '"+id+"'");
		}

		District item = cityToUpdate.getDistrictList().first();

		item.updateName( name );


		//checkParamsForAddingDistrict(userContext,cityId,name, code, used,tokensExpr);
		City city = saveCity(userContext, cityToUpdate, tokens().withDistrictList().done());
		synchronized(city){
			return present(userContext,city, mergedAllTokens(tokensExpr));
		}
	}


	protected District createDistrict(FlowableUserContext userContext, String name, String platformId) throws Exception{

		District district = new District();
		
		
		district.setName(name);		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		district.setPlatform(platform);
	
		
		return district;


	}

	protected District createIndexedDistrict(String id, int version){

		District district = new District();
		district.setId(id);
		district.setVersion(version);
		return district;

	}

	protected void checkParamsForRemovingDistrictList(FlowableUserContext userContext, String cityId,
			String districtIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfCity(cityId);
		for(String districtIdItem: districtIds){
			checkerOf(userContext).checkIdOfDistrict(districtIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(CityManagerException.class);

	}
	public  City removeDistrictList(FlowableUserContext userContext, String cityId,
			String districtIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingDistrictList(userContext, cityId,  districtIds, tokensExpr);


			City city = loadCity(userContext, cityId, allTokens());
			synchronized(city){
				//Will be good when the city loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				cityDaoOf(userContext).planToRemoveDistrictList(city, districtIds, allTokens());
				city = saveCity(userContext, city, tokens().withDistrictList().done());
				deleteRelationListInGraph(userContext, city.getDistrictList());
				return present(userContext,city, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingDistrict(FlowableUserContext userContext, String cityId,
		String districtId, int districtVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfCity( cityId);
		checkerOf(userContext).checkIdOfDistrict(districtId);
		checkerOf(userContext).checkVersionOfDistrict(districtVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(CityManagerException.class);

	}
	public  City removeDistrict(FlowableUserContext userContext, String cityId,
		String districtId, int districtVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingDistrict(userContext,cityId, districtId, districtVersion,tokensExpr);

		District district = createIndexedDistrict(districtId, districtVersion);
		City city = loadCity(userContext, cityId, allTokens());
		synchronized(city){
			//Will be good when the city loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			city.removeDistrict( district );
			city = saveCity(userContext, city, tokens().withDistrictList().done());
			deleteRelationInGraph(userContext, district);
			return present(userContext,city, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingDistrict(FlowableUserContext userContext, String cityId,
		String districtId, int districtVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfCity( cityId);
		checkerOf(userContext).checkIdOfDistrict(districtId);
		checkerOf(userContext).checkVersionOfDistrict(districtVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(CityManagerException.class);

	}
	public  City copyDistrictFrom(FlowableUserContext userContext, String cityId,
		String districtId, int districtVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingDistrict(userContext,cityId, districtId, districtVersion,tokensExpr);

		District district = createIndexedDistrict(districtId, districtVersion);
		City city = loadCity(userContext, cityId, allTokens());
		synchronized(city){
			//Will be good when the city loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			city.copyDistrictFrom( district );
			city = saveCity(userContext, city, tokens().withDistrictList().done());
			
			userContext.getManagerGroup().getDistrictManager().onNewInstanceCreated(userContext, (District)city.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,city, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingDistrict(FlowableUserContext userContext, String cityId, String districtId, int districtVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfCity(cityId);
		checkerOf(userContext).checkIdOfDistrict(districtId);
		checkerOf(userContext).checkVersionOfDistrict(districtVersion);
		

		if(District.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfDistrict(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(CityManagerException.class);

	}

	public  City updateDistrict(FlowableUserContext userContext, String cityId, String districtId, int districtVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingDistrict(userContext, cityId, districtId, districtVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withDistrictList().searchDistrictListWith(District.ID_PROPERTY, "eq", districtId).done();



		City city = loadCity(userContext, cityId, loadTokens);

		synchronized(city){
			//Will be good when the city loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//city.removeDistrict( district );
			//make changes to AcceleraterAccount.
			District districtIndex = createIndexedDistrict(districtId, districtVersion);

			District district = city.findTheDistrict(districtIndex);
			if(district == null){
				throw new CityManagerException(district+" is NOT FOUND" );
			}

			district.changeProperty(property, newValueExpr);
			
			city = saveCity(userContext, city, tokens().withDistrictList().done());
			return present(userContext,city, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(FlowableUserContext userContext, City newCreated) throws Exception{
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, City.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(FlowableUserContext userContext,SmartList<City> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Province> provinceList = FlowableBaseUtils.collectReferencedObjectWithType(userContext, list, Province.class);
		userContext.getDAOGroup().enhanceList(provinceList, Province.class);
		List<Platform> platformList = FlowableBaseUtils.collectReferencedObjectWithType(userContext, list, Platform.class);
		userContext.getDAOGroup().enhanceList(platformList, Platform.class);

	
    }
	
	public Object listByProvince(FlowableUserContext userContext,String provinceId) throws Exception {
		return listPageByProvince(userContext, provinceId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByProvince(FlowableUserContext userContext,String provinceId, int start, int count) throws Exception {
		SmartList<City> list = cityDaoOf(userContext).findCityByProvince(provinceId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		FlowableCommonListOfViewPage page = new FlowableCommonListOfViewPage();
		page.setClassOfList(City.class);
		page.setContainerObject(Province.withId(provinceId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("省列表");
		page.setRequestName("listByProvince");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		
		page.assemblerContent(userContext, "listByProvince");
		return page.doRender(userContext);
	}
  
	public Object listByPlatform(FlowableUserContext userContext,String platformId) throws Exception {
		return listPageByPlatform(userContext, platformId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByPlatform(FlowableUserContext userContext,String platformId, int start, int count) throws Exception {
		SmartList<City> list = cityDaoOf(userContext).findCityByPlatform(platformId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		FlowableCommonListOfViewPage page = new FlowableCommonListOfViewPage();
		page.setClassOfList(City.class);
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


