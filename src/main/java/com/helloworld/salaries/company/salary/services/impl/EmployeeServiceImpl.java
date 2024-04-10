package com.helloworld.salaries.company.salary.services.impl;

import com.helloworld.salaries.company.salary.services.EmployeeService;
import com.helloworld.salaries.mapper.EmployeeMapper;
import com.helloworld.salaries.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper){
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Employee getEmployeeByCode(int codempleado) {
        return null;
    }
}
