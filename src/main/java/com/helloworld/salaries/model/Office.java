package com.helloworld.salaries.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Office {

    @Schema(description = "Identificador de la oficina")
    @NotNull(message = "Campo id obligatorio")
    private int id;

    @Schema(description = "Nombre de la oficina por lugar")
    @NotNull(message = "Campo name obligatorio")
    @NotBlank
    private String name;

    @Schema(description = "Nombre de la ciudad de la oficina")
    @NotNull(message = "Campo city obligatorio")
    @NotBlank
    private String city;

    @Schema(description = "Código postal de la oficina")
    @NotNull(message = "Campo postalcode obligatorio")
    @NotBlank
    private String postalcode;

    @Schema(description = "Código del país de la oficina")
    @NotNull(message = "Campo country_code obligatorio")
    @NotBlank
    private String country_code;

    @Schema(description = "Sei la oficina es sede o no")
    @NotNull(message = "Campo headquarter obligatorio")
    private boolean headquarter;

    @Schema(description = "Continente de la oficina")
    @NotNull(message = "Campo continent obligatorio")
    @NotBlank
    private String continent;

    @Schema(description = "Identificador de la región de la oficina")
    @NotNull(message = "Campo id_region obligatorio")
    private int id_region;
}
