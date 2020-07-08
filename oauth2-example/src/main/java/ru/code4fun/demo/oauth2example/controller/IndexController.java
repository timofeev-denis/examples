package ru.code4fun.demo.oauth2example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("")
    public String hello() {
        return "Hello";
    }
}
