package com.example.testoweapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Predicate;

@RestController
public class CarApi {

    private CarManager carManager;

    @Autowired
    public CarApi (CarManager carManager){
        this.carManager=carManager;
    }

    @GetMapping("/getCars")
    public List<Car> getCars(){
        return carManager.getCarList();
    }

    @GetMapping("/getCars/{name}")
    public Car getCarsName(@PathVariable("name") String carName){
        return carManager.getCarListByName(carName);
    }

    @PostMapping("/addCar")
    public boolean addCar(@RequestBody Car car){
        return carManager.addCar(car);
    }

    @DeleteMapping("/deleteCar/{id}")
    public void deleteCar(@PathVariable("id") int id){
        carManager.removeCar(id);
    }

}
