package com.seifernet.spring.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.jms.ConnectionFactory;

import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.api.jms.HornetQJMSClient;
import org.hornetq.api.jms.JMSFactoryType;
import org.hornetq.core.remoting.impl.netty.NettyConnectorFactory;
import org.hornetq.jms.client.HornetQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsConfiguration {

    @Bean
    public ConnectionFactory connectionFactory(){
        Map<String, Object> connectionParams = new HashMap<String, Object>();
           
        connectionParams.put(org.hornetq.core.remoting.impl.netty.TransportConstants.PORT_PROP_NAME, 
                           5446);

        TransportConfiguration transportConfiguration = 
           new TransportConfiguration(
           "org.hornetq.core.remoting.impl.netty.NettyConnectorFactory", 
           connectionParams);
             transportConfiguration = new TransportConfiguration(NettyConnectorFactory.class.getName(), connectionParams);
            //
            
        HornetQConnectionFactory connectionFactory = HornetQJMSClient.createConnectionFactoryWithoutHA(JMSFactoryType.CF, transportConfiguration);
        return connectionFactory;
    
    }
    
   @Bean
  JmsListenerContainerFactory<?> jmsContainerFactory( ConnectionFactory connectionFactory ) {
      SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
      factory.setConnectionFactory(connectionFactory);
      return factory;
  }
   
   @Bean
   public JmsTemplate jmsTemplate( ConnectionFactory connectionFactory ){
       JmsTemplate jmsTemplate = new JmsTemplate( );
       
       jmsTemplate.setConnectionFactory( connectionFactory );
       
       return jmsTemplate;
   }

}