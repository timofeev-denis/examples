package ru.code4fun.demo.configuration;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@Log4j2
@SpringBootApplication
public class ConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(Environment environment,
                                        @Value("${HOME}") String userHome,
                                        @Value("${message-from-program-args:}") String messageFromProgramArgs,
                                        @Value("${greeting-message:Default message: ${message-from-application-properties}}") String defaultValue) {

        return args -> {
            log.info("Message from application.properties: " + environment.getProperty("message-from-application-properties"));
            log.info("Default value from from application.properties: " + defaultValue);
            log.info("User home from environment HOME variable: " + userHome);
            log.info("Message from program args: " + messageFromProgramArgs);
        };
    }
}
