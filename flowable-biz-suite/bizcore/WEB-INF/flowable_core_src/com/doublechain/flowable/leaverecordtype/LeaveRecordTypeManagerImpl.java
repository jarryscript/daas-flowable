
package com.doublechain.flowable.leaverecordtype;

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


import com.doublechain.flowable.holydaysetting.HolydaySetting;
import com.doublechain.flowable.leaverecord.LeaveRecord;


import com.doublechain.flowable.user.User;
import com.doublechain.flowable.leaverecordtype.LeaveRecordType;
import com.doublechain.flowable.platform.Platform;






public class LeaveRecordTypeManagerImpl extends CustomFlowableCheckerManager implements LeaveRecordTypeManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "LeaveRecordType";
	@Override
	public LeaveRecordTypeDAO daoOf(FlowableUserContext userContext) {
		return leaveRecordTypeDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws LeaveRecordTypeManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new LeaveRecordTypeManagerException(message);

	}



 	protected LeaveRecordType saveLeaveRecordType(FlowableUserContext userContext, LeaveRecordType leaveRecordType, String [] tokensExpr) throws Exception{	
 		//return getLeaveRecordTypeDAO().save(leaveRecordType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLeaveRecordType(userContext, leaveRecordType, tokens);
 	}
 	
 	protected LeaveRecordType saveLeaveRecordTypeDetail(FlowableUserContext userContext, LeaveRecordType leaveRecordType) throws Exception{	

 		
 		return saveLeaveRecordType(userContext, leaveRecordType, allTokens());
 	}
 	
 	public LeaveRecordType loadLeaveRecordType(FlowableUserContext userContext, String leaveRecordTypeId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfLeaveRecordType(leaveRecordTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( LeaveRecordTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LeaveRecordType leaveRecordType = loadLeaveRecordType( userContext, leaveRecordTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,leaveRecordType, tokens);
 	}
 	
 	
 	 public LeaveRecordType searchLeaveRecordType(FlowableUserContext userContext, String leaveRecordTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfLeaveRecordType(leaveRecordTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( LeaveRecordTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		LeaveRecordType leaveRecordType = loadLeaveRecordType( userContext, leaveRecordTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,leaveRecordType, tokens);
 	}
 	
 	

 	protected LeaveRecordType present(FlowableUserContext userContext, LeaveRecordType leaveRecordType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,leaveRecordType,tokens);
		
		
		LeaveRecordType  leaveRecordTypeToPresent = leaveRecordTypeDaoOf(userContext).present(leaveRecordType, tokens);
		
		List<BaseEntity> entityListToNaming = leaveRecordTypeToPresent.collectRefercencesFromLists();
		leaveRecordTypeDaoOf(userContext).alias(entityListToNaming);
		
		return  leaveRecordTypeToPresent;
		
		
	}
 
 	
 	
 	public LeaveRecordType loadLeaveRecordTypeDetail(FlowableUserContext userContext, String leaveRecordTypeId) throws Exception{	
 		LeaveRecordType leaveRecordType = loadLeaveRecordType( userContext, leaveRecordTypeId, allTokens());
 		return present(userContext,leaveRecordType, allTokens());
		
 	}
 	
 	public Object view(FlowableUserContext userContext, String leaveRecordTypeId) throws Exception{	
 		LeaveRecordType leaveRecordType = loadLeaveRecordType( userContext, leaveRecordTypeId, viewTokens());
 		return present(userContext,leaveRecordType, allTokens());
		
 	}
 	protected LeaveRecordType saveLeaveRecordType(FlowableUserContext userContext, LeaveRecordType leaveRecordType, Map<String,Object>tokens) throws Exception{	
 		return leaveRecordTypeDaoOf(userContext).save(leaveRecordType, tokens);
 	}
 	protected LeaveRecordType loadLeaveRecordType(FlowableUserContext userContext, String leaveRecordTypeId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfLeaveRecordType(leaveRecordTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( LeaveRecordTypeManagerException.class);

 
 		return leaveRecordTypeDaoOf(userContext).load(leaveRecordTypeId, tokens);
 	}

	
	

	public LeaveRecordType loadLeaveRecordTypeWithCode(FlowableUserContext userContext, String code, Map<String,Object>tokens) throws Exception{	
 		return leaveRecordTypeDaoOf(userContext).loadByCode(code, tokens);
 	}

	 


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(FlowableUserContext userContext, LeaveRecordType leaveRecordType, Map<String, Object> tokens){
		super.addActions(userContext, leaveRecordType, tokens);
		
		addAction(userContext, leaveRecordType, tokens,"@create","createLeaveRecordType","createLeaveRecordType/","main","primary");
		addAction(userContext, leaveRecordType, tokens,"@update","updateLeaveRecordType","updateLeaveRecordType/"+leaveRecordType.getId()+"/","main","primary");
		addAction(userContext, leaveRecordType, tokens,"@copy","cloneLeaveRecordType","cloneLeaveRecordType/"+leaveRecordType.getId()+"/","main","primary");
		
		addAction(userContext, leaveRecordType, tokens,"leave_record_type.addLeaveRecord","addLeaveRecord","addLeaveRecord/"+leaveRecordType.getId()+"/","leaveRecordList","primary");
		addAction(userContext, leaveRecordType, tokens,"leave_record_type.removeLeaveRecord","removeLeaveRecord","removeLeaveRecord/"+leaveRecordType.getId()+"/","leaveRecordList","primary");
		addAction(userContext, leaveRecordType, tokens,"leave_record_type.updateLeaveRecord","updateLeaveRecord","updateLeaveRecord/"+leaveRecordType.getId()+"/","leaveRecordList","primary");
		addAction(userContext, leaveRecordType, tokens,"leave_record_type.copyLeaveRecordFrom","copyLeaveRecordFrom","copyLeaveRecordFrom/"+leaveRecordType.getId()+"/","leaveRecordList","primary");
		addAction(userContext, leaveRecordType, tokens,"leave_record_type.addHolydaySetting","addHolydaySetting","addHolydaySetting/"+leaveRecordType.getId()+"/","holydaySettingList","primary");
		addAction(userContext, leaveRecordType, tokens,"leave_record_type.removeHolydaySetting","removeHolydaySetting","removeHolydaySetting/"+leaveRecordType.getId()+"/","holydaySettingList","primary");
		addAction(userContext, leaveRecordType, tokens,"leave_record_type.updateHolydaySetting","updateHolydaySetting","updateHolydaySetting/"+leaveRecordType.getId()+"/","holydaySettingList","primary");
		addAction(userContext, leaveRecordType, tokens,"leave_record_type.copyHolydaySettingFrom","copyHolydaySettingFrom","copyHolydaySettingFrom/"+leaveRecordType.getId()+"/","holydaySettingList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(FlowableUserContext userContext, LeaveRecordType leaveRecordType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public LeaveRecordType createLeaveRecordType(FlowableUserContext userContext, String name,String code) throws Exception
	//public LeaveRecordType createLeaveRecordType(FlowableUserContext userContext,String name, String code) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfLeaveRecordType(name);
		checkerOf(userContext).checkCodeOfLeaveRecordType(code);
	
		checkerOf(userContext).throwExceptionIfHasErrors(LeaveRecordTypeManagerException.class);


		LeaveRecordType leaveRecordType=createNewLeaveRecordType();	

		leaveRecordType.setName(name);
		leaveRecordType.setCode(code);

		leaveRecordType = saveLeaveRecordType(userContext, leaveRecordType, emptyOptions());
		
		onNewInstanceCreated(userContext, leaveRecordType);
		return leaveRecordType;


	}
	protected LeaveRecordType createNewLeaveRecordType()
	{

		return new LeaveRecordType();
	}

	protected void checkParamsForUpdatingLeaveRecordType(FlowableUserContext userContext,String leaveRecordTypeId, int leaveRecordTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfLeaveRecordType(leaveRecordTypeId);
		checkerOf(userContext).checkVersionOfLeaveRecordType( leaveRecordTypeVersion);
		

		if(LeaveRecordType.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfLeaveRecordType(parseString(newValueExpr));
		
			
		}
		if(LeaveRecordType.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfLeaveRecordType(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(LeaveRecordTypeManagerException.class);


	}



	public LeaveRecordType clone(FlowableUserContext userContext, String fromLeaveRecordTypeId) throws Exception{

		return leaveRecordTypeDaoOf(userContext).clone(fromLeaveRecordTypeId, this.allTokens());
	}

	public LeaveRecordType internalSaveLeaveRecordType(FlowableUserContext userContext, LeaveRecordType leaveRecordType) throws Exception
	{
		return internalSaveLeaveRecordType(userContext, leaveRecordType, allTokens());

	}
	public LeaveRecordType internalSaveLeaveRecordType(FlowableUserContext userContext, LeaveRecordType leaveRecordType, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingLeaveRecordType(userContext, leaveRecordTypeId, leaveRecordTypeVersion, property, newValueExpr, tokensExpr);


		synchronized(leaveRecordType){
			//will be good when the leaveRecordType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LeaveRecordType.
			if (leaveRecordType.isChanged()){
			
			}
			leaveRecordType = saveLeaveRecordType(userContext, leaveRecordType, options);
			return leaveRecordType;

		}

	}

	public LeaveRecordType updateLeaveRecordType(FlowableUserContext userContext,String leaveRecordTypeId, int leaveRecordTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLeaveRecordType(userContext, leaveRecordTypeId, leaveRecordTypeVersion, property, newValueExpr, tokensExpr);



		LeaveRecordType leaveRecordType = loadLeaveRecordType(userContext, leaveRecordTypeId, allTokens());
		if(leaveRecordType.getVersion() != leaveRecordTypeVersion){
			String message = "The target version("+leaveRecordType.getVersion()+") is not equals to version("+leaveRecordTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(leaveRecordType){
			//will be good when the leaveRecordType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LeaveRecordType.
			
			leaveRecordType.changeProperty(property, newValueExpr);
			leaveRecordType = saveLeaveRecordType(userContext, leaveRecordType, tokens().done());
			return present(userContext,leaveRecordType, mergedAllTokens(tokensExpr));
			//return saveLeaveRecordType(userContext, leaveRecordType, tokens().done());
		}

	}

	public LeaveRecordType updateLeaveRecordTypeProperty(FlowableUserContext userContext,String leaveRecordTypeId, int leaveRecordTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLeaveRecordType(userContext, leaveRecordTypeId, leaveRecordTypeVersion, property, newValueExpr, tokensExpr);

		LeaveRecordType leaveRecordType = loadLeaveRecordType(userContext, leaveRecordTypeId, allTokens());
		if(leaveRecordType.getVersion() != leaveRecordTypeVersion){
			String message = "The target version("+leaveRecordType.getVersion()+") is not equals to version("+leaveRecordTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(leaveRecordType){
			//will be good when the leaveRecordType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LeaveRecordType.

			leaveRecordType.changeProperty(property, newValueExpr);
			
			leaveRecordType = saveLeaveRecordType(userContext, leaveRecordType, tokens().done());
			return present(userContext,leaveRecordType, mergedAllTokens(tokensExpr));
			//return saveLeaveRecordType(userContext, leaveRecordType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected LeaveRecordTypeTokens tokens(){
		return LeaveRecordTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LeaveRecordTypeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortLeaveRecordListWith("id","desc")
		.sortHolydaySettingListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LeaveRecordTypeTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(FlowableUserContext userContext, String leaveRecordTypeId, int leaveRecordTypeVersion) throws Exception {
		//deleteInternal(userContext, leaveRecordTypeId, leaveRecordTypeVersion);
	}
	protected void deleteInternal(FlowableUserContext userContext,
			String leaveRecordTypeId, int leaveRecordTypeVersion) throws Exception{

		leaveRecordTypeDaoOf(userContext).delete(leaveRecordTypeId, leaveRecordTypeVersion);
	}

	public LeaveRecordType forgetByAll(FlowableUserContext userContext, String leaveRecordTypeId, int leaveRecordTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, leaveRecordTypeId, leaveRecordTypeVersion);
	}
	protected LeaveRecordType forgetByAllInternal(FlowableUserContext userContext,
			String leaveRecordTypeId, int leaveRecordTypeVersion) throws Exception{

		return leaveRecordTypeDaoOf(userContext).disconnectFromAll(leaveRecordTypeId, leaveRecordTypeVersion);
	}




	public int deleteAll(FlowableUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LeaveRecordTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(FlowableUserContext userContext) throws Exception{
		return leaveRecordTypeDaoOf(userContext).deleteAll();
	}


	//disconnect LeaveRecordType with user in LeaveRecord
	protected LeaveRecordType breakWithLeaveRecordByUser(FlowableUserContext userContext, String leaveRecordTypeId, String userId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			LeaveRecordType leaveRecordType = loadLeaveRecordType(userContext, leaveRecordTypeId, allTokens());

			synchronized(leaveRecordType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				leaveRecordTypeDaoOf(userContext).planToRemoveLeaveRecordListWithUser(leaveRecordType, userId, this.emptyOptions());

				leaveRecordType = saveLeaveRecordType(userContext, leaveRecordType, tokens().withLeaveRecordList().done());
				return leaveRecordType;
			}
	}
	//disconnect LeaveRecordType with platform in LeaveRecord
	protected LeaveRecordType breakWithLeaveRecordByPlatform(FlowableUserContext userContext, String leaveRecordTypeId, String platformId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			LeaveRecordType leaveRecordType = loadLeaveRecordType(userContext, leaveRecordTypeId, allTokens());

			synchronized(leaveRecordType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				leaveRecordTypeDaoOf(userContext).planToRemoveLeaveRecordListWithPlatform(leaveRecordType, platformId, this.emptyOptions());

				leaveRecordType = saveLeaveRecordType(userContext, leaveRecordType, tokens().withLeaveRecordList().done());
				return leaveRecordType;
			}
	}






	protected void checkParamsForAddingLeaveRecord(FlowableUserContext userContext, String leaveRecordTypeId, String userId, Date fromdate, Date todate, String platformId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfLeaveRecordType(leaveRecordTypeId);

		
		checkerOf(userContext).checkUserIdOfLeaveRecord(userId);
		
		checkerOf(userContext).checkFromdateOfLeaveRecord(fromdate);
		
		checkerOf(userContext).checkTodateOfLeaveRecord(todate);
		
		checkerOf(userContext).checkPlatformIdOfLeaveRecord(platformId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(LeaveRecordTypeManagerException.class);


	}
	public  LeaveRecordType addLeaveRecord(FlowableUserContext userContext, String leaveRecordTypeId, String userId, Date fromdate, Date todate, String platformId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingLeaveRecord(userContext,leaveRecordTypeId,userId, fromdate, todate, platformId,tokensExpr);

		LeaveRecord leaveRecord = createLeaveRecord(userContext,userId, fromdate, todate, platformId);

		LeaveRecordType leaveRecordType = loadLeaveRecordType(userContext, leaveRecordTypeId, emptyOptions());
		synchronized(leaveRecordType){
			//Will be good when the leaveRecordType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			leaveRecordType.addLeaveRecord( leaveRecord );
			leaveRecordType = saveLeaveRecordType(userContext, leaveRecordType, tokens().withLeaveRecordList().done());
			
			userContext.getManagerGroup().getLeaveRecordManager().onNewInstanceCreated(userContext, leaveRecord);
			return present(userContext,leaveRecordType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLeaveRecordProperties(FlowableUserContext userContext, String leaveRecordTypeId,String id,Date fromdate,Date todate,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfLeaveRecordType(leaveRecordTypeId);
		checkerOf(userContext).checkIdOfLeaveRecord(id);

		checkerOf(userContext).checkFromdateOfLeaveRecord( fromdate);
		checkerOf(userContext).checkTodateOfLeaveRecord( todate);

		checkerOf(userContext).throwExceptionIfHasErrors(LeaveRecordTypeManagerException.class);

	}
	public  LeaveRecordType updateLeaveRecordProperties(FlowableUserContext userContext, String leaveRecordTypeId, String id,Date fromdate,Date todate, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLeaveRecordProperties(userContext,leaveRecordTypeId,id,fromdate,todate,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLeaveRecordListList()
				.searchLeaveRecordListWith(LeaveRecord.ID_PROPERTY, "is", id).done();

		LeaveRecordType leaveRecordTypeToUpdate = loadLeaveRecordType(userContext, leaveRecordTypeId, options);

		if(leaveRecordTypeToUpdate.getLeaveRecordList().isEmpty()){
			throw new LeaveRecordTypeManagerException("LeaveRecord is NOT FOUND with id: '"+id+"'");
		}

		LeaveRecord item = leaveRecordTypeToUpdate.getLeaveRecordList().first();

		item.updateFromdate( fromdate );
		item.updateTodate( todate );


		//checkParamsForAddingLeaveRecord(userContext,leaveRecordTypeId,name, code, used,tokensExpr);
		LeaveRecordType leaveRecordType = saveLeaveRecordType(userContext, leaveRecordTypeToUpdate, tokens().withLeaveRecordList().done());
		synchronized(leaveRecordType){
			return present(userContext,leaveRecordType, mergedAllTokens(tokensExpr));
		}
	}


	protected LeaveRecord createLeaveRecord(FlowableUserContext userContext, String userId, Date fromdate, Date todate, String platformId) throws Exception{

		LeaveRecord leaveRecord = new LeaveRecord();
		
		
		User  user = new User();
		user.setId(userId);		
		leaveRecord.setUser(user);		
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

	protected void checkParamsForRemovingLeaveRecordList(FlowableUserContext userContext, String leaveRecordTypeId,
			String leaveRecordIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfLeaveRecordType(leaveRecordTypeId);
		for(String leaveRecordIdItem: leaveRecordIds){
			checkerOf(userContext).checkIdOfLeaveRecord(leaveRecordIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(LeaveRecordTypeManagerException.class);

	}
	public  LeaveRecordType removeLeaveRecordList(FlowableUserContext userContext, String leaveRecordTypeId,
			String leaveRecordIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingLeaveRecordList(userContext, leaveRecordTypeId,  leaveRecordIds, tokensExpr);


			LeaveRecordType leaveRecordType = loadLeaveRecordType(userContext, leaveRecordTypeId, allTokens());
			synchronized(leaveRecordType){
				//Will be good when the leaveRecordType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				leaveRecordTypeDaoOf(userContext).planToRemoveLeaveRecordList(leaveRecordType, leaveRecordIds, allTokens());
				leaveRecordType = saveLeaveRecordType(userContext, leaveRecordType, tokens().withLeaveRecordList().done());
				deleteRelationListInGraph(userContext, leaveRecordType.getLeaveRecordList());
				return present(userContext,leaveRecordType, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingLeaveRecord(FlowableUserContext userContext, String leaveRecordTypeId,
		String leaveRecordId, int leaveRecordVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfLeaveRecordType( leaveRecordTypeId);
		checkerOf(userContext).checkIdOfLeaveRecord(leaveRecordId);
		checkerOf(userContext).checkVersionOfLeaveRecord(leaveRecordVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(LeaveRecordTypeManagerException.class);

	}
	public  LeaveRecordType removeLeaveRecord(FlowableUserContext userContext, String leaveRecordTypeId,
		String leaveRecordId, int leaveRecordVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingLeaveRecord(userContext,leaveRecordTypeId, leaveRecordId, leaveRecordVersion,tokensExpr);

		LeaveRecord leaveRecord = createIndexedLeaveRecord(leaveRecordId, leaveRecordVersion);
		LeaveRecordType leaveRecordType = loadLeaveRecordType(userContext, leaveRecordTypeId, allTokens());
		synchronized(leaveRecordType){
			//Will be good when the leaveRecordType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			leaveRecordType.removeLeaveRecord( leaveRecord );
			leaveRecordType = saveLeaveRecordType(userContext, leaveRecordType, tokens().withLeaveRecordList().done());
			deleteRelationInGraph(userContext, leaveRecord);
			return present(userContext,leaveRecordType, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingLeaveRecord(FlowableUserContext userContext, String leaveRecordTypeId,
		String leaveRecordId, int leaveRecordVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfLeaveRecordType( leaveRecordTypeId);
		checkerOf(userContext).checkIdOfLeaveRecord(leaveRecordId);
		checkerOf(userContext).checkVersionOfLeaveRecord(leaveRecordVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(LeaveRecordTypeManagerException.class);

	}
	public  LeaveRecordType copyLeaveRecordFrom(FlowableUserContext userContext, String leaveRecordTypeId,
		String leaveRecordId, int leaveRecordVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingLeaveRecord(userContext,leaveRecordTypeId, leaveRecordId, leaveRecordVersion,tokensExpr);

		LeaveRecord leaveRecord = createIndexedLeaveRecord(leaveRecordId, leaveRecordVersion);
		LeaveRecordType leaveRecordType = loadLeaveRecordType(userContext, leaveRecordTypeId, allTokens());
		synchronized(leaveRecordType){
			//Will be good when the leaveRecordType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			leaveRecordType.copyLeaveRecordFrom( leaveRecord );
			leaveRecordType = saveLeaveRecordType(userContext, leaveRecordType, tokens().withLeaveRecordList().done());
			
			userContext.getManagerGroup().getLeaveRecordManager().onNewInstanceCreated(userContext, (LeaveRecord)leaveRecordType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,leaveRecordType, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingLeaveRecord(FlowableUserContext userContext, String leaveRecordTypeId, String leaveRecordId, int leaveRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfLeaveRecordType(leaveRecordTypeId);
		checkerOf(userContext).checkIdOfLeaveRecord(leaveRecordId);
		checkerOf(userContext).checkVersionOfLeaveRecord(leaveRecordVersion);
		

		if(LeaveRecord.FROMDATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFromdateOfLeaveRecord(parseDate(newValueExpr));
		
		}
		
		if(LeaveRecord.TODATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTodateOfLeaveRecord(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(LeaveRecordTypeManagerException.class);

	}

	public  LeaveRecordType updateLeaveRecord(FlowableUserContext userContext, String leaveRecordTypeId, String leaveRecordId, int leaveRecordVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingLeaveRecord(userContext, leaveRecordTypeId, leaveRecordId, leaveRecordVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withLeaveRecordList().searchLeaveRecordListWith(LeaveRecord.ID_PROPERTY, "eq", leaveRecordId).done();



		LeaveRecordType leaveRecordType = loadLeaveRecordType(userContext, leaveRecordTypeId, loadTokens);

		synchronized(leaveRecordType){
			//Will be good when the leaveRecordType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//leaveRecordType.removeLeaveRecord( leaveRecord );
			//make changes to AcceleraterAccount.
			LeaveRecord leaveRecordIndex = createIndexedLeaveRecord(leaveRecordId, leaveRecordVersion);

			LeaveRecord leaveRecord = leaveRecordType.findTheLeaveRecord(leaveRecordIndex);
			if(leaveRecord == null){
				throw new LeaveRecordTypeManagerException(leaveRecord+" is NOT FOUND" );
			}

			leaveRecord.changeProperty(property, newValueExpr);
			
			leaveRecordType = saveLeaveRecordType(userContext, leaveRecordType, tokens().withLeaveRecordList().done());
			return present(userContext,leaveRecordType, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingHolydaySetting(FlowableUserContext userContext, String leaveRecordTypeId, int leaveDays,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfLeaveRecordType(leaveRecordTypeId);

		
		checkerOf(userContext).checkLeaveDaysOfHolydaySetting(leaveDays);
	
		checkerOf(userContext).throwExceptionIfHasErrors(LeaveRecordTypeManagerException.class);


	}
	public  LeaveRecordType addHolydaySetting(FlowableUserContext userContext, String leaveRecordTypeId, int leaveDays, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingHolydaySetting(userContext,leaveRecordTypeId,leaveDays,tokensExpr);

		HolydaySetting holydaySetting = createHolydaySetting(userContext,leaveDays);

		LeaveRecordType leaveRecordType = loadLeaveRecordType(userContext, leaveRecordTypeId, emptyOptions());
		synchronized(leaveRecordType){
			//Will be good when the leaveRecordType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			leaveRecordType.addHolydaySetting( holydaySetting );
			leaveRecordType = saveLeaveRecordType(userContext, leaveRecordType, tokens().withHolydaySettingList().done());
			
			userContext.getManagerGroup().getHolydaySettingManager().onNewInstanceCreated(userContext, holydaySetting);
			return present(userContext,leaveRecordType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingHolydaySettingProperties(FlowableUserContext userContext, String leaveRecordTypeId,String id,int leaveDays,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfLeaveRecordType(leaveRecordTypeId);
		checkerOf(userContext).checkIdOfHolydaySetting(id);

		checkerOf(userContext).checkLeaveDaysOfHolydaySetting( leaveDays);

		checkerOf(userContext).throwExceptionIfHasErrors(LeaveRecordTypeManagerException.class);

	}
	public  LeaveRecordType updateHolydaySettingProperties(FlowableUserContext userContext, String leaveRecordTypeId, String id,int leaveDays, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingHolydaySettingProperties(userContext,leaveRecordTypeId,id,leaveDays,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withHolydaySettingListList()
				.searchHolydaySettingListWith(HolydaySetting.ID_PROPERTY, "is", id).done();

		LeaveRecordType leaveRecordTypeToUpdate = loadLeaveRecordType(userContext, leaveRecordTypeId, options);

		if(leaveRecordTypeToUpdate.getHolydaySettingList().isEmpty()){
			throw new LeaveRecordTypeManagerException("HolydaySetting is NOT FOUND with id: '"+id+"'");
		}

		HolydaySetting item = leaveRecordTypeToUpdate.getHolydaySettingList().first();

		item.updateLeaveDays( leaveDays );


		//checkParamsForAddingHolydaySetting(userContext,leaveRecordTypeId,name, code, used,tokensExpr);
		LeaveRecordType leaveRecordType = saveLeaveRecordType(userContext, leaveRecordTypeToUpdate, tokens().withHolydaySettingList().done());
		synchronized(leaveRecordType){
			return present(userContext,leaveRecordType, mergedAllTokens(tokensExpr));
		}
	}


	protected HolydaySetting createHolydaySetting(FlowableUserContext userContext, int leaveDays) throws Exception{

		HolydaySetting holydaySetting = new HolydaySetting();
		
		
		holydaySetting.setLeaveDays(leaveDays);
	
		
		return holydaySetting;


	}

	protected HolydaySetting createIndexedHolydaySetting(String id, int version){

		HolydaySetting holydaySetting = new HolydaySetting();
		holydaySetting.setId(id);
		holydaySetting.setVersion(version);
		return holydaySetting;

	}

	protected void checkParamsForRemovingHolydaySettingList(FlowableUserContext userContext, String leaveRecordTypeId,
			String holydaySettingIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfLeaveRecordType(leaveRecordTypeId);
		for(String holydaySettingIdItem: holydaySettingIds){
			checkerOf(userContext).checkIdOfHolydaySetting(holydaySettingIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(LeaveRecordTypeManagerException.class);

	}
	public  LeaveRecordType removeHolydaySettingList(FlowableUserContext userContext, String leaveRecordTypeId,
			String holydaySettingIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingHolydaySettingList(userContext, leaveRecordTypeId,  holydaySettingIds, tokensExpr);


			LeaveRecordType leaveRecordType = loadLeaveRecordType(userContext, leaveRecordTypeId, allTokens());
			synchronized(leaveRecordType){
				//Will be good when the leaveRecordType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				leaveRecordTypeDaoOf(userContext).planToRemoveHolydaySettingList(leaveRecordType, holydaySettingIds, allTokens());
				leaveRecordType = saveLeaveRecordType(userContext, leaveRecordType, tokens().withHolydaySettingList().done());
				deleteRelationListInGraph(userContext, leaveRecordType.getHolydaySettingList());
				return present(userContext,leaveRecordType, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingHolydaySetting(FlowableUserContext userContext, String leaveRecordTypeId,
		String holydaySettingId, int holydaySettingVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfLeaveRecordType( leaveRecordTypeId);
		checkerOf(userContext).checkIdOfHolydaySetting(holydaySettingId);
		checkerOf(userContext).checkVersionOfHolydaySetting(holydaySettingVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(LeaveRecordTypeManagerException.class);

	}
	public  LeaveRecordType removeHolydaySetting(FlowableUserContext userContext, String leaveRecordTypeId,
		String holydaySettingId, int holydaySettingVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingHolydaySetting(userContext,leaveRecordTypeId, holydaySettingId, holydaySettingVersion,tokensExpr);

		HolydaySetting holydaySetting = createIndexedHolydaySetting(holydaySettingId, holydaySettingVersion);
		LeaveRecordType leaveRecordType = loadLeaveRecordType(userContext, leaveRecordTypeId, allTokens());
		synchronized(leaveRecordType){
			//Will be good when the leaveRecordType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			leaveRecordType.removeHolydaySetting( holydaySetting );
			leaveRecordType = saveLeaveRecordType(userContext, leaveRecordType, tokens().withHolydaySettingList().done());
			deleteRelationInGraph(userContext, holydaySetting);
			return present(userContext,leaveRecordType, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingHolydaySetting(FlowableUserContext userContext, String leaveRecordTypeId,
		String holydaySettingId, int holydaySettingVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfLeaveRecordType( leaveRecordTypeId);
		checkerOf(userContext).checkIdOfHolydaySetting(holydaySettingId);
		checkerOf(userContext).checkVersionOfHolydaySetting(holydaySettingVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(LeaveRecordTypeManagerException.class);

	}
	public  LeaveRecordType copyHolydaySettingFrom(FlowableUserContext userContext, String leaveRecordTypeId,
		String holydaySettingId, int holydaySettingVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingHolydaySetting(userContext,leaveRecordTypeId, holydaySettingId, holydaySettingVersion,tokensExpr);

		HolydaySetting holydaySetting = createIndexedHolydaySetting(holydaySettingId, holydaySettingVersion);
		LeaveRecordType leaveRecordType = loadLeaveRecordType(userContext, leaveRecordTypeId, allTokens());
		synchronized(leaveRecordType){
			//Will be good when the leaveRecordType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			leaveRecordType.copyHolydaySettingFrom( holydaySetting );
			leaveRecordType = saveLeaveRecordType(userContext, leaveRecordType, tokens().withHolydaySettingList().done());
			
			userContext.getManagerGroup().getHolydaySettingManager().onNewInstanceCreated(userContext, (HolydaySetting)leaveRecordType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,leaveRecordType, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingHolydaySetting(FlowableUserContext userContext, String leaveRecordTypeId, String holydaySettingId, int holydaySettingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfLeaveRecordType(leaveRecordTypeId);
		checkerOf(userContext).checkIdOfHolydaySetting(holydaySettingId);
		checkerOf(userContext).checkVersionOfHolydaySetting(holydaySettingVersion);
		

		if(HolydaySetting.LEAVE_DAYS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLeaveDaysOfHolydaySetting(parseInt(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(LeaveRecordTypeManagerException.class);

	}

	public  LeaveRecordType updateHolydaySetting(FlowableUserContext userContext, String leaveRecordTypeId, String holydaySettingId, int holydaySettingVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingHolydaySetting(userContext, leaveRecordTypeId, holydaySettingId, holydaySettingVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withHolydaySettingList().searchHolydaySettingListWith(HolydaySetting.ID_PROPERTY, "eq", holydaySettingId).done();



		LeaveRecordType leaveRecordType = loadLeaveRecordType(userContext, leaveRecordTypeId, loadTokens);

		synchronized(leaveRecordType){
			//Will be good when the leaveRecordType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//leaveRecordType.removeHolydaySetting( holydaySetting );
			//make changes to AcceleraterAccount.
			HolydaySetting holydaySettingIndex = createIndexedHolydaySetting(holydaySettingId, holydaySettingVersion);

			HolydaySetting holydaySetting = leaveRecordType.findTheHolydaySetting(holydaySettingIndex);
			if(holydaySetting == null){
				throw new LeaveRecordTypeManagerException(holydaySetting+" is NOT FOUND" );
			}

			holydaySetting.changeProperty(property, newValueExpr);
			
			leaveRecordType = saveLeaveRecordType(userContext, leaveRecordType, tokens().withHolydaySettingList().done());
			return present(userContext,leaveRecordType, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(FlowableUserContext userContext, LeaveRecordType newCreated) throws Exception{
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, LeaveRecordType.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(FlowableUserContext userContext,SmartList<LeaveRecordType> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}

	
    }
	
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------
}


