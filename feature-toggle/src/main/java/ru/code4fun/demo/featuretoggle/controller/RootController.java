package ru.code4fun.demo.featuretoggle.controller;

import lombok.RequiredArgsConstructor;
import org.ff4j.FF4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.code4fun.demo.featuretoggle.service.MessageService;

@RestController
@RequiredArgsConstructor
public class RootController {

    private final MessageService service;
    private final FF4j ff4j;

    @GetMapping("")
    public String sayHello() {
        if (ff4j.check("FEATURE_NEW")) {
            return service.getNewMessage();
        } else {
            return service.getOldMessage();
        }
    }
}
