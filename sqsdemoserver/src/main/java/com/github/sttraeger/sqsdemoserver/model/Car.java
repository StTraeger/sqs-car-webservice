package com.github.sttraeger.sqsdemoserver.model;

import java.util.Date;

public class Car {

    private String vin;
    private String manufacturer;
    private String model;
    private long hp;
    private Date registrationDate;
    private double mileage;

    public Car(){

    }

    public Car(String vin, String manufacturer, String model, long hp, Date registrationDate, double mileage) {
        this.vin = vin;
        this.manufacturer = manufacturer;
        this.model = model;
        this.hp = hp;
        this.registrationDate = registrationDate;
        this.mileage = mileage;
    }


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getHp() {
        return hp;
    }

    public void setHp(long hp) {
        this.hp = hp;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }
}
