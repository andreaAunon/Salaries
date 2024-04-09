package com.helloworld.salaries.company.salary.services;

import com.helloworld.salaries.exceptions.WrongParamsException;

import java.util.List;

public interface SalaryService {

    List<Double> getSalaryByEmployeeAndYear(int employeeCode, int year) throws WrongParamsException;
}
