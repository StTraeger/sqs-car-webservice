package com.github.sttraeger.sqsdemoserver.controller;

import com.github.sttraeger.sqsdemoserver.model.Car;
import com.github.sttraeger.sqsdemoserver.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @author sttraeger
 * Controller for handling the requests to the server. No need to update this class because it is designed so that
 * it will only use the interface ICarRepository. The implementation laying behing can be changed everytime.
 */
@RestController
public class CarController {

    private final ICarRepository carRepository;

    public CarController(@Qualifier("postgresCarRepository") ICarRepository iCarRepository) {
        this.carRepository = iCarRepository;
    }

    List<Car> cars = new ArrayList<>();

    /**
     * Returns an Iterable of all cars stored in the repository.
     *
     * @return all cars as Iterable
     */
    @GetMapping("/cars")
    public Iterable<Car> getAllCars() {
        return this.carRepository.getCars();
    }

    /**
     * Returns a specific car identified by the given vin.
     *
     * @param vin the unique vin
     * @return the car if it exists, null instead
     */
    @GetMapping("/cars/{vin}")
    public ResponseEntity getCarByVin(@PathVariable("vin") String vin) {
        return this.carRepository.getCarByVin(vin);
    }

    /**
     * Stores a new car in the repository.
     *
     * @param car the car to be stored
     * @return the new created car in the repository
     */
    @PostMapping("/cars")
    public ResponseEntity createNewCar(@RequestBody Car car) {
        return this.carRepository.createCar(car.getVin(), car);
    }

    /**
     * Updates an existing car in the repository.
     *
     * @param car the car to update
     * @return the updated car or null if no car was found
     */
    @PutMapping("/cars")
    public ResponseEntity updateExistingCar(@RequestBody Car car) {
        return this.carRepository.updateExistingCar(car);
    }

    @DeleteMapping("/cars/{vin}")
    public boolean deleteExistingCar(@PathVariable("vin") String vin) {
        return this.carRepository.deleteCar(vin);
    }
}
