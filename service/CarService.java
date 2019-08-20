package com.gl.hibernate.service;

import com.gl.hibernate.model.Car;

import java.util.List;

public interface CarService {
    Car addCar(Car car);

    List<Car> displayCars();

    void deleteCar(Long carId);
}
