package com.car.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.api.dto.CarDTO;

@RestController
@RequestMapping("/car")
public class CarController {
  @PostMapping
  public void postCar(@RequestBody CarDTO req) {
    System.out.println(req);
    System.out.println("Ano do Modelo: " + req.anoModelo());
    System.out.println("Ano de Fabricação: " + req.dataFabricacao());
  }
}
