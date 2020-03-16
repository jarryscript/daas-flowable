
package com.doublechain.flowable.role;

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

import com.doublechain.flowable.user.UserDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class RoleJDBCTemplateDAO extends FlowableBaseDAOImpl implements RoleDAO{


			
		
	
  	private  UserDAO  userDAO;
 	public void setUserDAO(UserDAO pUserDAO){
 	
 		if(pUserDAO == null){
 			throw new IllegalStateException("Do not try to set userDAO to null.");
 		}
	 	this.userDAO = pUserDAO;
 	}
 	public UserDAO getUserDAO(){
 		if(this.userDAO == null){
 			throw new IllegalStateException("The userDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.userDAO;
 	}	
 	
			
		

	
	/*
	protected Role load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRole(accessKey, options);
	}
	*/
	
	public SmartList<Role> loadAll() {
	    return this.loadAll(getRoleMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Role load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRole(RoleTable.withId(id), options);
	}
	
	
	
	public Role loadByCode(String code,Map<String,Object> options) throws Exception{
		return loadInternalRole(RoleTable.withCode( code), options);
	}
	
	
	public Role save(Role role,Map<String,Object> options){
		
		String methodName="save(Role role,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(role, methodName, "role");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRole(role,options);
	}
	public Role clone(String roleId, Map<String,Object> options) throws Exception{
	
		return clone(RoleTable.withId(roleId),options);
	}
	
	protected Role clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String roleId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Role newRole = loadInternalRole(accessKey, options);
		newRole.setVersion(0);
		
		
 		
 		if(isSaveUserListEnabled(options)){
 			for(User item: newRole.getUserList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRole(newRole,options);
		
		return newRole;
	}
	
	
	
	public Role cloneByCode(String code,Map<String,Object> options) throws Exception{
		return clone(RoleTable.withCode( code), options);
	}
	
	
	

	protected void throwIfHasException(String roleId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RoleVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RoleNotFoundException(
					"The " + this.getTableName() + "(" + roleId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String roleId, int version) throws Exception{
	
		String methodName="delete(String roleId, int version)";
		assertMethodArgumentNotNull(roleId, methodName, "roleId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{roleId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(roleId,version);
		}
		
	
	}
	
	
	
	
	

	public Role disconnectFromAll(String roleId, int version) throws Exception{
	
		
		Role role = loadInternalRole(RoleTable.withId(roleId), emptyOptions());
		role.clearFromAll();
		this.saveRole(role);
		return role;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RoleTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "role";
	}
	@Override
	protected String getBeanName() {
		
		return "role";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RoleTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractUserListEnabled(Map<String,Object> options){		
 		return checkOptions(options,RoleTokens.USER_LIST);
 	}
 	protected boolean isAnalyzeUserListEnabled(Map<String,Object> options){		 		
 		return RoleTokens.of(options).analyzeUserListEnabled();
 	}
	
	protected boolean isSaveUserListEnabled(Map<String,Object> options){
		return checkOptions(options, RoleTokens.USER_LIST);
		
 	}
 	
		

	

	protected RoleMapper getRoleMapper(){
		return new RoleMapper();
	}

	
	
	protected Role extractRole(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Role role = loadSingleObject(accessKey, getRoleMapper());
			return role;
		}catch(EmptyResultDataAccessException e){
			throw new RoleNotFoundException("Role("+accessKey+") is not found!");
		}

	}

	
	

	protected Role loadInternalRole(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Role role = extractRole(accessKey, loadOptions);

		
		if(isExtractUserListEnabled(loadOptions)){
	 		extractUserList(role, loadOptions);
 		}	
 		if(isAnalyzeUserListEnabled(loadOptions)){
	 		analyzeUserList(role, loadOptions);
 		}
 		
		
		return role;
		
	}

	
		
	protected void enhanceUserList(SmartList<User> userList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Role extractUserList(Role role, Map<String,Object> options){
		
		
		if(role == null){
			return null;
		}
		if(role.getId() == null){
			return role;
		}

		
		
		SmartList<User> userList = getUserDAO().findUserByRole(role.getId(),options);
		if(userList != null){
			enhanceUserList(userList,options);
			role.setUserList(userList);
		}
		
		return role;
	
	}	
	
	protected Role analyzeUserList(Role role, Map<String,Object> options){
		
		
		if(role == null){
			return null;
		}
		if(role.getId() == null){
			return role;
		}

		
		
		SmartList<User> userList = role.getUserList();
		if(userList != null){
			getUserDAO().analyzeUserByRole(userList, role.getId(), options);
			
		}
		
		return role;
	
	}	
	
		
		
 	
		
		
		

	

	protected Role saveRole(Role  role){
		
		if(!role.isChanged()){
			return role;
		}
		
		
		String SQL=this.getSaveRoleSQL(role);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRoleParameters(role);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		role.incVersion();
		return role;
	
	}
	public SmartList<Role> saveRoleList(SmartList<Role> roleList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRoleList(roleList);
		
		batchRoleCreate((List<Role>)lists[CREATE_LIST_INDEX]);
		
		batchRoleUpdate((List<Role>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Role role:roleList){
			if(role.isChanged()){
				role.incVersion();
			}
			
		
		}
		
		
		return roleList;
	}

	public SmartList<Role> removeRoleList(SmartList<Role> roleList,Map<String,Object> options){
		
		
		super.removeList(roleList, options);
		
		return roleList;
		
		
	}
	
	protected List<Object[]> prepareRoleBatchCreateArgs(List<Role> roleList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Role role:roleList ){
			Object [] parameters = prepareRoleCreateParameters(role);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRoleBatchUpdateArgs(List<Role> roleList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Role role:roleList ){
			if(!role.isChanged()){
				continue;
			}
			Object [] parameters = prepareRoleUpdateParameters(role);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRoleCreate(List<Role> roleList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRoleBatchCreateArgs(roleList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRoleUpdate(List<Role> roleList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRoleBatchUpdateArgs(roleList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRoleList(List<Role> roleList){
		
		List<Role> roleCreateList=new ArrayList<Role>();
		List<Role> roleUpdateList=new ArrayList<Role>();
		
		for(Role role: roleList){
			if(isUpdateRequest(role)){
				roleUpdateList.add( role);
				continue;
			}
			roleCreateList.add(role);
		}
		
		return new Object[]{roleCreateList,roleUpdateList};
	}
	
	protected boolean isUpdateRequest(Role role){
 		return role.getVersion() > 0;
 	}
 	protected String getSaveRoleSQL(Role role){
 		if(isUpdateRequest(role)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRoleParameters(Role role){
 		if(isUpdateRequest(role) ){
 			return prepareRoleUpdateParameters(role);
 		}
 		return prepareRoleCreateParameters(role);
 	}
 	protected Object[] prepareRoleUpdateParameters(Role role){
 		Object[] parameters = new Object[5];
 
 		
 		parameters[0] = role.getName();
 		
 		
 		parameters[1] = role.getCode();
 				
 		parameters[2] = role.nextVersion();
 		parameters[3] = role.getId();
 		parameters[4] = role.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRoleCreateParameters(Role role){
		Object[] parameters = new Object[3];
		String newRoleId=getNextId();
		role.setId(newRoleId);
		parameters[0] =  role.getId();
 
 		
 		parameters[1] = role.getName();
 		
 		
 		parameters[2] = role.getCode();
 				
 				
 		return parameters;
 	}
 	
	protected Role saveInternalRole(Role role, Map<String,Object> options){
		
		saveRole(role);

		
		if(isSaveUserListEnabled(options)){
	 		saveUserList(role, options);
	 		//removeUserList(role, options);
	 		//Not delete the record
	 		
 		}		
		
		return role;
		
	}
	
	
	
	//======================================================================================
	

	
	public Role planToRemoveUserList(Role role, String userIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(User.ROLE_PROPERTY, role.getId());
		key.put(User.ID_PROPERTY, userIds);
		
		SmartList<User> externalUserList = getUserDAO().
				findUserWithKey(key, options);
		if(externalUserList == null){
			return role;
		}
		if(externalUserList.isEmpty()){
			return role;
		}
		
		for(User userItem: externalUserList){

			userItem.clearFromAll();
		}
		
		
		SmartList<User> userList = role.getUserList();		
		userList.addAllToRemoveList(externalUserList);
		return role;	
	
	}


	//disconnect Role with district in User
	public Role planToRemoveUserListWithDistrict(Role role, String districtId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(User.ROLE_PROPERTY, role.getId());
		key.put(User.DISTRICT_PROPERTY, districtId);
		
		SmartList<User> externalUserList = getUserDAO().
				findUserWithKey(key, options);
		if(externalUserList == null){
			return role;
		}
		if(externalUserList.isEmpty()){
			return role;
		}
		
		for(User userItem: externalUserList){
			userItem.clearDistrict();
			userItem.clearRole();
			
		}
		
		
		SmartList<User> userList = role.getUserList();		
		userList.addAllToRemoveList(externalUserList);
		return role;
	}
	
	public int countUserListWithDistrict(String roleId, String districtId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(User.ROLE_PROPERTY, roleId);
		key.put(User.DISTRICT_PROPERTY, districtId);
		
		int count = getUserDAO().countUserWithKey(key, options);
		return count;
	}
	

		
	protected Role saveUserList(Role role, Map<String,Object> options){
		
		
		
		
		SmartList<User> userList = role.getUserList();
		if(userList == null){
			//null list means nothing
			return role;
		}
		SmartList<User> mergedUpdateUserList = new SmartList<User>();
		
		
		mergedUpdateUserList.addAll(userList); 
		if(userList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateUserList.addAll(userList.getToRemoveList());
			userList.removeAll(userList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getUserDAO().saveUserList(mergedUpdateUserList,options);
		
		if(userList.getToRemoveList() != null){
			userList.removeAll(userList.getToRemoveList());
		}
		
		
		return role;
	
	}
	
	protected Role removeUserList(Role role, Map<String,Object> options){
	
	
		SmartList<User> userList = role.getUserList();
		if(userList == null){
			return role;
		}	
	
		SmartList<User> toRemoveUserList = userList.getToRemoveList();
		
		if(toRemoveUserList == null){
			return role;
		}
		if(toRemoveUserList.isEmpty()){
			return role;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getUserDAO().removeUserList(toRemoveUserList,options);
		
		return role;
	
	}
	
	

 	
 	
	
	
	
		

	public Role present(Role role,Map<String, Object> options){
	
		presentUserList(role,options);

		return role;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Role presentUserList(
			Role role,
			Map<String, Object> options) {

		SmartList<User> userList = role.getUserList();		
				SmartList<User> newList= presentSubList(role.getId(),
				userList,
				options,
				getUserDAO()::countUserByRole,
				getUserDAO()::findUserByRole
				);

		
		role.setUserList(newList);
		

		return role;
	}			
		

	
    public SmartList<Role> requestCandidateRoleForUser(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RoleTable.COLUMN_NAME, filterKey, pageNo, pageSize, getRoleMapper());
    }
		

	protected String getTableName(){
		return RoleTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Role> roleList) {		
		this.enhanceListInternal(roleList, this.getRoleMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:User的role的UserList
	public SmartList<User> loadOurUserList(FlowableUserContext userContext, List<Role> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(User.ROLE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<User> loadedObjs = userContext.getDAOGroup().getUserDAO().findUserWithKey(key, options);
		Map<String, List<User>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getRole().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<User> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<User> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setUserList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Role> roleList = ownerEntity.collectRefsWithType(Role.INTERNAL_TYPE);
		this.enhanceList(roleList);
		
	}
	
	@Override
	public SmartList<Role> findRoleWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRoleMapper());

	}
	@Override
	public int countRoleWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRoleWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Role> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRoleMapper());
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


