package com.car.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

public record CarDTO(
@NotBlank  
String modelo, 

@NotBlank
String fabricante, 

@Past @NotNull
Date dataFabricacao, 

@NotNull @Positive
BigDecimal valor, 

@NotNull @Min(value = 2000)
int anoModelo) {
  
}
