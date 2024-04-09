package com.helloworld.salaries.controllers;

import com.helloworld.salaries.company.salary.services.AvgSalaryService;
import com.helloworld.salaries.exceptions.WrongParamsException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final AvgSalaryService avgSalaryService;

    public CompanyController(AvgSalaryService avgSalaryService) {
        this.avgSalaryService = avgSalaryService;
    }

    @GetMapping("/salary/{year}/avg")
    @Operation(summary = "Salario medio")
    @Tag(
            name = "Salario medio por año",
            description = "Este controlador se encarga de la obtención del salario medio de un año concreto"
    )
    @ApiResponses(
            value ={
                    @ApiResponse(responseCode = "200", description = "Salario medio por año"),
                    @ApiResponse(responseCode = "400", description = "El año no es válido")
            })
    public ResponseEntity<?> getAvgSalary(@PathVariable int year) {
        Double avgSalary = null;
        try {
            avgSalary = this.avgSalaryService.getAvgSalary(year);
            return ResponseEntity.ok(avgSalary);
        } catch (WrongParamsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
