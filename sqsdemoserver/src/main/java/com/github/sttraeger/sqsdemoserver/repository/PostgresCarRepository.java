package com.github.sttraeger.sqsdemoserver.repository;

import com.github.sttraeger.sqsdemoserver.database.CarRowMapper;
import com.github.sttraeger.sqsdemoserver.database.QueryHelper;
import com.github.sttraeger.sqsdemoserver.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity getCarByVin(String vin) {
        final String query = QueryHelper.getCarByVinQuery(vin);
        logger.info("Trying to get car for vin='{}'...", vin);
        try {
            Car retCar = (Car)jdbcTemplate.queryForObject(query, new CarRowMapper());
            return new ResponseEntity(retCar, HttpStatus.OK);
        } catch (EmptyResultDataAccessException e){
            return new ResponseEntity("No car with vin='" + vin + "' found in database.", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity createCar(String vin, Car car) {
        logger.info("Trying to create car={} with vin='{}' in database.", car, vin);
        // Check if primary key already exists
        int countForVin = this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM cars WHERE vin='" + vin + "';", Integer.class);
        if(countForVin == 0){

        }
        logger.warn("Car with vin='" + vin + "' already exists in database! Creation not possible. Try update options instead.");
        return new ResponseEntity("Car with vin='" + vin + "' already exists. Creation not possible.", HttpStatus.CONFLICT);
    }

    @Override
    public ResponseEntity updateExistingCar(Car car) {
        logger.info("Trying to update car={} in database.", car);
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
