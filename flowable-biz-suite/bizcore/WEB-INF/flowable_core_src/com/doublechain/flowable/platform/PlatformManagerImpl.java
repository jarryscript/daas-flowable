
package com.doublechain.flowable.platform;

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
import com.doublechain.flowable.city.City;
import com.doublechain.flowable.leaverecord.LeaveRecord;


import com.doublechain.flowable.user.User;
import com.doublechain.flowable.leaverecordtype.LeaveRecordType;
import com.doublechain.flowable.province.Province;
import com.doublechain.flowable.city.City;
import com.doublechain.flowable.platform.Platform;






public class PlatformManagerImpl extends CustomFlowableCheckerManager implements PlatformManager, BusinessHandler{

  


	private static final String SERVICE_TYPE = "Platform";
	@Override
	public PlatformDAO daoOf(FlowableUserContext userContext) {
		return platformDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws PlatformManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new PlatformManagerException(message);

	}



 	protected Platform savePlatform(FlowableUserContext userContext, Platform platform, String [] tokensExpr) throws Exception{	
 		//return getPlatformDAO().save(platform, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePlatform(userContext, platform, tokens);
 	}
 	
 	protected Platform savePlatformDetail(FlowableUserContext userContext, Platform platform) throws Exception{	

 		
 		return savePlatform(userContext, platform, allTokens());
 	}
 	
 	public Platform loadPlatform(FlowableUserContext userContext, String platformId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).throwExceptionIfHasErrors( PlatformManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Platform platform = loadPlatform( userContext, platformId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,platform, tokens);
 	}
 	
 	
 	 public Platform searchPlatform(FlowableUserContext userContext, String platformId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).throwExceptionIfHasErrors( PlatformManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Platform platform = loadPlatform( userContext, platformId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,platform, tokens);
 	}
 	
 	

 	protected Platform present(FlowableUserContext userContext, Platform platform, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,platform,tokens);
		
		
		Platform  platformToPresent = platformDaoOf(userContext).present(platform, tokens);
		
		List<BaseEntity> entityListToNaming = platformToPresent.collectRefercencesFromLists();
		platformDaoOf(userContext).alias(entityListToNaming);
		
		return  platformToPresent;
		
		
	}
 
 	
 	
 	public Platform loadPlatformDetail(FlowableUserContext userContext, String platformId) throws Exception{	
 		Platform platform = loadPlatform( userContext, platformId, allTokens());
 		return present(userContext,platform, allTokens());
		
 	}
 	
 	public Object view(FlowableUserContext userContext, String platformId) throws Exception{	
 		Platform platform = loadPlatform( userContext, platformId, viewTokens());
 		return present(userContext,platform, allTokens());
		
 	}
 	protected Platform savePlatform(FlowableUserContext userContext, Platform platform, Map<String,Object>tokens) throws Exception{	
 		return platformDaoOf(userContext).save(platform, tokens);
 	}
 	protected Platform loadPlatform(FlowableUserContext userContext, String platformId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).throwExceptionIfHasErrors( PlatformManagerException.class);

 
 		return platformDaoOf(userContext).load(platformId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(FlowableUserContext userContext, Platform platform, Map<String, Object> tokens){
		super.addActions(userContext, platform, tokens);
		
		addAction(userContext, platform, tokens,"@create","createPlatform","createPlatform/","main","primary");
		addAction(userContext, platform, tokens,"@update","updatePlatform","updatePlatform/"+platform.getId()+"/","main","primary");
		addAction(userContext, platform, tokens,"@copy","clonePlatform","clonePlatform/"+platform.getId()+"/","main","primary");
		
		addAction(userContext, platform, tokens,"platform.addLeaveRecord","addLeaveRecord","addLeaveRecord/"+platform.getId()+"/","leaveRecordList","primary");
		addAction(userContext, platform, tokens,"platform.removeLeaveRecord","removeLeaveRecord","removeLeaveRecord/"+platform.getId()+"/","leaveRecordList","primary");
		addAction(userContext, platform, tokens,"platform.updateLeaveRecord","updateLeaveRecord","updateLeaveRecord/"+platform.getId()+"/","leaveRecordList","primary");
		addAction(userContext, platform, tokens,"platform.copyLeaveRecordFrom","copyLeaveRecordFrom","copyLeaveRecordFrom/"+platform.getId()+"/","leaveRecordList","primary");
		addAction(userContext, platform, tokens,"platform.addProvince","addProvince","addProvince/"+platform.getId()+"/","provinceList","primary");
		addAction(userContext, platform, tokens,"platform.removeProvince","removeProvince","removeProvince/"+platform.getId()+"/","provinceList","primary");
		addAction(userContext, platform, tokens,"platform.updateProvince","updateProvince","updateProvince/"+platform.getId()+"/","provinceList","primary");
		addAction(userContext, platform, tokens,"platform.copyProvinceFrom","copyProvinceFrom","copyProvinceFrom/"+platform.getId()+"/","provinceList","primary");
		addAction(userContext, platform, tokens,"platform.addCity","addCity","addCity/"+platform.getId()+"/","cityList","primary");
		addAction(userContext, platform, tokens,"platform.removeCity","removeCity","removeCity/"+platform.getId()+"/","cityList","primary");
		addAction(userContext, platform, tokens,"platform.updateCity","updateCity","updateCity/"+platform.getId()+"/","cityList","primary");
		addAction(userContext, platform, tokens,"platform.copyCityFrom","copyCityFrom","copyCityFrom/"+platform.getId()+"/","cityList","primary");
		addAction(userContext, platform, tokens,"platform.addDistrict","addDistrict","addDistrict/"+platform.getId()+"/","districtList","primary");
		addAction(userContext, platform, tokens,"platform.removeDistrict","removeDistrict","removeDistrict/"+platform.getId()+"/","districtList","primary");
		addAction(userContext, platform, tokens,"platform.updateDistrict","updateDistrict","updateDistrict/"+platform.getId()+"/","districtList","primary");
		addAction(userContext, platform, tokens,"platform.copyDistrictFrom","copyDistrictFrom","copyDistrictFrom/"+platform.getId()+"/","districtList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(FlowableUserContext userContext, Platform platform, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public Platform createPlatform(FlowableUserContext userContext, String name) throws Exception
	//public Platform createPlatform(FlowableUserContext userContext,String name) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfPlatform(name);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);


		Platform platform=createNewPlatform();	

		platform.setName(name);
		platform.setFounded(userContext.now());

		platform = savePlatform(userContext, platform, emptyOptions());
		
		onNewInstanceCreated(userContext, platform);
		return platform;


	}
	protected Platform createNewPlatform()
	{

		return new Platform();
	}

	protected void checkParamsForUpdatingPlatform(FlowableUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkVersionOfPlatform( platformVersion);
		

		if(Platform.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfPlatform(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);


	}



	public Platform clone(FlowableUserContext userContext, String fromPlatformId) throws Exception{

		return platformDaoOf(userContext).clone(fromPlatformId, this.allTokens());
	}

	public Platform internalSavePlatform(FlowableUserContext userContext, Platform platform) throws Exception
	{
		return internalSavePlatform(userContext, platform, allTokens());

	}
	public Platform internalSavePlatform(FlowableUserContext userContext, Platform platform, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);


		synchronized(platform){
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			if (platform.isChanged()){
			platform.updateFounded(userContext.now());
			}
			platform = savePlatform(userContext, platform, options);
			return platform;

		}

	}

	public Platform updatePlatform(FlowableUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);



		Platform platform = loadPlatform(userContext, platformId, allTokens());
		if(platform.getVersion() != platformVersion){
			String message = "The target version("+platform.getVersion()+") is not equals to version("+platformVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(platform){
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			platform.updateFounded(userContext.now());
			platform.changeProperty(property, newValueExpr);
			platform = savePlatform(userContext, platform, tokens().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
			//return savePlatform(userContext, platform, tokens().done());
		}

	}

	public Platform updatePlatformProperty(FlowableUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);

		Platform platform = loadPlatform(userContext, platformId, allTokens());
		if(platform.getVersion() != platformVersion){
			String message = "The target version("+platform.getVersion()+") is not equals to version("+platformVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(platform){
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.

			platform.changeProperty(property, newValueExpr);
			platform.updateFounded(userContext.now());
			platform = savePlatform(userContext, platform, tokens().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
			//return savePlatform(userContext, platform, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected PlatformTokens tokens(){
		return PlatformTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PlatformTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortLeaveRecordListWith("id","desc")
		.sortProvinceListWith("id","desc")
		.sortCityListWith("id","desc")
		.sortDistrictListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PlatformTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(FlowableUserContext userContext, String platformId, int platformVersion) throws Exception {
		//deleteInternal(userContext, platformId, platformVersion);
	}
	protected void deleteInternal(FlowableUserContext userContext,
			String platformId, int platformVersion) throws Exception{

		platformDaoOf(userContext).delete(platformId, platformVersion);
	}

	public Platform forgetByAll(FlowableUserContext userContext, String platformId, int platformVersion) throws Exception {
		return forgetByAllInternal(userContext, platformId, platformVersion);
	}
	protected Platform forgetByAllInternal(FlowableUserContext userContext,
			String platformId, int platformVersion) throws Exception{

		return platformDaoOf(userContext).disconnectFromAll(platformId, platformVersion);
	}




	public int deleteAll(FlowableUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PlatformManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(FlowableUserContext userContext) throws Exception{
		return platformDaoOf(userContext).deleteAll();
	}


	//disconnect Platform with user in LeaveRecord
	protected Platform breakWithLeaveRecordByUser(FlowableUserContext userContext, String platformId, String userId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				platformDaoOf(userContext).planToRemoveLeaveRecordListWithUser(platform, userId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withLeaveRecordList().done());
				return platform;
			}
	}
	//disconnect Platform with type in LeaveRecord
	protected Platform breakWithLeaveRecordByType(FlowableUserContext userContext, String platformId, String typeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				platformDaoOf(userContext).planToRemoveLeaveRecordListWithType(platform, typeId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withLeaveRecordList().done());
				return platform;
			}
	}
	//disconnect Platform with province in City
	protected Platform breakWithCityByProvince(FlowableUserContext userContext, String platformId, String provinceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				platformDaoOf(userContext).planToRemoveCityListWithProvince(platform, provinceId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withCityList().done());
				return platform;
			}
	}
	//disconnect Platform with city in District
	protected Platform breakWithDistrictByCity(FlowableUserContext userContext, String platformId, String cityId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				platformDaoOf(userContext).planToRemoveDistrictListWithCity(platform, cityId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withDistrictList().done());
				return platform;
			}
	}






	protected void checkParamsForAddingLeaveRecord(FlowableUserContext userContext, String platformId, String userId, String typeId, Date fromdate, Date todate,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfPlatform(platformId);

		
		checkerOf(userContext).checkUserIdOfLeaveRecord(userId);
		
		checkerOf(userContext).checkTypeIdOfLeaveRecord(typeId);
		
		checkerOf(userContext).checkFromdateOfLeaveRecord(fromdate);
		
		checkerOf(userContext).checkTodateOfLeaveRecord(todate);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);


	}
	public  Platform addLeaveRecord(FlowableUserContext userContext, String platformId, String userId, String typeId, Date fromdate, Date todate, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingLeaveRecord(userContext,platformId,userId, typeId, fromdate, todate,tokensExpr);

		LeaveRecord leaveRecord = createLeaveRecord(userContext,userId, typeId, fromdate, todate);

		Platform platform = loadPlatform(userContext, platformId, emptyOptions());
		synchronized(platform){
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addLeaveRecord( leaveRecord );
			platform = savePlatform(userContext, platform, tokens().withLeaveRecordList().done());
			
			userContext.getManagerGroup().getLeaveRecordManager().onNewInstanceCreated(userContext, leaveRecord);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLeaveRecordProperties(FlowableUserContext userContext, String platformId,String id,Date fromdate,Date todate,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfLeaveRecord(id);

		checkerOf(userContext).checkFromdateOfLeaveRecord( fromdate);
		checkerOf(userContext).checkTodateOfLeaveRecord( todate);

		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}
	public  Platform updateLeaveRecordProperties(FlowableUserContext userContext, String platformId, String id,Date fromdate,Date todate, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLeaveRecordProperties(userContext,platformId,id,fromdate,todate,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLeaveRecordListList()
				.searchLeaveRecordListWith(LeaveRecord.ID_PROPERTY, "is", id).done();

		Platform platformToUpdate = loadPlatform(userContext, platformId, options);

		if(platformToUpdate.getLeaveRecordList().isEmpty()){
			throw new PlatformManagerException("LeaveRecord is NOT FOUND with id: '"+id+"'");
		}

		LeaveRecord item = platformToUpdate.getLeaveRecordList().first();

		item.updateFromdate( fromdate );
		item.updateTodate( todate );


		//checkParamsForAddingLeaveRecord(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withLeaveRecordList().done());
		synchronized(platform){
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}


	protected LeaveRecord createLeaveRecord(FlowableUserContext userContext, String userId, String typeId, Date fromdate, Date todate) throws Exception{

		LeaveRecord leaveRecord = new LeaveRecord();
		
		
		User  user = new User();
		user.setId(userId);		
		leaveRecord.setUser(user);		
		LeaveRecordType  type = new LeaveRecordType();
		type.setId(typeId);		
		leaveRecord.setType(type);		
		leaveRecord.setFromdate(fromdate);		
		leaveRecord.setTodate(todate);
	
		
		return leaveRecord;


	}

	protected LeaveRecord createIndexedLeaveRecord(String id, int version){

		LeaveRecord leaveRecord = new LeaveRecord();
		leaveRecord.setId(id);
		leaveRecord.setVersion(version);
		return leaveRecord;

	}

	protected void checkParamsForRemovingLeaveRecordList(FlowableUserContext userContext, String platformId,
			String leaveRecordIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPlatform(platformId);
		for(String leaveRecordIdItem: leaveRecordIds){
			checkerOf(userContext).checkIdOfLeaveRecord(leaveRecordIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}
	public  Platform removeLeaveRecordList(FlowableUserContext userContext, String platformId,
			String leaveRecordIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingLeaveRecordList(userContext, platformId,  leaveRecordIds, tokensExpr);


			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				platformDaoOf(userContext).planToRemoveLeaveRecordList(platform, leaveRecordIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withLeaveRecordList().done());
				deleteRelationListInGraph(userContext, platform.getLeaveRecordList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingLeaveRecord(FlowableUserContext userContext, String platformId,
		String leaveRecordId, int leaveRecordVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfLeaveRecord(leaveRecordId);
		checkerOf(userContext).checkVersionOfLeaveRecord(leaveRecordVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}
	public  Platform removeLeaveRecord(FlowableUserContext userContext, String platformId,
		String leaveRecordId, int leaveRecordVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingLeaveRecord(userContext,platformId, leaveRecordId, leaveRecordVersion,tokensExpr);

		LeaveRecord leaveRecord = createIndexedLeaveRecord(leaveRecordId, leaveRecordVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeLeaveRecord( leaveRecord );
			platform = savePlatform(userContext, platform, tokens().withLeaveRecordList().done());
			deleteRelationInGraph(userContext, leaveRecord);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingLeaveRecord(FlowableUserContext userContext, String platformId,
		String leaveRecordId, int leaveRecordVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfLeaveRecord(leaveRecordId);
		checkerOf(userContext).checkVersionOfLeaveRecord(leaveRecordVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}
	public  Platform copyLeaveRecordFrom(FlowableUserContext userContext, String platformId,
		String leaveRecordId, int leaveRecordVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingLeaveRecord(userContext,platformId, leaveRecordId, leaveRecordVersion,tokensExpr);

		LeaveRecord leaveRecord = createIndexedLeaveRecord(leaveRecordId, leaveRecordVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			platform.copyLeaveRecordFrom( leaveRecord );
			platform = savePlatform(userContext, platform, tokens().withLeaveRecordList().done());
			
			userContext.getManagerGroup().getLeaveRecordManager().onNewInstanceCreated(userContext, (LeaveRecord)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingLeaveRecord(FlowableUserContext userContext, String platformId, String leaveRecordId, int leaveRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfLeaveRecord(leaveRecordId);
		checkerOf(userContext).checkVersionOfLeaveRecord(leaveRecordVersion);
		

		if(LeaveRecord.FROMDATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFromdateOfLeaveRecord(parseDate(newValueExpr));
		
		}
		
		if(LeaveRecord.TODATE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTodateOfLeaveRecord(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}

	public  Platform updateLeaveRecord(FlowableUserContext userContext, String platformId, String leaveRecordId, int leaveRecordVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingLeaveRecord(userContext, platformId, leaveRecordId, leaveRecordVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withLeaveRecordList().searchLeaveRecordListWith(LeaveRecord.ID_PROPERTY, "eq", leaveRecordId).done();



		Platform platform = loadPlatform(userContext, platformId, loadTokens);

		synchronized(platform){
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeLeaveRecord( leaveRecord );
			//make changes to AcceleraterAccount.
			LeaveRecord leaveRecordIndex = createIndexedLeaveRecord(leaveRecordId, leaveRecordVersion);

			LeaveRecord leaveRecord = platform.findTheLeaveRecord(leaveRecordIndex);
			if(leaveRecord == null){
				throw new PlatformManagerException(leaveRecord+" is NOT FOUND" );
			}

			leaveRecord.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withLeaveRecordList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingProvince(FlowableUserContext userContext, String platformId, String name,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfPlatform(platformId);

		
		checkerOf(userContext).checkNameOfProvince(name);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);


	}
	public  Platform addProvince(FlowableUserContext userContext, String platformId, String name, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingProvince(userContext,platformId,name,tokensExpr);

		Province province = createProvince(userContext,name);

		Platform platform = loadPlatform(userContext, platformId, emptyOptions());
		synchronized(platform){
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addProvince( province );
			platform = savePlatform(userContext, platform, tokens().withProvinceList().done());
			
			userContext.getManagerGroup().getProvinceManager().onNewInstanceCreated(userContext, province);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProvinceProperties(FlowableUserContext userContext, String platformId,String id,String name,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfProvince(id);

		checkerOf(userContext).checkNameOfProvince( name);

		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}
	public  Platform updateProvinceProperties(FlowableUserContext userContext, String platformId, String id,String name, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingProvinceProperties(userContext,platformId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProvinceListList()
				.searchProvinceListWith(Province.ID_PROPERTY, "is", id).done();

		Platform platformToUpdate = loadPlatform(userContext, platformId, options);

		if(platformToUpdate.getProvinceList().isEmpty()){
			throw new PlatformManagerException("Province is NOT FOUND with id: '"+id+"'");
		}

		Province item = platformToUpdate.getProvinceList().first();

		item.updateName( name );


		//checkParamsForAddingProvince(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withProvinceList().done());
		synchronized(platform){
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}


	protected Province createProvince(FlowableUserContext userContext, String name) throws Exception{

		Province province = new Province();
		
		
		province.setName(name);
	
		
		return province;


	}

	protected Province createIndexedProvince(String id, int version){

		Province province = new Province();
		province.setId(id);
		province.setVersion(version);
		return province;

	}

	protected void checkParamsForRemovingProvinceList(FlowableUserContext userContext, String platformId,
			String provinceIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPlatform(platformId);
		for(String provinceIdItem: provinceIds){
			checkerOf(userContext).checkIdOfProvince(provinceIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}
	public  Platform removeProvinceList(FlowableUserContext userContext, String platformId,
			String provinceIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingProvinceList(userContext, platformId,  provinceIds, tokensExpr);


			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				platformDaoOf(userContext).planToRemoveProvinceList(platform, provinceIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withProvinceList().done());
				deleteRelationListInGraph(userContext, platform.getProvinceList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingProvince(FlowableUserContext userContext, String platformId,
		String provinceId, int provinceVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfProvince(provinceId);
		checkerOf(userContext).checkVersionOfProvince(provinceVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}
	public  Platform removeProvince(FlowableUserContext userContext, String platformId,
		String provinceId, int provinceVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingProvince(userContext,platformId, provinceId, provinceVersion,tokensExpr);

		Province province = createIndexedProvince(provinceId, provinceVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeProvince( province );
			platform = savePlatform(userContext, platform, tokens().withProvinceList().done());
			deleteRelationInGraph(userContext, province);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingProvince(FlowableUserContext userContext, String platformId,
		String provinceId, int provinceVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfProvince(provinceId);
		checkerOf(userContext).checkVersionOfProvince(provinceVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}
	public  Platform copyProvinceFrom(FlowableUserContext userContext, String platformId,
		String provinceId, int provinceVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingProvince(userContext,platformId, provinceId, provinceVersion,tokensExpr);

		Province province = createIndexedProvince(provinceId, provinceVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			platform.copyProvinceFrom( province );
			platform = savePlatform(userContext, platform, tokens().withProvinceList().done());
			
			userContext.getManagerGroup().getProvinceManager().onNewInstanceCreated(userContext, (Province)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingProvince(FlowableUserContext userContext, String platformId, String provinceId, int provinceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfProvince(provinceId);
		checkerOf(userContext).checkVersionOfProvince(provinceVersion);
		

		if(Province.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfProvince(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}

	public  Platform updateProvince(FlowableUserContext userContext, String platformId, String provinceId, int provinceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingProvince(userContext, platformId, provinceId, provinceVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withProvinceList().searchProvinceListWith(Province.ID_PROPERTY, "eq", provinceId).done();



		Platform platform = loadPlatform(userContext, platformId, loadTokens);

		synchronized(platform){
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeProvince( province );
			//make changes to AcceleraterAccount.
			Province provinceIndex = createIndexedProvince(provinceId, provinceVersion);

			Province province = platform.findTheProvince(provinceIndex);
			if(province == null){
				throw new PlatformManagerException(province+" is NOT FOUND" );
			}

			province.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withProvinceList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingCity(FlowableUserContext userContext, String platformId, String name, String provinceId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfPlatform(platformId);

		
		checkerOf(userContext).checkNameOfCity(name);
		
		checkerOf(userContext).checkProvinceIdOfCity(provinceId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);


	}
	public  Platform addCity(FlowableUserContext userContext, String platformId, String name, String provinceId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingCity(userContext,platformId,name, provinceId,tokensExpr);

		City city = createCity(userContext,name, provinceId);

		Platform platform = loadPlatform(userContext, platformId, emptyOptions());
		synchronized(platform){
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addCity( city );
			platform = savePlatform(userContext, platform, tokens().withCityList().done());
			
			userContext.getManagerGroup().getCityManager().onNewInstanceCreated(userContext, city);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingCityProperties(FlowableUserContext userContext, String platformId,String id,String name,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfCity(id);

		checkerOf(userContext).checkNameOfCity( name);

		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}
	public  Platform updateCityProperties(FlowableUserContext userContext, String platformId, String id,String name, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCityProperties(userContext,platformId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withCityListList()
				.searchCityListWith(City.ID_PROPERTY, "is", id).done();

		Platform platformToUpdate = loadPlatform(userContext, platformId, options);

		if(platformToUpdate.getCityList().isEmpty()){
			throw new PlatformManagerException("City is NOT FOUND with id: '"+id+"'");
		}

		City item = platformToUpdate.getCityList().first();

		item.updateName( name );


		//checkParamsForAddingCity(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withCityList().done());
		synchronized(platform){
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}


	protected City createCity(FlowableUserContext userContext, String name, String provinceId) throws Exception{

		City city = new City();
		
		
		city.setName(name);		
		Province  province = new Province();
		province.setId(provinceId);		
		city.setProvince(province);
	
		
		return city;


	}

	protected City createIndexedCity(String id, int version){

		City city = new City();
		city.setId(id);
		city.setVersion(version);
		return city;

	}

	protected void checkParamsForRemovingCityList(FlowableUserContext userContext, String platformId,
			String cityIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPlatform(platformId);
		for(String cityIdItem: cityIds){
			checkerOf(userContext).checkIdOfCity(cityIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}
	public  Platform removeCityList(FlowableUserContext userContext, String platformId,
			String cityIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingCityList(userContext, platformId,  cityIds, tokensExpr);


			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				platformDaoOf(userContext).planToRemoveCityList(platform, cityIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withCityList().done());
				deleteRelationListInGraph(userContext, platform.getCityList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingCity(FlowableUserContext userContext, String platformId,
		String cityId, int cityVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfCity(cityId);
		checkerOf(userContext).checkVersionOfCity(cityVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}
	public  Platform removeCity(FlowableUserContext userContext, String platformId,
		String cityId, int cityVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingCity(userContext,platformId, cityId, cityVersion,tokensExpr);

		City city = createIndexedCity(cityId, cityVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeCity( city );
			platform = savePlatform(userContext, platform, tokens().withCityList().done());
			deleteRelationInGraph(userContext, city);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingCity(FlowableUserContext userContext, String platformId,
		String cityId, int cityVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfCity(cityId);
		checkerOf(userContext).checkVersionOfCity(cityVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}
	public  Platform copyCityFrom(FlowableUserContext userContext, String platformId,
		String cityId, int cityVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingCity(userContext,platformId, cityId, cityVersion,tokensExpr);

		City city = createIndexedCity(cityId, cityVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			platform.copyCityFrom( city );
			platform = savePlatform(userContext, platform, tokens().withCityList().done());
			
			userContext.getManagerGroup().getCityManager().onNewInstanceCreated(userContext, (City)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingCity(FlowableUserContext userContext, String platformId, String cityId, int cityVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfCity(cityId);
		checkerOf(userContext).checkVersionOfCity(cityVersion);
		

		if(City.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfCity(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}

	public  Platform updateCity(FlowableUserContext userContext, String platformId, String cityId, int cityVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingCity(userContext, platformId, cityId, cityVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withCityList().searchCityListWith(City.ID_PROPERTY, "eq", cityId).done();



		Platform platform = loadPlatform(userContext, platformId, loadTokens);

		synchronized(platform){
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeCity( city );
			//make changes to AcceleraterAccount.
			City cityIndex = createIndexedCity(cityId, cityVersion);

			City city = platform.findTheCity(cityIndex);
			if(city == null){
				throw new PlatformManagerException(city+" is NOT FOUND" );
			}

			city.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withCityList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingDistrict(FlowableUserContext userContext, String platformId, String name, String cityId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfPlatform(platformId);

		
		checkerOf(userContext).checkNameOfDistrict(name);
		
		checkerOf(userContext).checkCityIdOfDistrict(cityId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);


	}
	public  Platform addDistrict(FlowableUserContext userContext, String platformId, String name, String cityId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingDistrict(userContext,platformId,name, cityId,tokensExpr);

		District district = createDistrict(userContext,name, cityId);

		Platform platform = loadPlatform(userContext, platformId, emptyOptions());
		synchronized(platform){
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addDistrict( district );
			platform = savePlatform(userContext, platform, tokens().withDistrictList().done());
			
			userContext.getManagerGroup().getDistrictManager().onNewInstanceCreated(userContext, district);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingDistrictProperties(FlowableUserContext userContext, String platformId,String id,String name,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfDistrict(id);

		checkerOf(userContext).checkNameOfDistrict( name);

		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}
	public  Platform updateDistrictProperties(FlowableUserContext userContext, String platformId, String id,String name, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingDistrictProperties(userContext,platformId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withDistrictListList()
				.searchDistrictListWith(District.ID_PROPERTY, "is", id).done();

		Platform platformToUpdate = loadPlatform(userContext, platformId, options);

		if(platformToUpdate.getDistrictList().isEmpty()){
			throw new PlatformManagerException("District is NOT FOUND with id: '"+id+"'");
		}

		District item = platformToUpdate.getDistrictList().first();

		item.updateName( name );


		//checkParamsForAddingDistrict(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withDistrictList().done());
		synchronized(platform){
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}


	protected District createDistrict(FlowableUserContext userContext, String name, String cityId) throws Exception{

		District district = new District();
		
		
		district.setName(name);		
		City  city = new City();
		city.setId(cityId);		
		district.setCity(city);
	
		
		return district;


	}

	protected District createIndexedDistrict(String id, int version){

		District district = new District();
		district.setId(id);
		district.setVersion(version);
		return district;

	}

	protected void checkParamsForRemovingDistrictList(FlowableUserContext userContext, String platformId,
			String districtIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfPlatform(platformId);
		for(String districtIdItem: districtIds){
			checkerOf(userContext).checkIdOfDistrict(districtIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}
	public  Platform removeDistrictList(FlowableUserContext userContext, String platformId,
			String districtIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingDistrictList(userContext, platformId,  districtIds, tokensExpr);


			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				platformDaoOf(userContext).planToRemoveDistrictList(platform, districtIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withDistrictList().done());
				deleteRelationListInGraph(userContext, platform.getDistrictList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingDistrict(FlowableUserContext userContext, String platformId,
		String districtId, int districtVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfDistrict(districtId);
		checkerOf(userContext).checkVersionOfDistrict(districtVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}
	public  Platform removeDistrict(FlowableUserContext userContext, String platformId,
		String districtId, int districtVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingDistrict(userContext,platformId, districtId, districtVersion,tokensExpr);

		District district = createIndexedDistrict(districtId, districtVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeDistrict( district );
			platform = savePlatform(userContext, platform, tokens().withDistrictList().done());
			deleteRelationInGraph(userContext, district);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingDistrict(FlowableUserContext userContext, String platformId,
		String districtId, int districtVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfDistrict(districtId);
		checkerOf(userContext).checkVersionOfDistrict(districtVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}
	public  Platform copyDistrictFrom(FlowableUserContext userContext, String platformId,
		String districtId, int districtVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingDistrict(userContext,platformId, districtId, districtVersion,tokensExpr);

		District district = createIndexedDistrict(districtId, districtVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			platform.copyDistrictFrom( district );
			platform = savePlatform(userContext, platform, tokens().withDistrictList().done());
			
			userContext.getManagerGroup().getDistrictManager().onNewInstanceCreated(userContext, (District)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingDistrict(FlowableUserContext userContext, String platformId, String districtId, int districtVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfDistrict(districtId);
		checkerOf(userContext).checkVersionOfDistrict(districtVersion);
		

		if(District.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfDistrict(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	}

	public  Platform updateDistrict(FlowableUserContext userContext, String platformId, String districtId, int districtVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingDistrict(userContext, platformId, districtId, districtVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withDistrictList().searchDistrictListWith(District.ID_PROPERTY, "eq", districtId).done();



		Platform platform = loadPlatform(userContext, platformId, loadTokens);

		synchronized(platform){
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeDistrict( district );
			//make changes to AcceleraterAccount.
			District districtIndex = createIndexedDistrict(districtId, districtVersion);

			District district = platform.findTheDistrict(districtIndex);
			if(district == null){
				throw new PlatformManagerException(district+" is NOT FOUND" );
			}

			district.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withDistrictList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(FlowableUserContext userContext, Platform newCreated) throws Exception{
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, Platform.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(FlowableUserContext userContext,SmartList<Platform> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}

	
    }
	
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------
}


