package ru.code4fun.demo.controller.api.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.code4fun.demo.dao.impl.jooq.tables.pojos.Employee;
import ru.code4fun.demo.service.EmployeeService;

@RequiredArgsConstructor
@RestController
public class EmployeeController {

    private final EmployeeService service;

    /**
     * Проверка работы с БД. GET используется для упрощения вызова
     */
    @GetMapping("")
    public Employee create() {
        return service.create(new Employee(null, "Василий", "Пупкин"));
    }
}
