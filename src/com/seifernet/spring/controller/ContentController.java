package com.seifernet.spring.controller;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import mx.udg.mxc.commons.rest.oauth.Oauth2TokenManager;
import mx.udg.mxc.commons.rest.oauth.Token;

/**
 * 
 * 
 * @author Cuauhtemoc Herrera
 * @version 0.0.1
 * @since 0.0.1
 *
 */
@Controller
public class ContentController {

	private Logger logger = Logger.getLogger( ContentController.class );
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@RequestMapping( "/homes/x" )
	public String defaultAction( Model model ){
		
		 
		// Send a message
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
            	String f = "asdaisdisjd";
            	ObjectMapper mapper = new ObjectMapper( );
            	
            	Message m = null;
            	
            	try {
            		m = session.createTextMessage( mapper.writeValueAsString( f ) );
				} catch (Exception e) {
					// TODO: handle exception
				}
            	
                return m;
            }
        };
        
       
        System.out.println("Sending a new message.");
        jmsTemplate.send("DLQ", messageCreator);
//		Token t = Oauth2TokenManager.getNewToken( "module1" , "pwd" );
//		System.out.println( t.getAccessToken( ) );
		return "system.index";
	}
	
	@RequestMapping( "/loginurl" )
	public String action(  ){
		System.out.println( "aksdokasd" );
		return "system.index";
	}
	
}
