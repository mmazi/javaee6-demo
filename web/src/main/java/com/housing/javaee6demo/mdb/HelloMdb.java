package com.housing.javaee6demo.mdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author Matija Mazi <br/>
 * @created 10.2.12 8:57
 */
@MessageDriven(activationConfig = {@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/demo")})
public class HelloMdb implements MessageListener {
    private static final Logger log = LoggerFactory.getLogger(HelloMdb.class);

    @Override
    public void onMessage(Message message) {
        try {
            log.debug("Hello, " + ((TextMessage)message).getText() + "!");
        } catch (JMSException e) {
            log.error("Error handling message.", e);
        }
    }
}
