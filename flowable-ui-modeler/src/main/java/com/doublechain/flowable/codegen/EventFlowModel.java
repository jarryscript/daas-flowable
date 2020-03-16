package com.doublechain.flowable.codegen;

import java.util.Map;

import org.flowable.ui.modeler.domain.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventFlowModel extends Model {
	// 包名
//			data.put("base_package", "");
//
//			//
//			data.put("package", packageName);
//			//项目名
//			data.put("project_name", model.get);
//			// 生成类名
//			data.put("class_name", model.getName());
//			// user context名，其实只需要项目名
//			data.put("context_name", model.getName()+"UserContext");
//			//  同上
//			data.put("custom_context_name", "Custom"+model.getName()+"UserContextImpl");
//
//			// 脚本对象，这里用自己的代替
//			data.put("script", script);

	private String basePackage;
	private String packageName;
	private String projectName;
	private String className;

	private String outputDir;
	private  Map<String,Object> data;

}
