
package com.doublechain.flowable.formmessage;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface FormMessageManager extends BaseManager{

		

	public FormMessage createFormMessage(FlowableUserContext userContext, String title,String formId,String level) throws Exception;	
	public FormMessage updateFormMessage(FlowableUserContext userContext,String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormMessage loadFormMessage(FlowableUserContext userContext, String formMessageId, String [] tokensExpr) throws Exception;
	public FormMessage internalSaveFormMessage(FlowableUserContext userContext, FormMessage formMessage) throws Exception;
	public FormMessage internalSaveFormMessage(FlowableUserContext userContext, FormMessage formMessage,Map<String,Object>option) throws Exception;
	
	public FormMessage transferToAnotherForm(FlowableUserContext userContext, String formMessageId, String anotherFormId)  throws Exception;
 

	public void delete(FlowableUserContext userContext, String formMessageId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, FormMessage newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	


	public Object listByForm(FlowableUserContext userContext,String formId) throws Exception;
	public Object listPageByForm(FlowableUserContext userContext,String formId, int start, int count) throws Exception;
  

}


