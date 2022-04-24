package ru.code4fun.demo.ff4j;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public String generateMessage() {
        return "Hello";
    }
}
