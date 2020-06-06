package ru.code4fun.demo.springbootactivemq.messageproducer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageProducerService {

    private final JmsTemplate jmsTemplate;
    private final Queue queue;

    public void postMessage(String message) {
        jmsTemplate.convertAndSend(queue, message);
        log.info("Сообщение {} добавлено в очередь", message);
    }
}
