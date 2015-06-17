/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms001;

import java.util.concurrent.atomic.AtomicInteger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.listener.adapter.JmsResponse;
import org.springframework.stereotype.Component;

@Component
public class ExampleListener {

    private final AtomicInteger counter = new AtomicInteger();

//    @JmsListener(destination = "INBOUND")
//    public Message inbound(Message message, Session s) throws JMSException {
//        String dst = "D" + (1 + counter.incrementAndGet() % 3);
//        System.out.println("sent to: " + dst);
//        message.setJMSReplyTo(new ActiveMQQueue(dst));
//        return s.createTextMessage("What a beautiful world!");
//    }

    @JmsListener(destination = "INBOUND")
    public JmsResponse inbound(Message message, Session s) throws JMSException {
        String dst = "D" + (1 + counter.incrementAndGet() % 3);
        System.out.println("sent to: " + dst);
        return JmsResponse.forQueue(s.createTextMessage("What a beautiful world!"), dst);
    }
    
    @JmsListener(destination = "D1")
    public void d1(Message message) {
        System.out.println("read from D1: " + message);
    }

    @JmsListener(destination = "D2")
    public void d2(Message message) {
        System.out.println("read from D2: " + message);
    }

    @JmsListener(destination = "D3")
    public void d3(Message message) {
        System.out.println("read from D3: " + message);
    }

}
