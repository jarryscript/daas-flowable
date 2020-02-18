
package com.doublechain.flowable.role;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechain.flowable.BaseDAO;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.SmartList;
import com.doublechain.flowable.MultipleAccessKey;
import com.doublechain.flowable.FlowableUserContext;

import com.doublechain.flowable.user.User;

import com.doublechain.flowable.user.UserDAO;


public interface RoleDAO extends BaseDAO{

	public SmartList<Role> loadAll();
	public Role load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Role> roleList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Role loadByCode(String code,Map<String,Object> options) throws Exception;
	
	
	public Role present(Role role,Map<String,Object> options) throws Exception;
	public Role clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Role cloneByCode(String code,Map<String,Object> options) throws Exception;
	
	
	public Role save(Role role,Map<String,Object> options);
	public SmartList<Role> saveRoleList(SmartList<Role> roleList,Map<String,Object> options);
	public SmartList<Role> removeRoleList(SmartList<Role> roleList,Map<String,Object> options);
	public SmartList<Role> findRoleWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRoleWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRoleWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String roleId, int version) throws Exception;
	public Role disconnectFromAll(String roleId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public UserDAO getUserDAO();
		
	
 	public SmartList<Role> requestCandidateRoleForUser(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Role planToRemoveUserList(Role role, String userIds[], Map<String,Object> options)throws Exception;


	//disconnect Role with district in User
	public Role planToRemoveUserListWithDistrict(Role role, String districtId, Map<String,Object> options)throws Exception;
	public int countUserListWithDistrict(String roleId, String districtId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Role> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);

	// 需要一个加载引用我的对象的enhance方法:User的role的UserList
	public SmartList<User> loadOurUserList(FlowableUserContext userContext, List<Role> us, Map<String,Object> options) throws Exception;
	
}


