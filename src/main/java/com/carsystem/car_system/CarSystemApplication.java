package com.carsystem.car_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.carsystem.car_system")
public class CarSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarSystemApplication.class, args);
	}

}
