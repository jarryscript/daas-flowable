
package com.doublechain.flowable.user;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface UserManager extends BaseManager{

		

	public User createUser(FlowableUserContext userContext, String name,String mobile,String avatar,int age,String description,String districtId,String roleId) throws Exception;	
	public User updateUser(FlowableUserContext userContext,String userId, int userVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public User loadUser(FlowableUserContext userContext, String userId, String [] tokensExpr) throws Exception;
	public User internalSaveUser(FlowableUserContext userContext, User user) throws Exception;
	public User internalSaveUser(FlowableUserContext userContext, User user,Map<String,Object>option) throws Exception;
	
	public User transferToAnotherDistrict(FlowableUserContext userContext, String userId, String anotherDistrictId)  throws Exception;
 	public User transferToAnotherRole(FlowableUserContext userContext, String userId, String anotherRoleId)  throws Exception;
 

	public void delete(FlowableUserContext userContext, String userId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, User newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  LeaveRecordManager getLeaveRecordManager(FlowableUserContext userContext, String userId, String typeId, Date fromdate, Date todate, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  User addLeaveRecord(FlowableUserContext userContext, String userId, String typeId, Date fromdate, Date todate, String platformId , String [] tokensExpr)  throws Exception;
	public  User removeLeaveRecord(FlowableUserContext userContext, String userId, String leaveRecordId, int leaveRecordVersion,String [] tokensExpr)  throws Exception;
	public  User updateLeaveRecord(FlowableUserContext userContext, String userId, String leaveRecordId, int leaveRecordVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByDistrict(FlowableUserContext userContext,String districtId) throws Exception;
	public Object listPageByDistrict(FlowableUserContext userContext,String districtId, int start, int count) throws Exception;
  
	public Object listByRole(FlowableUserContext userContext,String roleId) throws Exception;
	public Object listPageByRole(FlowableUserContext userContext,String roleId, int start, int count) throws Exception;
  

}


