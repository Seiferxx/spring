package com.seifernet.spring.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsListenerx {
    
    @Autowired
    ConfigurableApplicationContext context;
    
    
    
    
    
    
    private Object received;
    
    @JmsListener(containerFactory = "jmsContainerFactory", destination = "DLQ")
   public void receive(String message) {
       this.received = message;
       
       System.out.print(received);
       
   }


}