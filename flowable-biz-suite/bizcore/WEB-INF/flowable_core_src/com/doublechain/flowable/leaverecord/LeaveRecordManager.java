
package com.doublechain.flowable.leaverecord;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface LeaveRecordManager extends BaseManager{

		

	public LeaveRecord createLeaveRecord(FlowableUserContext userContext, String userId,String typeId,Date fromdate,Date todate,String platformId) throws Exception;	
	public LeaveRecord updateLeaveRecord(FlowableUserContext userContext,String leaveRecordId, int leaveRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LeaveRecord loadLeaveRecord(FlowableUserContext userContext, String leaveRecordId, String [] tokensExpr) throws Exception;
	public LeaveRecord internalSaveLeaveRecord(FlowableUserContext userContext, LeaveRecord leaveRecord) throws Exception;
	public LeaveRecord internalSaveLeaveRecord(FlowableUserContext userContext, LeaveRecord leaveRecord,Map<String,Object>option) throws Exception;
	
	public LeaveRecord transferToAnotherUser(FlowableUserContext userContext, String leaveRecordId, String anotherUserId)  throws Exception;
 	public LeaveRecord transferToAnotherType(FlowableUserContext userContext, String leaveRecordId, String anotherTypeId)  throws Exception;
 	public LeaveRecord transferToAnotherPlatform(FlowableUserContext userContext, String leaveRecordId, String anotherPlatformId)  throws Exception;
 

	public void delete(FlowableUserContext userContext, String leaveRecordId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, LeaveRecord newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	


	public Object listByUser(FlowableUserContext userContext,String userId) throws Exception;
	public Object listPageByUser(FlowableUserContext userContext,String userId, int start, int count) throws Exception;
  
	public Object listByType(FlowableUserContext userContext,String typeId) throws Exception;
	public Object listPageByType(FlowableUserContext userContext,String typeId, int start, int count) throws Exception;
  
	public Object listByPlatform(FlowableUserContext userContext,String platformId) throws Exception;
	public Object listPageByPlatform(FlowableUserContext userContext,String platformId, int start, int count) throws Exception;
  

}


