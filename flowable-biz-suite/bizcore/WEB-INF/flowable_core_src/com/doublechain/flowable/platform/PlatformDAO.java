
package com.doublechain.flowable.platform;
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
import com.doublechain.flowable.city.City;
import com.doublechain.flowable.leaverecord.LeaveRecord;

import com.doublechain.flowable.district.DistrictDAO;
import com.doublechain.flowable.leaverecord.LeaveRecordDAO;
import com.doublechain.flowable.province.ProvinceDAO;
import com.doublechain.flowable.city.CityDAO;


public interface PlatformDAO extends BaseDAO{

	public SmartList<Platform> loadAll();
	public Platform load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Platform> platformList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Platform present(Platform platform,Map<String,Object> options) throws Exception;
	public Platform clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Platform save(Platform platform,Map<String,Object> options);
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String platformId, int version) throws Exception;
	public Platform disconnectFromAll(String platformId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public LeaveRecordDAO getLeaveRecordDAO();
		
	public ProvinceDAO getProvinceDAO();
		
	public CityDAO getCityDAO();
		
	public DistrictDAO getDistrictDAO();
		
	
 	public SmartList<Platform> requestCandidatePlatformForLeaveRecord(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForProvince(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForCity(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForDistrict(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Platform planToRemoveLeaveRecordList(Platform platform, String leaveRecordIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with user in LeaveRecord
	public Platform planToRemoveLeaveRecordListWithUser(Platform platform, String userId, Map<String,Object> options)throws Exception;
	public int countLeaveRecordListWithUser(String platformId, String userId, Map<String,Object> options)throws Exception;
	
	//disconnect Platform with type in LeaveRecord
	public Platform planToRemoveLeaveRecordListWithType(Platform platform, String typeId, Map<String,Object> options)throws Exception;
	public int countLeaveRecordListWithType(String platformId, String typeId, Map<String,Object> options)throws Exception;
	
	public Platform planToRemoveProvinceList(Platform platform, String provinceIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveCityList(Platform platform, String cityIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with province in City
	public Platform planToRemoveCityListWithProvince(Platform platform, String provinceId, Map<String,Object> options)throws Exception;
	public int countCityListWithProvince(String platformId, String provinceId, Map<String,Object> options)throws Exception;
	
	public Platform planToRemoveDistrictList(Platform platform, String districtIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with city in District
	public Platform planToRemoveDistrictListWithCity(Platform platform, String cityId, Map<String,Object> options)throws Exception;
	public int countDistrictListWithCity(String platformId, String cityId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Platform> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);

	// 需要一个加载引用我的对象的enhance方法:LeaveRecord的platform的LeaveRecordList
	public SmartList<LeaveRecord> loadOurLeaveRecordList(FlowableUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:Province的platform的ProvinceList
	public SmartList<Province> loadOurProvinceList(FlowableUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:City的platform的CityList
	public SmartList<City> loadOurCityList(FlowableUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:District的platform的DistrictList
	public SmartList<District> loadOurDistrictList(FlowableUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception;
	
}


