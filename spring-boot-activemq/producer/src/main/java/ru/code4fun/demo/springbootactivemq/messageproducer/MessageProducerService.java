package ru.code4fun.demo.springbootactivemq.messageproducer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import ru.code4fun.demo.springbootactivemq.domain.EmailMessage;

import javax.jms.Queue;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageProducerService {

    private final JmsTemplate jmsTemplate;
    private final Queue queue;
    private final TaskExecutor taskExecutor;

    public void postMessage(EmailMessage message) {
        taskExecutor.execute(() -> {
            jmsTemplate.convertAndSend(queue, message);
            log.info("Сообщение {} добавлено в очередь", message);
        });
    }
}
