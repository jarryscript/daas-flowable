
package com.doublechain.flowable.user;

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


import com.doublechain.flowable.district.District;
import com.doublechain.flowable.leaverecord.LeaveRecord;
import com.doublechain.flowable.role.Role;

import com.doublechain.flowable.district.CandidateDistrict;
import com.doublechain.flowable.role.CandidateRole;

import com.doublechain.flowable.user.User;
import com.doublechain.flowable.leaverecordtype.LeaveRecordType;
import com.doublechain.flowable.platform.Platform;






public class UserManagerImpl extends CustomFlowableCheckerManager implements UserManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "User";
	@Override
	public UserDAO daoOf(FlowableUserContext userContext) {
		return userDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws UserManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new UserManagerException(message);

	}



 	protected User saveUser(FlowableUserContext userContext, User user, String [] tokensExpr) throws Exception{	
 		//return getUserDAO().save(user, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveUser(userContext, user, tokens);
 	}
 	
 	protected User saveUserDetail(FlowableUserContext userContext, User user) throws Exception{	

 		
 		return saveUser(userContext, user, allTokens());
 	}
 	
 	public User loadUser(FlowableUserContext userContext, String userId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfUser(userId);
		checkerOf(userContext).throwExceptionIfHasErrors( UserManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		User user = loadUser( userContext, userId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,user, tokens);
 	}
 	
 	
 	 public User searchUser(FlowableUserContext userContext, String userId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfUser(userId);
		checkerOf(userContext).throwExceptionIfHasErrors( UserManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		User user = loadUser( userContext, userId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,user, tokens);
 	}
 	
 	

 	protected User present(FlowableUserContext userContext, User user, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,user,tokens);
		
		
		User  userToPresent = userDaoOf(userContext).present(user, tokens);
		
		List<BaseEntity> entityListToNaming = userToPresent.collectRefercencesFromLists();
		userDaoOf(userContext).alias(entityListToNaming);
		
		return  userToPresent;
		
		
	}
 
 	
 	
 	public User loadUserDetail(FlowableUserContext userContext, String userId) throws Exception{	
 		User user = loadUser( userContext, userId, allTokens());
 		return present(userContext,user, allTokens());
		
 	}
 	
 	public Object view(FlowableUserContext userContext, String userId) throws Exception{	
 		User user = loadUser( userContext, userId, viewTokens());
 		return present(userContext,user, allTokens());
		
 	}
 	protected User saveUser(FlowableUserContext userContext, User user, Map<String,Object>tokens) throws Exception{	
 		return userDaoOf(userContext).save(user, tokens);
 	}
 	protected User loadUser(FlowableUserContext userContext, String userId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfUser(userId);
		checkerOf(userContext).throwExceptionIfHasErrors( UserManagerException.class);

 
 		return userDaoOf(userContext).load(userId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(FlowableUserContext userContext, User user, Map<String, Object> tokens){
		super.addActions(userContext, user, tokens);
		
		addAction(userContext, user, tokens,"@create","createUser","createUser/","main","primary");
		addAction(userContext, user, tokens,"@update","updateUser","updateUser/"+user.getId()+"/","main","primary");
		addAction(userContext, user, tokens,"@copy","cloneUser","cloneUser/"+user.getId()+"/","main","primary");
		
		addAction(userContext, user, tokens,"user.transfer_to_district","transferToAnotherDistrict","transferToAnotherDistrict/"+user.getId()+"/","main","primary");
		addAction(userContext, user, tokens,"user.transfer_to_role","transferToAnotherRole","transferToAnotherRole/"+user.getId()+"/","main","primary");
		addAction(userContext, user, tokens,"user.addLeaveRecord","addLeaveRecord","addLeaveRecord/"+user.getId()+"/","leaveRecordList","primary");
		addAction(userContext, user, tokens,"user.removeLeaveRecord","removeLeaveRecord","removeLeaveRecord/"+user.getId()+"/","leaveRecordList","primary");
		addAction(userContext, user, tokens,"user.updateLeaveRecord","updateLeaveRecord","updateLeaveRecord/"+user.getId()+"/","leaveRecordList","primary");
		addAction(userContext, user, tokens,"user.copyLeaveRecordFrom","copyLeaveRecordFrom","copyLeaveRecordFrom/"+user.getId()+"/","leaveRecordList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(FlowableUserContext userContext, User user, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public User createUser(FlowableUserContext userContext, String name,String mobile,String avatar,int age,String description,String districtId,String roleId) throws Exception
	//public User createUser(FlowableUserContext userContext,String name, String mobile, String avatar, int age, String description, String districtId, String roleId) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfUser(name);
		checkerOf(userContext).checkMobileOfUser(mobile);
		checkerOf(userContext).checkAvatarOfUser(avatar);
		checkerOf(userContext).checkAgeOfUser(age);
		checkerOf(userContext).checkDescriptionOfUser(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(UserManagerException.class);


		User user=createNewUser();	

		user.setName(name);
		user.setMobile(mobile);
		user.setAvatar(avatar);
		user.setAge(age);
		user.setDescription(description);
			
		District district = loadDistrict(userContext, districtId,emptyOptions());
		user.setDistrict(district);
		
		
			
		Role role = loadRole(userContext, roleId,emptyOptions());
		user.setRole(role);
		
		

		user = saveUser(userContext, user, emptyOptions());
		
		onNewInstanceCreated(userContext, user);
		return user;


	}
	protected User createNewUser()
	{

		return new User();
	}

	protected void checkParamsForUpdatingUser(FlowableUserContext userContext,String userId, int userVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfUser(userId);
		checkerOf(userContext).checkVersionOfUser( userVersion);
		

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

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(UserManagerException.class);


	}



	public User clone(FlowableUserContext userContext, String fromUserId) throws Exception{

		return userDaoOf(userContext).clone(fromUserId, this.allTokens());
	}

	public User internalSaveUser(FlowableUserContext userContext, User user) throws Exception
	{
		return internalSaveUser(userContext, user, allTokens());

	}
	public User internalSaveUser(FlowableUserContext userContext, User user, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingUser(userContext, userId, userVersion, property, newValueExpr, tokensExpr);


		synchronized(user){
			//will be good when the user loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to User.
			if (user.isChanged()){
			
			}
			user = saveUser(userContext, user, options);
			return user;

		}

	}

	public User updateUser(FlowableUserContext userContext,String userId, int userVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingUser(userContext, userId, userVersion, property, newValueExpr, tokensExpr);



		User user = loadUser(userContext, userId, allTokens());
		if(user.getVersion() != userVersion){
			String message = "The target version("+user.getVersion()+") is not equals to version("+userVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(user){
			//will be good when the user loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to User.
			
			user.changeProperty(property, newValueExpr);
			user = saveUser(userContext, user, tokens().done());
			return present(userContext,user, mergedAllTokens(tokensExpr));
			//return saveUser(userContext, user, tokens().done());
		}

	}

	public User updateUserProperty(FlowableUserContext userContext,String userId, int userVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingUser(userContext, userId, userVersion, property, newValueExpr, tokensExpr);

		User user = loadUser(userContext, userId, allTokens());
		if(user.getVersion() != userVersion){
			String message = "The target version("+user.getVersion()+") is not equals to version("+userVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(user){
			//will be good when the user loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to User.

			user.changeProperty(property, newValueExpr);
			
			user = saveUser(userContext, user, tokens().done());
			return present(userContext,user, mergedAllTokens(tokensExpr));
			//return saveUser(userContext, user, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected UserTokens tokens(){
		return UserTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return UserTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortLeaveRecordListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return UserTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherDistrict(FlowableUserContext userContext, String userId, String anotherDistrictId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfUser(userId);
 		checkerOf(userContext).checkIdOfDistrict(anotherDistrictId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(UserManagerException.class);

 	}
 	public User transferToAnotherDistrict(FlowableUserContext userContext, String userId, String anotherDistrictId) throws Exception
 	{
 		checkParamsForTransferingAnotherDistrict(userContext, userId,anotherDistrictId);
 
		User user = loadUser(userContext, userId, allTokens());	
		synchronized(user){
			//will be good when the user loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			District district = loadDistrict(userContext, anotherDistrictId, emptyOptions());		
			user.updateDistrict(district);		
			user = saveUser(userContext, user, emptyOptions());
			
			return present(userContext,user, allTokens());
			
		}

 	}

	


	public CandidateDistrict requestCandidateDistrict(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateDistrict result = new CandidateDistrict();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<District> candidateList = districtDaoOf(userContext).requestCandidateDistrictForUser(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherRole(FlowableUserContext userContext, String userId, String anotherRoleId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfUser(userId);
 		checkerOf(userContext).checkIdOfRole(anotherRoleId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(UserManagerException.class);

 	}
 	public User transferToAnotherRole(FlowableUserContext userContext, String userId, String anotherRoleId) throws Exception
 	{
 		checkParamsForTransferingAnotherRole(userContext, userId,anotherRoleId);
 
		User user = loadUser(userContext, userId, allTokens());	
		synchronized(user){
			//will be good when the user loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Role role = loadRole(userContext, anotherRoleId, emptyOptions());		
			user.updateRole(role);		
			user = saveUser(userContext, user, emptyOptions());
			
			return present(userContext,user, allTokens());
			
		}

 	}

	

	protected void checkParamsForTransferingAnotherRoleWithCode(FlowableUserContext userContext, String userId, String anotherCode) throws Exception
 	{

 		checkerOf(userContext).checkIdOfUser(userId);
 		checkerOf(userContext).checkCodeOfRole( anotherCode);
 		checkerOf(userContext).throwExceptionIfHasErrors(UserManagerException.class);

 	}

 	public User transferToAnotherRoleWithCode(FlowableUserContext userContext, String userId, String anotherCode) throws Exception
 	{
 		checkParamsForTransferingAnotherRoleWithCode(userContext, userId,anotherCode);
 		User user = loadUser(userContext, userId, allTokens());
		synchronized(user){
			//will be good when the user loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Role role = loadRoleWithCode(userContext, anotherCode, emptyOptions());
			user.updateRole(role);
			user = saveUser(userContext, user, emptyOptions());

			return present(userContext,user, allTokens());

		}
 	}

	 


	public CandidateRole requestCandidateRole(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRole result = new CandidateRole();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Role> candidateList = roleDaoOf(userContext).requestCandidateRoleForUser(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected District loadDistrict(FlowableUserContext userContext, String newDistrictId, Map<String,Object> options) throws Exception
 	{

 		return districtDaoOf(userContext).load(newDistrictId, options);
 	}
 	


	

 	protected Role loadRole(FlowableUserContext userContext, String newRoleId, Map<String,Object> options) throws Exception
 	{

 		return roleDaoOf(userContext).load(newRoleId, options);
 	}
 	
 	protected Role loadRoleWithCode(FlowableUserContext userContext, String newCode, Map<String,Object> options) throws Exception
 	{

 		return roleDaoOf(userContext).loadByCode(newCode, options);
 	}

 	


	
	//--------------------------------------------------------------

	public void delete(FlowableUserContext userContext, String userId, int userVersion) throws Exception {
		//deleteInternal(userContext, userId, userVersion);
	}
	protected void deleteInternal(FlowableUserContext userContext,
			String userId, int userVersion) throws Exception{

		userDaoOf(userContext).delete(userId, userVersion);
	}

	public User forgetByAll(FlowableUserContext userContext, String userId, int userVersion) throws Exception {
		return forgetByAllInternal(userContext, userId, userVersion);
	}
	protected User forgetByAllInternal(FlowableUserContext userContext,
			String userId, int userVersion) throws Exception{

		return userDaoOf(userContext).disconnectFromAll(userId, userVersion);
	}




	public int deleteAll(FlowableUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new UserManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(FlowableUserContext userContext) throws Exception{
		return userDaoOf(userContext).deleteAll();
	}


	//disconnect User with type in LeaveRecord
	protected User breakWithLeaveRecordByType(FlowableUserContext userContext, String userId, String typeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			User user = loadUser(userContext, userId, allTokens());

			synchronized(user){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				userDaoOf(userContext).planToRemoveLeaveRecordListWithType(user, typeId, this.emptyOptions());

				user = saveUser(userContext, user, tokens().withLeaveRecordList().done());
				return user;
			}
	}
	//disconnect User with platform in LeaveRecord
	protected User breakWithLeaveRecordByPlatform(FlowableUserContext userContext, String userId, String platformId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			User user = loadUser(userContext, userId, allTokens());

			synchronized(user){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				userDaoOf(userContext).planToRemoveLeaveRecordListWithPlatform(user, platformId, this.emptyOptions());

				user = saveUser(userContext, user, tokens().withLeaveRecordList().done());
				return user;
			}
	}






	protected void checkParamsForAddingLeaveRecord(FlowableUserContext userContext, String userId, String typeId, Date fromdate, Date todate, String platformId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfUser(userId);

		
		checkerOf(userContext).checkTypeIdOfLeaveRecord(typeId);
		
		checkerOf(userContext).checkFromdateOfLeaveRecord(fromdate);
		
		checkerOf(userContext).checkTodateOfLeaveRecord(todate);
		
		checkerOf(userContext).checkPlatformIdOfLeaveRecord(platformId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(UserManagerException.class);


	}
	public  User addLeaveRecord(FlowableUserContext userContext, String userId, String typeId, Date fromdate, Date todate, String platformId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingLeaveRecord(userContext,userId,typeId, fromdate, todate, platformId,tokensExpr);

		LeaveRecord leaveRecord = createLeaveRecord(userContext,typeId, fromdate, todate, platformId);

		User user = loadUser(userContext, userId, emptyOptions());
		synchronized(user){
			//Will be good when the user loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			user.addLeaveRecord( leaveRecord );
			user = saveUser(userContext, user, tokens().withLeaveRecordList().done());
			
			userContext.getManagerGroup().getLeaveRecordManager().onNewInstanceCreated(userContext, leaveRecord);
			return present(userContext,user, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLeaveRecordProperties(FlowableUserContext userContext, String userId,String id,Date fromdate,Date todate,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfUser(userId);
		checkerOf(userContext).checkIdOfLeaveRecord(id);

		checkerOf(userContext).checkFromdateOfLeaveRecord( fromdate);
		checkerOf(userContext).checkTodateOfLeaveRecord( todate);

		checkerOf(userContext).throwExceptionIfHasErrors(UserManagerException.class);

	}
	public  User updateLeaveRecordProperties(FlowableUserContext userContext, String userId, String id,Date fromdate,Date todate, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLeaveRecordProperties(userContext,userId,id,fromdate,todate,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLeaveRecordListList()
				.searchLeaveRecordListWith(LeaveRecord.ID_PROPERTY, "is", id).done();

		User userToUpdate = loadUser(userContext, userId, options);

		if(userToUpdate.getLeaveRecordList().isEmpty()){
			throw new UserManagerException("LeaveRecord is NOT FOUND with id: '"+id+"'");
		}

		LeaveRecord item = userToUpdate.getLeaveRecordList().first();

		item.updateFromdate( fromdate );
		item.updateTodate( todate );


		//checkParamsForAddingLeaveRecord(userContext,userId,name, code, used,tokensExpr);
		User user = saveUser(userContext, userToUpdate, tokens().withLeaveRecordList().done());
		synchronized(user){
			return present(userContext,user, mergedAllTokens(tokensExpr));
		}
	}


	protected LeaveRecord createLeaveRecord(FlowableUserContext userContext, String typeId, Date fromdate, Date todate, String platformId) throws Exception{

		LeaveRecord leaveRecord = new LeaveRecord();
		
		
		LeaveRecordType  type = new LeaveRecordType();
		type.setId(typeId);		
		leaveRecord.setType(type);		
		leaveRecord.setFromdate(fromdate);		
		leaveRecord.setTodate(todate);		
		Platform  platform = new Platform();
		platform.setId(platformId);		
		leaveRecord.setPlatform(platform);
	
		
		return leaveRecord;


	}

	protected LeaveRecord createIndexedLeaveRecord(String id, int version){

		LeaveRecord leaveRecord = new LeaveRecord();
		leaveRecord.setId(id);
		leaveRecord.setVersion(version);
		return leaveRecord;

	}

	protected void checkParamsForRemovingLeaveRecordList(FlowableUserContext userContext, String userId,
			String leaveRecordIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfUser(userId);
		for(String leaveRecordIdItem: leaveRecordIds){
			checkerOf(userContext).checkIdOfLeaveRecord(leaveRecordIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(UserManagerException.class);

	}
	public  User removeLeaveRecordList(FlowableUserContext userContext, String userId,
			String leaveRecordIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingLeaveRecordList(userContext, userId,  leaveRecordIds, tokensExpr);


			User user = loadUser(userContext, userId, allTokens());
			synchronized(user){
				//Will be good when the user loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userDaoOf(userContext).planToRemoveLeaveRecordList(user, leaveRecordIds, allTokens());
				user = saveUser(userContext, user, tokens().withLeaveRecordList().done());
				deleteRelationListInGraph(userContext, user.getLeaveRecordList());
				return present(userContext,user, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingLeaveRecord(FlowableUserContext userContext, String userId,
		String leaveRecordId, int leaveRecordVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfUser( userId);
		checkerOf(userContext).checkIdOfLeaveRecord(leaveRecordId);
		checkerOf(userContext).checkVersionOfLeaveRecord(leaveRecordVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(UserManagerException.class);

	}
	public  User removeLeaveRecord(FlowableUserContext userContext, String userId,
		String leaveRecordId, int leaveRecordVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingLeaveRecord(userContext,userId, leaveRecordId, leaveRecordVersion,tokensExpr);

		LeaveRecord leaveRecord = createIndexedLeaveRecord(leaveRecordId, leaveRecordVersion);
		User user = loadUser(userContext, userId, allTokens());
		synchronized(user){
			//Will be good when the user loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			user.removeLeaveRecord( leaveRecord );
			user = saveUser(userContext, user, tokens().withLeaveRecordList().done());
			deleteRelationInGraph(userContext, leaveRecord);
			return present(userContext,user, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingLeaveRecord(FlowableUserContext userContext, String userId,
		String leaveRecordId, int leaveRecordVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfUser( userId);
		checkerOf(userContext).checkIdOfLeaveRecord(leaveRecordId);
		checkerOf(userContext).checkVersionOfLeaveRecord(leaveRecordVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(UserManagerException.class);

	}
	public  User copyLeaveRecordFrom(FlowableUserContext userContext, String userId,
		String leaveRecordId, int leaveRecordVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingLeaveRecord(userContext,userId, leaveRecordId, leaveRecordVersion,tokensExpr);

		LeaveRecord leaveRecord = createIndexedLeaveRecord(leaveRecordId, leaveRecordVersion);
		User user = loadUser(userContext, userId, allTokens());
		synchronized(user){
			//Will be good when the user loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			user.copyLeaveRecordFrom( leaveRecord );
			user = saveUser(userContext, user, tokens().withLeaveRecordList().done());
			
			userContext.getManagerGroup().getLeaveRecordManager().onNewInstanceCreated(userContext, (LeaveRecord)user.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,user, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingLeaveRecord(FlowableUserContext userContext, String userId, String leaveRecordId, int leaveRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfUser(userId);
		checkerOf(userContext).checkIdOfLeaveRecord(leaveRecordId);
		checkerOf(userContext).checkVersionOfLeaveRecord(leaveRecordVersion);
		

		if(LeaveRecord.FROMDATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFromdateOfLeaveRecord(parseDate(newValueExpr));
		
		}
		
		if(LeaveRecord.TODATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTodateOfLeaveRecord(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(UserManagerException.class);

	}

	public  User updateLeaveRecord(FlowableUserContext userContext, String userId, String leaveRecordId, int leaveRecordVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingLeaveRecord(userContext, userId, leaveRecordId, leaveRecordVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withLeaveRecordList().searchLeaveRecordListWith(LeaveRecord.ID_PROPERTY, "eq", leaveRecordId).done();



		User user = loadUser(userContext, userId, loadTokens);

		synchronized(user){
			//Will be good when the user loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//user.removeLeaveRecord( leaveRecord );
			//make changes to AcceleraterAccount.
			LeaveRecord leaveRecordIndex = createIndexedLeaveRecord(leaveRecordId, leaveRecordVersion);

			LeaveRecord leaveRecord = user.findTheLeaveRecord(leaveRecordIndex);
			if(leaveRecord == null){
				throw new UserManagerException(leaveRecord+" is NOT FOUND" );
			}

			leaveRecord.changeProperty(property, newValueExpr);
			
			user = saveUser(userContext, user, tokens().withLeaveRecordList().done());
			return present(userContext,user, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(FlowableUserContext userContext, User newCreated) throws Exception{
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, User.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(FlowableUserContext userContext,SmartList<User> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<District> districtList = FlowableBaseUtils.collectReferencedObjectWithType(userContext, list, District.class);
		userContext.getDAOGroup().enhanceList(districtList, District.class);
		List<Role> roleList = FlowableBaseUtils.collectReferencedObjectWithType(userContext, list, Role.class);
		userContext.getDAOGroup().enhanceList(roleList, Role.class);

	
    }
	
	public Object listByDistrict(FlowableUserContext userContext,String districtId) throws Exception {
		return listPageByDistrict(userContext, districtId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByDistrict(FlowableUserContext userContext,String districtId, int start, int count) throws Exception {
		SmartList<User> list = userDaoOf(userContext).findUserByDistrict(districtId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		FlowableCommonListOfViewPage page = new FlowableCommonListOfViewPage();
		page.setClassOfList(User.class);
		page.setContainerObject(District.withId(districtId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("区/县列表");
		page.setRequestName("listByDistrict");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		
		page.assemblerContent(userContext, "listByDistrict");
		return page.doRender(userContext);
	}
  
	public Object listByRole(FlowableUserContext userContext,String roleId) throws Exception {
		return listPageByRole(userContext, roleId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByRole(FlowableUserContext userContext,String roleId, int start, int count) throws Exception {
		SmartList<User> list = userDaoOf(userContext).findUserByRole(roleId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		FlowableCommonListOfViewPage page = new FlowableCommonListOfViewPage();
		page.setClassOfList(User.class);
		page.setContainerObject(Role.withId(roleId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("角色列表");
		page.setRequestName("listByRole");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		
		page.assemblerContent(userContext, "listByRole");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------
}


