
package com.doublechain.flowable.district;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechain.flowable.BaseDAO;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.SmartList;
import com.doublechain.flowable.MultipleAccessKey;
import com.doublechain.flowable.FlowableUserContext;

import com.doublechain.flowable.user.User;
import com.doublechain.flowable.city.City;
import com.doublechain.flowable.platform.Platform;

import com.doublechain.flowable.user.UserDAO;
import com.doublechain.flowable.platform.PlatformDAO;
import com.doublechain.flowable.city.CityDAO;


public interface DistrictDAO extends BaseDAO{

	public SmartList<District> loadAll();
	public District load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<District> districtList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public District present(District district,Map<String,Object> options) throws Exception;
	public District clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public District save(District district,Map<String,Object> options);
	public SmartList<District> saveDistrictList(SmartList<District> districtList,Map<String,Object> options);
	public SmartList<District> removeDistrictList(SmartList<District> districtList,Map<String,Object> options);
	public SmartList<District> findDistrictWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countDistrictWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countDistrictWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String districtId, int version) throws Exception;
	public District disconnectFromAll(String districtId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public UserDAO getUserDAO();
		
	
 	public SmartList<District> requestCandidateDistrictForUser(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public District planToRemoveUserList(District district, String userIds[], Map<String,Object> options)throws Exception;


	//disconnect District with role in User
	public District planToRemoveUserListWithRole(District district, String roleId, Map<String,Object> options)throws Exception;
	public int countUserListWithRole(String districtId, String roleId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<District> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<District> findDistrictByCity(String cityId, Map<String,Object> options);
 	public int countDistrictByCity(String cityId, Map<String,Object> options);
 	public Map<String, Integer> countDistrictByCityIds(String[] ids, Map<String,Object> options);
 	public SmartList<District> findDistrictByCity(String cityId, int start, int count, Map<String,Object> options);
 	public void analyzeDistrictByCity(SmartList<District> resultList, String cityId, Map<String,Object> options);

 
  
 	public SmartList<District> findDistrictByPlatform(String platformId, Map<String,Object> options);
 	public int countDistrictByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countDistrictByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<District> findDistrictByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeDistrictByPlatform(SmartList<District> resultList, String platformId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:User的district的UserList
	public SmartList<User> loadOurUserList(FlowableUserContext userContext, List<District> us, Map<String,Object> options) throws Exception;
	
}


