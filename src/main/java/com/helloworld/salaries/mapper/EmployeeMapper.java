package com.helloworld.salaries.mapper;

import com.helloworld.salaries.model.Employee;
import com.helloworld.salaries.model.Salary;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT * " +
            "FROM EMPLOYEE " +
            "WHERE CODEMPLEADO=#{codeempleado}")
    Employee getEmployeeByCodempleado(int codeempleado);
}
