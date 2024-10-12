package com.carsystem.car_system.adapters.rest;

import com.carsystem.car_system.application.usecases.*;
import com.carsystem.car_system.domain.entities.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CreateCarUseCase createCarUseCase;
    private final UpdateCarUseCase updateCarUseCase;
    private final DeleteCarUseCase deleteCarUseCase;
    private final FindByIdUseCase findByIdUseCase;
    private final ListAllCarUseCase listAllCarUseCase;
    private final FindByBrandCarUseCase findByBrandCarUseCase;

    public CarController(CreateCarUseCase createCarUseCase, UpdateCarUseCase updateCarUseCase, DeleteCarUseCase deleteCarUseCase, FindByIdUseCase findByIdUseCase, ListAllCarUseCase listAllCarUseCase, FindByBrandCarUseCase findByBrandCarUseCase) {
        this.createCarUseCase = createCarUseCase;
        this.updateCarUseCase = updateCarUseCase;
        this.deleteCarUseCase = deleteCarUseCase;
        this.findByIdUseCase = findByIdUseCase;
        this.listAllCarUseCase = listAllCarUseCase;
        this.findByBrandCarUseCase = findByBrandCarUseCase;
    }


    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car createdCar = createCarUseCase.execute(car.getBrand(), car.getModel(), car.getYear(), car.getColor(), car.getLicensePlate(), car.getPrice());
        return ResponseEntity.ok(createdCar);
    }


    @GetMapping
    public ResponseEntity<List<Car>> listAllCars() {
        List<Car> cars = listAllCarUseCase.execute();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findCarById(@PathVariable UUID id) {
        return findByIdUseCase.execute(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Car>> findCarsByBrand(@PathVariable String brand) {
        List<Car> cars = findByBrandCarUseCase.execute(brand);
        return ResponseEntity.ok(cars);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable UUID id, @RequestBody Car car) {
        Car updatedCar = updateCarUseCase.execute(id, car.getBrand(), car.getModel(), car.getYear(), car.getColor(), car.getLicensePlate(), car.getPrice());
        return ResponseEntity.ok(updatedCar);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable UUID id) {
        deleteCarUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

}

