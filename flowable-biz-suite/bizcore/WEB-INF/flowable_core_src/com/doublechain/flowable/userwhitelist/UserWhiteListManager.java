
package com.doublechain.flowable.userwhitelist;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface UserWhiteListManager extends BaseManager{

		

	public UserWhiteList createUserWhiteList(FlowableUserContext userContext, String userIdentity,String userSpecialFunctions,String domainId) throws Exception;	
	public UserWhiteList updateUserWhiteList(FlowableUserContext userContext,String userWhiteListId, int userWhiteListVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserWhiteList loadUserWhiteList(FlowableUserContext userContext, String userWhiteListId, String [] tokensExpr) throws Exception;
	public UserWhiteList internalSaveUserWhiteList(FlowableUserContext userContext, UserWhiteList userWhiteList) throws Exception;
	public UserWhiteList internalSaveUserWhiteList(FlowableUserContext userContext, UserWhiteList userWhiteList,Map<String,Object>option) throws Exception;
	
	public UserWhiteList transferToAnotherDomain(FlowableUserContext userContext, String userWhiteListId, String anotherDomainId)  throws Exception;
 

	public void delete(FlowableUserContext userContext, String userWhiteListId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, UserWhiteList newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	


	public Object listByDomain(FlowableUserContext userContext,String domainId) throws Exception;
	public Object listPageByDomain(FlowableUserContext userContext,String domainId, int start, int count) throws Exception;
  

}


