package com.housing.javaee6demo.mdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author Matija Mazi <br/>
 * @created 10.2.12 8:45
 */
@Stateful
@SessionScoped
@Named
public class HelloMessageSender {
    private static final Logger log = LoggerFactory.getLogger(HelloMessageSender.class);

    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory jmsConnectionFactory;

    @Resource(mappedName = "java:/queue/demo")
    private Destination destination;

    private String name;

    public void sendMessage() throws JMSException {
        Connection connection = null;
        try {
            connection = jmsConnectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);
            TextMessage msg = session.createTextMessage(name);
            log.debug("Sending message {} to {}...", msg, destination);
            producer.send(msg);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
