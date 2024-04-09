package com.helloworld.salaries.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SalaryMapper {

    @Select("SELECT SALARY " +
            "FROM SALARY " +
            "INNER JOIN EMPLOYEE ON SALARY.CODEMPLEADO = EMPLOYEE.#{codeempleado} " +
            "WHERE SALARYYEAR=#{year}")
    List<Double> getSalarioMensual(int codeempleado, int year);
}
