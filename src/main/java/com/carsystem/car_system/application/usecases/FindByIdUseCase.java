package com.carsystem.car_system.application.usecases;

import com.carsystem.car_system.domain.entities.Car;
import com.carsystem.car_system.domain.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FindByIdUseCase {
    public final CarRepository carRepository;

    public FindByIdUseCase(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Optional<Car> execute(UUID id) {
        return carRepository.findById(id);
    }

}
