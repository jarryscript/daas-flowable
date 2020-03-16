
package com.doublechain.flowable.secuser;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface SecUserManager extends BaseManager{

		
	

	public SecUser loadSecUserWithLogin(FlowableUserContext userContext, String login, Map<String,Object>tokens) throws Exception;

	 
	

	public SecUser loadSecUserWithEmail(FlowableUserContext userContext, String email, Map<String,Object>tokens) throws Exception;

	 
	

	public SecUser loadSecUserWithMobile(FlowableUserContext userContext, String mobile, Map<String,Object>tokens) throws Exception;

	 

	public SecUser createSecUser(FlowableUserContext userContext, String login,String mobile,String email,String pwd,String weixinOpenid,String weixinAppid,String accessToken,int verificationCode,DateTime verificationCodeExpire,DateTime lastLoginTime,String domainId) throws Exception;	
	public SecUser updateSecUser(FlowableUserContext userContext,String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SecUser loadSecUser(FlowableUserContext userContext, String secUserId, String [] tokensExpr) throws Exception;
	public SecUser internalSaveSecUser(FlowableUserContext userContext, SecUser secUser) throws Exception;
	public SecUser internalSaveSecUser(FlowableUserContext userContext, SecUser secUser,Map<String,Object>option) throws Exception;
	
	public SecUser transferToAnotherDomain(FlowableUserContext userContext, String secUserId, String anotherDomainId)  throws Exception;
 

	public void delete(FlowableUserContext userContext, String secUserId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, SecUser newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  UserAppManager getUserAppManager(FlowableUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location ,String [] tokensExpr)  throws Exception;
	
	public  SecUser addUserApp(FlowableUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location , String [] tokensExpr)  throws Exception;
	public  SecUser removeUserApp(FlowableUserContext userContext, String secUserId, String userAppId, int userAppVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateUserApp(FlowableUserContext userContext, String secUserId, String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  LoginHistoryManager getLoginHistoryManager(FlowableUserContext userContext, String secUserId, String fromIp, String description ,String [] tokensExpr)  throws Exception;
	
	public  SecUser addLoginHistory(FlowableUserContext userContext, String secUserId, String fromIp, String description , String [] tokensExpr)  throws Exception;
	public  SecUser removeLoginHistory(FlowableUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateLoginHistory(FlowableUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  WechatWorkappIdentifyManager getWechatWorkappIdentifyManager(FlowableUserContext userContext, String secUserId, String corpId, String userId, DateTime lastLoginTime ,String [] tokensExpr)  throws Exception;
	
	public  SecUser addWechatWorkappIdentify(FlowableUserContext userContext, String secUserId, String corpId, String userId, DateTime lastLoginTime , String [] tokensExpr)  throws Exception;
	public  SecUser removeWechatWorkappIdentify(FlowableUserContext userContext, String secUserId, String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateWechatWorkappIdentify(FlowableUserContext userContext, String secUserId, String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  WechatMiniappIdentifyManager getWechatMiniappIdentifyManager(FlowableUserContext userContext, String secUserId, String openId, String appId, DateTime lastLoginTime ,String [] tokensExpr)  throws Exception;
	
	public  SecUser addWechatMiniappIdentify(FlowableUserContext userContext, String secUserId, String openId, String appId, DateTime lastLoginTime , String [] tokensExpr)  throws Exception;
	public  SecUser removeWechatMiniappIdentify(FlowableUserContext userContext, String secUserId, String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion,String [] tokensExpr)  throws Exception;
	public  SecUser updateWechatMiniappIdentify(FlowableUserContext userContext, String secUserId, String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByDomain(FlowableUserContext userContext,String domainId) throws Exception;
	public Object listPageByDomain(FlowableUserContext userContext,String domainId, int start, int count) throws Exception;
  

}


