package com.carsystem.car_system.application.usecases;

import com.carsystem.car_system.domain.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCarUseCase {
    public final CarRepository carRepository;

    @Autowired
    public DeleteCarUseCase(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void execute(UUID id) {
        carRepository.deleteById(id);
    }
}
