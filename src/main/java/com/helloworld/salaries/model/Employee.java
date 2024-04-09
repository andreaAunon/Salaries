package com.helloworld.salaries.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class Employee {

    @Schema(description = "Identificador del empleado")
    @NotNull(message = "Campo codempleado obligatorio")
    private int codempleado;

    @Schema(description = "Nombre del empleado")
    @NotNull(message = "Campo nombreempleado obligatorio")
    @NotBlank
    private String nombreeempleado;

    @Schema(description = "Fecha de inicio en el trabajo")
    @NotNull(message = "Campo fechainicio obligatorio")
    private Date fechainicio;

    @Schema(description = "Fecha de baja del trabajo")
    @NotNull(message = "Campo fechabaja obligatorio")
    private Date fechabaja;

    @Schema(description = "Oficina asignada al empleado")
    @NotNull(message = "Campo office obligatorio")
    private Office office;

    @Schema(description = "Categoria por salario")
    @NotNull(message = "Campo categoria obligatorio")
    @NotBlank
    private String categoria;

}
