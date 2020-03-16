
package com.doublechain.flowable.formfield;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface FormFieldManager extends BaseManager{

		

	public FormField createFormField(FlowableUserContext userContext, String label,String localeKey,String parameterName,String type,String formId,String placeholder,String defaultValue,String description,String fieldGroup,String minimumValue,String maximumValue,boolean required,boolean disabled,boolean customRendering,String candidateValues,String suggestValues) throws Exception;	
	public FormField updateFormField(FlowableUserContext userContext,String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormField loadFormField(FlowableUserContext userContext, String formFieldId, String [] tokensExpr) throws Exception;
	public FormField internalSaveFormField(FlowableUserContext userContext, FormField formField) throws Exception;
	public FormField internalSaveFormField(FlowableUserContext userContext, FormField formField,Map<String,Object>option) throws Exception;
	
	public FormField transferToAnotherForm(FlowableUserContext userContext, String formFieldId, String anotherFormId)  throws Exception;
 

	public void delete(FlowableUserContext userContext, String formFieldId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, FormField newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	


	public Object listByForm(FlowableUserContext userContext,String formId) throws Exception;
	public Object listPageByForm(FlowableUserContext userContext,String formId, int start, int count) throws Exception;
  

}


