package com.helloworld.salaries.company.salary.services.impl;

import com.helloworld.salaries.company.salary.services.AvgSalaryService;
import com.helloworld.salaries.exceptions.WrongParamsException;
import com.helloworld.salaries.mapper.AvgSalaryMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AvgSalaryServiceImpl implements AvgSalaryService {

        private final int minimalYear = 2000;
        private final AvgSalaryMapper avgSalaryMapper;

        public AvgSalaryServiceImpl(AvgSalaryMapper avgSalaryMapper){
            this.avgSalaryMapper = avgSalaryMapper;
        }

        @Override
        public double getAvgSalary(int year) throws WrongParamsException {
            validateYear(year);
            return avgSalaryMapper.getAvgSalary(year);
        }

        private void validateYear(int year) throws WrongParamsException {
            if (year < this.minimalYear || year > LocalDate.now().getYear()) {
                throw new WrongParamsException("year");
            }
        }


}
