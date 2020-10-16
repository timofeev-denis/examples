package ru.code4fun.demo.featuretoggle.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public String getOldMessage() {
        return "OLD Hello !";
    }

    public String getNewMessage() {
        return "NEW Hello !";
    }
}
