package ru.code4fun.demo.elksession.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final CookieSerializer cookieSerializer;

    @GetMapping("")
    public String test(HttpServletRequest servletRequest) {
        log.info("SESSION ID: {}", servletRequest.getSession().getId());
        log.info("Cookies: {}", cookieSerializer.readCookieValues(servletRequest));
        return "OK";
    }
}
