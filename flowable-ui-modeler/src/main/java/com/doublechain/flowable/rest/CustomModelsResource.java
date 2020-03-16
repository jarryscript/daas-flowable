package com.doublechain.flowable.rest;

import javax.servlet.http.HttpServletRequest;

import org.flowable.ui.common.model.ResultListDataRepresentation;
import org.flowable.ui.modeler.repository.ModelRepository;
import org.flowable.ui.modeler.repository.ModelSort;
import org.flowable.ui.modeler.rest.app.ModelsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class CustomModelsResource extends ModelsResource {
	@Autowired
	protected ModelRepository modelRepository;

	@GetMapping(value = "/rest/event-flows-for-app-definition",  produces = "application/json")
	public ResultListDataRepresentation getEventFlowsToIncludeInAppDefinition(HttpServletRequest request) {
		return modelQueryService.getModels(null, ModelSort.MODIFIED_DESC, 99, request);
	}

	protected void createEventFlowModel() {

	}
}
