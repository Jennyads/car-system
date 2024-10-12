package com.carsystem.car_system.adapters.persistence;

import com.carsystem.car_system.domain.entities.Car;
import com.carsystem.car_system.domain.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CarRepositoryImpl implements CarRepository {
    private final JpaCarRepository jpaCarRepository;

    @Autowired
    public CarRepositoryImpl(JpaCarRepository jpaCarRepository) {
        this.jpaCarRepository = jpaCarRepository;
    }


    @Override
    public Car createCar(Car car) {
        if (jpaCarRepository.existsById(car.getId())) {
            throw new IllegalArgumentException("Car with ID " + car.getId() + " already exists.");
        }
        return jpaCarRepository.save(car);
    }

    @Override
    public Car updateCar(Car car) {
        if (!jpaCarRepository.existsById(car.getId())) {
            throw new IllegalArgumentException("Car with ID " + car.getId() + " does not exist.");
        }
        return jpaCarRepository.save(car);
    }

    @Override
    public Optional<Car> findById(UUID id) {
        return jpaCarRepository.findById(id);
    }

    @Override
    public List<Car> findAll() {
        return jpaCarRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        jpaCarRepository.deleteById(id);

    }

    @Override
    public List<Car> findByBrand(String brand) {
        return jpaCarRepository.findByBrand(brand);
    }
}
