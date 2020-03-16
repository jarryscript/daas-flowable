package com.doublechain.flowable.service;

import org.flowable.ui.common.service.exception.InternalServerErrorException;
import org.flowable.ui.modeler.domain.Model;
import org.flowable.ui.modeler.service.ModelServiceImpl;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class CustomModelService extends ModelServiceImpl {
	@Override
	protected Model persistModel(Model model) {
		ObjectNode jsonNode = null;
		try {
			jsonNode = (ObjectNode) objectMapper.readTree(model.getModelEditorJson());
		} catch (Exception e) {
			throw new InternalServerErrorException("Could not deserialize json model");
		}

		//事件流模型
		if (model.getModelType().intValue() == 99) {
			byte[] thumbnail = modelImageService.generateThumbnailImage(model, jsonNode);
			if (thumbnail != null) {
				model.setThumbnail(thumbnail);
			}
			modelRepository.save(model);

			// Relations
			handleBpmnProcessFormModelRelations(model, jsonNode);
			handleBpmnProcessDecisionTaskModelRelations(model, jsonNode);
			return model;

		//代码生成APP
		} else if (model.getModelType().intValue() == 98) {
			modelRepository.save(model);
			handleAppModelProcessRelations(model, jsonNode);
			return model;
		}
		return super.persistModel(model);
	}
}
