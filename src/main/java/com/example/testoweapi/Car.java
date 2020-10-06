package com.example.testoweapi;

public class Car {

    private String name;
    private String mark;
    private int production_date;
    private int mileage;

    public Car(){

    }

    public Car(String name, String mark, int production_date, int mileage) {
        this.name = name;
        this.mark = mark;
        this.production_date = production_date;
        this.mileage = mileage;
    }

    public int getProduction_date() {
        return production_date;
    }

    public void setProduction_date(int production_date) {
        this.production_date = production_date;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
