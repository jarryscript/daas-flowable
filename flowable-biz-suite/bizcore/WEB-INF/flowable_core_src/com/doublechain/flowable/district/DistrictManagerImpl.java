
package com.doublechain.flowable.district;

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
import com.doublechain.flowable.city.City;
import com.doublechain.flowable.platform.Platform;

import com.doublechain.flowable.city.CandidateCity;
import com.doublechain.flowable.platform.CandidatePlatform;

import com.doublechain.flowable.district.District;
import com.doublechain.flowable.role.Role;






public class DistrictManagerImpl extends CustomFlowableCheckerManager implements DistrictManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "District";
	@Override
	public DistrictDAO daoOf(FlowableUserContext userContext) {
		return districtDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws DistrictManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new DistrictManagerException(message);

	}



 	protected District saveDistrict(FlowableUserContext userContext, District district, String [] tokensExpr) throws Exception{	
 		//return getDistrictDAO().save(district, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveDistrict(userContext, district, tokens);
 	}
 	
 	protected District saveDistrictDetail(FlowableUserContext userContext, District district) throws Exception{	

 		
 		return saveDistrict(userContext, district, allTokens());
 	}
 	
 	public District loadDistrict(FlowableUserContext userContext, String districtId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfDistrict(districtId);
		checkerOf(userContext).throwExceptionIfHasErrors( DistrictManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		District district = loadDistrict( userContext, districtId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,district, tokens);
 	}
 	
 	
 	 public District searchDistrict(FlowableUserContext userContext, String districtId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfDistrict(districtId);
		checkerOf(userContext).throwExceptionIfHasErrors( DistrictManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		District district = loadDistrict( userContext, districtId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,district, tokens);
 	}
 	
 	

 	protected District present(FlowableUserContext userContext, District district, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,district,tokens);
		
		
		District  districtToPresent = districtDaoOf(userContext).present(district, tokens);
		
		List<BaseEntity> entityListToNaming = districtToPresent.collectRefercencesFromLists();
		districtDaoOf(userContext).alias(entityListToNaming);
		
		return  districtToPresent;
		
		
	}
 
 	
 	
 	public District loadDistrictDetail(FlowableUserContext userContext, String districtId) throws Exception{	
 		District district = loadDistrict( userContext, districtId, allTokens());
 		return present(userContext,district, allTokens());
		
 	}
 	
 	public Object view(FlowableUserContext userContext, String districtId) throws Exception{	
 		District district = loadDistrict( userContext, districtId, viewTokens());
 		return present(userContext,district, allTokens());
		
 	}
 	protected District saveDistrict(FlowableUserContext userContext, District district, Map<String,Object>tokens) throws Exception{	
 		return districtDaoOf(userContext).save(district, tokens);
 	}
 	protected District loadDistrict(FlowableUserContext userContext, String districtId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfDistrict(districtId);
		checkerOf(userContext).throwExceptionIfHasErrors( DistrictManagerException.class);

 
 		return districtDaoOf(userContext).load(districtId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(FlowableUserContext userContext, District district, Map<String, Object> tokens){
		super.addActions(userContext, district, tokens);
		
		addAction(userContext, district, tokens,"@create","createDistrict","createDistrict/","main","primary");
		addAction(userContext, district, tokens,"@update","updateDistrict","updateDistrict/"+district.getId()+"/","main","primary");
		addAction(userContext, district, tokens,"@copy","cloneDistrict","cloneDistrict/"+district.getId()+"/","main","primary");
		
		addAction(userContext, district, tokens,"district.transfer_to_city","transferToAnotherCity","transferToAnotherCity/"+district.getId()+"/","main","primary");
		addAction(userContext, district, tokens,"district.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+district.getId()+"/","main","primary");
		addAction(userContext, district, tokens,"district.addUser","addUser","addUser/"+district.getId()+"/","userList","primary");
		addAction(userContext, district, tokens,"district.removeUser","removeUser","removeUser/"+district.getId()+"/","userList","primary");
		addAction(userContext, district, tokens,"district.updateUser","updateUser","updateUser/"+district.getId()+"/","userList","primary");
		addAction(userContext, district, tokens,"district.copyUserFrom","copyUserFrom","copyUserFrom/"+district.getId()+"/","userList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(FlowableUserContext userContext, District district, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public District createDistrict(FlowableUserContext userContext, String name,String cityId,String platformId) throws Exception
	//public District createDistrict(FlowableUserContext userContext,String name, String cityId, String platformId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfDistrict(name);
	
		checkerOf(userContext).throwExceptionIfHasErrors(DistrictManagerException.class);


		District district=createNewDistrict();	

		district.setName(name);
			
		City city = loadCity(userContext, cityId,emptyOptions());
		district.setCity(city);
		
		
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		district.setPlatform(platform);
		
		

		district = saveDistrict(userContext, district, emptyOptions());
		
		onNewInstanceCreated(userContext, district);
		return district;


	}
	protected District createNewDistrict()
	{

		return new District();
	}

	protected void checkParamsForUpdatingDistrict(FlowableUserContext userContext,String districtId, int districtVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfDistrict(districtId);
		checkerOf(userContext).checkVersionOfDistrict( districtVersion);
		

		if(District.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfDistrict(parseString(newValueExpr));
		
			
		}		

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(DistrictManagerException.class);


	}



	public District clone(FlowableUserContext userContext, String fromDistrictId) throws Exception{

		return districtDaoOf(userContext).clone(fromDistrictId, this.allTokens());
	}

	public District internalSaveDistrict(FlowableUserContext userContext, District district) throws Exception
	{
		return internalSaveDistrict(userContext, district, allTokens());

	}
	public District internalSaveDistrict(FlowableUserContext userContext, District district, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingDistrict(userContext, districtId, districtVersion, property, newValueExpr, tokensExpr);


		synchronized(district){
			//will be good when the district loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to District.
			if (district.isChanged()){
			
			}
			district = saveDistrict(userContext, district, options);
			return district;

		}

	}

	public District updateDistrict(FlowableUserContext userContext,String districtId, int districtVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingDistrict(userContext, districtId, districtVersion, property, newValueExpr, tokensExpr);



		District district = loadDistrict(userContext, districtId, allTokens());
		if(district.getVersion() != districtVersion){
			String message = "The target version("+district.getVersion()+") is not equals to version("+districtVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(district){
			//will be good when the district loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to District.
			
			district.changeProperty(property, newValueExpr);
			district = saveDistrict(userContext, district, tokens().done());
			return present(userContext,district, mergedAllTokens(tokensExpr));
			//return saveDistrict(userContext, district, tokens().done());
		}

	}

	public District updateDistrictProperty(FlowableUserContext userContext,String districtId, int districtVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingDistrict(userContext, districtId, districtVersion, property, newValueExpr, tokensExpr);

		District district = loadDistrict(userContext, districtId, allTokens());
		if(district.getVersion() != districtVersion){
			String message = "The target version("+district.getVersion()+") is not equals to version("+districtVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(district){
			//will be good when the district loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to District.

			district.changeProperty(property, newValueExpr);
			
			district = saveDistrict(userContext, district, tokens().done());
			return present(userContext,district, mergedAllTokens(tokensExpr));
			//return saveDistrict(userContext, district, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected DistrictTokens tokens(){
		return DistrictTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return DistrictTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortUserListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return DistrictTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCity(FlowableUserContext userContext, String districtId, String anotherCityId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfDistrict(districtId);
 		checkerOf(userContext).checkIdOfCity(anotherCityId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(DistrictManagerException.class);

 	}
 	public District transferToAnotherCity(FlowableUserContext userContext, String districtId, String anotherCityId) throws Exception
 	{
 		checkParamsForTransferingAnotherCity(userContext, districtId,anotherCityId);
 
		District district = loadDistrict(userContext, districtId, allTokens());	
		synchronized(district){
			//will be good when the district loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			City city = loadCity(userContext, anotherCityId, emptyOptions());		
			district.updateCity(city);		
			district = saveDistrict(userContext, district, emptyOptions());
			
			return present(userContext,district, allTokens());
			
		}

 	}

	


	public CandidateCity requestCandidateCity(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateCity result = new CandidateCity();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<City> candidateList = cityDaoOf(userContext).requestCandidateCityForDistrict(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherPlatform(FlowableUserContext userContext, String districtId, String anotherPlatformId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfDistrict(districtId);
 		checkerOf(userContext).checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(DistrictManagerException.class);

 	}
 	public District transferToAnotherPlatform(FlowableUserContext userContext, String districtId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, districtId,anotherPlatformId);
 
		District district = loadDistrict(userContext, districtId, allTokens());	
		synchronized(district){
			//will be good when the district loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			district.updatePlatform(platform);		
			district = saveDistrict(userContext, district, emptyOptions());
			
			return present(userContext,district, allTokens());
			
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
		SmartList<Platform> candidateList = platformDaoOf(userContext).requestCandidatePlatformForDistrict(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected City loadCity(FlowableUserContext userContext, String newCityId, Map<String,Object> options) throws Exception
 	{

 		return cityDaoOf(userContext).load(newCityId, options);
 	}
 	


	

 	protected Platform loadPlatform(FlowableUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{

 		return platformDaoOf(userContext).load(newPlatformId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(FlowableUserContext userContext, String districtId, int districtVersion) throws Exception {
		//deleteInternal(userContext, districtId, districtVersion);
	}
	protected void deleteInternal(FlowableUserContext userContext,
			String districtId, int districtVersion) throws Exception{

		districtDaoOf(userContext).delete(districtId, districtVersion);
	}

	public District forgetByAll(FlowableUserContext userContext, String districtId, int districtVersion) throws Exception {
		return forgetByAllInternal(userContext, districtId, districtVersion);
	}
	protected District forgetByAllInternal(FlowableUserContext userContext,
			String districtId, int districtVersion) throws Exception{

		return districtDaoOf(userContext).disconnectFromAll(districtId, districtVersion);
	}




	public int deleteAll(FlowableUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new DistrictManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(FlowableUserContext userContext) throws Exception{
		return districtDaoOf(userContext).deleteAll();
	}


	//disconnect District with role in User
	protected District breakWithUserByRole(FlowableUserContext userContext, String districtId, String roleId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			District district = loadDistrict(userContext, districtId, allTokens());

			synchronized(district){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				districtDaoOf(userContext).planToRemoveUserListWithRole(district, roleId, this.emptyOptions());

				district = saveDistrict(userContext, district, tokens().withUserList().done());
				return district;
			}
	}






	protected void checkParamsForAddingUser(FlowableUserContext userContext, String districtId, String name, String mobile, String avatar, int age, String description, String roleId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfDistrict(districtId);

		
		checkerOf(userContext).checkNameOfUser(name);
		
		checkerOf(userContext).checkMobileOfUser(mobile);
		
		checkerOf(userContext).checkAvatarOfUser(avatar);
		
		checkerOf(userContext).checkAgeOfUser(age);
		
		checkerOf(userContext).checkDescriptionOfUser(description);
		
		checkerOf(userContext).checkRoleIdOfUser(roleId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(DistrictManagerException.class);


	}
	public  District addUser(FlowableUserContext userContext, String districtId, String name, String mobile, String avatar, int age, String description, String roleId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingUser(userContext,districtId,name, mobile, avatar, age, description, roleId,tokensExpr);

		User user = createUser(userContext,name, mobile, avatar, age, description, roleId);

		District district = loadDistrict(userContext, districtId, emptyOptions());
		synchronized(district){
			//Will be good when the district loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			district.addUser( user );
			district = saveDistrict(userContext, district, tokens().withUserList().done());
			
			userContext.getManagerGroup().getUserManager().onNewInstanceCreated(userContext, user);
			return present(userContext,district, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingUserProperties(FlowableUserContext userContext, String districtId,String id,String name,String mobile,String avatar,int age,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfDistrict(districtId);
		checkerOf(userContext).checkIdOfUser(id);

		checkerOf(userContext).checkNameOfUser( name);
		checkerOf(userContext).checkMobileOfUser( mobile);
		checkerOf(userContext).checkAvatarOfUser( avatar);
		checkerOf(userContext).checkAgeOfUser( age);
		checkerOf(userContext).checkDescriptionOfUser( description);

		checkerOf(userContext).throwExceptionIfHasErrors(DistrictManagerException.class);

	}
	public  District updateUserProperties(FlowableUserContext userContext, String districtId, String id,String name,String mobile,String avatar,int age,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingUserProperties(userContext,districtId,id,name,mobile,avatar,age,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withUserListList()
				.searchUserListWith(User.ID_PROPERTY, "is", id).done();

		District districtToUpdate = loadDistrict(userContext, districtId, options);

		if(districtToUpdate.getUserList().isEmpty()){
			throw new DistrictManagerException("User is NOT FOUND with id: '"+id+"'");
		}

		User item = districtToUpdate.getUserList().first();

		item.updateName( name );
		item.updateMobile( mobile );
		item.updateAvatar( avatar );
		item.updateAge( age );
		item.updateDescription( description );


		//checkParamsForAddingUser(userContext,districtId,name, code, used,tokensExpr);
		District district = saveDistrict(userContext, districtToUpdate, tokens().withUserList().done());
		synchronized(district){
			return present(userContext,district, mergedAllTokens(tokensExpr));
		}
	}


	protected User createUser(FlowableUserContext userContext, String name, String mobile, String avatar, int age, String description, String roleId) throws Exception{

		User user = new User();
		
		
		user.setName(name);		
		user.setMobile(mobile);		
		user.setAvatar(avatar);		
		user.setAge(age);		
		user.setDescription(description);		
		Role  role = new Role();
		role.setId(roleId);		
		user.setRole(role);
	
		
		return user;


	}

	protected User createIndexedUser(String id, int version){

		User user = new User();
		user.setId(id);
		user.setVersion(version);
		return user;

	}

	protected void checkParamsForRemovingUserList(FlowableUserContext userContext, String districtId,
			String userIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfDistrict(districtId);
		for(String userIdItem: userIds){
			checkerOf(userContext).checkIdOfUser(userIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(DistrictManagerException.class);

	}
	public  District removeUserList(FlowableUserContext userContext, String districtId,
			String userIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingUserList(userContext, districtId,  userIds, tokensExpr);


			District district = loadDistrict(userContext, districtId, allTokens());
			synchronized(district){
				//Will be good when the district loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				districtDaoOf(userContext).planToRemoveUserList(district, userIds, allTokens());
				district = saveDistrict(userContext, district, tokens().withUserList().done());
				deleteRelationListInGraph(userContext, district.getUserList());
				return present(userContext,district, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingUser(FlowableUserContext userContext, String districtId,
		String userId, int userVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfDistrict( districtId);
		checkerOf(userContext).checkIdOfUser(userId);
		checkerOf(userContext).checkVersionOfUser(userVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(DistrictManagerException.class);

	}
	public  District removeUser(FlowableUserContext userContext, String districtId,
		String userId, int userVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingUser(userContext,districtId, userId, userVersion,tokensExpr);

		User user = createIndexedUser(userId, userVersion);
		District district = loadDistrict(userContext, districtId, allTokens());
		synchronized(district){
			//Will be good when the district loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			district.removeUser( user );
			district = saveDistrict(userContext, district, tokens().withUserList().done());
			deleteRelationInGraph(userContext, user);
			return present(userContext,district, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingUser(FlowableUserContext userContext, String districtId,
		String userId, int userVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfDistrict( districtId);
		checkerOf(userContext).checkIdOfUser(userId);
		checkerOf(userContext).checkVersionOfUser(userVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(DistrictManagerException.class);

	}
	public  District copyUserFrom(FlowableUserContext userContext, String districtId,
		String userId, int userVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingUser(userContext,districtId, userId, userVersion,tokensExpr);

		User user = createIndexedUser(userId, userVersion);
		District district = loadDistrict(userContext, districtId, allTokens());
		synchronized(district){
			//Will be good when the district loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			district.copyUserFrom( user );
			district = saveDistrict(userContext, district, tokens().withUserList().done());
			
			userContext.getManagerGroup().getUserManager().onNewInstanceCreated(userContext, (User)district.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,district, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingUser(FlowableUserContext userContext, String districtId, String userId, int userVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfDistrict(districtId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(DistrictManagerException.class);

	}

	public  District updateUser(FlowableUserContext userContext, String districtId, String userId, int userVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingUser(userContext, districtId, userId, userVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withUserList().searchUserListWith(User.ID_PROPERTY, "eq", userId).done();



		District district = loadDistrict(userContext, districtId, loadTokens);

		synchronized(district){
			//Will be good when the district loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//district.removeUser( user );
			//make changes to AcceleraterAccount.
			User userIndex = createIndexedUser(userId, userVersion);

			User user = district.findTheUser(userIndex);
			if(user == null){
				throw new DistrictManagerException(user+" is NOT FOUND" );
			}

			user.changeProperty(property, newValueExpr);
			
			district = saveDistrict(userContext, district, tokens().withUserList().done());
			return present(userContext,district, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(FlowableUserContext userContext, District newCreated) throws Exception{
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, District.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(FlowableUserContext userContext,SmartList<District> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<City> cityList = FlowableBaseUtils.collectReferencedObjectWithType(userContext, list, City.class);
		userContext.getDAOGroup().enhanceList(cityList, City.class);
		List<Platform> platformList = FlowableBaseUtils.collectReferencedObjectWithType(userContext, list, Platform.class);
		userContext.getDAOGroup().enhanceList(platformList, Platform.class);

	
    }
	
	public Object listByCity(FlowableUserContext userContext,String cityId) throws Exception {
		return listPageByCity(userContext, cityId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCity(FlowableUserContext userContext,String cityId, int start, int count) throws Exception {
		SmartList<District> list = districtDaoOf(userContext).findDistrictByCity(cityId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		FlowableCommonListOfViewPage page = new FlowableCommonListOfViewPage();
		page.setClassOfList(District.class);
		page.setContainerObject(City.withId(cityId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("城市列表");
		page.setRequestName("listByCity");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		
		page.assemblerContent(userContext, "listByCity");
		return page.doRender(userContext);
	}
  
	public Object listByPlatform(FlowableUserContext userContext,String platformId) throws Exception {
		return listPageByPlatform(userContext, platformId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByPlatform(FlowableUserContext userContext,String platformId, int start, int count) throws Exception {
		SmartList<District> list = districtDaoOf(userContext).findDistrictByPlatform(platformId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		FlowableCommonListOfViewPage page = new FlowableCommonListOfViewPage();
		page.setClassOfList(District.class);
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


