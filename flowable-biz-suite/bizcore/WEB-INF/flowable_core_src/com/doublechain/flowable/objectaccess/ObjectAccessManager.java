
package com.doublechain.flowable.objectaccess;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface ObjectAccessManager extends BaseManager{

		

	public ObjectAccess createObjectAccess(FlowableUserContext userContext, String name,String objectType,String list1,String list2,String list3,String list4,String list5,String list6,String list7,String list8,String list9,String appId) throws Exception;	
	public ObjectAccess updateObjectAccess(FlowableUserContext userContext,String objectAccessId, int objectAccessVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ObjectAccess loadObjectAccess(FlowableUserContext userContext, String objectAccessId, String [] tokensExpr) throws Exception;
	public ObjectAccess internalSaveObjectAccess(FlowableUserContext userContext, ObjectAccess objectAccess) throws Exception;
	public ObjectAccess internalSaveObjectAccess(FlowableUserContext userContext, ObjectAccess objectAccess,Map<String,Object>option) throws Exception;
	
	public ObjectAccess transferToAnotherApp(FlowableUserContext userContext, String objectAccessId, String anotherAppId)  throws Exception;
 

	public void delete(FlowableUserContext userContext, String objectAccessId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, ObjectAccess newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	


	public Object listByApp(FlowableUserContext userContext,String appId) throws Exception;
	public Object listPageByApp(FlowableUserContext userContext,String appId, int start, int count) throws Exception;
  

}


