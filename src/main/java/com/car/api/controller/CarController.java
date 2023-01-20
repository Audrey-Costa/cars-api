package com.car.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.api.dto.CarDTO;
import com.car.api.model.Car;
import com.car.api.repository.CarRepository;
import com.car.api.service.CarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/car")
public class CarController {

  @Autowired
  private CarService service;

  @GetMapping
  public List<Car> listAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Car> ListCarById(@PathVariable Long id) {
    return service.findCarById(id);
  }

  @PostMapping
  public void postCar(@RequestBody @Valid CarDTO req) {
    service.createCar(req);
  }

  @PutMapping("/{id}")
  public void updateCar(@PathVariable Long id, @RequestBody @Valid CarDTO req){
    service.updateCarById(id, req);
  }

  @DeleteMapping("/{id}")
  public void deleteCar(@PathVariable Long id) {
    service.deleteCarById(id);
  }
}
