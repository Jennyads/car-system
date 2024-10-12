package com.carsystem.car_system.domain.repositories;

import com.carsystem.car_system.domain.entities.Car;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

public interface CarRepository {

    Car createCar(Car car);

    Car updateCar(Car car);

    Optional<Car> findById(UUID id);

    List<Car> findAll();

    void deleteById(UUID id);

    List<Car> findByBrand(String brand);

}
