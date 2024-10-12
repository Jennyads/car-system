package com.carsystem.car_system.adapters.persistence;

import com.carsystem.car_system.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaCarRepository extends JpaRepository<Car, UUID> {
    List<Car> findByBrand(String brand);
}
