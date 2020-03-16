
package com.doublechain.flowable.listaccess;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface ListAccessManager extends BaseManager{

		

	public ListAccess createListAccess(FlowableUserContext userContext, String name,String internalName,boolean readPermission,boolean createPermission,boolean deletePermission,boolean updatePermission,boolean executionPermission,String appId) throws Exception;	
	public ListAccess updateListAccess(FlowableUserContext userContext,String listAccessId, int listAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ListAccess loadListAccess(FlowableUserContext userContext, String listAccessId, String [] tokensExpr) throws Exception;
	public ListAccess internalSaveListAccess(FlowableUserContext userContext, ListAccess listAccess) throws Exception;
	public ListAccess internalSaveListAccess(FlowableUserContext userContext, ListAccess listAccess,Map<String,Object>option) throws Exception;
	
	public ListAccess transferToAnotherApp(FlowableUserContext userContext, String listAccessId, String anotherAppId)  throws Exception;
 

	public void delete(FlowableUserContext userContext, String listAccessId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, ListAccess newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	


	public Object listByApp(FlowableUserContext userContext,String appId) throws Exception;
	public Object listPageByApp(FlowableUserContext userContext,String appId, int start, int count) throws Exception;
  

}


