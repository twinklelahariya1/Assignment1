package com.gl.hibernate.controller;


import com.gl.hibernate.model.Car;
import com.gl.hibernate.model.User;
import com.gl.hibernate.service.impl.CarServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private final CarServiceImpl carServiceImpl;


    public CarController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }


    @GetMapping("/showCar")
    public ResponseEntity<List> displayCar(){
        return ResponseEntity.ok(carServiceImpl.displayCars());
    }


    @PostMapping("/addCar")
    public ResponseEntity<User> addCar(@RequestBody Car car){
        Car updated = carServiceImpl.addCar(car);
        return new ResponseEntity(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteCar/{carId}")
    public HttpStatus deleteCar(@PathVariable("carId") Long carId) {
        carServiceImpl.deleteCar(carId);
        return HttpStatus.FORBIDDEN;
    }
}
