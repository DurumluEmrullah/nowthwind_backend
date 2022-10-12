package com.edurumluemrullah.northwind_backend.controllers;

import com.edurumluemrullah.northwind_backend.common.controller.BaseController;
import com.edurumluemrullah.northwind_backend.models.pojos.Employee;
import com.edurumluemrullah.northwind_backend.services.abstracts.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController extends BaseController<Employee> {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        super(employeeService);
        this.employeeService = employeeService;
    }
}
