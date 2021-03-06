package com.rlearn.serverless.handler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.rlearn.serverless.controllers"})
@ImportResource({"classpath:services-context.xml", "classpath:security-context.xml" })
public class SpringConfig {

}