package com.ch.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class WebConfig extends WebMvcConfigurerAdapter {
	 @Bean  
	    public ViewResolver getViewResolver() {  
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();  
	        resolver.setPrefix("WEB-INF/pages/");  
	        resolver.setSuffix(".jsp");  
	        return resolver;  
	    }  
	  
}
