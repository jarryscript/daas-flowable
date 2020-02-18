
package com.doublechain.flowable.city;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechain.flowable.BaseDAO;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.SmartList;
import com.doublechain.flowable.MultipleAccessKey;
import com.doublechain.flowable.FlowableUserContext;

import com.doublechain.flowable.province.Province;
import com.doublechain.flowable.district.District;
import com.doublechain.flowable.platform.Platform;

import com.doublechain.flowable.district.DistrictDAO;
import com.doublechain.flowable.province.ProvinceDAO;
import com.doublechain.flowable.platform.PlatformDAO;


public interface CityDAO extends BaseDAO{

	public SmartList<City> loadAll();
	public City load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<City> cityList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public City present(City city,Map<String,Object> options) throws Exception;
	public City clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public City save(City city,Map<String,Object> options);
	public SmartList<City> saveCityList(SmartList<City> cityList,Map<String,Object> options);
	public SmartList<City> removeCityList(SmartList<City> cityList,Map<String,Object> options);
	public SmartList<City> findCityWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countCityWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countCityWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String cityId, int version) throws Exception;
	public City disconnectFromAll(String cityId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public DistrictDAO getDistrictDAO();
		
	
 	public SmartList<City> requestCandidateCityForDistrict(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public City planToRemoveDistrictList(City city, String districtIds[], Map<String,Object> options)throws Exception;


	//disconnect City with platform in District
	public City planToRemoveDistrictListWithPlatform(City city, String platformId, Map<String,Object> options)throws Exception;
	public int countDistrictListWithPlatform(String cityId, String platformId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<City> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<City> findCityByProvince(String provinceId, Map<String,Object> options);
 	public int countCityByProvince(String provinceId, Map<String,Object> options);
 	public Map<String, Integer> countCityByProvinceIds(String[] ids, Map<String,Object> options);
 	public SmartList<City> findCityByProvince(String provinceId, int start, int count, Map<String,Object> options);
 	public void analyzeCityByProvince(SmartList<City> resultList, String provinceId, Map<String,Object> options);

 
  
 	public SmartList<City> findCityByPlatform(String platformId, Map<String,Object> options);
 	public int countCityByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countCityByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<City> findCityByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeCityByPlatform(SmartList<City> resultList, String platformId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:District的city的DistrictList
	public SmartList<District> loadOurDistrictList(FlowableUserContext userContext, List<City> us, Map<String,Object> options) throws Exception;
	
}


