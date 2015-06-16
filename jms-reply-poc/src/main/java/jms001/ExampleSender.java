/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms001;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author Bart
 */
@Component
public class ExampleSender {

    private final JmsTemplate jmsTemplate;

    @Autowired
    public ExampleSender(QueueConnectionFactory connectionFactory) {
        jmsTemplate = new JmsTemplate(connectionFactory);
    }

    @Scheduled(fixedDelay = 1000L)
    private void sendInboundMessage() {
        jmsTemplate.send("INBOUND", sn -> sn.createTextMessage("hello world"));
    }
}
