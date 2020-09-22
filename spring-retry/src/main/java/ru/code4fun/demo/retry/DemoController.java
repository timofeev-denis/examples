package ru.code4fun.demo.retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/multiplier")
    public String multiplierDelay() {
        demoService.retryableMethod();
        return "Finish";
    }

    @GetMapping("/custom")
    public String customDelay() {
        RetryTemplate template = RetryTemplate.builder()
                .maxAttempts(10)
                .customBackoff(new IncreasingDelayBackOffPolicy())
                .build();

        template.execute(ctx -> {
            logger.debug("Trying to execute...");
            throw new RuntimeException("Unsuccessful processing");
        }, ctx -> {
            logger.debug("All retries failed");
            return true;
        });

        return "Finish";
    }

}
