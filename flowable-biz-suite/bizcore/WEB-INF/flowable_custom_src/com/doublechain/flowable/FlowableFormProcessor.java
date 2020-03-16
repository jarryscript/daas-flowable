package com.doublechain.flowable;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.BooleanUtils;
import org.flowable.form.api.FormModel;
import org.flowable.form.model.FormField;
import static org.flowable.form.model.FormFieldTypes.*;
import org.flowable.form.model.SimpleFormModel;


public class FlowableFormProcessor extends BaseFlowableFormProcessor {
	private FormModel formModel;

	public FormModel getFormModel() {
		return formModel;
	}

	public void setFormModel(FormModel formModel) {
		this.formModel = formModel;
	}

	@Override
	public Map<String, Object> mapToUiForm(FlowableUserContext userContext) {
		SimpleFormModel form = (SimpleFormModel) getFormModel();
		List<FormField> fields = form.getFields();
		if (fields == null || fields.isEmpty()) {
			return Collections.emptyMap();
		}
		Map<String, Object> result = new HashMap<>();
		result.put("title", form.getName());
		Map<String, Object> fieldsMap = new HashMap<>();
		result.put("fields", fields);
		fields.forEach(field -> {
			Object value = Collections.emptyMap();;
			switch (field.getType()) {
			case SINGLE_LINE_TEXT:
			case MULTI_LINE_TEXT:
				value=mapStringFieldIntoUiForm(field.getName(), (String) field.getValue());
				break;
			case INTEGER:
				value=mapIntegerFieldIntoUiForm(field.getName(), Integer.parseInt((String) field.getValue()));
				break;
			case DECIMAL:
				value=mapBigDecimalFieldIntoUiForm(field.getName(),new BigDecimal((String) field.getValue()));
				break;
			case BOOLEAN:
				value=mapBooleanFieldIntoUiForm(field.getName(), BooleanUtils.toBoolean((String) field.getValue()));
				break;
			case DATE:
				//mapDateFieldIntoUiForm(field.getName(), ((String) field.getValue()));
				break;
			case PEOPLE:
				break;
			case AMOUNT:
			case RADIO_BUTTONS:
			case DROPDOWN:
			case UPLOAD:
			case EXPRESSION:
			
			case FUNCTIONAL_GROUP:
			case CONTAINER:
			case HYPERLINK:
			case SPACER:
			case HORIZONTAL_LINE:
			case HEADLINE:
			case HEADLINE_WITH_LINE:
				break;
			default:
				break;
			}
			fieldsMap.put(field.getName(), value);
		});
		mappingFormActions(result);
		return result;
	}

	public Map<String, Object> getData() {
		return null;
	}

	public FlowableFormProcessor initByRequest(FlowableUserContext userContext, String requestBody) throws Exception {
		setUserContext(userContext);
		loadRequestBody(requestBody);
		return this;
	}

	public FlowableFormProcessor fillWith(FormModel data) throws Exception {
		setFormModel(data);
		return this;
	}
}
