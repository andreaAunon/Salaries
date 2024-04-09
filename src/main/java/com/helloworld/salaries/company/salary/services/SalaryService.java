package com.helloworld.salaries.company.salary.services;

import com.helloworld.salaries.exceptions.WrongParamsException;
import com.helloworld.salaries.model.Salary;

import java.util.List;

public interface SalaryService {

    List<Salary> getSalaryByEmployeeAndYear(int employeeCode, int year) throws WrongParamsException;
    Boolean addSalaryByEmployeeAndYear(int employeeCode, int year) throws WrongParamsException;
}
