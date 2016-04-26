package com.seifernet.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Spring context configuration
 * 
 * @author Cuauhtemoc Herrera
 * @version 0.0.1
 * @since 0.0.1
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan( basePackages="com.seifernet.spring" )
public class ApplicationContext {
	
	private final String RESOLVER_PREFIX = "/WEB-INF/pages/";
	private final String RESOLVER_SUFFIX = ".jsp";
	
	/**
	 * Basic jsp view resolver configuration
	 * 
	 * @return ViewResolver 
	 */
	@Bean
	public ViewResolver viewResolver(  ){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver( );
		
		viewResolver.setViewClass( JstlView.class );
		viewResolver.setPrefix( RESOLVER_PREFIX );
		viewResolver.setSuffix( RESOLVER_SUFFIX );
		
		return viewResolver;
	}
}
