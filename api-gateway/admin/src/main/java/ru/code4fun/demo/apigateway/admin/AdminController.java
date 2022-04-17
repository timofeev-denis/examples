package ru.code4fun.demo.apigateway.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/private")
    public String makePrivateStuff() {
        return "Hello from private area!";
    }
}
