package com.example.testoweapi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarManager {

    private List<Car> carList;

    public CarManager() {
        this.carList = new ArrayList<>();
        carList.add(new Car(0,"Polo","VW",1998,40000,true,true));
        carList.add(new Car(1,"126","VW",2002,30000,false,true));
        carList.add(new Car(1,"1263","BMW",2002,30000,true,true));
    }

    public boolean addCar(Car car) {
        if(car.isUsedcar()==false){
            if(car.getMileage()>80){
                throw new RuntimeException("New car shouldn't have more than 80 miles");
            }
        }
        if(car.getProduction_date()>2000){
            if(car.isIzofix()==false){
                throw new RuntimeException("Value cannot be false");
            }
        }
            return carList.add(car);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public Car getCarListByName(String name) {
        return carList.stream().filter(t->t.getName().equals(name)).findFirst().get();
    }

    public Car getCarListById(int id) {
        return carList.stream().filter(t->t.getId()==id).findFirst().get();
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public Car removeCar(int id){ return carList.remove(id);}
}
