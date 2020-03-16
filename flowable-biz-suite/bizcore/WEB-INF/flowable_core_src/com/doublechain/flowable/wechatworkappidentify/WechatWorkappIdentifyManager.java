
package com.doublechain.flowable.wechatworkappidentify;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface WechatWorkappIdentifyManager extends BaseManager{

		

	public WechatWorkappIdentify createWechatWorkappIdentify(FlowableUserContext userContext, String corpId,String userId,String secUserId,DateTime lastLoginTime) throws Exception;	
	public WechatWorkappIdentify updateWechatWorkappIdentify(FlowableUserContext userContext,String wechatWorkappIdentifyId, int wechatWorkappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public WechatWorkappIdentify loadWechatWorkappIdentify(FlowableUserContext userContext, String wechatWorkappIdentifyId, String [] tokensExpr) throws Exception;
	public WechatWorkappIdentify internalSaveWechatWorkappIdentify(FlowableUserContext userContext, WechatWorkappIdentify wechatWorkappIdentify) throws Exception;
	public WechatWorkappIdentify internalSaveWechatWorkappIdentify(FlowableUserContext userContext, WechatWorkappIdentify wechatWorkappIdentify,Map<String,Object>option) throws Exception;
	
	public WechatWorkappIdentify transferToAnotherSecUser(FlowableUserContext userContext, String wechatWorkappIdentifyId, String anotherSecUserId)  throws Exception;
 

	public void delete(FlowableUserContext userContext, String wechatWorkappIdentifyId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, WechatWorkappIdentify newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	


	public Object listBySecUser(FlowableUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(FlowableUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


