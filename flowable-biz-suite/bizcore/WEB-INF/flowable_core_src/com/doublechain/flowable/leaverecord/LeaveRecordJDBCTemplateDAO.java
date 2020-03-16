
package com.doublechain.flowable.leaverecord;

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


import com.doublechain.flowable.user.User;
import com.doublechain.flowable.leaverecordtype.LeaveRecordType;
import com.doublechain.flowable.platform.Platform;

import com.doublechain.flowable.user.UserDAO;
import com.doublechain.flowable.platform.PlatformDAO;
import com.doublechain.flowable.leaverecordtype.LeaveRecordTypeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class LeaveRecordJDBCTemplateDAO extends FlowableBaseDAOImpl implements LeaveRecordDAO{
 
 	
 	private  UserDAO  userDAO;
 	public void setUserDAO(UserDAO userDAO){
	 	this.userDAO = userDAO;
 	}
 	public UserDAO getUserDAO(){
	 	return this.userDAO;
 	}
 
 	
 	private  LeaveRecordTypeDAO  leaveRecordTypeDAO;
 	public void setLeaveRecordTypeDAO(LeaveRecordTypeDAO leaveRecordTypeDAO){
	 	this.leaveRecordTypeDAO = leaveRecordTypeDAO;
 	}
 	public LeaveRecordTypeDAO getLeaveRecordTypeDAO(){
	 	return this.leaveRecordTypeDAO;
 	}
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		

	
	/*
	protected LeaveRecord load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLeaveRecord(accessKey, options);
	}
	*/
	
	public SmartList<LeaveRecord> loadAll() {
	    return this.loadAll(getLeaveRecordMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public LeaveRecord load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLeaveRecord(LeaveRecordTable.withId(id), options);
	}
	
	
	
	public LeaveRecord save(LeaveRecord leaveRecord,Map<String,Object> options){
		
		String methodName="save(LeaveRecord leaveRecord,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(leaveRecord, methodName, "leaveRecord");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalLeaveRecord(leaveRecord,options);
	}
	public LeaveRecord clone(String leaveRecordId, Map<String,Object> options) throws Exception{
	
		return clone(LeaveRecordTable.withId(leaveRecordId),options);
	}
	
	protected LeaveRecord clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String leaveRecordId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		LeaveRecord newLeaveRecord = loadInternalLeaveRecord(accessKey, options);
		newLeaveRecord.setVersion(0);
		
		

		
		saveInternalLeaveRecord(newLeaveRecord,options);
		
		return newLeaveRecord;
	}
	
	
	
	

	protected void throwIfHasException(String leaveRecordId,int version,int count) throws Exception{
		if (count == 1) {
			throw new LeaveRecordVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LeaveRecordNotFoundException(
					"The " + this.getTableName() + "(" + leaveRecordId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String leaveRecordId, int version) throws Exception{
	
		String methodName="delete(String leaveRecordId, int version)";
		assertMethodArgumentNotNull(leaveRecordId, methodName, "leaveRecordId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{leaveRecordId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(leaveRecordId,version);
		}
		
	
	}
	
	
	
	
	

	public LeaveRecord disconnectFromAll(String leaveRecordId, int version) throws Exception{
	
		
		LeaveRecord leaveRecord = loadInternalLeaveRecord(LeaveRecordTable.withId(leaveRecordId), emptyOptions());
		leaveRecord.clearFromAll();
		this.saveLeaveRecord(leaveRecord);
		return leaveRecord;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return LeaveRecordTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "leave_record";
	}
	@Override
	protected String getBeanName() {
		
		return "leaveRecord";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return LeaveRecordTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractUserEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LeaveRecordTokens.USER);
 	}

 	protected boolean isSaveUserEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LeaveRecordTokens.USER);
 	}
 	

 	
  

 	protected boolean isExtractTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LeaveRecordTokens.TYPE);
 	}

 	protected boolean isSaveTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LeaveRecordTokens.TYPE);
 	}
 	

 	
  

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LeaveRecordTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LeaveRecordTokens.PLATFORM);
 	}
 	

 	
 
		

	

	protected LeaveRecordMapper getLeaveRecordMapper(){
		return new LeaveRecordMapper();
	}

	
	
	protected LeaveRecord extractLeaveRecord(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			LeaveRecord leaveRecord = loadSingleObject(accessKey, getLeaveRecordMapper());
			return leaveRecord;
		}catch(EmptyResultDataAccessException e){
			throw new LeaveRecordNotFoundException("LeaveRecord("+accessKey+") is not found!");
		}

	}

	
	

	protected LeaveRecord loadInternalLeaveRecord(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		LeaveRecord leaveRecord = extractLeaveRecord(accessKey, loadOptions);
 	
 		if(isExtractUserEnabled(loadOptions)){
	 		extractUser(leaveRecord, loadOptions);
 		}
  	
 		if(isExtractTypeEnabled(loadOptions)){
	 		extractType(leaveRecord, loadOptions);
 		}
  	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(leaveRecord, loadOptions);
 		}
 
		
		return leaveRecord;
		
	}

	 

 	protected LeaveRecord extractUser(LeaveRecord leaveRecord, Map<String,Object> options) throws Exception{

		if(leaveRecord.getUser() == null){
			return leaveRecord;
		}
		String userId = leaveRecord.getUser().getId();
		if( userId == null){
			return leaveRecord;
		}
		User user = getUserDAO().load(userId,options);
		if(user != null){
			leaveRecord.setUser(user);
		}
		
 		
 		return leaveRecord;
 	}
 		
  

 	protected LeaveRecord extractType(LeaveRecord leaveRecord, Map<String,Object> options) throws Exception{

		if(leaveRecord.getType() == null){
			return leaveRecord;
		}
		String typeId = leaveRecord.getType().getId();
		if( typeId == null){
			return leaveRecord;
		}
		LeaveRecordType type = getLeaveRecordTypeDAO().load(typeId,options);
		if(type != null){
			leaveRecord.setType(type);
		}
		
 		
 		return leaveRecord;
 	}
 		
  

 	protected LeaveRecord extractPlatform(LeaveRecord leaveRecord, Map<String,Object> options) throws Exception{

		if(leaveRecord.getPlatform() == null){
			return leaveRecord;
		}
		String platformId = leaveRecord.getPlatform().getId();
		if( platformId == null){
			return leaveRecord;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			leaveRecord.setPlatform(platform);
		}
		
 		
 		return leaveRecord;
 	}
 		
 
		
		
  	
 	public SmartList<LeaveRecord> findLeaveRecordByUser(String userId,Map<String,Object> options){
 	
  		SmartList<LeaveRecord> resultList = queryWith(LeaveRecordTable.COLUMN_USER, userId, options, getLeaveRecordMapper());
		// analyzeLeaveRecordByUser(resultList, userId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<LeaveRecord> findLeaveRecordByUser(String userId, int start, int count,Map<String,Object> options){
 		
 		SmartList<LeaveRecord> resultList =  queryWithRange(LeaveRecordTable.COLUMN_USER, userId, options, getLeaveRecordMapper(), start, count);
 		//analyzeLeaveRecordByUser(resultList, userId, options);
 		return resultList;
 		
 	}
 	public void analyzeLeaveRecordByUser(SmartList<LeaveRecord> resultList, String userId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(LeaveRecord.USER_PROPERTY, userId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countLeaveRecordByUser(String userId,Map<String,Object> options){

 		return countWith(LeaveRecordTable.COLUMN_USER, userId, options);
 	}
 	@Override
	public Map<String, Integer> countLeaveRecordByUserIds(String[] ids, Map<String, Object> options) {
		return countWithIds(LeaveRecordTable.COLUMN_USER, ids, options);
	}
 	
  	
 	public SmartList<LeaveRecord> findLeaveRecordByType(String leaveRecordTypeId,Map<String,Object> options){
 	
  		SmartList<LeaveRecord> resultList = queryWith(LeaveRecordTable.COLUMN_TYPE, leaveRecordTypeId, options, getLeaveRecordMapper());
		// analyzeLeaveRecordByType(resultList, leaveRecordTypeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<LeaveRecord> findLeaveRecordByType(String leaveRecordTypeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<LeaveRecord> resultList =  queryWithRange(LeaveRecordTable.COLUMN_TYPE, leaveRecordTypeId, options, getLeaveRecordMapper(), start, count);
 		//analyzeLeaveRecordByType(resultList, leaveRecordTypeId, options);
 		return resultList;
 		
 	}
 	public void analyzeLeaveRecordByType(SmartList<LeaveRecord> resultList, String leaveRecordTypeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(LeaveRecord.TYPE_PROPERTY, leaveRecordTypeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countLeaveRecordByType(String leaveRecordTypeId,Map<String,Object> options){

 		return countWith(LeaveRecordTable.COLUMN_TYPE, leaveRecordTypeId, options);
 	}
 	@Override
	public Map<String, Integer> countLeaveRecordByTypeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(LeaveRecordTable.COLUMN_TYPE, ids, options);
	}
 	
  	
 	public SmartList<LeaveRecord> findLeaveRecordByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<LeaveRecord> resultList = queryWith(LeaveRecordTable.COLUMN_PLATFORM, platformId, options, getLeaveRecordMapper());
		// analyzeLeaveRecordByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<LeaveRecord> findLeaveRecordByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<LeaveRecord> resultList =  queryWithRange(LeaveRecordTable.COLUMN_PLATFORM, platformId, options, getLeaveRecordMapper(), start, count);
 		//analyzeLeaveRecordByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeLeaveRecordByPlatform(SmartList<LeaveRecord> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(LeaveRecord.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countLeaveRecordByPlatform(String platformId,Map<String,Object> options){

 		return countWith(LeaveRecordTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countLeaveRecordByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(LeaveRecordTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected LeaveRecord saveLeaveRecord(LeaveRecord  leaveRecord){
		
		if(!leaveRecord.isChanged()){
			return leaveRecord;
		}
		
		
		String SQL=this.getSaveLeaveRecordSQL(leaveRecord);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLeaveRecordParameters(leaveRecord);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		leaveRecord.incVersion();
		return leaveRecord;
	
	}
	public SmartList<LeaveRecord> saveLeaveRecordList(SmartList<LeaveRecord> leaveRecordList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLeaveRecordList(leaveRecordList);
		
		batchLeaveRecordCreate((List<LeaveRecord>)lists[CREATE_LIST_INDEX]);
		
		batchLeaveRecordUpdate((List<LeaveRecord>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(LeaveRecord leaveRecord:leaveRecordList){
			if(leaveRecord.isChanged()){
				leaveRecord.incVersion();
			}
			
		
		}
		
		
		return leaveRecordList;
	}

	public SmartList<LeaveRecord> removeLeaveRecordList(SmartList<LeaveRecord> leaveRecordList,Map<String,Object> options){
		
		
		super.removeList(leaveRecordList, options);
		
		return leaveRecordList;
		
		
	}
	
	protected List<Object[]> prepareLeaveRecordBatchCreateArgs(List<LeaveRecord> leaveRecordList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LeaveRecord leaveRecord:leaveRecordList ){
			Object [] parameters = prepareLeaveRecordCreateParameters(leaveRecord);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareLeaveRecordBatchUpdateArgs(List<LeaveRecord> leaveRecordList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LeaveRecord leaveRecord:leaveRecordList ){
			if(!leaveRecord.isChanged()){
				continue;
			}
			Object [] parameters = prepareLeaveRecordUpdateParameters(leaveRecord);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchLeaveRecordCreate(List<LeaveRecord> leaveRecordList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLeaveRecordBatchCreateArgs(leaveRecordList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchLeaveRecordUpdate(List<LeaveRecord> leaveRecordList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLeaveRecordBatchUpdateArgs(leaveRecordList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitLeaveRecordList(List<LeaveRecord> leaveRecordList){
		
		List<LeaveRecord> leaveRecordCreateList=new ArrayList<LeaveRecord>();
		List<LeaveRecord> leaveRecordUpdateList=new ArrayList<LeaveRecord>();
		
		for(LeaveRecord leaveRecord: leaveRecordList){
			if(isUpdateRequest(leaveRecord)){
				leaveRecordUpdateList.add( leaveRecord);
				continue;
			}
			leaveRecordCreateList.add(leaveRecord);
		}
		
		return new Object[]{leaveRecordCreateList,leaveRecordUpdateList};
	}
	
	protected boolean isUpdateRequest(LeaveRecord leaveRecord){
 		return leaveRecord.getVersion() > 0;
 	}
 	protected String getSaveLeaveRecordSQL(LeaveRecord leaveRecord){
 		if(isUpdateRequest(leaveRecord)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveLeaveRecordParameters(LeaveRecord leaveRecord){
 		if(isUpdateRequest(leaveRecord) ){
 			return prepareLeaveRecordUpdateParameters(leaveRecord);
 		}
 		return prepareLeaveRecordCreateParameters(leaveRecord);
 	}
 	protected Object[] prepareLeaveRecordUpdateParameters(LeaveRecord leaveRecord){
 		Object[] parameters = new Object[8];
  	
 		if(leaveRecord.getUser() != null){
 			parameters[0] = leaveRecord.getUser().getId();
 		}
  	
 		if(leaveRecord.getType() != null){
 			parameters[1] = leaveRecord.getType().getId();
 		}
 
 		
 		parameters[2] = leaveRecord.getFromdate();
 		
 		
 		parameters[3] = leaveRecord.getTodate();
 		 	
 		if(leaveRecord.getPlatform() != null){
 			parameters[4] = leaveRecord.getPlatform().getId();
 		}
 		
 		parameters[5] = leaveRecord.nextVersion();
 		parameters[6] = leaveRecord.getId();
 		parameters[7] = leaveRecord.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareLeaveRecordCreateParameters(LeaveRecord leaveRecord){
		Object[] parameters = new Object[6];
		String newLeaveRecordId=getNextId();
		leaveRecord.setId(newLeaveRecordId);
		parameters[0] =  leaveRecord.getId();
  	
 		if(leaveRecord.getUser() != null){
 			parameters[1] = leaveRecord.getUser().getId();
 		
 		}
 		 	
 		if(leaveRecord.getType() != null){
 			parameters[2] = leaveRecord.getType().getId();
 		
 		}
 		
 		
 		parameters[3] = leaveRecord.getFromdate();
 		
 		
 		parameters[4] = leaveRecord.getTodate();
 		 	
 		if(leaveRecord.getPlatform() != null){
 			parameters[5] = leaveRecord.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected LeaveRecord saveInternalLeaveRecord(LeaveRecord leaveRecord, Map<String,Object> options){
		
		saveLeaveRecord(leaveRecord);
 	
 		if(isSaveUserEnabled(options)){
	 		saveUser(leaveRecord, options);
 		}
  	
 		if(isSaveTypeEnabled(options)){
	 		saveType(leaveRecord, options);
 		}
  	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(leaveRecord, options);
 		}
 
		
		return leaveRecord;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected LeaveRecord saveUser(LeaveRecord leaveRecord, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(leaveRecord.getUser() == null){
 			return leaveRecord;//do nothing when it is null
 		}
 		
 		getUserDAO().save(leaveRecord.getUser(),options);
 		return leaveRecord;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected LeaveRecord saveType(LeaveRecord leaveRecord, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(leaveRecord.getType() == null){
 			return leaveRecord;//do nothing when it is null
 		}
 		
 		getLeaveRecordTypeDAO().save(leaveRecord.getType(),options);
 		return leaveRecord;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected LeaveRecord savePlatform(LeaveRecord leaveRecord, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(leaveRecord.getPlatform() == null){
 			return leaveRecord;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(leaveRecord.getPlatform(),options);
 		return leaveRecord;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public LeaveRecord present(LeaveRecord leaveRecord,Map<String, Object> options){
	

		return leaveRecord;
	
	}
		

	

	protected String getTableName(){
		return LeaveRecordTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<LeaveRecord> leaveRecordList) {		
		this.enhanceListInternal(leaveRecordList, this.getLeaveRecordMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<LeaveRecord> leaveRecordList = ownerEntity.collectRefsWithType(LeaveRecord.INTERNAL_TYPE);
		this.enhanceList(leaveRecordList);
		
	}
	
	@Override
	public SmartList<LeaveRecord> findLeaveRecordWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getLeaveRecordMapper());

	}
	@Override
	public int countLeaveRecordWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countLeaveRecordWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<LeaveRecord> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getLeaveRecordMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


