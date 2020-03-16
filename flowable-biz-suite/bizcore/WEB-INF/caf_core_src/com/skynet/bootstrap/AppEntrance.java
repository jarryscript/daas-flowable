package com.skynet.bootstrap;
import org.flowable.app.rest.AppRestResponseFactory;
import org.flowable.spring.boot.FlowableSecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.elasticsearch.rest.RestClientAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.doublechain.flowable.CustomUCInvocationServlet;

@Import(org.flowable.app.rest.service.api.repository.AppDeploymentCollectionResource.class)
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, RestClientAutoConfiguration.class, KafkaAutoConfiguration.class, SecurityAutoConfiguration.class,
		FlowableSecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
@ImportResource(locations = { "classpath:/META-INF/spring.xml", "classpath:/META-INF/online-system.xml" })
@ServletComponentScan(basePackageClasses = { CustomUCInvocationServlet.class })
public class AppEntrance {
	public static void main(String[] args) {
		SpringApplication.run(AppEntrance.class, args);
	}

	@Bean
	public AppRestResponseFactory restResponseFactory() {
		return new AppRestResponseFactory();
	}
}
