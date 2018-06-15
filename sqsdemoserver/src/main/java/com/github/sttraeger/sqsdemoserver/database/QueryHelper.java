package com.github.sttraeger.sqsdemoserver.database;

import com.github.sttraeger.sqsdemoserver.model.Car;

/**
 * @author sttrae
 * Class for constants. Holding all SQL Queries used in this project.
 */
public class QueryHelper {

    /**
     * Private constructor to prevent initialization of QueryHelper.
     */
    private QueryHelper(){

    }
    public static final String GET_ALL_CARS = "SELECT * FROM cars";
    public static final String CREATE_TABLE_CARS = "CREATE TABLE IF NOT EXISTS cars(" +
            "vin varchar(10) NOT NULL PRIMARY KEY, " +
            "manufacturer varchar(100) NOT NULL, " +
            "model varchar(20) NOT NULL, " +
            "hp integer NOT NULL, " +
            "registrationDate date NOT NULL, " +
            "mileage float NOT NULL)";
			
	public static final String CREATE_TEST_CARS = "INSERT INTO cars " +
			"(vin, manufacturer, model, hp, registrationDate, mileage) VALUES" +
			"('123456', 'BMW', 'X1', 250, TO_DATE('12/12/2017', 'DD/MM/YYYY'), 2333.1)," +
            "('654321', 'Ford', 'Mustang', 450, TO_DATE('01/02/2010', 'DD/MM/YYYY'), 50132.05)," +
            "('456123', 'Fiat', 'Punto', 69, TO_DATE('11/11/2011', 'DD/MM/YYYY'), 48000.0);";

	public static final String TRUNCATE_CARS = "TRUNCATE TABLE cars";

	public static final String updateCarByVin(final String vin, final Car car){
	    return "UPDATE cars " +
                "SET vin='" + vin + "', " +
                "manufacturer='" + car.getManufacturer() + "', " +
                "model='" + car.getModel() + "', " +
                "hp=" + car.getHp() + ", " +
                "registrationDate=" + car.getRegistrationDate() + ", " +
                "mileage=" + car.getMileage() + "" +
                "WHERE vin='" + vin + "';" ;
    }

    /**
     * Creates the get-query for a specified vin.
     * @param vin the unique vin
     * @return the get-query
     */
    public static final String getCarByVinQuery(final String vin){
        assert vin != null;
        return GET_ALL_CARS + " WHERE vin='" + vin.toLowerCase() + "'";
    }

    /**
     * Creates the delete-query for a specific vin.
     * @param vin the unique vin
     * @return the delete-query
     */
    public static final String deleteCarByVinQuery(final String vin){
        assert vin != null;
        return "DELETE FROM cars WHERE vin='" + vin + "'";
    }

    public static final String createCar(final Car car){
        return "INSERT INTO cars (vin, manufacturer, model, hp, mileage, registrationDate) " +
                "VALUES ('" + car.getVin() + "', " +
                "'" + car.getManufacturer() + "', " +
                "'" + car.getModel() + "', " +
                + car.getHp() + ", " +
                + car.getMileage() + ", " +
                "TO_DATE(" + car.getRegistrationDate() + "));";
    }

    public static final String countCarsWithVin(final String vin){
        return "SELECT COUNT(*) FROM cars WHERE vin='" + vin + "';";
    }
}
