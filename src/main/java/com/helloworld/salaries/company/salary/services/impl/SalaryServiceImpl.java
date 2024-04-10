package com.helloworld.salaries.company.salary.services.impl;

import com.helloworld.salaries.company.salary.services.EmployeeService;
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
    private SalaryMapper salaryMapper;
    private EmployeeService employeeService;

    public SalaryServiceImpl(SalaryMapper salaryMapper, EmployeeService employeeService){
        this.salaryMapper = salaryMapper;
        this.employeeService = employeeService;
    }

    @Override
    public List<Salary> getSalaryByEmployeeAndYear(int codempleado, int year) throws WrongParamsException {
        validateYear(year);
        return salaryMapper.getSalarioMensual(codempleado,year);
    }

    @Override
    public Boolean addSalaryByEmployeeAndYear(int codempleado, int year, Salary salary) throws WrongParamsException {
        if(getSalaryByEmployeeAndYear(codempleado,year).size() <= 0){
            return false;
        }

        salary.setEmployee(employeeService.getEmployeeByCode(codempleado));
        salary.setSalaryyear(year);
        salaryMapper.addSalarioMensual(salary);
        return true;
    }

    private void validateYear(int year) throws WrongParamsException {
        if (year < this.minimalYear || year > LocalDate.now().getYear()) {
            throw new WrongParamsException("year");
        }
    }

    private void addSalaries(Salary salary){
        int months = 12;
        for(int i=0; i < months; i++){
            salary.setSalarymonth(i+1);
            salaryMapper.addSalarioMensual(salary);
        }
    }
}
