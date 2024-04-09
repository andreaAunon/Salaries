package com.helloworld.salaries.company.salary.services.impl;

import com.helloworld.salaries.company.salary.services.SalaryService;
import com.helloworld.salaries.exceptions.WrongParamsException;
import com.helloworld.salaries.mapper.SalaryMapper;
import com.helloworld.salaries.model.Salary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    private final int minimalYear = 2000;
    private final SalaryMapper salaryMapper;

    public SalaryServiceImpl(SalaryMapper salaryMapper){
        this.salaryMapper = salaryMapper;
    }

    @Override
    public List<Salary> getSalaryByEmployeeAndYear(int employeeCode, int year) throws WrongParamsException {
        validateYear(year);
        return salaryMapper.getSalarioMensual(employeeCode,year);
    }

    @Override
    public Boolean addSalaryByEmployeeAndYear(int employeeCode, int year) throws WrongParamsException {
        if(getSalaryByEmployeeAndYear(employeeCode,year).size() <= 0){
            return false;
        }

        salaryMapper.addSalarioMensual(employeeCode,year);
        return true;
    }

    private void validateYear(int year) throws WrongParamsException {
        if (year < this.minimalYear || year > LocalDate.now().getYear()) {
            throw new WrongParamsException("year");
        }
    }

    private void addSalaries(int employeeCode, int year){
        int months = 12;
        for(int i=0; i < months; i++){
            Salary salary = new Salary();

        }
    }
}
