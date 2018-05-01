package com.github.sttraeger.sqsdemoserver.controller;

import com.github.sttraeger.sqsdemoserver.model.Car;
import com.github.sttraeger.sqsdemoserver.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class CarController {

    private ICarRepository carRepository;

    public CarController(ICarRepository iCarRepository){
        this.carRepository = iCarRepository;
    }

    List<Car> cars = new ArrayList<>();

    @GetMapping("/cars")
    public Iterable<Car> getAllCars() {
        return carRepository.getCars();
    }

    @GetMapping("/cars/{vin}")
    public Car getCarByVin(@PathVariable("vin") String vin){
        return carRepository.getCarByVin(vin);
    }
}
