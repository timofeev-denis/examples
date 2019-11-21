package ru.code4fun.demo.cars.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by: Denis Timofeev
 * Date: 29.10.2019
 */

@RestController
public class RootController {

    @GetMapping("")
    public ResponseEntity<String> hello(HttpSession session) {
        return ResponseEntity.ok("Hello, " + session.getId());
    }

    @GetMapping("/profile")
    public ResponseEntity<String> profile(HttpSession session) {
        return ResponseEntity.ok("PROFILE " + session.getId() + " " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

}
