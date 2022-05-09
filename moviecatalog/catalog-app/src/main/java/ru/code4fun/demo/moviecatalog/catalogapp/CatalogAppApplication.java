package ru.code4fun.demo.moviecatalog.catalogapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CatalogAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogAppApplication.class, args);
    }

}
