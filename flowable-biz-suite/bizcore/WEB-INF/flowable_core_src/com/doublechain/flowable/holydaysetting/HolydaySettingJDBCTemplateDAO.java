
package com.doublechain.flowable.holydaysetting;

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


import com.doublechain.flowable.leaverecordtype.LeaveRecordType;

import com.doublechain.flowable.leaverecordtype.LeaveRecordTypeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class HolydaySettingJDBCTemplateDAO extends FlowableBaseDAOImpl implements HolydaySettingDAO{
 
 	
 	private  LeaveRecordTypeDAO  leaveRecordTypeDAO;
 	public void setLeaveRecordTypeDAO(LeaveRecordTypeDAO leaveRecordTypeDAO){
	 	this.leaveRecordTypeDAO = leaveRecordTypeDAO;
 	}
 	public LeaveRecordTypeDAO getLeaveRecordTypeDAO(){
	 	return this.leaveRecordTypeDAO;
 	}


			
		

	
	/*
	protected HolydaySetting load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalHolydaySetting(accessKey, options);
	}
	*/
	
	public SmartList<HolydaySetting> loadAll() {
	    return this.loadAll(getHolydaySettingMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public HolydaySetting load(String id,Map<String,Object> options) throws Exception{
		return loadInternalHolydaySetting(HolydaySettingTable.withId(id), options);
	}
	
	
	
	public HolydaySetting save(HolydaySetting holydaySetting,Map<String,Object> options){
		
		String methodName="save(HolydaySetting holydaySetting,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(holydaySetting, methodName, "holydaySetting");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalHolydaySetting(holydaySetting,options);
	}
	public HolydaySetting clone(String holydaySettingId, Map<String,Object> options) throws Exception{
	
		return clone(HolydaySettingTable.withId(holydaySettingId),options);
	}
	
	protected HolydaySetting clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String holydaySettingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		HolydaySetting newHolydaySetting = loadInternalHolydaySetting(accessKey, options);
		newHolydaySetting.setVersion(0);
		
		

		
		saveInternalHolydaySetting(newHolydaySetting,options);
		
		return newHolydaySetting;
	}
	
	
	
	

	protected void throwIfHasException(String holydaySettingId,int version,int count) throws Exception{
		if (count == 1) {
			throw new HolydaySettingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new HolydaySettingNotFoundException(
					"The " + this.getTableName() + "(" + holydaySettingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String holydaySettingId, int version) throws Exception{
	
		String methodName="delete(String holydaySettingId, int version)";
		assertMethodArgumentNotNull(holydaySettingId, methodName, "holydaySettingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{holydaySettingId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(holydaySettingId,version);
		}
		
	
	}
	
	
	
	
	

	public HolydaySetting disconnectFromAll(String holydaySettingId, int version) throws Exception{
	
		
		HolydaySetting holydaySetting = loadInternalHolydaySetting(HolydaySettingTable.withId(holydaySettingId), emptyOptions());
		holydaySetting.clearFromAll();
		this.saveHolydaySetting(holydaySetting);
		return holydaySetting;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return HolydaySettingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "holyday_setting";
	}
	@Override
	protected String getBeanName() {
		
		return "holydaySetting";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return HolydaySettingTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, HolydaySettingTokens.TYPE);
 	}

 	protected boolean isSaveTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, HolydaySettingTokens.TYPE);
 	}
 	

 	
 
		

	

	protected HolydaySettingMapper getHolydaySettingMapper(){
		return new HolydaySettingMapper();
	}

	
	
	protected HolydaySetting extractHolydaySetting(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			HolydaySetting holydaySetting = loadSingleObject(accessKey, getHolydaySettingMapper());
			return holydaySetting;
		}catch(EmptyResultDataAccessException e){
			throw new HolydaySettingNotFoundException("HolydaySetting("+accessKey+") is not found!");
		}

	}

	
	

	protected HolydaySetting loadInternalHolydaySetting(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		HolydaySetting holydaySetting = extractHolydaySetting(accessKey, loadOptions);
 	
 		if(isExtractTypeEnabled(loadOptions)){
	 		extractType(holydaySetting, loadOptions);
 		}
 
		
		return holydaySetting;
		
	}

	 

 	protected HolydaySetting extractType(HolydaySetting holydaySetting, Map<String,Object> options) throws Exception{

		if(holydaySetting.getType() == null){
			return holydaySetting;
		}
		String typeId = holydaySetting.getType().getId();
		if( typeId == null){
			return holydaySetting;
		}
		LeaveRecordType type = getLeaveRecordTypeDAO().load(typeId,options);
		if(type != null){
			holydaySetting.setType(type);
		}
		
 		
 		return holydaySetting;
 	}
 		
 
		
		
  	
 	public SmartList<HolydaySetting> findHolydaySettingByType(String leaveRecordTypeId,Map<String,Object> options){
 	
  		SmartList<HolydaySetting> resultList = queryWith(HolydaySettingTable.COLUMN_TYPE, leaveRecordTypeId, options, getHolydaySettingMapper());
		// analyzeHolydaySettingByType(resultList, leaveRecordTypeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<HolydaySetting> findHolydaySettingByType(String leaveRecordTypeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<HolydaySetting> resultList =  queryWithRange(HolydaySettingTable.COLUMN_TYPE, leaveRecordTypeId, options, getHolydaySettingMapper(), start, count);
 		//analyzeHolydaySettingByType(resultList, leaveRecordTypeId, options);
 		return resultList;
 		
 	}
 	public void analyzeHolydaySettingByType(SmartList<HolydaySetting> resultList, String leaveRecordTypeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countHolydaySettingByType(String leaveRecordTypeId,Map<String,Object> options){

 		return countWith(HolydaySettingTable.COLUMN_TYPE, leaveRecordTypeId, options);
 	}
 	@Override
	public Map<String, Integer> countHolydaySettingByTypeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(HolydaySettingTable.COLUMN_TYPE, ids, options);
	}
 	
 	
		
		
		

	

	protected HolydaySetting saveHolydaySetting(HolydaySetting  holydaySetting){
		
		if(!holydaySetting.isChanged()){
			return holydaySetting;
		}
		
		
		String SQL=this.getSaveHolydaySettingSQL(holydaySetting);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveHolydaySettingParameters(holydaySetting);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		holydaySetting.incVersion();
		return holydaySetting;
	
	}
	public SmartList<HolydaySetting> saveHolydaySettingList(SmartList<HolydaySetting> holydaySettingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitHolydaySettingList(holydaySettingList);
		
		batchHolydaySettingCreate((List<HolydaySetting>)lists[CREATE_LIST_INDEX]);
		
		batchHolydaySettingUpdate((List<HolydaySetting>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(HolydaySetting holydaySetting:holydaySettingList){
			if(holydaySetting.isChanged()){
				holydaySetting.incVersion();
			}
			
		
		}
		
		
		return holydaySettingList;
	}

	public SmartList<HolydaySetting> removeHolydaySettingList(SmartList<HolydaySetting> holydaySettingList,Map<String,Object> options){
		
		
		super.removeList(holydaySettingList, options);
		
		return holydaySettingList;
		
		
	}
	
	protected List<Object[]> prepareHolydaySettingBatchCreateArgs(List<HolydaySetting> holydaySettingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(HolydaySetting holydaySetting:holydaySettingList ){
			Object [] parameters = prepareHolydaySettingCreateParameters(holydaySetting);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareHolydaySettingBatchUpdateArgs(List<HolydaySetting> holydaySettingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(HolydaySetting holydaySetting:holydaySettingList ){
			if(!holydaySetting.isChanged()){
				continue;
			}
			Object [] parameters = prepareHolydaySettingUpdateParameters(holydaySetting);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchHolydaySettingCreate(List<HolydaySetting> holydaySettingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareHolydaySettingBatchCreateArgs(holydaySettingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchHolydaySettingUpdate(List<HolydaySetting> holydaySettingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareHolydaySettingBatchUpdateArgs(holydaySettingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitHolydaySettingList(List<HolydaySetting> holydaySettingList){
		
		List<HolydaySetting> holydaySettingCreateList=new ArrayList<HolydaySetting>();
		List<HolydaySetting> holydaySettingUpdateList=new ArrayList<HolydaySetting>();
		
		for(HolydaySetting holydaySetting: holydaySettingList){
			if(isUpdateRequest(holydaySetting)){
				holydaySettingUpdateList.add( holydaySetting);
				continue;
			}
			holydaySettingCreateList.add(holydaySetting);
		}
		
		return new Object[]{holydaySettingCreateList,holydaySettingUpdateList};
	}
	
	protected boolean isUpdateRequest(HolydaySetting holydaySetting){
 		return holydaySetting.getVersion() > 0;
 	}
 	protected String getSaveHolydaySettingSQL(HolydaySetting holydaySetting){
 		if(isUpdateRequest(holydaySetting)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveHolydaySettingParameters(HolydaySetting holydaySetting){
 		if(isUpdateRequest(holydaySetting) ){
 			return prepareHolydaySettingUpdateParameters(holydaySetting);
 		}
 		return prepareHolydaySettingCreateParameters(holydaySetting);
 	}
 	protected Object[] prepareHolydaySettingUpdateParameters(HolydaySetting holydaySetting){
 		Object[] parameters = new Object[5];
  	
 		if(holydaySetting.getType() != null){
 			parameters[0] = holydaySetting.getType().getId();
 		}
 
 		
 		parameters[1] = holydaySetting.getLeaveDays();
 				
 		parameters[2] = holydaySetting.nextVersion();
 		parameters[3] = holydaySetting.getId();
 		parameters[4] = holydaySetting.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareHolydaySettingCreateParameters(HolydaySetting holydaySetting){
		Object[] parameters = new Object[3];
		String newHolydaySettingId=getNextId();
		holydaySetting.setId(newHolydaySettingId);
		parameters[0] =  holydaySetting.getId();
  	
 		if(holydaySetting.getType() != null){
 			parameters[1] = holydaySetting.getType().getId();
 		
 		}
 		
 		
 		parameters[2] = holydaySetting.getLeaveDays();
 				
 				
 		return parameters;
 	}
 	
	protected HolydaySetting saveInternalHolydaySetting(HolydaySetting holydaySetting, Map<String,Object> options){
		
		saveHolydaySetting(holydaySetting);
 	
 		if(isSaveTypeEnabled(options)){
	 		saveType(holydaySetting, options);
 		}
 
		
		return holydaySetting;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected HolydaySetting saveType(HolydaySetting holydaySetting, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(holydaySetting.getType() == null){
 			return holydaySetting;//do nothing when it is null
 		}
 		
 		getLeaveRecordTypeDAO().save(holydaySetting.getType(),options);
 		return holydaySetting;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public HolydaySetting present(HolydaySetting holydaySetting,Map<String, Object> options){
	

		return holydaySetting;
	
	}
		

	

	protected String getTableName(){
		return HolydaySettingTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<HolydaySetting> holydaySettingList) {		
		this.enhanceListInternal(holydaySettingList, this.getHolydaySettingMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<HolydaySetting> holydaySettingList = ownerEntity.collectRefsWithType(HolydaySetting.INTERNAL_TYPE);
		this.enhanceList(holydaySettingList);
		
	}
	
	@Override
	public SmartList<HolydaySetting> findHolydaySettingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getHolydaySettingMapper());

	}
	@Override
	public int countHolydaySettingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countHolydaySettingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<HolydaySetting> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getHolydaySettingMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


