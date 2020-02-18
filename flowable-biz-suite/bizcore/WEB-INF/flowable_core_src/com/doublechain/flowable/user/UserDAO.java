
package com.doublechain.flowable.user;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechain.flowable.BaseDAO;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.SmartList;
import com.doublechain.flowable.MultipleAccessKey;
import com.doublechain.flowable.FlowableUserContext;

import com.doublechain.flowable.district.District;
import com.doublechain.flowable.leaverecord.LeaveRecord;
import com.doublechain.flowable.role.Role;

import com.doublechain.flowable.district.DistrictDAO;
import com.doublechain.flowable.leaverecord.LeaveRecordDAO;
import com.doublechain.flowable.role.RoleDAO;


public interface UserDAO extends BaseDAO{

	public SmartList<User> loadAll();
	public User load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<User> userList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public User present(User user,Map<String,Object> options) throws Exception;
	public User clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public User save(User user,Map<String,Object> options);
	public SmartList<User> saveUserList(SmartList<User> userList,Map<String,Object> options);
	public SmartList<User> removeUserList(SmartList<User> userList,Map<String,Object> options);
	public SmartList<User> findUserWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countUserWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countUserWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String userId, int version) throws Exception;
	public User disconnectFromAll(String userId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public LeaveRecordDAO getLeaveRecordDAO();
		
	
 	public SmartList<User> requestCandidateUserForLeaveRecord(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public User planToRemoveLeaveRecordList(User user, String leaveRecordIds[], Map<String,Object> options)throws Exception;


	//disconnect User with type in LeaveRecord
	public User planToRemoveLeaveRecordListWithType(User user, String typeId, Map<String,Object> options)throws Exception;
	public int countLeaveRecordListWithType(String userId, String typeId, Map<String,Object> options)throws Exception;
	
	//disconnect User with platform in LeaveRecord
	public User planToRemoveLeaveRecordListWithPlatform(User user, String platformId, Map<String,Object> options)throws Exception;
	public int countLeaveRecordListWithPlatform(String userId, String platformId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<User> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<User> findUserByDistrict(String districtId, Map<String,Object> options);
 	public int countUserByDistrict(String districtId, Map<String,Object> options);
 	public Map<String, Integer> countUserByDistrictIds(String[] ids, Map<String,Object> options);
 	public SmartList<User> findUserByDistrict(String districtId, int start, int count, Map<String,Object> options);
 	public void analyzeUserByDistrict(SmartList<User> resultList, String districtId, Map<String,Object> options);

 
  
 	public SmartList<User> findUserByRole(String roleId, Map<String,Object> options);
 	public int countUserByRole(String roleId, Map<String,Object> options);
 	public Map<String, Integer> countUserByRoleIds(String[] ids, Map<String,Object> options);
 	public SmartList<User> findUserByRole(String roleId, int start, int count, Map<String,Object> options);
 	public void analyzeUserByRole(SmartList<User> resultList, String roleId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:LeaveRecord的user的LeaveRecordList
	public SmartList<LeaveRecord> loadOurLeaveRecordList(FlowableUserContext userContext, List<User> us, Map<String,Object> options) throws Exception;
	
}


