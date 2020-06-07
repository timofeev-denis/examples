package ru.code4fun.demo.springbootactivemq.controller.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.code4fun.demo.springbootactivemq.domain.EmailMessage;
import ru.code4fun.demo.springbootactivemq.messageproducer.MessageProducerService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/messages")
public class MessageController {

    private final MessageProducerService service;

    @PostMapping("")
    public ResponseEntity<Void> postMessage(@RequestBody EmailMessage message) {
        log.info("Получен запрос на отправку сообщения адресату {}", message.getTo());
        service.postMessage(message);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
