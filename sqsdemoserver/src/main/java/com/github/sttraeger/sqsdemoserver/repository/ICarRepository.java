package com.github.sttraeger.sqsdemoserver.repository;

import com.github.sttraeger.sqsdemoserver.model.Car;

/**
 * @author sttrae
 * Interface for database operations.
 */
public interface ICarRepository {

    /**
     * Return all cars from database.
     * @return all Cars as Iterable<Car>
     */
    Iterable<Car> getCars();

    /**
     * Returns a specific car with a given vin.
     * @param vin the unique vin
     * @return the car or null if no car was found
     */
    Car getCarByVin(final String vin);

    /**
     * Create and store a new car.
     * @param vin the unique vin of the new car
     * @param car the new car
     * @return the car if it was stored successfully, null instead
     */
    Car createCar(final String vin, final Car car);

    /**
     * Updates an existing car in the database.
     * @param car the car to be update
     * @return the updated car or null if no car was found
     */
    Car updateExistingCar(final Car car);

    /**
     * Deletes a car with a given vin.
     * @param vin the unique vin
     * @return true if car was successfully deleted, false instead
     */
    boolean deleteCar(final String vin);
}
