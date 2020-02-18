
package com.doublechain.flowable.leaverecordtype;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechain.flowable.BaseDAO;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.SmartList;
import com.doublechain.flowable.MultipleAccessKey;
import com.doublechain.flowable.FlowableUserContext;

import com.doublechain.flowable.holydaysetting.HolydaySetting;
import com.doublechain.flowable.leaverecord.LeaveRecord;

import com.doublechain.flowable.leaverecord.LeaveRecordDAO;
import com.doublechain.flowable.holydaysetting.HolydaySettingDAO;


public interface LeaveRecordTypeDAO extends BaseDAO{

	public SmartList<LeaveRecordType> loadAll();
	public LeaveRecordType load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<LeaveRecordType> leaveRecordTypeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public LeaveRecordType loadByCode(String code,Map<String,Object> options) throws Exception;
	
	
	public LeaveRecordType present(LeaveRecordType leaveRecordType,Map<String,Object> options) throws Exception;
	public LeaveRecordType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public LeaveRecordType cloneByCode(String code,Map<String,Object> options) throws Exception;
	
	
	public LeaveRecordType save(LeaveRecordType leaveRecordType,Map<String,Object> options);
	public SmartList<LeaveRecordType> saveLeaveRecordTypeList(SmartList<LeaveRecordType> leaveRecordTypeList,Map<String,Object> options);
	public SmartList<LeaveRecordType> removeLeaveRecordTypeList(SmartList<LeaveRecordType> leaveRecordTypeList,Map<String,Object> options);
	public SmartList<LeaveRecordType> findLeaveRecordTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countLeaveRecordTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countLeaveRecordTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String leaveRecordTypeId, int version) throws Exception;
	public LeaveRecordType disconnectFromAll(String leaveRecordTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public LeaveRecordDAO getLeaveRecordDAO();
		
	public HolydaySettingDAO getHolydaySettingDAO();
		
	
 	public SmartList<LeaveRecordType> requestCandidateLeaveRecordTypeForLeaveRecord(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<LeaveRecordType> requestCandidateLeaveRecordTypeForHolydaySetting(FlowableUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public LeaveRecordType planToRemoveLeaveRecordList(LeaveRecordType leaveRecordType, String leaveRecordIds[], Map<String,Object> options)throws Exception;


	//disconnect LeaveRecordType with user in LeaveRecord
	public LeaveRecordType planToRemoveLeaveRecordListWithUser(LeaveRecordType leaveRecordType, String userId, Map<String,Object> options)throws Exception;
	public int countLeaveRecordListWithUser(String leaveRecordTypeId, String userId, Map<String,Object> options)throws Exception;
	
	//disconnect LeaveRecordType with platform in LeaveRecord
	public LeaveRecordType planToRemoveLeaveRecordListWithPlatform(LeaveRecordType leaveRecordType, String platformId, Map<String,Object> options)throws Exception;
	public int countLeaveRecordListWithPlatform(String leaveRecordTypeId, String platformId, Map<String,Object> options)throws Exception;
	
	public LeaveRecordType planToRemoveHolydaySettingList(LeaveRecordType leaveRecordType, String holydaySettingIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<LeaveRecordType> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);

	// 需要一个加载引用我的对象的enhance方法:LeaveRecord的type的LeaveRecordList
	public SmartList<LeaveRecord> loadOurLeaveRecordList(FlowableUserContext userContext, List<LeaveRecordType> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:HolydaySetting的type的HolydaySettingList
	public SmartList<HolydaySetting> loadOurHolydaySettingList(FlowableUserContext userContext, List<LeaveRecordType> us, Map<String,Object> options) throws Exception;
	
}


