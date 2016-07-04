package com.seifernet.spring.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Abstract DAO with generic operations
 * 
 * @author Cuauhtemoc Herrera
 * @version 0.0.1
 * @since 0.0.1
 *
 * @param <T> Mapped class
 * @param <PK> Primary Key type
 */
public abstract class AbstractDAO <T, PK extends Serializable>{

	//Class logger
	private Logger logger = Logger.getLogger( AbstractDAO.class );
	
	//Hibernate session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<T> type;
	
	/**
	 * Generic constructor
	 * 
	 * @param type The class type
	 */
	public AbstractDAO( Class<T> type ) {
		this.type = type;
	}

	/**
	 * Returns a session obtained from session factory
	 * 
	 * @return Session instance
	 */
	protected Session getSession(  ){
		Session session = null;
		
		try {
			session = sessionFactory.getCurrentSession( );
		} catch( HibernateException e ){
			logger.error( "" );
			
			session = sessionFactory.openSession( );	
		}
		return session;
		
	}
	
	/**
	 * Creates an object on the database
	 * SQL:
	 * 
	 * INSERT
	 * 
	 * @param object The object to insert
	 * @return Primary key of the inserted object
	 */
	@SuppressWarnings("unchecked")
	public PK create( T object ) {
		PK key = null;
		
		try {
			key = ( PK )getSession( ).save( object );
		} catch( Exception e ){
			logger.error( "" );
		}
		
		logger.debug( "" );
		return key;
	}
	
	/**
	 * Updates information of a register on database
	 * SQL:
	 * 
	 * UPDATE
	 * 
	 * @param object The object to update
	 */
	public void update( T object ) {
		
		try {
			getSession( ).update( object );
		} catch( Exception e ){
			logger.error( "" );
		}
	}
	
	/**
	 * Deletes specified object from database
	 * SQL:
	 * 
	 * DELETE
	 * 
	 * @param object The object to delete
	 */
	public void delete( T object ) {
		
		try {
			getSession( ).delete( object );
		} catch( Exception e ){
			logger.error( "" );
		}
	}
	
	/**
	 * Reads an object by id from the database
	 * SQL:
	 * 
	 * SELECT... WHERE id = ID
	 * 
	 * @param id The id to search
	 * @return Register from database
	 */
	@SuppressWarnings("unchecked")
	public T read( PK id ) {
		T object = null;
		
		try {
			object =  ( T )getSession( ).get( type, id );
			return object;
		}catch( Exception e ){
			logger.error( "" );
			
			return null;
		}
		
	}
	
	/**
	 * Read a list of objects
	 * SQL:
	 * 
	 * SELECT... 
	 * 
	 * @return List of registers from database
	 */
	@SuppressWarnings("unchecked")
	public List<T> readAll( ){
		List<T>		list		= null;
		
		try {
			list = getSession( ).createCriteria( type ).list( );
			return list;
		}catch( Exception e ){
			logger.error( "" );
			
			return null;
		}
	}

}
