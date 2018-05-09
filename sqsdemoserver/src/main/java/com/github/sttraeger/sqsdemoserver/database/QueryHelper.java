package com.github.sttraeger.sqsdemoserver.database;

/**
 * @author sttrae
 * Class for constants. Holding all SQL Queries used in this project.
 */
public class QueryHelper {

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

    public static String getCarByVinQuery(final String vin){
        assert vin != null;
        return GET_ALL_CARS + " WHERE vin='" + vin.toLowerCase() + "'";
    }

    public static String deleteCarByVinQuery(final String vin){
        assert vin != null;
        return "DELETE FROM cars WHERE vin='" + vin + "'";
    }


}
