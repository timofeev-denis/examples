package ru.code4fun.demo.togglz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.manager.FeatureManager;

import static ru.code4fun.demo.togglz.config.ApplicationFeatures.MESSAGE_A;

@RestController
public class HelloController {

    private FeatureManager featureManager;

    public HelloController(FeatureManager featureManager) {
        this.featureManager = featureManager;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return getMessage();
    }

    private String getMessage() {
        if (featureManager.isActive(MESSAGE_A)) {
            return "Message A";
        }
        return "Default message";
    }
}
