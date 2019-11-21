package ru.code4fun.demo.cars.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

/**
 * Created by: Denis Timofeev
 * Date: 22.11.2019
 */

@Configuration
public class RedisConfig {

    @Bean
    protected LettuceConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }
}
