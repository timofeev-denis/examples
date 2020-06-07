package ru.code4fun.demo.springbootactivemq.domain;

import lombok.Data;

@Data
public class EmailMessage {
    private String to;
    private String body;
}
