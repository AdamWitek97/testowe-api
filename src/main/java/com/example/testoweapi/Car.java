package com.example.testoweapi;

public class Car {

    private int id;
    private String name;
    private String mark;
    private int production_date;
    private int mileage;

    public Car(){

    }

    public Car(int id, String name, String mark, int production_date, int mileage) {
        this.id = id;
        this.name = name;
        this.mark = mark;
        this.production_date = production_date;
        this.mileage = mileage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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



}
