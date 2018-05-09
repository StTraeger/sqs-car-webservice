package com.github.sttraeger.sqsdemoserver.database;

public class QueryHelper {

    public static final String GET_ALL_CARS = "SELECT * FROM cars";

    public static String getCarByVinQuery(final String vin){
        assert vin != null;
        return GET_ALL_CARS + "WHERE vin='" + vin.toLowerCase() + "'";
    }


}
