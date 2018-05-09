package com.github.sttraeger.sqsdemoserver.repository;

import com.github.sttraeger.sqsdemoserver.database.QueryHelper;
import com.github.sttraeger.sqsdemoserver.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostgresCarRepository implements ICarRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Iterable<Car> getCars() {
        List<Car> carList =  jdbcTemplate.query(QueryHelper.GET_ALL_CARS, new BeanPropertyRowMapper(Car.class));
        return carList;
    }

    @Override
    public Car getCarByVin(String vin) {
        return null;
    }

    @Override
    public Car createCar(String vin, Car car) {
        return null;
    }

    @Override
    public Car updateExistingCar(Car car) {
        return null;
    }

    @Override
    public boolean deleteCar(String vin) {
        return false;
    }
}
