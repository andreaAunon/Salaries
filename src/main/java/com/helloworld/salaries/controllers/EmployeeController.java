package com.helloworld.salaries.controllers;

import com.helloworld.salaries.company.salary.services.SalaryService;
import com.helloworld.salaries.exceptions.WrongParamsException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private SalaryService salaryService;

    public EmployeeController(SalaryService salaryService){
        this.salaryService = salaryService;
    }

    @GetMapping("/{employeeCode}/salary/{year}")
    @Operation(summary = "Salario mensual de un empleado por año")
    @Tag(
            name = "Salario medio por empleado y año",
            description = "Este controlador se encarga de la obtención de todos los salarios " +
                    "de un empleado en un año concreto"
    )
    @ApiResponses(
            value ={
                    @ApiResponse(responseCode = "200", description = "Salario medio por año"),
                    @ApiResponse(responseCode = "400", description = "El año no es válido")
            })
    public ResponseEntity<?> getSalaryByEmployeeAndYear(@PathVariable int employeeCode, @PathVariable int year) {
        List<Double> salary = null;
        try {
            salary = this.salaryService.getSalaryByEmployeeAndYear(employeeCode,year);
            return ResponseEntity.ok(salary);
        } catch (WrongParamsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
