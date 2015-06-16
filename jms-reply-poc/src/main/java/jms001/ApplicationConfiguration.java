/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms001;

import javax.jms.QueueConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author Bart
 */
@Configuration
@ComponentScan
@EnableScheduling
@EnableJms
public class ApplicationConfiguration {

    @Bean
    public BrokerService brokerService() throws Exception {
        BrokerService broker = new BrokerService();
//        broker.addConnector("tcp://localhost:61616");
        broker.setPersistent(false);
        broker.start();
        return broker;
    }

    @Bean
    public QueueConnectionFactory jmsConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("vm://localhost");
        return new CachingConnectionFactory(activeMQConnectionFactory);
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(QueueConnectionFactory cf) {
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setConnectionFactory(cf);
        return containerFactory;
    }
}
