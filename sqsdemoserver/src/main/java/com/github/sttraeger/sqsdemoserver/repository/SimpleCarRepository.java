package com.github.sttraeger.sqsdemoserver.repository;

import com.github.sttraeger.sqsdemoserver.model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sttraeger
 * Simple implemenation of a car repository. Data is stored in an ArrayList. For testing purposes only.
 */
@Component
public class SimpleCarRepository implements ICarRepository {

    private static List<Car> cars = new ArrayList<>();

    /**
     * Constructor initializes the underlying ArrayList with sample cars.
     */
    public SimpleCarRepository() {
        cars.add(new Car("123456", "BMW", "X1", 150, new Date(2018, 4, 30), 200));
        cars.add(new Car("456123", "Fiat", "Punto", 69, new Date(2012, 10, 11), 20000));
        cars.add(new Car("654321", "Ford", "Focus", 105, new Date(1999, 10, 11), 250441));
    }

    /**
     * Returns all cars from the ArrayList 'cars'.
     *
     * @return all cars as Iterable
     */
    @Override
    public Iterable<Car> getCars() {
        return cars;
    }

    /**
     * Returns a specific car from the list, identified by the vin.
     *
     * @param vin the unique vin
     * @return the car or null if the car doesn't exist
     */
    @Override
    public Car getCarByVin(String vin) {
        for (Car car : cars) {
            if (vin.equals(car.getVin())) {
                return car;
            }
        }
        return null;
    }

    /**
     * Adds a new car to the list if the given vin doesn't already exist in list.
     *
     * @param vin the unique vin
     * @param car the new car
     * @return the new created car or null if there was already a car with the given vin in the list
     */
    @Override
    public Car createCar(String vin, Car car) {
        if (!isCarAlreadyExisting(vin)) {
            cars.add(car);
            return car;
        }
        return null;
    }

    /**
     * Updates an existing car in the list. Removes it first and adds it new to the list(workflow for ArrayList).
     *
     * @param car the car to be updated
     * @return the updated car or null if no car with the vin was found
     */
    @Override
    public Car updateExistingCar(Car car) {
        if (!isCarAlreadyExisting(car.getVin())) {
            return null;
        }
        for (Car actualCar : cars) {
            if (actualCar.getVin().equals(car.getVin())) {
                cars.remove(actualCar);
                cars.add(car);
            }
        }
        return car;
    }

    /**
     * Deletes a car specified by the vin.
     *
     * @param vin the unique vin
     * @return true if car was deleted, false instead
     */
    @Override
    public boolean deleteCar(String vin) {
        if (!isCarAlreadyExisting(vin)) {
            return false;
        }
        for (Car actualCar : cars) {
            if (actualCar.getVin().equals(vin)) {
                cars.remove(actualCar);
            }
        }
        return true;
    }

    /**
     * Checks wether a car to a given vin already exists in data-storage.
     *
     * @param vin the vin to check
     * @return true if car already exists in db, false instead
     */
    private boolean isCarAlreadyExisting(final String vin) {
        for (Car car : cars) {
            if (car.getVin().equals(vin)) {
                return true;
            }
        }
        return false;
    }
}
