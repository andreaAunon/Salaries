package com.helloworld.salaries.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AvgSalaryMapper {

    @Select("SELECT AVG(SALARY) FROM SALARY WHERE SALARYYEAR=#{year}")
    double getAvgSalary(int year);
}
