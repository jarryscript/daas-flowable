
package com.doublechain.flowable.userapp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface UserAppManager extends BaseManager{

		

	public UserApp createUserApp(FlowableUserContext userContext, String title,String secUserId,String appIcon,boolean fullAccess,String permission,String objectType,String objectId,String location) throws Exception;	
	public UserApp updateUserApp(FlowableUserContext userContext,String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserApp loadUserApp(FlowableUserContext userContext, String userAppId, String [] tokensExpr) throws Exception;
	public UserApp internalSaveUserApp(FlowableUserContext userContext, UserApp userApp) throws Exception;
	public UserApp internalSaveUserApp(FlowableUserContext userContext, UserApp userApp,Map<String,Object>option) throws Exception;
	
	public UserApp transferToAnotherSecUser(FlowableUserContext userContext, String userAppId, String anotherSecUserId)  throws Exception;
 

	public void delete(FlowableUserContext userContext, String userAppId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, UserApp newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  QuickLinkManager getQuickLinkManager(FlowableUserContext userContext, String userAppId, String name, String icon, String imagePath, String linkTarget ,String [] tokensExpr)  throws Exception;
	
	public  UserApp addQuickLink(FlowableUserContext userContext, String userAppId, String name, String icon, String imagePath, String linkTarget , String [] tokensExpr)  throws Exception;
	public  UserApp removeQuickLink(FlowableUserContext userContext, String userAppId, String quickLinkId, int quickLinkVersion,String [] tokensExpr)  throws Exception;
	public  UserApp updateQuickLink(FlowableUserContext userContext, String userAppId, String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ListAccessManager getListAccessManager(FlowableUserContext userContext, String userAppId, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission ,String [] tokensExpr)  throws Exception;
	
	public  UserApp addListAccess(FlowableUserContext userContext, String userAppId, String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission , String [] tokensExpr)  throws Exception;
	public  UserApp removeListAccess(FlowableUserContext userContext, String userAppId, String listAccessId, int listAccessVersion,String [] tokensExpr)  throws Exception;
	public  UserApp updateListAccess(FlowableUserContext userContext, String userAppId, String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ObjectAccessManager getObjectAccessManager(FlowableUserContext userContext, String userAppId, String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9 ,String [] tokensExpr)  throws Exception;
	
	public  UserApp addObjectAccess(FlowableUserContext userContext, String userAppId, String name, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9 , String [] tokensExpr)  throws Exception;
	public  UserApp removeObjectAccess(FlowableUserContext userContext, String userAppId, String objectAccessId, int objectAccessVersion,String [] tokensExpr)  throws Exception;
	public  UserApp updateObjectAccess(FlowableUserContext userContext, String userAppId, String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listBySecUser(FlowableUserContext userContext,String secUserId) throws Exception;
	public Object listPageBySecUser(FlowableUserContext userContext,String secUserId, int start, int count) throws Exception;
  

}


