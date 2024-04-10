package com.helloworld.salaries.mapper;

import com.helloworld.salaries.model.Salary;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SalaryMapper {

    @Select("SELECT SALARY " +
            "FROM SALARY S " +
            "INNER JOIN EMPLOYEE E ON S.CODEMPLEADO = E.#{codeempleado} " +
            "WHERE S.SALARYYEAR=#{year}")
    List<Salary> getSalarioMensual(int codempleado, int year);

    @Insert("INSERT INTO SLARY (id, codempleado, costehora, nombreempleado, salary, salarymonth, salaryyear) " +
            "VALUES (#{salary.id, #{salary.employee.codempleado}, #{salary.costehora}, " +
            "#{salary.employee.codempleado}, #{salary.salary}, #{salary.salarymonth}, #{salary.salaryyear})")
    Boolean addSalarioMensual (Salary salary);
}
