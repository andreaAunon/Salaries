package com.helloworld.salaries.mapper;

import com.helloworld.salaries.model.Salary;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SalaryMapper {

    @Select("SELECT SALARY " +
            "FROM SALARY " +
            "INNER JOIN EMPLOYEE ON SALARY.CODEMPLEADO = EMPLOYEE.#{codeempleado} " +
            "WHERE SALARYYEAR=#{year}")
    List<Salary> getSalarioMensual(int codeempleado, int year);

    @Insert("INSERT INTO SALARY () VALUES ()")
    Boolean addSalarioMensual (int codeempleado, int year);
}
