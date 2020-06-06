package ru.code4fun.demo.springbootactivemq.messageconsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import static ru.code4fun.demo.springbootactivemq.config.ActiveMQConfig.QUEUE_NAME;

@Slf4j
@Component
public class MessageConsumer {

    @JmsListener(destination = QUEUE_NAME)
    public void consume(String message) {
        log.info("Consumed message {}", message);
    }
}
