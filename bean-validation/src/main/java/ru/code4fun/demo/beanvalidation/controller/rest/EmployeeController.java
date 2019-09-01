package ru.code4fun.demo.beanvalidation.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.code4fun.demo.beanvalidation.dto.EmployeeDto;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class EmployeeController {

    @PostMapping("/employees")
    public ResponseEntity<Void> add(@RequestBody @Valid EmployeeDto dto) {
        // Сохранение...
        return ResponseEntity.ok().build();
    }
}
