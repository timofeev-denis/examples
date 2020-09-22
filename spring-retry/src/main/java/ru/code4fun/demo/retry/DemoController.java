package ru.code4fun.demo.retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("")
    public String runMethod() {
        logger.debug("Получен запрос на запуск retryableMethod");
        demoService.retryableMethod();
        return "Started retryableMethod";
    }
}
