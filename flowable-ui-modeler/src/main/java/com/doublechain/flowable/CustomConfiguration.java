package com.doublechain.flowable;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "org.flowable.app.rest", })
public class CustomConfiguration {

}
