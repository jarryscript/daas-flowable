package com.doublechain.flowable.listener;

import org.flowable.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * flowable 全局监听器配置类
 * @author: Lu Yang
 */
@Component
public class FlowableListenerConfig implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	private RuntimeService runtimeService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("✅✅✅加入全局监听");
		getRuntimeService().addEventListener(new GlobalEventListener());

	}

	public RuntimeService getRuntimeService() {
		return runtimeService;
	}

	public void setRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}


}
