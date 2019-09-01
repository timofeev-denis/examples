package ru.code4fun.demo.beanvalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BeanValidationApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeanValidationApplication.class, args);
    }

}
