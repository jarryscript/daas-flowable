
package com.doublechain.flowable.leaverecord;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechain.flowable.BaseDAO;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.SmartList;
import com.doublechain.flowable.MultipleAccessKey;
import com.doublechain.flowable.FlowableUserContext;

import com.doublechain.flowable.user.User;
import com.doublechain.flowable.leaverecordtype.LeaveRecordType;
import com.doublechain.flowable.platform.Platform;

import com.doublechain.flowable.user.UserDAO;
import com.doublechain.flowable.platform.PlatformDAO;
import com.doublechain.flowable.leaverecordtype.LeaveRecordTypeDAO;


public interface LeaveRecordDAO extends BaseDAO{

	public SmartList<LeaveRecord> loadAll();
	public LeaveRecord load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<LeaveRecord> leaveRecordList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public LeaveRecord present(LeaveRecord leaveRecord,Map<String,Object> options) throws Exception;
	public LeaveRecord clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public LeaveRecord save(LeaveRecord leaveRecord,Map<String,Object> options);
	public SmartList<LeaveRecord> saveLeaveRecordList(SmartList<LeaveRecord> leaveRecordList,Map<String,Object> options);
	public SmartList<LeaveRecord> removeLeaveRecordList(SmartList<LeaveRecord> leaveRecordList,Map<String,Object> options);
	public SmartList<LeaveRecord> findLeaveRecordWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countLeaveRecordWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countLeaveRecordWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String leaveRecordId, int version) throws Exception;
	public LeaveRecord disconnectFromAll(String leaveRecordId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<LeaveRecord> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<LeaveRecord> findLeaveRecordByUser(String userId, Map<String,Object> options);
 	public int countLeaveRecordByUser(String userId, Map<String,Object> options);
 	public Map<String, Integer> countLeaveRecordByUserIds(String[] ids, Map<String,Object> options);
 	public SmartList<LeaveRecord> findLeaveRecordByUser(String userId, int start, int count, Map<String,Object> options);
 	public void analyzeLeaveRecordByUser(SmartList<LeaveRecord> resultList, String userId, Map<String,Object> options);

 
  
 	public SmartList<LeaveRecord> findLeaveRecordByType(String leaveRecordTypeId, Map<String,Object> options);
 	public int countLeaveRecordByType(String leaveRecordTypeId, Map<String,Object> options);
 	public Map<String, Integer> countLeaveRecordByTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<LeaveRecord> findLeaveRecordByType(String leaveRecordTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeLeaveRecordByType(SmartList<LeaveRecord> resultList, String leaveRecordTypeId, Map<String,Object> options);

 
  
 	public SmartList<LeaveRecord> findLeaveRecordByPlatform(String platformId, Map<String,Object> options);
 	public int countLeaveRecordByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countLeaveRecordByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<LeaveRecord> findLeaveRecordByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeLeaveRecordByPlatform(SmartList<LeaveRecord> resultList, String platformId, Map<String,Object> options);

 
 
}


