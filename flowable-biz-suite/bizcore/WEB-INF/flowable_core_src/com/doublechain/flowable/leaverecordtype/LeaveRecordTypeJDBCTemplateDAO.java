
package com.doublechain.flowable.leaverecordtype;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechain.flowable.FlowableBaseDAOImpl;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.SmartList;
import com.doublechain.flowable.AccessKey;
import com.doublechain.flowable.DateKey;
import com.doublechain.flowable.StatsInfo;
import com.doublechain.flowable.StatsItem;

import com.doublechain.flowable.MultipleAccessKey;
import com.doublechain.flowable.FlowableUserContext;


import com.doublechain.flowable.holydaysetting.HolydaySetting;
import com.doublechain.flowable.leaverecord.LeaveRecord;

import com.doublechain.flowable.leaverecord.LeaveRecordDAO;
import com.doublechain.flowable.holydaysetting.HolydaySettingDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class LeaveRecordTypeJDBCTemplateDAO extends FlowableBaseDAOImpl implements LeaveRecordTypeDAO{


			
		
	
  	private  LeaveRecordDAO  leaveRecordDAO;
 	public void setLeaveRecordDAO(LeaveRecordDAO pLeaveRecordDAO){
 	
 		if(pLeaveRecordDAO == null){
 			throw new IllegalStateException("Do not try to set leaveRecordDAO to null.");
 		}
	 	this.leaveRecordDAO = pLeaveRecordDAO;
 	}
 	public LeaveRecordDAO getLeaveRecordDAO(){
 		if(this.leaveRecordDAO == null){
 			throw new IllegalStateException("The leaveRecordDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.leaveRecordDAO;
 	}	
 	
			
		
	
  	private  HolydaySettingDAO  holydaySettingDAO;
 	public void setHolydaySettingDAO(HolydaySettingDAO pHolydaySettingDAO){
 	
 		if(pHolydaySettingDAO == null){
 			throw new IllegalStateException("Do not try to set holydaySettingDAO to null.");
 		}
	 	this.holydaySettingDAO = pHolydaySettingDAO;
 	}
 	public HolydaySettingDAO getHolydaySettingDAO(){
 		if(this.holydaySettingDAO == null){
 			throw new IllegalStateException("The holydaySettingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.holydaySettingDAO;
 	}	
 	
			
		

	
	/*
	protected LeaveRecordType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLeaveRecordType(accessKey, options);
	}
	*/
	
	public SmartList<LeaveRecordType> loadAll() {
	    return this.loadAll(getLeaveRecordTypeMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public LeaveRecordType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLeaveRecordType(LeaveRecordTypeTable.withId(id), options);
	}
	
	
	
	public LeaveRecordType loadByCode(String code,Map<String,Object> options) throws Exception{
		return loadInternalLeaveRecordType(LeaveRecordTypeTable.withCode( code), options);
	}
	
	
	public LeaveRecordType save(LeaveRecordType leaveRecordType,Map<String,Object> options){
		
		String methodName="save(LeaveRecordType leaveRecordType,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(leaveRecordType, methodName, "leaveRecordType");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalLeaveRecordType(leaveRecordType,options);
	}
	public LeaveRecordType clone(String leaveRecordTypeId, Map<String,Object> options) throws Exception{
	
		return clone(LeaveRecordTypeTable.withId(leaveRecordTypeId),options);
	}
	
	protected LeaveRecordType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String leaveRecordTypeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		LeaveRecordType newLeaveRecordType = loadInternalLeaveRecordType(accessKey, options);
		newLeaveRecordType.setVersion(0);
		
		
 		
 		if(isSaveLeaveRecordListEnabled(options)){
 			for(LeaveRecord item: newLeaveRecordType.getLeaveRecordList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveHolydaySettingListEnabled(options)){
 			for(HolydaySetting item: newLeaveRecordType.getHolydaySettingList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalLeaveRecordType(newLeaveRecordType,options);
		
		return newLeaveRecordType;
	}
	
	
	
	public LeaveRecordType cloneByCode(String code,Map<String,Object> options) throws Exception{
		return clone(LeaveRecordTypeTable.withCode( code), options);
	}
	
	
	

	protected void throwIfHasException(String leaveRecordTypeId,int version,int count) throws Exception{
		if (count == 1) {
			throw new LeaveRecordTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LeaveRecordTypeNotFoundException(
					"The " + this.getTableName() + "(" + leaveRecordTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String leaveRecordTypeId, int version) throws Exception{
	
		String methodName="delete(String leaveRecordTypeId, int version)";
		assertMethodArgumentNotNull(leaveRecordTypeId, methodName, "leaveRecordTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{leaveRecordTypeId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(leaveRecordTypeId,version);
		}
		
	
	}
	
	
	
	
	

	public LeaveRecordType disconnectFromAll(String leaveRecordTypeId, int version) throws Exception{
	
		
		LeaveRecordType leaveRecordType = loadInternalLeaveRecordType(LeaveRecordTypeTable.withId(leaveRecordTypeId), emptyOptions());
		leaveRecordType.clearFromAll();
		this.saveLeaveRecordType(leaveRecordType);
		return leaveRecordType;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return LeaveRecordTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "leave_record_type";
	}
	@Override
	protected String getBeanName() {
		
		return "leaveRecordType";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return LeaveRecordTypeTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractLeaveRecordListEnabled(Map<String,Object> options){		
 		return checkOptions(options,LeaveRecordTypeTokens.LEAVE_RECORD_LIST);
 	}
 	protected boolean isAnalyzeLeaveRecordListEnabled(Map<String,Object> options){		 		
 		return LeaveRecordTypeTokens.of(options).analyzeLeaveRecordListEnabled();
 	}
	
	protected boolean isSaveLeaveRecordListEnabled(Map<String,Object> options){
		return checkOptions(options, LeaveRecordTypeTokens.LEAVE_RECORD_LIST);
		
 	}
 	
		
	
	protected boolean isExtractHolydaySettingListEnabled(Map<String,Object> options){		
 		return checkOptions(options,LeaveRecordTypeTokens.HOLYDAY_SETTING_LIST);
 	}
 	protected boolean isAnalyzeHolydaySettingListEnabled(Map<String,Object> options){		 		
 		return LeaveRecordTypeTokens.of(options).analyzeHolydaySettingListEnabled();
 	}
	
	protected boolean isSaveHolydaySettingListEnabled(Map<String,Object> options){
		return checkOptions(options, LeaveRecordTypeTokens.HOLYDAY_SETTING_LIST);
		
 	}
 	
		

	

	protected LeaveRecordTypeMapper getLeaveRecordTypeMapper(){
		return new LeaveRecordTypeMapper();
	}

	
	
	protected LeaveRecordType extractLeaveRecordType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			LeaveRecordType leaveRecordType = loadSingleObject(accessKey, getLeaveRecordTypeMapper());
			return leaveRecordType;
		}catch(EmptyResultDataAccessException e){
			throw new LeaveRecordTypeNotFoundException("LeaveRecordType("+accessKey+") is not found!");
		}

	}

	
	

	protected LeaveRecordType loadInternalLeaveRecordType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		LeaveRecordType leaveRecordType = extractLeaveRecordType(accessKey, loadOptions);

		
		if(isExtractLeaveRecordListEnabled(loadOptions)){
	 		extractLeaveRecordList(leaveRecordType, loadOptions);
 		}	
 		if(isAnalyzeLeaveRecordListEnabled(loadOptions)){
	 		analyzeLeaveRecordList(leaveRecordType, loadOptions);
 		}
 		
		
		if(isExtractHolydaySettingListEnabled(loadOptions)){
	 		extractHolydaySettingList(leaveRecordType, loadOptions);
 		}	
 		if(isAnalyzeHolydaySettingListEnabled(loadOptions)){
	 		analyzeHolydaySettingList(leaveRecordType, loadOptions);
 		}
 		
		
		return leaveRecordType;
		
	}

	
		
	protected void enhanceLeaveRecordList(SmartList<LeaveRecord> leaveRecordList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected LeaveRecordType extractLeaveRecordList(LeaveRecordType leaveRecordType, Map<String,Object> options){
		
		
		if(leaveRecordType == null){
			return null;
		}
		if(leaveRecordType.getId() == null){
			return leaveRecordType;
		}

		
		
		SmartList<LeaveRecord> leaveRecordList = getLeaveRecordDAO().findLeaveRecordByType(leaveRecordType.getId(),options);
		if(leaveRecordList != null){
			enhanceLeaveRecordList(leaveRecordList,options);
			leaveRecordType.setLeaveRecordList(leaveRecordList);
		}
		
		return leaveRecordType;
	
	}	
	
	protected LeaveRecordType analyzeLeaveRecordList(LeaveRecordType leaveRecordType, Map<String,Object> options){
		
		
		if(leaveRecordType == null){
			return null;
		}
		if(leaveRecordType.getId() == null){
			return leaveRecordType;
		}

		
		
		SmartList<LeaveRecord> leaveRecordList = leaveRecordType.getLeaveRecordList();
		if(leaveRecordList != null){
			getLeaveRecordDAO().analyzeLeaveRecordByType(leaveRecordList, leaveRecordType.getId(), options);
			
		}
		
		return leaveRecordType;
	
	}	
	
		
	protected void enhanceHolydaySettingList(SmartList<HolydaySetting> holydaySettingList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected LeaveRecordType extractHolydaySettingList(LeaveRecordType leaveRecordType, Map<String,Object> options){
		
		
		if(leaveRecordType == null){
			return null;
		}
		if(leaveRecordType.getId() == null){
			return leaveRecordType;
		}

		
		
		SmartList<HolydaySetting> holydaySettingList = getHolydaySettingDAO().findHolydaySettingByType(leaveRecordType.getId(),options);
		if(holydaySettingList != null){
			enhanceHolydaySettingList(holydaySettingList,options);
			leaveRecordType.setHolydaySettingList(holydaySettingList);
		}
		
		return leaveRecordType;
	
	}	
	
	protected LeaveRecordType analyzeHolydaySettingList(LeaveRecordType leaveRecordType, Map<String,Object> options){
		
		
		if(leaveRecordType == null){
			return null;
		}
		if(leaveRecordType.getId() == null){
			return leaveRecordType;
		}

		
		
		SmartList<HolydaySetting> holydaySettingList = leaveRecordType.getHolydaySettingList();
		if(holydaySettingList != null){
			getHolydaySettingDAO().analyzeHolydaySettingByType(holydaySettingList, leaveRecordType.getId(), options);
			
		}
		
		return leaveRecordType;
	
	}	
	
		
		
 	
		
		
		

	

	protected LeaveRecordType saveLeaveRecordType(LeaveRecordType  leaveRecordType){
		
		if(!leaveRecordType.isChanged()){
			return leaveRecordType;
		}
		
		
		String SQL=this.getSaveLeaveRecordTypeSQL(leaveRecordType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLeaveRecordTypeParameters(leaveRecordType);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		leaveRecordType.incVersion();
		return leaveRecordType;
	
	}
	public SmartList<LeaveRecordType> saveLeaveRecordTypeList(SmartList<LeaveRecordType> leaveRecordTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLeaveRecordTypeList(leaveRecordTypeList);
		
		batchLeaveRecordTypeCreate((List<LeaveRecordType>)lists[CREATE_LIST_INDEX]);
		
		batchLeaveRecordTypeUpdate((List<LeaveRecordType>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(LeaveRecordType leaveRecordType:leaveRecordTypeList){
			if(leaveRecordType.isChanged()){
				leaveRecordType.incVersion();
			}
			
		
		}
		
		
		return leaveRecordTypeList;
	}

	public SmartList<LeaveRecordType> removeLeaveRecordTypeList(SmartList<LeaveRecordType> leaveRecordTypeList,Map<String,Object> options){
		
		
		super.removeList(leaveRecordTypeList, options);
		
		return leaveRecordTypeList;
		
		
	}
	
	protected List<Object[]> prepareLeaveRecordTypeBatchCreateArgs(List<LeaveRecordType> leaveRecordTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LeaveRecordType leaveRecordType:leaveRecordTypeList ){
			Object [] parameters = prepareLeaveRecordTypeCreateParameters(leaveRecordType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareLeaveRecordTypeBatchUpdateArgs(List<LeaveRecordType> leaveRecordTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LeaveRecordType leaveRecordType:leaveRecordTypeList ){
			if(!leaveRecordType.isChanged()){
				continue;
			}
			Object [] parameters = prepareLeaveRecordTypeUpdateParameters(leaveRecordType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchLeaveRecordTypeCreate(List<LeaveRecordType> leaveRecordTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLeaveRecordTypeBatchCreateArgs(leaveRecordTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchLeaveRecordTypeUpdate(List<LeaveRecordType> leaveRecordTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLeaveRecordTypeBatchUpdateArgs(leaveRecordTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitLeaveRecordTypeList(List<LeaveRecordType> leaveRecordTypeList){
		
		List<LeaveRecordType> leaveRecordTypeCreateList=new ArrayList<LeaveRecordType>();
		List<LeaveRecordType> leaveRecordTypeUpdateList=new ArrayList<LeaveRecordType>();
		
		for(LeaveRecordType leaveRecordType: leaveRecordTypeList){
			if(isUpdateRequest(leaveRecordType)){
				leaveRecordTypeUpdateList.add( leaveRecordType);
				continue;
			}
			leaveRecordTypeCreateList.add(leaveRecordType);
		}
		
		return new Object[]{leaveRecordTypeCreateList,leaveRecordTypeUpdateList};
	}
	
	protected boolean isUpdateRequest(LeaveRecordType leaveRecordType){
 		return leaveRecordType.getVersion() > 0;
 	}
 	protected String getSaveLeaveRecordTypeSQL(LeaveRecordType leaveRecordType){
 		if(isUpdateRequest(leaveRecordType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveLeaveRecordTypeParameters(LeaveRecordType leaveRecordType){
 		if(isUpdateRequest(leaveRecordType) ){
 			return prepareLeaveRecordTypeUpdateParameters(leaveRecordType);
 		}
 		return prepareLeaveRecordTypeCreateParameters(leaveRecordType);
 	}
 	protected Object[] prepareLeaveRecordTypeUpdateParameters(LeaveRecordType leaveRecordType){
 		Object[] parameters = new Object[5];
 
 		
 		parameters[0] = leaveRecordType.getName();
 		
 		
 		parameters[1] = leaveRecordType.getCode();
 				
 		parameters[2] = leaveRecordType.nextVersion();
 		parameters[3] = leaveRecordType.getId();
 		parameters[4] = leaveRecordType.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareLeaveRecordTypeCreateParameters(LeaveRecordType leaveRecordType){
		Object[] parameters = new Object[3];
		String newLeaveRecordTypeId=getNextId();
		leaveRecordType.setId(newLeaveRecordTypeId);
		parameters[0] =  leaveRecordType.getId();
 
 		
 		parameters[1] = leaveRecordType.getName();
 		
 		
 		parameters[2] = leaveRecordType.getCode();
 				
 				
 		return parameters;
 	}
 	
	protected LeaveRecordType saveInternalLeaveRecordType(LeaveRecordType leaveRecordType, Map<String,Object> options){
		
		saveLeaveRecordType(leaveRecordType);

		
		if(isSaveLeaveRecordListEnabled(options)){
	 		saveLeaveRecordList(leaveRecordType, options);
	 		//removeLeaveRecordList(leaveRecordType, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveHolydaySettingListEnabled(options)){
	 		saveHolydaySettingList(leaveRecordType, options);
	 		//removeHolydaySettingList(leaveRecordType, options);
	 		//Not delete the record
	 		
 		}		
		
		return leaveRecordType;
		
	}
	
	
	
	//======================================================================================
	

	
	public LeaveRecordType planToRemoveLeaveRecordList(LeaveRecordType leaveRecordType, String leaveRecordIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LeaveRecord.TYPE_PROPERTY, leaveRecordType.getId());
		key.put(LeaveRecord.ID_PROPERTY, leaveRecordIds);
		
		SmartList<LeaveRecord> externalLeaveRecordList = getLeaveRecordDAO().
				findLeaveRecordWithKey(key, options);
		if(externalLeaveRecordList == null){
			return leaveRecordType;
		}
		if(externalLeaveRecordList.isEmpty()){
			return leaveRecordType;
		}
		
		for(LeaveRecord leaveRecordItem: externalLeaveRecordList){

			leaveRecordItem.clearFromAll();
		}
		
		
		SmartList<LeaveRecord> leaveRecordList = leaveRecordType.getLeaveRecordList();		
		leaveRecordList.addAllToRemoveList(externalLeaveRecordList);
		return leaveRecordType;	
	
	}


	//disconnect LeaveRecordType with user in LeaveRecord
	public LeaveRecordType planToRemoveLeaveRecordListWithUser(LeaveRecordType leaveRecordType, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LeaveRecord.TYPE_PROPERTY, leaveRecordType.getId());
		key.put(LeaveRecord.USER_PROPERTY, userId);
		
		SmartList<LeaveRecord> externalLeaveRecordList = getLeaveRecordDAO().
				findLeaveRecordWithKey(key, options);
		if(externalLeaveRecordList == null){
			return leaveRecordType;
		}
		if(externalLeaveRecordList.isEmpty()){
			return leaveRecordType;
		}
		
		for(LeaveRecord leaveRecordItem: externalLeaveRecordList){
			leaveRecordItem.clearUser();
			leaveRecordItem.clearType();
			
		}
		
		
		SmartList<LeaveRecord> leaveRecordList = leaveRecordType.getLeaveRecordList();		
		leaveRecordList.addAllToRemoveList(externalLeaveRecordList);
		return leaveRecordType;
	}
	
	public int countLeaveRecordListWithUser(String leaveRecordTypeId, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LeaveRecord.TYPE_PROPERTY, leaveRecordTypeId);
		key.put(LeaveRecord.USER_PROPERTY, userId);
		
		int count = getLeaveRecordDAO().countLeaveRecordWithKey(key, options);
		return count;
	}
	
	//disconnect LeaveRecordType with platform in LeaveRecord
	public LeaveRecordType planToRemoveLeaveRecordListWithPlatform(LeaveRecordType leaveRecordType, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LeaveRecord.TYPE_PROPERTY, leaveRecordType.getId());
		key.put(LeaveRecord.PLATFORM_PROPERTY, platformId);
		
		SmartList<LeaveRecord> externalLeaveRecordList = getLeaveRecordDAO().
				findLeaveRecordWithKey(key, options);
		if(externalLeaveRecordList == null){
			return leaveRecordType;
		}
		if(externalLeaveRecordList.isEmpty()){
			return leaveRecordType;
		}
		
		for(LeaveRecord leaveRecordItem: externalLeaveRecordList){
			leaveRecordItem.clearPlatform();
			leaveRecordItem.clearType();
			
		}
		
		
		SmartList<LeaveRecord> leaveRecordList = leaveRecordType.getLeaveRecordList();		
		leaveRecordList.addAllToRemoveList(externalLeaveRecordList);
		return leaveRecordType;
	}
	
	public int countLeaveRecordListWithPlatform(String leaveRecordTypeId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LeaveRecord.TYPE_PROPERTY, leaveRecordTypeId);
		key.put(LeaveRecord.PLATFORM_PROPERTY, platformId);
		
		int count = getLeaveRecordDAO().countLeaveRecordWithKey(key, options);
		return count;
	}
	
	public LeaveRecordType planToRemoveHolydaySettingList(LeaveRecordType leaveRecordType, String holydaySettingIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(HolydaySetting.TYPE_PROPERTY, leaveRecordType.getId());
		key.put(HolydaySetting.ID_PROPERTY, holydaySettingIds);
		
		SmartList<HolydaySetting> externalHolydaySettingList = getHolydaySettingDAO().
				findHolydaySettingWithKey(key, options);
		if(externalHolydaySettingList == null){
			return leaveRecordType;
		}
		if(externalHolydaySettingList.isEmpty()){
			return leaveRecordType;
		}
		
		for(HolydaySetting holydaySettingItem: externalHolydaySettingList){

			holydaySettingItem.clearFromAll();
		}
		
		
		SmartList<HolydaySetting> holydaySettingList = leaveRecordType.getHolydaySettingList();		
		holydaySettingList.addAllToRemoveList(externalHolydaySettingList);
		return leaveRecordType;	
	
	}



		
	protected LeaveRecordType saveLeaveRecordList(LeaveRecordType leaveRecordType, Map<String,Object> options){
		
		
		
		
		SmartList<LeaveRecord> leaveRecordList = leaveRecordType.getLeaveRecordList();
		if(leaveRecordList == null){
			//null list means nothing
			return leaveRecordType;
		}
		SmartList<LeaveRecord> mergedUpdateLeaveRecordList = new SmartList<LeaveRecord>();
		
		
		mergedUpdateLeaveRecordList.addAll(leaveRecordList); 
		if(leaveRecordList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateLeaveRecordList.addAll(leaveRecordList.getToRemoveList());
			leaveRecordList.removeAll(leaveRecordList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getLeaveRecordDAO().saveLeaveRecordList(mergedUpdateLeaveRecordList,options);
		
		if(leaveRecordList.getToRemoveList() != null){
			leaveRecordList.removeAll(leaveRecordList.getToRemoveList());
		}
		
		
		return leaveRecordType;
	
	}
	
	protected LeaveRecordType removeLeaveRecordList(LeaveRecordType leaveRecordType, Map<String,Object> options){
	
	
		SmartList<LeaveRecord> leaveRecordList = leaveRecordType.getLeaveRecordList();
		if(leaveRecordList == null){
			return leaveRecordType;
		}	
	
		SmartList<LeaveRecord> toRemoveLeaveRecordList = leaveRecordList.getToRemoveList();
		
		if(toRemoveLeaveRecordList == null){
			return leaveRecordType;
		}
		if(toRemoveLeaveRecordList.isEmpty()){
			return leaveRecordType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLeaveRecordDAO().removeLeaveRecordList(toRemoveLeaveRecordList,options);
		
		return leaveRecordType;
	
	}
	
	

 	
 	
	
	
	
		
	protected LeaveRecordType saveHolydaySettingList(LeaveRecordType leaveRecordType, Map<String,Object> options){
		
		
		
		
		SmartList<HolydaySetting> holydaySettingList = leaveRecordType.getHolydaySettingList();
		if(holydaySettingList == null){
			//null list means nothing
			return leaveRecordType;
		}
		SmartList<HolydaySetting> mergedUpdateHolydaySettingList = new SmartList<HolydaySetting>();
		
		
		mergedUpdateHolydaySettingList.addAll(holydaySettingList); 
		if(holydaySettingList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateHolydaySettingList.addAll(holydaySettingList.getToRemoveList());
			holydaySettingList.removeAll(holydaySettingList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getHolydaySettingDAO().saveHolydaySettingList(mergedUpdateHolydaySettingList,options);
		
		if(holydaySettingList.getToRemoveList() != null){
			holydaySettingList.removeAll(holydaySettingList.getToRemoveList());
		}
		
		
		return leaveRecordType;
	
	}
	
	protected LeaveRecordType removeHolydaySettingList(LeaveRecordType leaveRecordType, Map<String,Object> options){
	
	
		SmartList<HolydaySetting> holydaySettingList = leaveRecordType.getHolydaySettingList();
		if(holydaySettingList == null){
			return leaveRecordType;
		}	
	
		SmartList<HolydaySetting> toRemoveHolydaySettingList = holydaySettingList.getToRemoveList();
		
		if(toRemoveHolydaySettingList == null){
			return leaveRecordType;
		}
		if(toRemoveHolydaySettingList.isEmpty()){
			return leaveRecordType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getHolydaySettingDAO().removeHolydaySettingList(toRemoveHolydaySettingList,options);
		
		return leaveRecordType;
	
	}
	
	

 	
 	
	
	
	
		

	public LeaveRecordType present(LeaveRecordType leaveRecordType,Map<String, Object> options){
	
		presentLeaveRecordList(leaveRecordType,options);
		presentHolydaySettingList(leaveRecordType,options);

		return leaveRecordType;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected LeaveRecordType presentLeaveRecordList(
			LeaveRecordType leaveRecordType,
			Map<String, Object> options) {

		SmartList<LeaveRecord> leaveRecordList = leaveRecordType.getLeaveRecordList();		
				SmartList<LeaveRecord> newList= presentSubList(leaveRecordType.getId(),
				leaveRecordList,
				options,
				getLeaveRecordDAO()::countLeaveRecordByType,
				getLeaveRecordDAO()::findLeaveRecordByType
				);

		
		leaveRecordType.setLeaveRecordList(newList);
		

		return leaveRecordType;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected LeaveRecordType presentHolydaySettingList(
			LeaveRecordType leaveRecordType,
			Map<String, Object> options) {

		SmartList<HolydaySetting> holydaySettingList = leaveRecordType.getHolydaySettingList();		
				SmartList<HolydaySetting> newList= presentSubList(leaveRecordType.getId(),
				holydaySettingList,
				options,
				getHolydaySettingDAO()::countHolydaySettingByType,
				getHolydaySettingDAO()::findHolydaySettingByType
				);

		
		leaveRecordType.setHolydaySettingList(newList);
		

		return leaveRecordType;
	}			
		

	
    public SmartList<LeaveRecordType> requestCandidateLeaveRecordTypeForLeaveRecord(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(LeaveRecordTypeTable.COLUMN_NAME, filterKey, pageNo, pageSize, getLeaveRecordTypeMapper());
    }
		
    public SmartList<LeaveRecordType> requestCandidateLeaveRecordTypeForHolydaySetting(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(LeaveRecordTypeTable.COLUMN_NAME, filterKey, pageNo, pageSize, getLeaveRecordTypeMapper());
    }
		

	protected String getTableName(){
		return LeaveRecordTypeTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<LeaveRecordType> leaveRecordTypeList) {		
		this.enhanceListInternal(leaveRecordTypeList, this.getLeaveRecordTypeMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:LeaveRecord的type的LeaveRecordList
	public SmartList<LeaveRecord> loadOurLeaveRecordList(FlowableUserContext userContext, List<LeaveRecordType> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LeaveRecord.TYPE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<LeaveRecord> loadedObjs = userContext.getDAOGroup().getLeaveRecordDAO().findLeaveRecordWithKey(key, options);
		Map<String, List<LeaveRecord>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getType().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<LeaveRecord> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<LeaveRecord> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setLeaveRecordList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:HolydaySetting的type的HolydaySettingList
	public SmartList<HolydaySetting> loadOurHolydaySettingList(FlowableUserContext userContext, List<LeaveRecordType> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(HolydaySetting.TYPE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<HolydaySetting> loadedObjs = userContext.getDAOGroup().getHolydaySettingDAO().findHolydaySettingWithKey(key, options);
		Map<String, List<HolydaySetting>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getType().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<HolydaySetting> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<HolydaySetting> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setHolydaySettingList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<LeaveRecordType> leaveRecordTypeList = ownerEntity.collectRefsWithType(LeaveRecordType.INTERNAL_TYPE);
		this.enhanceList(leaveRecordTypeList);
		
	}
	
	@Override
	public SmartList<LeaveRecordType> findLeaveRecordTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getLeaveRecordTypeMapper());

	}
	@Override
	public int countLeaveRecordTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countLeaveRecordTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<LeaveRecordType> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getLeaveRecordTypeMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	
    
	public Map<String, Integer> countBySql(String sql, Object[] params) {
		if (params == null || params.length == 0) {
			return new HashMap<>();
		}
		List<Map<String, Object>> result = this.getJdbcTemplateObject().queryForList(sql, params);
		if (result == null || result.isEmpty()) {
			return new HashMap<>();
		}
		Map<String, Integer> cntMap = new HashMap<>();
		for (Map<String, Object> data : result) {
			String key = (String) data.get("id");
			Number value = (Number) data.get("count");
			cntMap.put(key, value.intValue());
		}
		this.logSQLAndParameters("countBySql", sql, params, cntMap.size() + " Counts");
		return cntMap;
	}

	public Integer singleCountBySql(String sql, Object[] params) {
		Integer cnt = this.getJdbcTemplateObject().queryForObject(sql, params, Integer.class);
		logSQLAndParameters("singleCountBySql", sql, params, cnt + "");
		return cnt;
	}

	public BigDecimal summaryBySql(String sql, Object[] params) {
		BigDecimal cnt = this.getJdbcTemplateObject().queryForObject(sql, params, BigDecimal.class);
		logSQLAndParameters("summaryBySql", sql, params, cnt + "");
		return cnt == null ? BigDecimal.ZERO : cnt;
	}

	public <T> List<T> queryForList(String sql, Object[] params, Class<T> claxx) {
		List<T> result = this.getJdbcTemplateObject().queryForList(sql, params, claxx);
		logSQLAndParameters("queryForList", sql, params, result.size() + " items");
		return result;
	}

	public Map<String, Object> queryForMap(String sql, Object[] params) throws DataAccessException {
		Map<String, Object> result = null;
		try {
			result = this.getJdbcTemplateObject().queryForMap(sql, params);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public <T> T queryForObject(String sql, Object[] params, Class<T> claxx) throws DataAccessException {
		T result = null;
		try {
			result = this.getJdbcTemplateObject().queryForObject(sql, params, claxx);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public List<Map<String, Object>> queryAsMapList(String sql, Object[] params) {
		List<Map<String, Object>> result = getJdbcTemplateObject().queryForList(sql, params);
		logSQLAndParameters("queryAsMapList", sql, params, result.size() + " items");
		return result;
	}

	public synchronized int updateBySql(String sql, Object[] params) {
		int result = getJdbcTemplateObject().update(sql, params);
		logSQLAndParameters("updateBySql", sql, params, result + " items");
		return result;
	}

	public void execSqlWithRowCallback(String sql, Object[] args, RowCallbackHandler callback) {
		getJdbcTemplateObject().query(sql, args, callback);
	}

	public void executeSql(String sql) {
		logSQLAndParameters("executeSql", sql, new Object[] {}, "");
		getJdbcTemplateObject().execute(sql);
	}


}


