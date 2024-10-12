package com.carsystem.car_system.application.usecases;

import com.carsystem.car_system.domain.entities.Car;
import com.carsystem.car_system.domain.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateCarUseCase {
    private final CarRepository carRepository;

    @Autowired
    public CreateCarUseCase(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car execute(String brand, String model, int year, String color, String licensePlate, double price) {
        Car car = new Car(UUID.randomUUID(), brand, model, year, color, licensePlate, price);
        return carRepository.createCar(car);
    }
}
