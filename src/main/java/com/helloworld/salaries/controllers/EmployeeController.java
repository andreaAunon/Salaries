package com.helloworld.salaries.controllers;

import com.helloworld.salaries.company.salary.services.SalaryService;
import com.helloworld.salaries.exceptions.WrongParamsException;
import com.helloworld.salaries.model.Salary;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<Salary> salary = null;
        try {
            salary = this.salaryService.getSalaryByEmployeeAndYear(employeeCode,year);
            return ResponseEntity.ok(salary);
        } catch (WrongParamsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{employeeCode}/salary/{year}")
    @Operation(summary = "Crea el salario mensual para un empleado")
    @Tag(
            name = "Salario medio por empleado y año",
            description = "Este controlador se encarga de la creación de todos los salarios " +
                    "de un empleado en un año concreto"
    )
    @ApiResponses(
            value ={
                    @ApiResponse(responseCode = "200", description = "Salario medio por año"),
                    @ApiResponse(responseCode = "400", description = "El año no es válido")
            })
    public ResponseEntity<?> addSalaryByEmployeeAndYear(@PathVariable int employeeCode, @PathVariable int year,
                                                        @RequestBody Salary salary) {
       Boolean isAdd = false;
        try {
            isAdd = this.salaryService.addSalaryByEmployeeAndYear(employeeCode,year,salary);
            return ResponseEntity.ok(isAdd);
        } catch (WrongParamsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("?name=asdads&codEmployee=121&page=1")
    @Operation(summary = "Realiza una búsqueda paginada de empleados")
    @Tag(
            name = "Busca por código de empleaod y nombre",
            description = "Este controlador se encarga de hacer una búsqueda paginada de un empleado" +
                    "por su código y su nombre"
    )
    @ApiResponses(
            value ={
                    @ApiResponse(responseCode = "200", description = "Empleado"),
                    @ApiResponse(responseCode = "400", description = "El empleado no existe")
            })
    public ResponseEntity<?> getEmployeeByCodeAndName() {
        Boolean isAdd = false;
        return ResponseEntity.ok(isAdd);
    }
}
