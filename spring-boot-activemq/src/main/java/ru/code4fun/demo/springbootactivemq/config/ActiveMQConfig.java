package ru.code4fun.demo.springbootactivemq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

@Configuration
public class ActiveMQConfig {

    public static final String QUEUE_NAME = "standalone.queue";

    @Value("${activemq.broker-url}")
    private String brokerUrl;

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(QUEUE_NAME);
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(brokerUrl);
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        return new JmsTemplate(activeMQConnectionFactory());
    }
}
