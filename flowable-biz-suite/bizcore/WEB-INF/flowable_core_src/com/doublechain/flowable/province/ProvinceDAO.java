
package com.doublechain.flowable.province;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechain.flowable.BaseDAO;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.SmartList;
import com.doublechain.flowable.MultipleAccessKey;
import com.doublechain.flowable.FlowableUserContext;

import com.doublechain.flowable.city.City;
import com.doublechain.flowable.platform.Platform;

import com.doublechain.flowable.platform.PlatformDAO;
import com.doublechain.flowable.city.CityDAO;


public interface ProvinceDAO extends BaseDAO{

	public SmartList<Province> loadAll();
	public Province load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Province> provinceList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Province present(Province province,Map<String,Object> options) throws Exception;
	public Province clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Province save(Province province,Map<String,Object> options);
	public SmartList<Province> saveProvinceList(SmartList<Province> provinceList,Map<String,Object> options);
	public SmartList<Province> removeProvinceList(SmartList<Province> provinceList,Map<String,Object> options);
	public SmartList<Province> findProvinceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countProvinceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countProvinceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String provinceId, int version) throws Exception;
	public Province disconnectFromAll(String provinceId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public CityDAO getCityDAO();
		
	
 	public SmartList<Province> requestCandidateProvinceForCity(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Province planToRemoveCityList(Province province, String cityIds[], Map<String,Object> options)throws Exception;


	//disconnect Province with platform in City
	public Province planToRemoveCityListWithPlatform(Province province, String platformId, Map<String,Object> options)throws Exception;
	public int countCityListWithPlatform(String provinceId, String platformId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Province> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<Province> findProvinceByPlatform(String platformId, Map<String,Object> options);
 	public int countProvinceByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countProvinceByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<Province> findProvinceByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeProvinceByPlatform(SmartList<Province> resultList, String platformId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:City的province的CityList
	public SmartList<City> loadOurCityList(FlowableUserContext userContext, List<Province> us, Map<String,Object> options) throws Exception;
	
}


