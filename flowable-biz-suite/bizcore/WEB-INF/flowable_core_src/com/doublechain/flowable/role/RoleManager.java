
package com.doublechain.flowable.role;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface RoleManager extends BaseManager{

		
	

	public Role loadRoleWithCode(FlowableUserContext userContext, String code, Map<String,Object>tokens) throws Exception;

	 

	public Role createRole(FlowableUserContext userContext, String name,String code) throws Exception;	
	public Role updateRole(FlowableUserContext userContext,String roleId, int roleVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Role loadRole(FlowableUserContext userContext, String roleId, String [] tokensExpr) throws Exception;
	public Role internalSaveRole(FlowableUserContext userContext, Role role) throws Exception;
	public Role internalSaveRole(FlowableUserContext userContext, Role role,Map<String,Object>option) throws Exception;
	


	public void delete(FlowableUserContext userContext, String roleId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, Role newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  UserManager getUserManager(FlowableUserContext userContext, String roleId, String name, String mobile, String avatar, int age, String description, String districtId ,String [] tokensExpr)  throws Exception;
	
	public  Role addUser(FlowableUserContext userContext, String roleId, String name, String mobile, String avatar, int age, String description, String districtId , String [] tokensExpr)  throws Exception;
	public  Role removeUser(FlowableUserContext userContext, String roleId, String userId, int userVersion,String [] tokensExpr)  throws Exception;
	public  Role updateUser(FlowableUserContext userContext, String roleId, String userId, int userVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


