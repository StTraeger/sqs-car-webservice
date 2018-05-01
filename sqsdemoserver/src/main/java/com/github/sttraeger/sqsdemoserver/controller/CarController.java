package com.github.sttraeger.sqsdemoserver.controller;

import com.github.sttraeger.sqsdemoserver.model.Car;
import com.github.sttraeger.sqsdemoserver.repository.ICarRepository;
import org.springframework.web.bind.annotation.*;

/**
 * @author sttraeger
 * Controller for handling the requests to the server. No need to update this class because it is designed so that
 * it will only use the interface ICarRepository. The implementation laying behing can be changed everytime.
 */
@RestController
public class CarController {

    private ICarRepository carRepository;

    public CarController(ICarRepository iCarRepository) {
        carRepository = iCarRepository;
    }

    /**
     * Returns an Iterable of all cars stored in the repository.
     *
     * @return all cars as Iterable
     */
    @GetMapping("/cars")
    public Iterable<Car> getAllCars() {
        return carRepository.getCars();
    }

    /**
     * Returns a specific car identified by the given vin.
     *
     * @param vin the unique vin
     * @return the car if it exists, null instead
     */
    @GetMapping("/cars/{vin}")
    public Car getCarByVin(@PathVariable("vin") String vin) {
        return carRepository.getCarByVin(vin);
    }

    /**
     * Stores a new car in the repository.
     *
     * @param car the car to be stored
     * @return the new created car in the repository
     */
    @PostMapping("/cars")
    public Car createNewCar(@RequestBody Car car) {
        return carRepository.createCar(car.getVin(), car);
    }

    /**
     * Updates an existing car in the repository.
     *
     * @param car the car to update
     * @return the updated car or null if no car was found
     */
    @PutMapping("/cars")
    public Car updateExistingCar(@RequestBody Car car) {
        return carRepository.updateExistingCar(car);
    }

    /**
     * Deletes a car (if exists) with a given vin.
     *
     * @param vin the unique vin
     * @return true if the car could be deleted, false instead
     */
    @DeleteMapping("/cars/{vin}")
    public boolean deleteExistingCar(@PathVariable("vin") String vin) {
        return carRepository.deleteCar(vin);
    }
}
