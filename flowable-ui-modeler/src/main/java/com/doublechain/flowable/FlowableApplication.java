
package com.doublechain.flowable;

import javax.servlet.http.HttpServletRequest;

import org.flowable.ui.common.filter.FlowableCookieFilter;
import org.flowable.ui.common.filter.FlowableCookieFilterRegistrationBean;
import org.flowable.ui.common.properties.FlowableCommonAppProperties;
import org.flowable.ui.common.service.idm.RemoteIdmService;
import org.flowable.ui.modeler.conf.ApplicationConfiguration;
import org.flowable.ui.modeler.servlet.AppDispatcherServletConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Import({ ApplicationConfiguration.class, AppDispatcherServletConfiguration.class })

@SpringBootApplication
@EnableWebSecurity
public class FlowableApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {

		SpringApplication.run(FlowableApplication.class, args);
	}

	/**
	 * 重写 Flowable 的 FlowableCookieFilterRegistrationBean,跳过cookie认证
	 * @param remoteIdmService
	 * @param properties
	 * @return
	 */
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public FlowableCookieFilterRegistrationBean flowableCookieFilterRegistrationBean(RemoteIdmService remoteIdmService,
			FlowableCommonAppProperties properties) {
		return new FlowableCookieFilterRegistrationBean(remoteIdmService, properties) {
			@Override
			protected void initializeFilter() {
				if (getFilter() == null) {
					FlowableCookieFilter flowableCookieFilter = new FlowableCookieFilter(remoteIdmService, properties) {
						@Override
						protected boolean skipAuthenticationCheck(HttpServletRequest request) {
							return true;
						}
					};
					setFilter(flowableCookieFilter);
				}
			}
		};
	}

	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
    @ConditionalOnProperty(prefix = "flowable.idm.ldap", name = "enabled", havingValue = "false", matchIfMissing = true)
    public AuthenticationProvider authenticationProvider() {
		return new CustomFlowableAuthenticationProvider();
    }

	@EnableWebSecurity
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public  class CustomFormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.formLogin().and().authenticationProvider(authenticationProvider()).authorizeRequests().anyRequest().authenticated().and().csrf().disable();
		}
	}
	@Bean
	public RemoteIdmService remoteIdmService(FlowableCommonAppProperties properties) {
		return new CustomRemoteIdmService(properties);
	}

}
