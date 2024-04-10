package com.helloworld.salaries.company.salary.services;

import com.helloworld.salaries.exceptions.WrongParamsException;
import com.helloworld.salaries.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployeeByCode(int codempleado);
}
