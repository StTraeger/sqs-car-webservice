package com.github.sttraeger.sqsdemoserver.repository;

import com.github.sttraeger.sqsdemoserver.model.Car;
import org.springframework.stereotype.Service;

public interface ICarRepository {

    public Iterable<Car> getCars();
    public Car getCarByVin(final String vin);
    public Car createCar(final String vin, final Car car);
    public Car updateCar(final Car car);
    public boolean deleteCar(final String vin);
}
