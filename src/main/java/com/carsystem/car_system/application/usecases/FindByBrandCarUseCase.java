package com.carsystem.car_system.application.usecases;

import com.carsystem.car_system.domain.entities.Car;
import com.carsystem.car_system.domain.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindByBrandCarUseCase {
    private final CarRepository carRepository;

    @Autowired
    public FindByBrandCarUseCase(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> execute(String brand) {
        return carRepository.findByBrand(brand);
    }
}
