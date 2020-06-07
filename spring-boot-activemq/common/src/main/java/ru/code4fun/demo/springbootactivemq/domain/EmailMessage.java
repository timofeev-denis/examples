package ru.code4fun.demo.springbootactivemq.domain;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailMessage {

    @Email
    private String to;

    @NotBlank
    private String body;
}
