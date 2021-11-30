package ru.code4fun.demo.gracefulshutdown;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TimeoutController {

    @GetMapping
    public String sleep() throws InterruptedException {
        log.debug("Starting some long operation");
        Thread.sleep(5000);
        log.debug("Long operation completed");
        return "Good morning!";
    }
}
