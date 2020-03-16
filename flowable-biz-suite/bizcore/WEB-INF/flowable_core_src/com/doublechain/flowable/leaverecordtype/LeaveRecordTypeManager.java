
package com.doublechain.flowable.leaverecordtype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface LeaveRecordTypeManager extends BaseManager{

		
	

	public LeaveRecordType loadLeaveRecordTypeWithCode(FlowableUserContext userContext, String code, Map<String,Object>tokens) throws Exception;

	 

	public LeaveRecordType createLeaveRecordType(FlowableUserContext userContext, String name,String code) throws Exception;	
	public LeaveRecordType updateLeaveRecordType(FlowableUserContext userContext,String leaveRecordTypeId, int leaveRecordTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LeaveRecordType loadLeaveRecordType(FlowableUserContext userContext, String leaveRecordTypeId, String [] tokensExpr) throws Exception;
	public LeaveRecordType internalSaveLeaveRecordType(FlowableUserContext userContext, LeaveRecordType leaveRecordType) throws Exception;
	public LeaveRecordType internalSaveLeaveRecordType(FlowableUserContext userContext, LeaveRecordType leaveRecordType,Map<String,Object>option) throws Exception;
	


	public void delete(FlowableUserContext userContext, String leaveRecordTypeId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, LeaveRecordType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  LeaveRecordManager getLeaveRecordManager(FlowableUserContext userContext, String leaveRecordTypeId, String userId, Date fromdate, Date todate, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  LeaveRecordType addLeaveRecord(FlowableUserContext userContext, String leaveRecordTypeId, String userId, Date fromdate, Date todate, String platformId , String [] tokensExpr)  throws Exception;
	public  LeaveRecordType removeLeaveRecord(FlowableUserContext userContext, String leaveRecordTypeId, String leaveRecordId, int leaveRecordVersion,String [] tokensExpr)  throws Exception;
	public  LeaveRecordType updateLeaveRecord(FlowableUserContext userContext, String leaveRecordTypeId, String leaveRecordId, int leaveRecordVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  HolydaySettingManager getHolydaySettingManager(FlowableUserContext userContext, String leaveRecordTypeId, int leaveDays ,String [] tokensExpr)  throws Exception;
	
	public  LeaveRecordType addHolydaySetting(FlowableUserContext userContext, String leaveRecordTypeId, int leaveDays , String [] tokensExpr)  throws Exception;
	public  LeaveRecordType removeHolydaySetting(FlowableUserContext userContext, String leaveRecordTypeId, String holydaySettingId, int holydaySettingVersion,String [] tokensExpr)  throws Exception;
	public  LeaveRecordType updateHolydaySetting(FlowableUserContext userContext, String leaveRecordTypeId, String holydaySettingId, int holydaySettingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


