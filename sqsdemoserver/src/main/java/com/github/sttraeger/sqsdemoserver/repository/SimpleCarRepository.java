package com.github.sttraeger.sqsdemoserver.repository;

import com.github.sttraeger.sqsdemoserver.model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class SimpleCarRepository implements ICarRepository {

    private static List<Car> cars = new ArrayList<>();

    public SimpleCarRepository() {
        cars.add(new Car("123456", "BMW", "X1", 150, new Date(2018, 04, 30), 200));
        cars.add(new Car("456123", "Fiat", "Punto", 69, new Date(2012, 10, 11), 20000));
        cars.add(new Car("654321", "Ford", "Focus", 105, new Date(1999, 10, 11), 250441));
    }

    @Override
    public Iterable<Car> getCars() {
        return cars;
    }

    @Override
    public Car getCarByVin(String vin) {
        for(Car car: cars){
            if(vin.equals(car.getVin()))
                return car;
        }
        return null;
    }

    @Override
    public Car createCar(String vin, Car car) {
        cars.add(car);
        return car;
    }

    @Override
    public Car updateCar(Car car) {
        for (Car actualCar : cars) {
            if (actualCar.getVin().equals(car.getVin())) {
                cars.remove(actualCar);
                cars.add(car);
                return car;
            }
        }
        return null;
    }

    @Override
    public boolean deleteCar(String vin) {
        for (Car actualCar : cars) {
            if (actualCar.getVin().equals(actualCar.getVin())) {
                cars.remove(actualCar);
                return true;
            }
        }
        return false;
    }
}
