package com.github.sttraeger.sqsdemoserver.database;

import com.github.sttraeger.sqsdemoserver.model.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Car car = new Car();
        car.setVin(resultSet.getString("vin"));
        car.setManufacturer(resultSet.getString("manufacturer"));
        car.setModel(resultSet.getString("model"));
        car.setHp(resultSet.getInt("hp"));
        car.setRegistrationDate(resultSet.getDate("registrationDate"));
        car.setMileage(resultSet.getFloat("mileage"));
        return car;
    }
}
