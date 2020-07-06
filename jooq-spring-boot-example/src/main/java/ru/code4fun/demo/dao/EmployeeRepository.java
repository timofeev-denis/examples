package ru.code4fun.demo.dao;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.code4fun.demo.dao.impl.jooq.tables.daos.EmployeeDao;

@Repository
public class EmployeeRepository extends EmployeeDao {

    @Autowired
    public EmployeeRepository(DSLContext context) {
        super(context.configuration());
    }

}
