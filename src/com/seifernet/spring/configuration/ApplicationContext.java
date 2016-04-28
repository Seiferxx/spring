package com.seifernet.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

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
public class ApplicationContext extends WebMvcConfigurerAdapter{
	
	private final String RESOLVER_PREFIX 				= "/WEB-INF/pages/";
	private final String RESOLVER_SUFFIX 				= ".jsp";
	private final String TILES_CONFIG_FILE_LOCATION 	= "/WEB-INF/tiles.xml";
	
	/**
	 * Resources configuration
	 */
	@Override
	public void addResourceHandlers( final ResourceHandlerRegistry registry ) {
		registry.addResourceHandler( "/resources/**" ).addResourceLocations( "/resources/" );
	}
	
	/**
	 * Tiles resolver
	 * 
	 * @return TilesViewResolver
	 */
	@Bean
	TilesViewResolver viewResolver( ) {
		return new TilesViewResolver( );
    }
	
	/**
	 * Tiles resolver configuration
	 * 
	 * @return TilesConfigurer
	 */
	@Bean
	TilesConfigurer tilesConfigurer( ) {
		TilesConfigurer tilesConfigurer = new TilesConfigurer( );
		
		tilesConfigurer.setDefinitions( TILES_CONFIG_FILE_LOCATION );
		tilesConfigurer.setPreparerFactoryClass( SpringBeanPreparerFactory.class );
		
		return tilesConfigurer;
    }
	
	/**
	 * Basic jsp view resolver configuration
	 * 
	 * @return ViewResolver 
	 */
	/*
	@Bean
	public ViewResolver viewResolver(  ){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver( );
		
		viewResolver.setViewClass( JstlView.class );
		viewResolver.setPrefix( RESOLVER_PREFIX );
		viewResolver.setSuffix( RESOLVER_SUFFIX );
		
		return viewResolver;
	}*/
}
