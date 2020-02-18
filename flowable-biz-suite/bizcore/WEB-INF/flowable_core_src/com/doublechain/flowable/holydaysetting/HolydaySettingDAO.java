
package com.doublechain.flowable.holydaysetting;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechain.flowable.BaseDAO;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.SmartList;
import com.doublechain.flowable.MultipleAccessKey;
import com.doublechain.flowable.FlowableUserContext;

import com.doublechain.flowable.leaverecordtype.LeaveRecordType;

import com.doublechain.flowable.leaverecordtype.LeaveRecordTypeDAO;


public interface HolydaySettingDAO extends BaseDAO{

	public SmartList<HolydaySetting> loadAll();
	public HolydaySetting load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<HolydaySetting> holydaySettingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public HolydaySetting present(HolydaySetting holydaySetting,Map<String,Object> options) throws Exception;
	public HolydaySetting clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public HolydaySetting save(HolydaySetting holydaySetting,Map<String,Object> options);
	public SmartList<HolydaySetting> saveHolydaySettingList(SmartList<HolydaySetting> holydaySettingList,Map<String,Object> options);
	public SmartList<HolydaySetting> removeHolydaySettingList(SmartList<HolydaySetting> holydaySettingList,Map<String,Object> options);
	public SmartList<HolydaySetting> findHolydaySettingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countHolydaySettingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countHolydaySettingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String holydaySettingId, int version) throws Exception;
	public HolydaySetting disconnectFromAll(String holydaySettingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<HolydaySetting> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<HolydaySetting> findHolydaySettingByType(String leaveRecordTypeId, Map<String,Object> options);
 	public int countHolydaySettingByType(String leaveRecordTypeId, Map<String,Object> options);
 	public Map<String, Integer> countHolydaySettingByTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<HolydaySetting> findHolydaySettingByType(String leaveRecordTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeHolydaySettingByType(SmartList<HolydaySetting> resultList, String leaveRecordTypeId, Map<String,Object> options);

 
 
}


