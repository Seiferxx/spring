package com.seifernet.spring.configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * Hibernate configuration
 * 
 * @author Cuauhtemoc Herrera
 * @version 0.0.1
 * @since 0.0.1
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan( { "com.seifernet.spring" } )
public class HibernateConfiguration {
	
	private final String MODEL_PACKAGE 	= "com.seifernet.spring.model.dto";
	private final String DATASOURCE 	= "java:jboss/datasources/spring";
	private final String DB_DIALECT 	= "org.hibernate.dialect.PostgreSQLDialect";
	
	/**
	 * Session factory configuration
	 * 
	 * @return SessionFactory
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory(  ){
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean( );
		
		String[ ] packagesToScan = new String[ 1 ];
		packagesToScan[ 0 ] = MODEL_PACKAGE;
		
		//Scan for annotated clases
		sessionFactory.setPackagesToScan( packagesToScan );
		
		//Hibernate properties
		Properties properties = new Properties( );
		
		properties.setProperty( "hibernate.connection.datasource", DATASOURCE );
		properties.setProperty( "hibernate.dialect", DB_DIALECT );
		
		//Manual transaction management
//		properties.setProperty( "hibernate.current_session_context_class", "thread" );
		
		//Debug properties, this lines should be commented on productive environments
//		properties.setProperty( "hibernate.show_sql", "true" );
//		properties.setProperty( "hibernate.format_sql", "true" );
//		properties.setProperty( "hibernate.generate_statistics", "true" );
//		properties.setProperty( "hibernate.use_sql_comments", "true" );
		
		//WARNING!
		//If this property is set during deploy or server reboot
		//database is deleted and created again!
		properties.setProperty( "hibernate.hbm2ddl.auto", "create" );
		
		sessionFactory.setHibernateProperties( properties );
		
		return sessionFactory;
	}
	
	/**
	 * Hibernate transaction manager bean
	 * 
	 * @param sessionFactory configured object
	 * @return HibernateTransactionManager
	 */
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager( SessionFactory sessionFactory ) {
		HibernateTransactionManager txManager = new HibernateTransactionManager(  );
		txManager.setSessionFactory( sessionFactory );
		return txManager;
    }
	
	
}
