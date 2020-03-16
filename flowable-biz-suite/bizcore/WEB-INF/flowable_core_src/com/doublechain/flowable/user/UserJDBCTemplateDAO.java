
package com.doublechain.flowable.user;

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


import com.doublechain.flowable.district.District;
import com.doublechain.flowable.leaverecord.LeaveRecord;
import com.doublechain.flowable.role.Role;

import com.doublechain.flowable.district.DistrictDAO;
import com.doublechain.flowable.leaverecord.LeaveRecordDAO;
import com.doublechain.flowable.role.RoleDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class UserJDBCTemplateDAO extends FlowableBaseDAOImpl implements UserDAO{
 
 	
 	private  DistrictDAO  districtDAO;
 	public void setDistrictDAO(DistrictDAO districtDAO){
	 	this.districtDAO = districtDAO;
 	}
 	public DistrictDAO getDistrictDAO(){
	 	return this.districtDAO;
 	}
 
 	
 	private  RoleDAO  roleDAO;
 	public void setRoleDAO(RoleDAO roleDAO){
	 	this.roleDAO = roleDAO;
 	}
 	public RoleDAO getRoleDAO(){
	 	return this.roleDAO;
 	}


			
		
	
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
 	
			
		

	
	/*
	protected User load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalUser(accessKey, options);
	}
	*/
	
	public SmartList<User> loadAll() {
	    return this.loadAll(getUserMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public User load(String id,Map<String,Object> options) throws Exception{
		return loadInternalUser(UserTable.withId(id), options);
	}
	
	
	
	public User save(User user,Map<String,Object> options){
		
		String methodName="save(User user,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(user, methodName, "user");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalUser(user,options);
	}
	public User clone(String userId, Map<String,Object> options) throws Exception{
	
		return clone(UserTable.withId(userId),options);
	}
	
	protected User clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String userId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		User newUser = loadInternalUser(accessKey, options);
		newUser.setVersion(0);
		
		
 		
 		if(isSaveLeaveRecordListEnabled(options)){
 			for(LeaveRecord item: newUser.getLeaveRecordList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalUser(newUser,options);
		
		return newUser;
	}
	
	
	
	

	protected void throwIfHasException(String userId,int version,int count) throws Exception{
		if (count == 1) {
			throw new UserVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new UserNotFoundException(
					"The " + this.getTableName() + "(" + userId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String userId, int version) throws Exception{
	
		String methodName="delete(String userId, int version)";
		assertMethodArgumentNotNull(userId, methodName, "userId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{userId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(userId,version);
		}
		
	
	}
	
	
	
	
	

	public User disconnectFromAll(String userId, int version) throws Exception{
	
		
		User user = loadInternalUser(UserTable.withId(userId), emptyOptions());
		user.clearFromAll();
		this.saveUser(user);
		return user;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return UserTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "user";
	}
	@Override
	protected String getBeanName() {
		
		return "user";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return UserTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractDistrictEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, UserTokens.DISTRICT);
 	}

 	protected boolean isSaveDistrictEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, UserTokens.DISTRICT);
 	}
 	

 	
  

 	protected boolean isExtractRoleEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, UserTokens.ROLE);
 	}

 	protected boolean isSaveRoleEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, UserTokens.ROLE);
 	}
 	

 	
 
		
	
	protected boolean isExtractLeaveRecordListEnabled(Map<String,Object> options){		
 		return checkOptions(options,UserTokens.LEAVE_RECORD_LIST);
 	}
 	protected boolean isAnalyzeLeaveRecordListEnabled(Map<String,Object> options){		 		
 		return UserTokens.of(options).analyzeLeaveRecordListEnabled();
 	}
	
	protected boolean isSaveLeaveRecordListEnabled(Map<String,Object> options){
		return checkOptions(options, UserTokens.LEAVE_RECORD_LIST);
		
 	}
 	
		

	

	protected UserMapper getUserMapper(){
		return new UserMapper();
	}

	
	
	protected User extractUser(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			User user = loadSingleObject(accessKey, getUserMapper());
			return user;
		}catch(EmptyResultDataAccessException e){
			throw new UserNotFoundException("User("+accessKey+") is not found!");
		}

	}

	
	

	protected User loadInternalUser(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		User user = extractUser(accessKey, loadOptions);
 	
 		if(isExtractDistrictEnabled(loadOptions)){
	 		extractDistrict(user, loadOptions);
 		}
  	
 		if(isExtractRoleEnabled(loadOptions)){
	 		extractRole(user, loadOptions);
 		}
 
		
		if(isExtractLeaveRecordListEnabled(loadOptions)){
	 		extractLeaveRecordList(user, loadOptions);
 		}	
 		if(isAnalyzeLeaveRecordListEnabled(loadOptions)){
	 		analyzeLeaveRecordList(user, loadOptions);
 		}
 		
		
		return user;
		
	}

	 

 	protected User extractDistrict(User user, Map<String,Object> options) throws Exception{

		if(user.getDistrict() == null){
			return user;
		}
		String districtId = user.getDistrict().getId();
		if( districtId == null){
			return user;
		}
		District district = getDistrictDAO().load(districtId,options);
		if(district != null){
			user.setDistrict(district);
		}
		
 		
 		return user;
 	}
 		
  

 	protected User extractRole(User user, Map<String,Object> options) throws Exception{

		if(user.getRole() == null){
			return user;
		}
		String roleId = user.getRole().getId();
		if( roleId == null){
			return user;
		}
		Role role = getRoleDAO().load(roleId,options);
		if(role != null){
			user.setRole(role);
		}
		
 		
 		return user;
 	}
 		
 
		
	protected void enhanceLeaveRecordList(SmartList<LeaveRecord> leaveRecordList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected User extractLeaveRecordList(User user, Map<String,Object> options){
		
		
		if(user == null){
			return null;
		}
		if(user.getId() == null){
			return user;
		}

		
		
		SmartList<LeaveRecord> leaveRecordList = getLeaveRecordDAO().findLeaveRecordByUser(user.getId(),options);
		if(leaveRecordList != null){
			enhanceLeaveRecordList(leaveRecordList,options);
			user.setLeaveRecordList(leaveRecordList);
		}
		
		return user;
	
	}	
	
	protected User analyzeLeaveRecordList(User user, Map<String,Object> options){
		
		
		if(user == null){
			return null;
		}
		if(user.getId() == null){
			return user;
		}

		
		
		SmartList<LeaveRecord> leaveRecordList = user.getLeaveRecordList();
		if(leaveRecordList != null){
			getLeaveRecordDAO().analyzeLeaveRecordByUser(leaveRecordList, user.getId(), options);
			
		}
		
		return user;
	
	}	
	
		
		
  	
 	public SmartList<User> findUserByDistrict(String districtId,Map<String,Object> options){
 	
  		SmartList<User> resultList = queryWith(UserTable.COLUMN_DISTRICT, districtId, options, getUserMapper());
		// analyzeUserByDistrict(resultList, districtId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<User> findUserByDistrict(String districtId, int start, int count,Map<String,Object> options){
 		
 		SmartList<User> resultList =  queryWithRange(UserTable.COLUMN_DISTRICT, districtId, options, getUserMapper(), start, count);
 		//analyzeUserByDistrict(resultList, districtId, options);
 		return resultList;
 		
 	}
 	public void analyzeUserByDistrict(SmartList<User> resultList, String districtId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(User.DISTRICT_PROPERTY, districtId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countUserByDistrict(String districtId,Map<String,Object> options){

 		return countWith(UserTable.COLUMN_DISTRICT, districtId, options);
 	}
 	@Override
	public Map<String, Integer> countUserByDistrictIds(String[] ids, Map<String, Object> options) {
		return countWithIds(UserTable.COLUMN_DISTRICT, ids, options);
	}
 	
  	
 	public SmartList<User> findUserByRole(String roleId,Map<String,Object> options){
 	
  		SmartList<User> resultList = queryWith(UserTable.COLUMN_ROLE, roleId, options, getUserMapper());
		// analyzeUserByRole(resultList, roleId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<User> findUserByRole(String roleId, int start, int count,Map<String,Object> options){
 		
 		SmartList<User> resultList =  queryWithRange(UserTable.COLUMN_ROLE, roleId, options, getUserMapper(), start, count);
 		//analyzeUserByRole(resultList, roleId, options);
 		return resultList;
 		
 	}
 	public void analyzeUserByRole(SmartList<User> resultList, String roleId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(User.ROLE_PROPERTY, roleId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countUserByRole(String roleId,Map<String,Object> options){

 		return countWith(UserTable.COLUMN_ROLE, roleId, options);
 	}
 	@Override
	public Map<String, Integer> countUserByRoleIds(String[] ids, Map<String, Object> options) {
		return countWithIds(UserTable.COLUMN_ROLE, ids, options);
	}
 	
 	
		
		
		

	

	protected User saveUser(User  user){
		
		if(!user.isChanged()){
			return user;
		}
		
		
		String SQL=this.getSaveUserSQL(user);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveUserParameters(user);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		user.incVersion();
		return user;
	
	}
	public SmartList<User> saveUserList(SmartList<User> userList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitUserList(userList);
		
		batchUserCreate((List<User>)lists[CREATE_LIST_INDEX]);
		
		batchUserUpdate((List<User>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(User user:userList){
			if(user.isChanged()){
				user.incVersion();
			}
			
		
		}
		
		
		return userList;
	}

	public SmartList<User> removeUserList(SmartList<User> userList,Map<String,Object> options){
		
		
		super.removeList(userList, options);
		
		return userList;
		
		
	}
	
	protected List<Object[]> prepareUserBatchCreateArgs(List<User> userList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(User user:userList ){
			Object [] parameters = prepareUserCreateParameters(user);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareUserBatchUpdateArgs(List<User> userList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(User user:userList ){
			if(!user.isChanged()){
				continue;
			}
			Object [] parameters = prepareUserUpdateParameters(user);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchUserCreate(List<User> userList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareUserBatchCreateArgs(userList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUserUpdate(List<User> userList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareUserBatchUpdateArgs(userList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitUserList(List<User> userList){
		
		List<User> userCreateList=new ArrayList<User>();
		List<User> userUpdateList=new ArrayList<User>();
		
		for(User user: userList){
			if(isUpdateRequest(user)){
				userUpdateList.add( user);
				continue;
			}
			userCreateList.add(user);
		}
		
		return new Object[]{userCreateList,userUpdateList};
	}
	
	protected boolean isUpdateRequest(User user){
 		return user.getVersion() > 0;
 	}
 	protected String getSaveUserSQL(User user){
 		if(isUpdateRequest(user)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveUserParameters(User user){
 		if(isUpdateRequest(user) ){
 			return prepareUserUpdateParameters(user);
 		}
 		return prepareUserCreateParameters(user);
 	}
 	protected Object[] prepareUserUpdateParameters(User user){
 		Object[] parameters = new Object[10];
 
 		
 		parameters[0] = user.getName();
 		
 		
 		parameters[1] = user.getMobile();
 		
 		
 		parameters[2] = user.getAvatar();
 		
 		
 		parameters[3] = user.getAge();
 		
 		
 		parameters[4] = user.getDescription();
 		 	
 		if(user.getDistrict() != null){
 			parameters[5] = user.getDistrict().getId();
 		}
  	
 		if(user.getRole() != null){
 			parameters[6] = user.getRole().getId();
 		}
 		
 		parameters[7] = user.nextVersion();
 		parameters[8] = user.getId();
 		parameters[9] = user.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareUserCreateParameters(User user){
		Object[] parameters = new Object[8];
		String newUserId=getNextId();
		user.setId(newUserId);
		parameters[0] =  user.getId();
 
 		
 		parameters[1] = user.getName();
 		
 		
 		parameters[2] = user.getMobile();
 		
 		
 		parameters[3] = user.getAvatar();
 		
 		
 		parameters[4] = user.getAge();
 		
 		
 		parameters[5] = user.getDescription();
 		 	
 		if(user.getDistrict() != null){
 			parameters[6] = user.getDistrict().getId();
 		
 		}
 		 	
 		if(user.getRole() != null){
 			parameters[7] = user.getRole().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected User saveInternalUser(User user, Map<String,Object> options){
		
		saveUser(user);
 	
 		if(isSaveDistrictEnabled(options)){
	 		saveDistrict(user, options);
 		}
  	
 		if(isSaveRoleEnabled(options)){
	 		saveRole(user, options);
 		}
 
		
		if(isSaveLeaveRecordListEnabled(options)){
	 		saveLeaveRecordList(user, options);
	 		//removeLeaveRecordList(user, options);
	 		//Not delete the record
	 		
 		}		
		
		return user;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected User saveDistrict(User user, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(user.getDistrict() == null){
 			return user;//do nothing when it is null
 		}
 		
 		getDistrictDAO().save(user.getDistrict(),options);
 		return user;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected User saveRole(User user, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(user.getRole() == null){
 			return user;//do nothing when it is null
 		}
 		
 		getRoleDAO().save(user.getRole(),options);
 		return user;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public User planToRemoveLeaveRecordList(User user, String leaveRecordIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LeaveRecord.USER_PROPERTY, user.getId());
		key.put(LeaveRecord.ID_PROPERTY, leaveRecordIds);
		
		SmartList<LeaveRecord> externalLeaveRecordList = getLeaveRecordDAO().
				findLeaveRecordWithKey(key, options);
		if(externalLeaveRecordList == null){
			return user;
		}
		if(externalLeaveRecordList.isEmpty()){
			return user;
		}
		
		for(LeaveRecord leaveRecordItem: externalLeaveRecordList){

			leaveRecordItem.clearFromAll();
		}
		
		
		SmartList<LeaveRecord> leaveRecordList = user.getLeaveRecordList();		
		leaveRecordList.addAllToRemoveList(externalLeaveRecordList);
		return user;	
	
	}


	//disconnect User with type in LeaveRecord
	public User planToRemoveLeaveRecordListWithType(User user, String typeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LeaveRecord.USER_PROPERTY, user.getId());
		key.put(LeaveRecord.TYPE_PROPERTY, typeId);
		
		SmartList<LeaveRecord> externalLeaveRecordList = getLeaveRecordDAO().
				findLeaveRecordWithKey(key, options);
		if(externalLeaveRecordList == null){
			return user;
		}
		if(externalLeaveRecordList.isEmpty()){
			return user;
		}
		
		for(LeaveRecord leaveRecordItem: externalLeaveRecordList){
			leaveRecordItem.clearType();
			leaveRecordItem.clearUser();
			
		}
		
		
		SmartList<LeaveRecord> leaveRecordList = user.getLeaveRecordList();		
		leaveRecordList.addAllToRemoveList(externalLeaveRecordList);
		return user;
	}
	
	public int countLeaveRecordListWithType(String userId, String typeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LeaveRecord.USER_PROPERTY, userId);
		key.put(LeaveRecord.TYPE_PROPERTY, typeId);
		
		int count = getLeaveRecordDAO().countLeaveRecordWithKey(key, options);
		return count;
	}
	
	//disconnect User with platform in LeaveRecord
	public User planToRemoveLeaveRecordListWithPlatform(User user, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LeaveRecord.USER_PROPERTY, user.getId());
		key.put(LeaveRecord.PLATFORM_PROPERTY, platformId);
		
		SmartList<LeaveRecord> externalLeaveRecordList = getLeaveRecordDAO().
				findLeaveRecordWithKey(key, options);
		if(externalLeaveRecordList == null){
			return user;
		}
		if(externalLeaveRecordList.isEmpty()){
			return user;
		}
		
		for(LeaveRecord leaveRecordItem: externalLeaveRecordList){
			leaveRecordItem.clearPlatform();
			leaveRecordItem.clearUser();
			
		}
		
		
		SmartList<LeaveRecord> leaveRecordList = user.getLeaveRecordList();		
		leaveRecordList.addAllToRemoveList(externalLeaveRecordList);
		return user;
	}
	
	public int countLeaveRecordListWithPlatform(String userId, String platformId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LeaveRecord.USER_PROPERTY, userId);
		key.put(LeaveRecord.PLATFORM_PROPERTY, platformId);
		
		int count = getLeaveRecordDAO().countLeaveRecordWithKey(key, options);
		return count;
	}
	

		
	protected User saveLeaveRecordList(User user, Map<String,Object> options){
		
		
		
		
		SmartList<LeaveRecord> leaveRecordList = user.getLeaveRecordList();
		if(leaveRecordList == null){
			//null list means nothing
			return user;
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
		
		
		return user;
	
	}
	
	protected User removeLeaveRecordList(User user, Map<String,Object> options){
	
	
		SmartList<LeaveRecord> leaveRecordList = user.getLeaveRecordList();
		if(leaveRecordList == null){
			return user;
		}	
	
		SmartList<LeaveRecord> toRemoveLeaveRecordList = leaveRecordList.getToRemoveList();
		
		if(toRemoveLeaveRecordList == null){
			return user;
		}
		if(toRemoveLeaveRecordList.isEmpty()){
			return user;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLeaveRecordDAO().removeLeaveRecordList(toRemoveLeaveRecordList,options);
		
		return user;
	
	}
	
	

 	
 	
	
	
	
		

	public User present(User user,Map<String, Object> options){
	
		presentLeaveRecordList(user,options);

		return user;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected User presentLeaveRecordList(
			User user,
			Map<String, Object> options) {

		SmartList<LeaveRecord> leaveRecordList = user.getLeaveRecordList();		
				SmartList<LeaveRecord> newList= presentSubList(user.getId(),
				leaveRecordList,
				options,
				getLeaveRecordDAO()::countLeaveRecordByUser,
				getLeaveRecordDAO()::findLeaveRecordByUser
				);

		
		user.setLeaveRecordList(newList);
		

		return user;
	}			
		

	
    public SmartList<User> requestCandidateUserForLeaveRecord(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(UserTable.COLUMN_NAME, filterKey, pageNo, pageSize, getUserMapper());
    }
		

	protected String getTableName(){
		return UserTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<User> userList) {		
		this.enhanceListInternal(userList, this.getUserMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:LeaveRecord的user的LeaveRecordList
	public SmartList<LeaveRecord> loadOurLeaveRecordList(FlowableUserContext userContext, List<User> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LeaveRecord.USER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<LeaveRecord> loadedObjs = userContext.getDAOGroup().getLeaveRecordDAO().findLeaveRecordWithKey(key, options);
		Map<String, List<LeaveRecord>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getUser().getId()));
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
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<User> userList = ownerEntity.collectRefsWithType(User.INTERNAL_TYPE);
		this.enhanceList(userList);
		
	}
	
	@Override
	public SmartList<User> findUserWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getUserMapper());

	}
	@Override
	public int countUserWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countUserWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<User> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getUserMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


