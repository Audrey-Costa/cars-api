package com.car.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.api.dto.CarDTO;
import com.car.api.model.Car;
import com.car.api.repository.CarRepository;

@Service
public class CarService {
  
  @Autowired
  private CarRepository repository;

  public Optional<Car> findCarById(Long id) {
    return repository.findById(id);
  }

  public List<Car> findAll() {
    return repository.findAll();
  }

  public Car createCar(CarDTO req) {
    return repository.save(new Car(req));
  }

  public Optional<Car> updateCarById(Long id, CarDTO req) {
   return (repository.findById(id).map(car -> {
      car.setModelo(req.modelo());
      car.setAnoModelo(req.anoModelo());
      car.setDataFabricacao(req.dataFabricacao());
      car.setFabricante(req.fabricante());
      car.setValor(req.valor());
      return repository.save(car);
    }));
  }

  public void deleteCarById(Long id) {
    repository.deleteById(id);
  }
}
