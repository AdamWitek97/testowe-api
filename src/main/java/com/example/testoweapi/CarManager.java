package com.example.testoweapi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarManager {

    private List<Car> carList;

    public CarManager() {
        this.carList = new ArrayList<>();
        carList.add(new Car("Polo","VW",1998,40000));
        carList.add(new Car("126","VW",2002,30000));
    }

    public boolean addCar(Car car) {
        return carList.add(car);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public Car getCarListByName(String name) {
        return carList.stream().filter(t->t.getName().equals(name)).findFirst().get();
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}