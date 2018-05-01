package com.github.sttraeger.sqsdemoserver.repository;

import com.github.sttraeger.sqsdemoserver.model.Car;

public interface ICarRepository {

    Iterable<Car> getCars();

    Car getCarByVin(final String vin);

    Car createCar(final String vin, final Car car);

    Car updateExistingCar(final Car car);

    boolean deleteCar(final String vin);
}
