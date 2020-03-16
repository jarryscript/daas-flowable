
package com.doublechain.flowable.formfieldmessage;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface FormFieldMessageManager extends BaseManager{

		

	public FormFieldMessage createFormFieldMessage(FlowableUserContext userContext, String title,String parameterName,String formId,String level) throws Exception;	
	public FormFieldMessage updateFormFieldMessage(FlowableUserContext userContext,String formFieldMessageId, int formFieldMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormFieldMessage loadFormFieldMessage(FlowableUserContext userContext, String formFieldMessageId, String [] tokensExpr) throws Exception;
	public FormFieldMessage internalSaveFormFieldMessage(FlowableUserContext userContext, FormFieldMessage formFieldMessage) throws Exception;
	public FormFieldMessage internalSaveFormFieldMessage(FlowableUserContext userContext, FormFieldMessage formFieldMessage,Map<String,Object>option) throws Exception;
	
	public FormFieldMessage transferToAnotherForm(FlowableUserContext userContext, String formFieldMessageId, String anotherFormId)  throws Exception;
 

	public void delete(FlowableUserContext userContext, String formFieldMessageId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, FormFieldMessage newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	


	public Object listByForm(FlowableUserContext userContext,String formId) throws Exception;
	public Object listPageByForm(FlowableUserContext userContext,String formId, int start, int count) throws Exception;
  

}


