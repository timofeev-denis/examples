package ru.code4fun.demo.featuretoggle.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.code4fun.demo.featuretoggle.service.MessageService;

@RestController
@RequiredArgsConstructor
public class RootController {

    private final MessageService service;

    @GetMapping("")
    public String sayHello() {
        return service.getMessage();
    }
}
