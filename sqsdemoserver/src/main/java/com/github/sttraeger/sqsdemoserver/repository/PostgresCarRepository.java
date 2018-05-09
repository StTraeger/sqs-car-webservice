package com.github.sttraeger.sqsdemoserver.repository;

import com.github.sttraeger.sqsdemoserver.database.CarRowMapper;
import com.github.sttraeger.sqsdemoserver.database.QueryHelper;
import com.github.sttraeger.sqsdemoserver.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author sttrae
 * @see com.github.sttraeger.sqsdemoserver.repository.ICarRepository
 * Repository implementing Repository-Interface. Connected to a SQL-database specified in the application.properties
 * file.
 */
@Component
public class PostgresCarRepository implements ICarRepository{

    private static final Logger logger = LoggerFactory.getLogger(PostgresCarRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Iterable<Car> getCars() {
        return jdbcTemplate.query(QueryHelper.GET_ALL_CARS, new BeanPropertyRowMapper(Car.class));
    }

    @Override
    public Car getCarByVin(String vin) {
        final String query = QueryHelper.getCarByVinQuery(vin);
        logger.info("Trying to get car for vin='{}'...", vin);
        return (Car)jdbcTemplate.queryForObject(query, new CarRowMapper());
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
        final String query = QueryHelper.deleteCarByVinQuery(vin);
        logger.info("Trying to delete car with vin='{}'...", vin);
        int deletedRowsCount = jdbcTemplate.update(query);
        if(deletedRowsCount == 0){
            logger.info("No matching car found. Deleted nothing.");
            return false;
        }
        logger.info("Deleted " + deletedRowsCount + " rows.");
        return true;
    }
}
