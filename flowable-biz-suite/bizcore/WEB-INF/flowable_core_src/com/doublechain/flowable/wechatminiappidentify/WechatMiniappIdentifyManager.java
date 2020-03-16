
package com.doublechain.flowable.wechatminiappidentify;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface WechatMiniappIdentifyManager extends BaseManager{

		

	public WechatMiniappIdentify createWechatMiniappIdentify(FlowableUserContext userContext, String openId,String appId,String secUserId,DateTime lastLoginTime) throws Exception;	
	public WechatMiniappIdentify updateWechatMiniappIdentify(FlowableUserContext userContext,String wechatMiniappIdentifyId, int wechatMiniappIdentifyVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public WechatMiniappIdentify loadWechatMiniappIdentify(FlowableUserContext userContext, String wechatMiniappIdentifyId, String [] tokensExpr) throws Exception;
	public WechatMiniappIdentify internalSaveWechatMiniappIdentify(FlowableUserContext userContext, WechatMiniappIdentify wechatMiniappIdentify) throws Exception;
	public WechatMiniappIdentify internalSaveWechatMiniappIdentify(FlowableUserContext userContext, WechatMiniappIdentify wechatMiniappIdentify,Map<String,Object>option) throws Exception;
	
	public WechatMiniappIdentify transferToAnotherSecUser(FlowableUserContext userContext, String wechatMiniappIdentifyId, String anotherSecUserId)  throws Exception;
 

	public void delete(FlowableUserContext userContext, String wechatMiniappIdentifyId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, WechatMiniappIdentify newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	


	public Object listBySecUser(FlowableUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(FlowableUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}












