package com.example.testoweapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.function.Predicate;

@RestController
public class CarApi {

    @Autowired
    private CarRepository carRepository;


    @GetMapping("/getCars")
    public Page<Car> getCars(Pageable pageable){
        return carRepository.findAll(pageable);
    }

    /*@GetMapping("/getCars/{name}")
    public Car getCarsName(@PathVariable("name") String carName){
        return carManager.getCarListByName(carName);
    }
*/
    @PostMapping("/addCar")
    public Car addCar(@Valid @RequestBody Car car){
        return carRepository.save(car);
    }

    @DeleteMapping("/deleteCar/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id){
        return carRepository.findById(id)
                            .map(car -> {
                                carRepository.delete(car);
                                return ResponseEntity.ok().build();
                            }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id "+id));
    }

}
