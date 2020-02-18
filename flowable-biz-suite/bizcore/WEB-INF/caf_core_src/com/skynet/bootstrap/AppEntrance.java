package com.skynet.bootstrap;

import com.doublechain.flowable.CustomConfiguration;
import com.doublechain.flowable.CustomUCInvocationServlet;
import com.terapico.uccaf.UCInvocationServlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.flowable.app.rest.AppRestResponseFactory;
import org.flowable.rest.service.api.RestResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.elasticsearch.rest.RestClientAutoConfiguration;
import org.springframework.boot.autoconfigure.elasticsearch.rest.RestClientAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Import(org.flowable.app.rest.service.api.repository.AppDeploymentCollectionResource.class)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, RestClientAutoConfiguration.class, KafkaAutoConfiguration.class,})
@ImportResource(locations = {"classpath:/META-INF/spring.xml", "classpath:/META-INF/online-system.xml"})
@ServletComponentScan(basePackageClasses = {CustomUCInvocationServlet.class})
public class AppEntrance {
    public static void main(String[] args) {
        SpringApplication.run(AppEntrance.class, args);
    }
    
    
    @Bean
    public AppRestResponseFactory restResponseFactory() {
        return new AppRestResponseFactory();
    }
    
    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
       
       @Override
       protected void configure(HttpSecurity http) throws Exception {
          http.csrf().disable()
             .authorizeRequests()
             .anyRequest().permitAll()
             .and().logout().permitAll();
       }
       
    }
    
    @Component
    public class Test implements ApplicationRunner{
    	@Autowired
    	WebApplicationContext applicationContext;

		@Override
		public void run(ApplicationArguments args) throws Exception {
			RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
			Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
			
	 
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			for (Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
				Map<String, String> map1 = new HashMap<String, String>();
				RequestMappingInfo info = m.getKey();  
	            HandlerMethod method = m.getValue();  
	            PatternsRequestCondition p = info.getPatternsCondition();  
	            for (String url : p.getPatterns()) {  
	            	map1.put("url", url);
	            }  
	            map1.put("className", method.getMethod().getDeclaringClass().getName()); // 类名  
	            map1.put("method", method.getMethod().getName()); // 方法名 
	            RequestMethodsRequestCondition methodsCondition = info.getMethodsCondition();
	            for (RequestMethod requestMethod : methodsCondition.getMethods()) {
	            	map1.put("type", requestMethod.toString());
				}
				
	            list.add(map1);
			}
			System.out.println("==========================================");
			list.forEach(System.out::println);
			System.out.println("==========================================");
	 
		}
    	
    }

}
