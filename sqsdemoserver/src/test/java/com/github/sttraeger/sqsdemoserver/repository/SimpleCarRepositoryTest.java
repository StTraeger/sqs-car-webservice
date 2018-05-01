package com.github.sttraeger.sqsdemoserver.repository;

import com.github.sttraeger.sqsdemoserver.model.Car;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.stream.StreamSupport;

public class SimpleCarRepositoryTest {

    private ICarRepository carRepository;

    private Car testCar1 = new Car("123456", "BMW", "X1", 150, new Date(2018, 4, 30), 200);
    private Car testCar2 = new Car("456123", "Fiat", "Punto", 69, new Date(2012, 10, 11), 20000);
    private Car testCar3 = new Car("654321", "Ford", "Focus", 105, new Date(1999, 10, 11), 250441);

    @Before
    public void init() {
        carRepository = new SimpleCarRepository();
    }

    @Test
    public void testGetCars() {
        Iterable<Car> receivedCars = carRepository.getCars();
        Assert.assertTrue(StreamSupport.stream(receivedCars.spliterator(), false).anyMatch(car -> testCar1.getVin().equals(car.getVin())));
        Assert.assertTrue(StreamSupport.stream(receivedCars.spliterator(), false).anyMatch(car -> testCar2.getVin().equals(car.getVin())));
        Assert.assertTrue(StreamSupport.stream(receivedCars.spliterator(), false).anyMatch(car -> testCar3.getVin().equals(car.getVin())));
    }

    @Test
    public void testGetCarByVins() {
        Assert.assertTrue(isCarEqual(testCar1, carRepository.getCarByVin("123456")));
        Assert.assertTrue(isCarEqual(testCar2, carRepository.getCarByVin("456123")));
        Assert.assertTrue(isCarEqual(testCar3, carRepository.getCarByVin("654321")));
    }

    @Test
    public void testCreateCar() {
        Car newCar = new Car("131414", "Opel", "Corsa", 45, new Date(2012, 10, 10), 313);
        Assert.assertTrue(isCarEqual(newCar, carRepository.createCar(newCar.getVin(), newCar)));

        Car newCarReceivedFromDb = carRepository.getCarByVin("131414");
        Assert.assertNotNull(newCarReceivedFromDb);
        Assert.assertTrue(isCarEqual(newCar, newCarReceivedFromDb));
    }


    /**
     * Checks if two cars are identical in their attribute values.
     *
     * @param expectedCar the expected car
     * @param actualCar   the actual car
     * @return true if the cars are identical, false instead
     */
    private boolean isCarEqual(final Car expectedCar, final Car actualCar) {
        if (expectedCar.getVin().equals(actualCar.getVin()) && expectedCar.getHp() == actualCar.getHp() && expectedCar.getManufacturer().equals(actualCar.getManufacturer()) && expectedCar.getModel().equals(actualCar.getModel()) && expectedCar.getMileage() == actualCar.getMileage()) {
            return true;
        }
        return false;
    }
}
