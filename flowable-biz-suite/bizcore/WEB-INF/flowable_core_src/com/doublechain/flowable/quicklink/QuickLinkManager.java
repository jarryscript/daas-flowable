
package com.doublechain.flowable.quicklink;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface QuickLinkManager extends BaseManager{

		

	public QuickLink createQuickLink(FlowableUserContext userContext, String name,String icon,String imagePath,String linkTarget,String appId) throws Exception;	
	public QuickLink updateQuickLink(FlowableUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public QuickLink loadQuickLink(FlowableUserContext userContext, String quickLinkId, String [] tokensExpr) throws Exception;
	public QuickLink internalSaveQuickLink(FlowableUserContext userContext, QuickLink quickLink) throws Exception;
	public QuickLink internalSaveQuickLink(FlowableUserContext userContext, QuickLink quickLink,Map<String,Object>option) throws Exception;
	
	public QuickLink transferToAnotherApp(FlowableUserContext userContext, String quickLinkId, String anotherAppId)  throws Exception;
 

	public void delete(FlowableUserContext userContext, String quickLinkId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, QuickLink newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	


	public Object listByApp(FlowableUserContext userContext,String appId) throws Exception;
	public Object listPageByApp(FlowableUserContext userContext,String appId, int start, int count) throws Exception;
  

}


