package com.gl.hibernate.service.impl;

import com.gl.hibernate.model.Car;
import com.gl.hibernate.repository.CarRepository;
import com.gl.hibernate.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarServiceImpl implements CarService {

    private  final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car addCar(Car car) {
        car = carRepository.save(car);
        return car;
    }

    @Override
    public List<Car> displayCars() {
        return carRepository.findAll();
    }

    @Override
    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }
}
