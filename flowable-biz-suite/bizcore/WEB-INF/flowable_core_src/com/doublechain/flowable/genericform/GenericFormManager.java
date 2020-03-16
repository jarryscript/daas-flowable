
package com.doublechain.flowable.genericform;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface GenericFormManager extends BaseManager{

		

	public GenericForm createGenericForm(FlowableUserContext userContext, String title,String description) throws Exception;	
	public GenericForm updateGenericForm(FlowableUserContext userContext,String genericFormId, int genericFormVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public GenericForm loadGenericForm(FlowableUserContext userContext, String genericFormId, String [] tokensExpr) throws Exception;
	public GenericForm internalSaveGenericForm(FlowableUserContext userContext, GenericForm genericForm) throws Exception;
	public GenericForm internalSaveGenericForm(FlowableUserContext userContext, GenericForm genericForm,Map<String,Object>option) throws Exception;
	


	public void delete(FlowableUserContext userContext, String genericFormId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, GenericForm newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  FormMessageManager getFormMessageManager(FlowableUserContext userContext, String genericFormId, String title, String level ,String [] tokensExpr)  throws Exception;
	
	public  GenericForm addFormMessage(FlowableUserContext userContext, String genericFormId, String title, String level , String [] tokensExpr)  throws Exception;
	public  GenericForm removeFormMessage(FlowableUserContext userContext, String genericFormId, String formMessageId, int formMessageVersion,String [] tokensExpr)  throws Exception;
	public  GenericForm updateFormMessage(FlowableUserContext userContext, String genericFormId, String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  FormFieldMessageManager getFormFieldMessageManager(FlowableUserContext userContext, String genericFormId, String title, String parameterName, String level ,String [] tokensExpr)  throws Exception;
	
	public  GenericForm addFormFieldMessage(FlowableUserContext userContext, String genericFormId, String title, String parameterName, String level , String [] tokensExpr)  throws Exception;
	public  GenericForm removeFormFieldMessage(FlowableUserContext userContext, String genericFormId, String formFieldMessageId, int formFieldMessageVersion,String [] tokensExpr)  throws Exception;
	public  GenericForm updateFormFieldMessage(FlowableUserContext userContext, String genericFormId, String formFieldMessageId, int formFieldMessageVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  FormFieldManager getFormFieldManager(FlowableUserContext userContext, String genericFormId, String label, String localeKey, String parameterName, String type, String placeholder, String defaultValue, String description, String fieldGroup, String minimumValue, String maximumValue, boolean required, boolean disabled, boolean customRendering, String candidateValues, String suggestValues ,String [] tokensExpr)  throws Exception;
	
	public  GenericForm addFormField(FlowableUserContext userContext, String genericFormId, String label, String localeKey, String parameterName, String type, String placeholder, String defaultValue, String description, String fieldGroup, String minimumValue, String maximumValue, boolean required, boolean disabled, boolean customRendering, String candidateValues, String suggestValues , String [] tokensExpr)  throws Exception;
	public  GenericForm removeFormField(FlowableUserContext userContext, String genericFormId, String formFieldId, int formFieldVersion,String [] tokensExpr)  throws Exception;
	public  GenericForm updateFormField(FlowableUserContext userContext, String genericFormId, String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  FormActionManager getFormActionManager(FlowableUserContext userContext, String genericFormId, String label, String localeKey, String actionKey, String level, String url ,String [] tokensExpr)  throws Exception;
	
	public  GenericForm addFormAction(FlowableUserContext userContext, String genericFormId, String label, String localeKey, String actionKey, String level, String url , String [] tokensExpr)  throws Exception;
	public  GenericForm removeFormAction(FlowableUserContext userContext, String genericFormId, String formActionId, int formActionVersion,String [] tokensExpr)  throws Exception;
	public  GenericForm updateFormAction(FlowableUserContext userContext, String genericFormId, String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


