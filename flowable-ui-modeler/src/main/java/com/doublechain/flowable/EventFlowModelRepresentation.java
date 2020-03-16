package com.doublechain.flowable;

import org.flowable.ui.modeler.model.ModelRepresentation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventFlowModelRepresentation extends ModelRepresentation {
	private String projectName;
	private String basePackage;
	private String outputDir;
}
