package ru.code4fun.demo.logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.code4fun.demo.logging.aspect.LogExecutionTime;

@Slf4j
@RestController
public class RootController {

    @GetMapping("")
    @LogExecutionTime
    public String hello() {
        log.trace("Some text to log");
        return "Hello";
    }
}
