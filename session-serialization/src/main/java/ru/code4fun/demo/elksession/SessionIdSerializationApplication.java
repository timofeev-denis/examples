package ru.code4fun.demo.elksession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
public class SessionIdSerializationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SessionIdSerializationApplication.class, args);
    }

}
