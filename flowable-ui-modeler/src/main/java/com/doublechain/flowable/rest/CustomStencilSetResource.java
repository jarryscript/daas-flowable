package com.doublechain.flowable.rest;


import org.flowable.ui.common.service.exception.InternalServerErrorException;
import org.flowable.ui.modeler.rest.app.StencilSetResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.JsonNode;

public class CustomStencilSetResource extends StencilSetResource {
	 @RequestMapping(value = "/rest/stencil-sets/event-flow-editor", method = RequestMethod.GET, produces = "application/json")
	    public JsonNode getStencilSetForEventFlowEditor() {
	        try {
	            JsonNode stencilNode = objectMapper.readTree(this.getClass().getClassLoader().getResourceAsStream("event_flow_stencilset_bpmn.json"));
	            return stencilNode;
	        } catch (Exception e) {
	            throw new InternalServerErrorException("Error reading bpmn stencil set json");
	        }
	    }
}
