package com.example.shop;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import static java.util.Optional.ofNullable;

@RestController
public class HelloController {

    @GetMapping
    public String sayHello() {
        return "Hello " + getUserName();
    }

    private String getUserName() {
        return ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(a -> (Principal) a)
                .map(Principal::getName)
                .orElse("Anonymous");
    }
}
