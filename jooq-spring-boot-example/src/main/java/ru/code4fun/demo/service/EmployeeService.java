package ru.code4fun.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.code4fun.demo.dao.EmployeeRepository;
import ru.code4fun.demo.dao.impl.jooq.tables.pojos.Employee;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public Employee create(Employee employee) {
        repository.insert(employee);
        return employee;
    }
}
