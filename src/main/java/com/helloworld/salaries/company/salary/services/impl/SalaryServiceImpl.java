package com.helloworld.salaries.company.salary.services.impl;

import com.helloworld.salaries.company.salary.services.SalaryService;
import com.helloworld.salaries.exceptions.WrongParamsException;
import com.helloworld.salaries.mapper.SalaryMapper;
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
    public List<Double> getSalaryByEmployeeAndYear(int employeeCode, int year) throws WrongParamsException {
        validateYear(year);
        return salaryMapper.getSalarioMensual(employeeCode,year);
    }

    private void validateYear(int year) throws WrongParamsException {
        if (year < this.minimalYear || year > LocalDate.now().getYear()) {
            throw new WrongParamsException("year");
        }
    }

}
