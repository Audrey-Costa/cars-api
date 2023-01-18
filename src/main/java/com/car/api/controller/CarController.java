package com.car.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.api.dto.CarDTO;
import com.car.api.model.Car;
import com.car.api.repository.CarRepository;

@RestController
@RequestMapping("/car")
public class CarController {

  @Autowired
  private CarRepository repository;

  @PostMapping
  public void postCar(@RequestBody CarDTO req) {
    repository.save(new Car(req));
  }
}
