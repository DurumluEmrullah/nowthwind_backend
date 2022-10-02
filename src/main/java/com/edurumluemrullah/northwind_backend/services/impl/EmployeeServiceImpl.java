package com.edurumluemrullah.northwind_backend.services.impl;

import com.edurumluemrullah.northwind_backend.common.results.DataResult;
import com.edurumluemrullah.northwind_backend.common.services.impl.BaseServiceImpl;
import com.edurumluemrullah.northwind_backend.daos.EmployeeDao;
import com.edurumluemrullah.northwind_backend.models.pojos.Employee;
import com.edurumluemrullah.northwind_backend.services.abstracts.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements EmployeeService {

    private final EmployeeDao employeeDao;
    public EmployeeServiceImpl( EmployeeDao employeeDao) {
        super(employeeDao);
        this.employeeDao = employeeDao;
    }

    @Override
    public DataResult<Employee> create(Employee entity) {
        entity.setId(0);
        return super.create(entity);
    }
}
