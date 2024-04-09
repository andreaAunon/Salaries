package com.helloworld.salaries.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class Salary {

    @Schema(description = "Identificador del salario")
    @NotNull(message = "Campo id obligatorio")
    private int id;

    @Schema(description = "Identificador del empleado asociado al salario")
    @NotNull(message = "Campo employee obligatorio")
    private Employee employee;

    @Schema(description = "Coste por hora del empleado")
    @NotNull(message = "Campo costehora obligatorio")
    @Positive
    @Min(value = 0)
    private int costehora;

    @Schema(description = "Salari total por mes del empleado")
    @NotNull(message = "Campo salary obligatorio")
    @Min(value = 0)
    @Positive
    private double salary;

    @Schema(description = "Mes del salario")
    @NotNull(message = "Campo salarymoth obligatorio")
    @Min(value = 1)
    @Max(value = 12)
    @Size(min = 1, max = 12)
    @Positive
    private int salarymonth;

    @Schema(description = "Año del salario")
    @NotNull(message = "Campo salaryyear obligatorio")
    @Min(value = 2000)
    @Positive
    private int salaryyear;
}
