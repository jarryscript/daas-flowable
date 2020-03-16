
package com.doublechain.flowable.userdomain;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface UserDomainManager extends BaseManager{

		

	public UserDomain createUserDomain(FlowableUserContext userContext, String name) throws Exception;	
	public UserDomain updateUserDomain(FlowableUserContext userContext,String userDomainId, int userDomainVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserDomain loadUserDomain(FlowableUserContext userContext, String userDomainId, String [] tokensExpr) throws Exception;
	public UserDomain internalSaveUserDomain(FlowableUserContext userContext, UserDomain userDomain) throws Exception;
	public UserDomain internalSaveUserDomain(FlowableUserContext userContext, UserDomain userDomain,Map<String,Object>option) throws Exception;
	


	public void delete(FlowableUserContext userContext, String userDomainId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, UserDomain newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  UserWhiteListManager getUserWhiteListManager(FlowableUserContext userContext, String userDomainId, String userIdentity, String userSpecialFunctions ,String [] tokensExpr)  throws Exception;
	
	public  UserDomain addUserWhiteList(FlowableUserContext userContext, String userDomainId, String userIdentity, String userSpecialFunctions , String [] tokensExpr)  throws Exception;
	public  UserDomain removeUserWhiteList(FlowableUserContext userContext, String userDomainId, String userWhiteListId, int userWhiteListVersion,String [] tokensExpr)  throws Exception;
	public  UserDomain updateUserWhiteList(FlowableUserContext userContext, String userDomainId, String userWhiteListId, int userWhiteListVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SecUserManager getSecUserManager(FlowableUserContext userContext, String userDomainId, String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid, String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime ,String [] tokensExpr)  throws Exception;
	
	public  UserDomain addSecUser(FlowableUserContext userContext, String userDomainId, String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid, String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime , String [] tokensExpr)  throws Exception;
	public  UserDomain removeSecUser(FlowableUserContext userContext, String userDomainId, String secUserId, int secUserVersion,String [] tokensExpr)  throws Exception;
	public  UserDomain updateSecUser(FlowableUserContext userContext, String userDomainId, String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


