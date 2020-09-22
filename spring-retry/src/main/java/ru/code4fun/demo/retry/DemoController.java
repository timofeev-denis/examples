package ru.code4fun.demo.retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.RetryContext;
import org.springframework.retry.backoff.*;
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

    @GetMapping("")
    public String runMethod() {
        logger.debug("Получен запрос на запуск retryableMethod");
        BackOffPolicy customBackoff = new BackOffPolicy() {
            private Sleeper sleeper = new ThreadWaitSleeper();

            @Override
            public BackOffContext start(RetryContext context) {
                return new CustomBackOffContext();
            }

            @Override
            public void backOff(BackOffContext backOffContext) throws BackOffInterruptedException {
                final CustomBackOffContext context = (CustomBackOffContext) backOffContext;
                try {
                    sleeper.sleep(calculateSleepTime(context.getAttempt()));
                } catch (InterruptedException e) {
                    throw new BackOffInterruptedException("Thread interrupted while sleeping", e);
                }
            }

            private long calculateSleepTime(Integer attempt) {
                if (attempt < 5) {
                    return 100L;
                } else {
                    return 1000L;
                }
            }
        };

        RetryTemplate template = RetryTemplate.builder()
                .maxAttempts(10)
                .customBackoff(customBackoff)
                .build();

        template.execute(ctx -> {
            logger.debug("Попытка выполнения");
            throw new RuntimeException("Штатная неудачная обработка");
        }, ctx -> {
            logger.debug("Всё тщетно");
            return true;
        });

        return "finish";
    }

    class CustomBackOffContext implements BackOffContext {
        private Integer attempt = 0;

        public Integer getAttempt() {
            return this.attempt++;
        }
    }
}
