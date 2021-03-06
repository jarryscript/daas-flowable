
package com.doublechain.flowable.formaction;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface FormActionManager extends BaseManager{

		

	public FormAction createFormAction(FlowableUserContext userContext, String label,String localeKey,String actionKey,String level,String url,String formId) throws Exception;	
	public FormAction updateFormAction(FlowableUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormAction loadFormAction(FlowableUserContext userContext, String formActionId, String [] tokensExpr) throws Exception;
	public FormAction internalSaveFormAction(FlowableUserContext userContext, FormAction formAction) throws Exception;
	public FormAction internalSaveFormAction(FlowableUserContext userContext, FormAction formAction,Map<String,Object>option) throws Exception;
	
	public FormAction transferToAnotherForm(FlowableUserContext userContext, String formActionId, String anotherFormId)  throws Exception;
 

	public void delete(FlowableUserContext userContext, String formActionId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, FormAction newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	


	public Object listByForm(FlowableUserContext userContext,String formId) throws Exception;
	public Object listPageByForm(FlowableUserContext userContext,String formId, int start, int count) throws Exception;
  

}


