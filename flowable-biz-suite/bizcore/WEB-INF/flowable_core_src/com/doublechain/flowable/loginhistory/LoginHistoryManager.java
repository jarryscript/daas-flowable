
package com.doublechain.flowable.loginhistory;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface LoginHistoryManager extends BaseManager{

		

	public LoginHistory createLoginHistory(FlowableUserContext userContext, String fromIp,String description,String secUserId) throws Exception;	
	public LoginHistory updateLoginHistory(FlowableUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public LoginHistory loadLoginHistory(FlowableUserContext userContext, String loginHistoryId, String [] tokensExpr) throws Exception;
	public LoginHistory internalSaveLoginHistory(FlowableUserContext userContext, LoginHistory loginHistory) throws Exception;
	public LoginHistory internalSaveLoginHistory(FlowableUserContext userContext, LoginHistory loginHistory,Map<String,Object>option) throws Exception;
	
	public LoginHistory transferToAnotherSecUser(FlowableUserContext userContext, String loginHistoryId, String anotherSecUserId)  throws Exception;
 

	public void delete(FlowableUserContext userContext, String loginHistoryId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, LoginHistory newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	


	public Object listBySecUser(FlowableUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(FlowableUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


