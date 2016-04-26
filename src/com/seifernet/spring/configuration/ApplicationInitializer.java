package com.seifernet.spring.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Application initializer
 * 
 * Used to define default spring servlet
 * 
 * @author Cuauhtemoc Herrera
 * @version 0.0.1
 * @since 0.0.1
 *
 */
public class ApplicationInitializer implements WebApplicationInitializer{

	/**
	 * @see WebApplicationInitializer
	 */
	@Override
	public void onStartup( ServletContext context ) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext( );
		
		ctx.register( ApplicationContext.class );
		ctx.setServletContext( context );
		
		ServletRegistration.Dynamic servlet = context.addServlet( "dispatcher" , new DispatcherServlet( ctx ) );
		
		servlet.setLoadOnStartup( 1 );
		servlet.addMapping( "/" );
	}

}
