package com.helloworld.salaries.company.salary.services;

import com.helloworld.salaries.exceptions.WrongParamsException;
import com.helloworld.salaries.model.Salary;

import java.util.List;

public interface SalaryService {

    List<Salary> getSalaryByEmployeeAndYear(int codempleado, int year) throws WrongParamsException;
    Boolean addSalaryByEmployeeAndYear(int codempleado, int year, Salary salary) throws WrongParamsException;
}
