
package com.doublechain.flowable.platform;

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


import com.doublechain.flowable.province.Province;
import com.doublechain.flowable.district.District;
import com.doublechain.flowable.city.City;
import com.doublechain.flowable.leaverecord.LeaveRecord;

import com.doublechain.flowable.district.DistrictDAO;
import com.doublechain.flowable.leaverecord.LeaveRecordDAO;
import com.doublechain.flowable.province.ProvinceDAO;
import com.doublechain.flowable.city.CityDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class PlatformJDBCTemplateDAO extends FlowableBaseDAOImpl implements PlatformDAO{


			
		
	
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
 	
			
		
	
  	private  ProvinceDAO  provinceDAO;
 	public void setProvinceDAO(ProvinceDAO pProvinceDAO){
 	
 		if(pProvinceDAO == null){
 			throw new IllegalStateException("Do not try to set provinceDAO to null.");
 		}
	 	this.provinceDAO = pProvinceDAO;
 	}
 	public ProvinceDAO getProvinceDAO(){
 		if(this.provinceDAO == null){
 			throw new IllegalStateException("The provinceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.provinceDAO;
 	}	
 	
			
		
	
  	private  CityDAO  cityDAO;
 	public void setCityDAO(CityDAO pCityDAO){
 	
 		if(pCityDAO == null){
 			throw new IllegalStateException("Do not try to set cityDAO to null.");
 		}
	 	this.cityDAO = pCityDAO;
 	}
 	public CityDAO getCityDAO(){
 		if(this.cityDAO == null){
 			throw new IllegalStateException("The cityDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.cityDAO;
 	}	
 	
			
		
	
  	private  DistrictDAO  districtDAO;
 	public void setDistrictDAO(DistrictDAO pDistrictDAO){
 	
 		if(pDistrictDAO == null){
 			throw new IllegalStateException("Do not try to set districtDAO to null.");
 		}
	 	this.districtDAO = pDistrictDAO;
 	}
 	public DistrictDAO getDistrictDAO(){
 		if(this.districtDAO == null){
 			throw new IllegalStateException("The districtDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.districtDAO;
 	}	
 	
			
		

	
	/*
	protected Platform load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPlatform(accessKey, options);
	}
	*/
	
	public SmartList<Platform> loadAll() {
	    return this.loadAll(getPlatformMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Platform load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPlatform(PlatformTable.withId(id), options);
	}
	
	
	
	public Platform save(Platform platform,Map<String,Object> options){
		
		String methodName="save(Platform platform,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(platform, methodName, "platform");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPlatform(platform,options);
	}
	public Platform clone(String platformId, Map<String,Object> options) throws Exception{
	
		return clone(PlatformTable.withId(platformId),options);
	}
	
	protected Platform clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String platformId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Platform newPlatform = loadInternalPlatform(accessKey, options);
		newPlatform.setVersion(0);
		
		
 		
 		if(isSaveLeaveRecordListEnabled(options)){
 			for(LeaveRecord item: newPlatform.getLeaveRecordList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveProvinceListEnabled(options)){
 			for(Province item: newPlatform.getProvinceList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveCityListEnabled(options)){
 			for(City item: newPlatform.getCityList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveDistrictListEnabled(options)){
 			for(District item: newPlatform.getDistrictList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalPlatform(newPlatform,options);
		
		return newPlatform;
	}
	
	
	
	

	protected void throwIfHasException(String platformId,int version,int count) throws Exception{
		if (count == 1) {
			throw new PlatformVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PlatformNotFoundException(
					"The " + this.getTableName() + "(" + platformId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String platformId, int version) throws Exception{
	
		String methodName="delete(String platformId, int version)";
		assertMethodArgumentNotNull(platformId, methodName, "platformId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{platformId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(platformId,version);
		}
		
	
	}
	
	
	
	
	

	public Platform disconnectFromAll(String platformId, int version) throws Exception{
	
		
		Platform platform = loadInternalPlatform(PlatformTable.withId(platformId), emptyOptions());
		platform.clearFromAll();
		this.savePlatform(platform);
		return platform;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return PlatformTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "platform";
	}
	@Override
	protected String getBeanName() {
		
		return "platform";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PlatformTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractLeaveRecordListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.LEAVE_RECORD_LIST);
 	}
 	protected boolean isAnalyzeLeaveRecordListEnabled(Map<String,Object> options){		 		
 		return PlatformTokens.of(options).analyzeLeaveRecordListEnabled();
 	}
	
	protected boolean isSaveLeaveRecordListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.LEAVE_RECORD_LIST);
		
 	}
 	
		
	
	protected boolean isExtractProvinceListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.PROVINCE_LIST);
 	}
 	protected boolean isAnalyzeProvinceListEnabled(Map<String,Object> options){		 		
 		return PlatformTokens.of(options).analyzeProvinceListEnabled();
 	}
	
	protected boolean isSaveProvinceListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.PROVINCE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractCityListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.CITY_LIST);
 	}
 	protected boolean isAnalyzeCityListEnabled(Map<String,Object> options){		 		
 		return PlatformTokens.of(options).analyzeCityListEnabled();
 	}
	
	protected boolean isSaveCityListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.CITY_LIST);
		
 	}
 	
		
	
	protected boolean isExtractDistrictListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.DISTRICT_LIST);
 	}
 	protected boolean isAnalyzeDistrictListEnabled(Map<String,Object> options){		 		
 		return PlatformTokens.of(options).analyzeDistrictListEnabled();
 	}
	
	protected boolean isSaveDistrictListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.DISTRICT_LIST);
		
 	}
 	
		

	

	protected PlatformMapper getPlatformMapper(){
		return new PlatformMapper();
	}

	
	
	protected Platform extractPlatform(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Platform platform = loadSingleObject(accessKey, getPlatformMapper());
			return platform;
		}catch(EmptyResultDataAccessException e){
			throw new PlatformNotFoundException("Platform("+accessKey+") is not found!");
		}

	}

	
	

	protected Platform loadInternalPlatform(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Platform platform = extractPlatform(accessKey, loadOptions);

		
		if(isExtractLeaveRecordListEnabled(loadOptions)){
	 		extractLeaveRecordList(platform, loadOptions);
 		}	
 		if(isAnalyzeLeaveRecordListEnabled(loadOptions)){
	 		analyzeLeaveRecordList(platform, loadOptions);
 		}
 		
		
		if(isExtractProvinceListEnabled(loadOptions)){
	 		extractProvinceList(platform, loadOptions);
 		}	
 		if(isAnalyzeProvinceListEnabled(loadOptions)){
	 		analyzeProvinceList(platform, loadOptions);
 		}
 		
		
		if(isExtractCityListEnabled(loadOptions)){
	 		extractCityList(platform, loadOptions);
 		}	
 		if(isAnalyzeCityListEnabled(loadOptions)){
	 		analyzeCityList(platform, loadOptions);
 		}
 		
		
		if(isExtractDistrictListEnabled(loadOptions)){
	 		extractDistrictList(platform, loadOptions);
 		}	
 		if(isAnalyzeDistrictListEnabled(loadOptions)){
	 		analyzeDistrictList(platform, loadOptions);
 		}
 		
		
		return platform;
		
	}

	
		
	protected void enhanceLeaveRecordList(SmartList<LeaveRecord> leaveRecordList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractLeaveRecordList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<LeaveRecord> leaveRecordList = getLeaveRecordDAO().findLeaveRecordByPlatform(platform.getId(),options);
		if(leaveRecordList != null){
			enhanceLeaveRecordList(leaveRecordList,options);
			platform.setLeaveRecordList(leaveRecordList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeLeaveRecordList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<LeaveRecord> leaveRecordList = platform.getLeaveRecordList();
		if(leaveRecordList != null){
			getLeaveRecordDAO().analyzeLeaveRecordByPlatform(leaveRecordList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceProvinceList(SmartList<Province> provinceList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractProvinceList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Province> provinceList = getProvinceDAO().findProvinceByPlatform(platform.getId(),options);
		if(provinceList != null){
			enhanceProvinceList(provinceList,options);
			platform.setProvinceList(provinceList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeProvinceList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Province> provinceList = platform.getProvinceList();
		if(provinceList != null){
			getProvinceDAO().analyzeProvinceByPlatform(provinceList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceCityList(SmartList<City> cityList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractCityList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<City> cityList = getCityDAO().findCityByPlatform(platform.getId(),options);
		if(cityList != null){
			enhanceCityList(cityList,options);
			platform.setCityList(cityList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeCityList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<City> cityList = platform.getCityList();
		if(cityList != null){
			getCityDAO().analyzeCityByPlatform(cityList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceDistrictList(SmartList<District> districtList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractDistrictList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<District> districtList = getDistrictDAO().findDistrictByPlatform(platform.getId(),options);
		if(districtList != null){
			enhanceDistrictList(districtList,options);
			platform.setDistrictList(districtList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeDistrictList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<District> districtList = platform.getDistrictList();
		if(districtList != null){
			getDistrictDAO().analyzeDistrictByPlatform(districtList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
		
 	
		
		
		

	

	protected Platform savePlatform(Platform  platform){
		
		if(!platform.isChanged()){
			return platform;
		}
		
		
		String SQL=this.getSavePlatformSQL(platform);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePlatformParameters(platform);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		platform.incVersion();
		return platform;
	
	}
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPlatformList(platformList);
		
		batchPlatformCreate((List<Platform>)lists[CREATE_LIST_INDEX]);
		
		batchPlatformUpdate((List<Platform>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Platform platform:platformList){
			if(platform.isChanged()){
				platform.incVersion();
			}
			
		
		}
		
		
		return platformList;
	}

	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options){
		
		
		super.removeList(platformList, options);
		
		return platformList;
		
		
	}
	
	protected List<Object[]> preparePlatformBatchCreateArgs(List<Platform> platformList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Platform platform:platformList ){
			Object [] parameters = preparePlatformCreateParameters(platform);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePlatformBatchUpdateArgs(List<Platform> platformList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Platform platform:platformList ){
			if(!platform.isChanged()){
				continue;
			}
			Object [] parameters = preparePlatformUpdateParameters(platform);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPlatformCreate(List<Platform> platformList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePlatformBatchCreateArgs(platformList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPlatformUpdate(List<Platform> platformList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePlatformBatchUpdateArgs(platformList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPlatformList(List<Platform> platformList){
		
		List<Platform> platformCreateList=new ArrayList<Platform>();
		List<Platform> platformUpdateList=new ArrayList<Platform>();
		
		for(Platform platform: platformList){
			if(isUpdateRequest(platform)){
				platformUpdateList.add( platform);
				continue;
			}
			platformCreateList.add(platform);
		}
		
		return new Object[]{platformCreateList,platformUpdateList};
	}
	
	protected boolean isUpdateRequest(Platform platform){
 		return platform.getVersion() > 0;
 	}
 	protected String getSavePlatformSQL(Platform platform){
 		if(isUpdateRequest(platform)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePlatformParameters(Platform platform){
 		if(isUpdateRequest(platform) ){
 			return preparePlatformUpdateParameters(platform);
 		}
 		return preparePlatformCreateParameters(platform);
 	}
 	protected Object[] preparePlatformUpdateParameters(Platform platform){
 		Object[] parameters = new Object[5];
 
 		
 		parameters[0] = platform.getName();
 		
 		
 		parameters[1] = platform.getFounded();
 				
 		parameters[2] = platform.nextVersion();
 		parameters[3] = platform.getId();
 		parameters[4] = platform.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePlatformCreateParameters(Platform platform){
		Object[] parameters = new Object[3];
		String newPlatformId=getNextId();
		platform.setId(newPlatformId);
		parameters[0] =  platform.getId();
 
 		
 		parameters[1] = platform.getName();
 		
 		
 		parameters[2] = platform.getFounded();
 				
 				
 		return parameters;
 	}
 	
	protected Platform saveInternalPlatform(Platform platform, Map<String,Object> options){
		
		savePlatform(platform);

		
		if(isSaveLeaveRecordListEnabled(options)){
	 		saveLeaveRecordList(platform, options);
	 		//removeLeaveRecordList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveProvinceListEnabled(options)){
	 		saveProvinceList(platform, options);
	 		//removeProvinceList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveCityListEnabled(options)){
	 		saveCityList(platform, options);
	 		//removeCityList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveDistrictListEnabled(options)){
	 		saveDistrictList(platform, options);
	 		//removeDistrictList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		return platform;
		
	}
	
	
	
	//======================================================================================
	

	
	public Platform planToRemoveLeaveRecordList(Platform platform, String leaveRecordIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LeaveRecord.PLATFORM_PROPERTY, platform.getId());
		key.put(LeaveRecord.ID_PROPERTY, leaveRecordIds);
		
		SmartList<LeaveRecord> externalLeaveRecordList = getLeaveRecordDAO().
				findLeaveRecordWithKey(key, options);
		if(externalLeaveRecordList == null){
			return platform;
		}
		if(externalLeaveRecordList.isEmpty()){
			return platform;
		}
		
		for(LeaveRecord leaveRecordItem: externalLeaveRecordList){

			leaveRecordItem.clearFromAll();
		}
		
		
		SmartList<LeaveRecord> leaveRecordList = platform.getLeaveRecordList();		
		leaveRecordList.addAllToRemoveList(externalLeaveRecordList);
		return platform;	
	
	}


	//disconnect Platform with user in LeaveRecord
	public Platform planToRemoveLeaveRecordListWithUser(Platform platform, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LeaveRecord.PLATFORM_PROPERTY, platform.getId());
		key.put(LeaveRecord.USER_PROPERTY, userId);
		
		SmartList<LeaveRecord> externalLeaveRecordList = getLeaveRecordDAO().
				findLeaveRecordWithKey(key, options);
		if(externalLeaveRecordList == null){
			return platform;
		}
		if(externalLeaveRecordList.isEmpty()){
			return platform;
		}
		
		for(LeaveRecord leaveRecordItem: externalLeaveRecordList){
			leaveRecordItem.clearUser();
			leaveRecordItem.clearPlatform();
			
		}
		
		
		SmartList<LeaveRecord> leaveRecordList = platform.getLeaveRecordList();		
		leaveRecordList.addAllToRemoveList(externalLeaveRecordList);
		return platform;
	}
	
	public int countLeaveRecordListWithUser(String platformId, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LeaveRecord.PLATFORM_PROPERTY, platformId);
		key.put(LeaveRecord.USER_PROPERTY, userId);
		
		int count = getLeaveRecordDAO().countLeaveRecordWithKey(key, options);
		return count;
	}
	
	//disconnect Platform with type in LeaveRecord
	public Platform planToRemoveLeaveRecordListWithType(Platform platform, String typeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LeaveRecord.PLATFORM_PROPERTY, platform.getId());
		key.put(LeaveRecord.TYPE_PROPERTY, typeId);
		
		SmartList<LeaveRecord> externalLeaveRecordList = getLeaveRecordDAO().
				findLeaveRecordWithKey(key, options);
		if(externalLeaveRecordList == null){
			return platform;
		}
		if(externalLeaveRecordList.isEmpty()){
			return platform;
		}
		
		for(LeaveRecord leaveRecordItem: externalLeaveRecordList){
			leaveRecordItem.clearType();
			leaveRecordItem.clearPlatform();
			
		}
		
		
		SmartList<LeaveRecord> leaveRecordList = platform.getLeaveRecordList();		
		leaveRecordList.addAllToRemoveList(externalLeaveRecordList);
		return platform;
	}
	
	public int countLeaveRecordListWithType(String platformId, String typeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LeaveRecord.PLATFORM_PROPERTY, platformId);
		key.put(LeaveRecord.TYPE_PROPERTY, typeId);
		
		int count = getLeaveRecordDAO().countLeaveRecordWithKey(key, options);
		return count;
	}
	
	public Platform planToRemoveProvinceList(Platform platform, String provinceIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Province.PLATFORM_PROPERTY, platform.getId());
		key.put(Province.ID_PROPERTY, provinceIds);
		
		SmartList<Province> externalProvinceList = getProvinceDAO().
				findProvinceWithKey(key, options);
		if(externalProvinceList == null){
			return platform;
		}
		if(externalProvinceList.isEmpty()){
			return platform;
		}
		
		for(Province provinceItem: externalProvinceList){

			provinceItem.clearFromAll();
		}
		
		
		SmartList<Province> provinceList = platform.getProvinceList();		
		provinceList.addAllToRemoveList(externalProvinceList);
		return platform;	
	
	}


	public Platform planToRemoveCityList(Platform platform, String cityIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(City.PLATFORM_PROPERTY, platform.getId());
		key.put(City.ID_PROPERTY, cityIds);
		
		SmartList<City> externalCityList = getCityDAO().
				findCityWithKey(key, options);
		if(externalCityList == null){
			return platform;
		}
		if(externalCityList.isEmpty()){
			return platform;
		}
		
		for(City cityItem: externalCityList){

			cityItem.clearFromAll();
		}
		
		
		SmartList<City> cityList = platform.getCityList();		
		cityList.addAllToRemoveList(externalCityList);
		return platform;	
	
	}


	//disconnect Platform with province in City
	public Platform planToRemoveCityListWithProvince(Platform platform, String provinceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(City.PLATFORM_PROPERTY, platform.getId());
		key.put(City.PROVINCE_PROPERTY, provinceId);
		
		SmartList<City> externalCityList = getCityDAO().
				findCityWithKey(key, options);
		if(externalCityList == null){
			return platform;
		}
		if(externalCityList.isEmpty()){
			return platform;
		}
		
		for(City cityItem: externalCityList){
			cityItem.clearProvince();
			cityItem.clearPlatform();
			
		}
		
		
		SmartList<City> cityList = platform.getCityList();		
		cityList.addAllToRemoveList(externalCityList);
		return platform;
	}
	
	public int countCityListWithProvince(String platformId, String provinceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(City.PLATFORM_PROPERTY, platformId);
		key.put(City.PROVINCE_PROPERTY, provinceId);
		
		int count = getCityDAO().countCityWithKey(key, options);
		return count;
	}
	
	public Platform planToRemoveDistrictList(Platform platform, String districtIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(District.PLATFORM_PROPERTY, platform.getId());
		key.put(District.ID_PROPERTY, districtIds);
		
		SmartList<District> externalDistrictList = getDistrictDAO().
				findDistrictWithKey(key, options);
		if(externalDistrictList == null){
			return platform;
		}
		if(externalDistrictList.isEmpty()){
			return platform;
		}
		
		for(District districtItem: externalDistrictList){

			districtItem.clearFromAll();
		}
		
		
		SmartList<District> districtList = platform.getDistrictList();		
		districtList.addAllToRemoveList(externalDistrictList);
		return platform;	
	
	}


	//disconnect Platform with city in District
	public Platform planToRemoveDistrictListWithCity(Platform platform, String cityId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(District.PLATFORM_PROPERTY, platform.getId());
		key.put(District.CITY_PROPERTY, cityId);
		
		SmartList<District> externalDistrictList = getDistrictDAO().
				findDistrictWithKey(key, options);
		if(externalDistrictList == null){
			return platform;
		}
		if(externalDistrictList.isEmpty()){
			return platform;
		}
		
		for(District districtItem: externalDistrictList){
			districtItem.clearCity();
			districtItem.clearPlatform();
			
		}
		
		
		SmartList<District> districtList = platform.getDistrictList();		
		districtList.addAllToRemoveList(externalDistrictList);
		return platform;
	}
	
	public int countDistrictListWithCity(String platformId, String cityId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(District.PLATFORM_PROPERTY, platformId);
		key.put(District.CITY_PROPERTY, cityId);
		
		int count = getDistrictDAO().countDistrictWithKey(key, options);
		return count;
	}
	

		
	protected Platform saveLeaveRecordList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<LeaveRecord> leaveRecordList = platform.getLeaveRecordList();
		if(leaveRecordList == null){
			//null list means nothing
			return platform;
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
		
		
		return platform;
	
	}
	
	protected Platform removeLeaveRecordList(Platform platform, Map<String,Object> options){
	
	
		SmartList<LeaveRecord> leaveRecordList = platform.getLeaveRecordList();
		if(leaveRecordList == null){
			return platform;
		}	
	
		SmartList<LeaveRecord> toRemoveLeaveRecordList = leaveRecordList.getToRemoveList();
		
		if(toRemoveLeaveRecordList == null){
			return platform;
		}
		if(toRemoveLeaveRecordList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLeaveRecordDAO().removeLeaveRecordList(toRemoveLeaveRecordList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveProvinceList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Province> provinceList = platform.getProvinceList();
		if(provinceList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Province> mergedUpdateProvinceList = new SmartList<Province>();
		
		
		mergedUpdateProvinceList.addAll(provinceList); 
		if(provinceList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateProvinceList.addAll(provinceList.getToRemoveList());
			provinceList.removeAll(provinceList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getProvinceDAO().saveProvinceList(mergedUpdateProvinceList,options);
		
		if(provinceList.getToRemoveList() != null){
			provinceList.removeAll(provinceList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeProvinceList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Province> provinceList = platform.getProvinceList();
		if(provinceList == null){
			return platform;
		}	
	
		SmartList<Province> toRemoveProvinceList = provinceList.getToRemoveList();
		
		if(toRemoveProvinceList == null){
			return platform;
		}
		if(toRemoveProvinceList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProvinceDAO().removeProvinceList(toRemoveProvinceList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveCityList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<City> cityList = platform.getCityList();
		if(cityList == null){
			//null list means nothing
			return platform;
		}
		SmartList<City> mergedUpdateCityList = new SmartList<City>();
		
		
		mergedUpdateCityList.addAll(cityList); 
		if(cityList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateCityList.addAll(cityList.getToRemoveList());
			cityList.removeAll(cityList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getCityDAO().saveCityList(mergedUpdateCityList,options);
		
		if(cityList.getToRemoveList() != null){
			cityList.removeAll(cityList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeCityList(Platform platform, Map<String,Object> options){
	
	
		SmartList<City> cityList = platform.getCityList();
		if(cityList == null){
			return platform;
		}	
	
		SmartList<City> toRemoveCityList = cityList.getToRemoveList();
		
		if(toRemoveCityList == null){
			return platform;
		}
		if(toRemoveCityList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getCityDAO().removeCityList(toRemoveCityList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveDistrictList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<District> districtList = platform.getDistrictList();
		if(districtList == null){
			//null list means nothing
			return platform;
		}
		SmartList<District> mergedUpdateDistrictList = new SmartList<District>();
		
		
		mergedUpdateDistrictList.addAll(districtList); 
		if(districtList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateDistrictList.addAll(districtList.getToRemoveList());
			districtList.removeAll(districtList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getDistrictDAO().saveDistrictList(mergedUpdateDistrictList,options);
		
		if(districtList.getToRemoveList() != null){
			districtList.removeAll(districtList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeDistrictList(Platform platform, Map<String,Object> options){
	
	
		SmartList<District> districtList = platform.getDistrictList();
		if(districtList == null){
			return platform;
		}	
	
		SmartList<District> toRemoveDistrictList = districtList.getToRemoveList();
		
		if(toRemoveDistrictList == null){
			return platform;
		}
		if(toRemoveDistrictList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getDistrictDAO().removeDistrictList(toRemoveDistrictList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		

	public Platform present(Platform platform,Map<String, Object> options){
	
		presentLeaveRecordList(platform,options);
		presentProvinceList(platform,options);
		presentCityList(platform,options);
		presentDistrictList(platform,options);

		return platform;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentLeaveRecordList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<LeaveRecord> leaveRecordList = platform.getLeaveRecordList();		
				SmartList<LeaveRecord> newList= presentSubList(platform.getId(),
				leaveRecordList,
				options,
				getLeaveRecordDAO()::countLeaveRecordByPlatform,
				getLeaveRecordDAO()::findLeaveRecordByPlatform
				);

		
		platform.setLeaveRecordList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentProvinceList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Province> provinceList = platform.getProvinceList();		
				SmartList<Province> newList= presentSubList(platform.getId(),
				provinceList,
				options,
				getProvinceDAO()::countProvinceByPlatform,
				getProvinceDAO()::findProvinceByPlatform
				);

		
		platform.setProvinceList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentCityList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<City> cityList = platform.getCityList();		
				SmartList<City> newList= presentSubList(platform.getId(),
				cityList,
				options,
				getCityDAO()::countCityByPlatform,
				getCityDAO()::findCityByPlatform
				);

		
		platform.setCityList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentDistrictList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<District> districtList = platform.getDistrictList();		
				SmartList<District> newList= presentSubList(platform.getId(),
				districtList,
				options,
				getDistrictDAO()::countDistrictByPlatform,
				getDistrictDAO()::findDistrictByPlatform
				);

		
		platform.setDistrictList(newList);
		

		return platform;
	}			
		

	
    public SmartList<Platform> requestCandidatePlatformForLeaveRecord(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForProvince(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForCity(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForDistrict(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		

	protected String getTableName(){
		return PlatformTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Platform> platformList) {		
		this.enhanceListInternal(platformList, this.getPlatformMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:LeaveRecord的platform的LeaveRecordList
	public SmartList<LeaveRecord> loadOurLeaveRecordList(FlowableUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LeaveRecord.PLATFORM_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<LeaveRecord> loadedObjs = userContext.getDAOGroup().getLeaveRecordDAO().findLeaveRecordWithKey(key, options);
		Map<String, List<LeaveRecord>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getPlatform().getId()));
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
	
	// 需要一个加载引用我的对象的enhance方法:Province的platform的ProvinceList
	public SmartList<Province> loadOurProvinceList(FlowableUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Province.PLATFORM_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Province> loadedObjs = userContext.getDAOGroup().getProvinceDAO().findProvinceWithKey(key, options);
		Map<String, List<Province>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getPlatform().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Province> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Province> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setProvinceList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:City的platform的CityList
	public SmartList<City> loadOurCityList(FlowableUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(City.PLATFORM_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<City> loadedObjs = userContext.getDAOGroup().getCityDAO().findCityWithKey(key, options);
		Map<String, List<City>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getPlatform().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<City> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<City> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setCityList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:District的platform的DistrictList
	public SmartList<District> loadOurDistrictList(FlowableUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(District.PLATFORM_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<District> loadedObjs = userContext.getDAOGroup().getDistrictDAO().findDistrictWithKey(key, options);
		Map<String, List<District>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getPlatform().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<District> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<District> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setDistrictList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Platform> platformList = ownerEntity.collectRefsWithType(Platform.INTERNAL_TYPE);
		this.enhanceList(platformList);
		
	}
	
	@Override
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getPlatformMapper());

	}
	@Override
	public int countPlatformWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Platform> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getPlatformMapper());
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


