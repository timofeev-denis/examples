package ru.code4fun.demo.ff4j;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MessageController {
    private final MessageService service;

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok(service.generateMessage());
    }
}
