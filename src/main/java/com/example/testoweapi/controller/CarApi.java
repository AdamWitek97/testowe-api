package com.example.testoweapi.controller;

import com.example.testoweapi.exception.ResourceNotFoundException;
import com.example.testoweapi.model.Car;
import com.example.testoweapi.repository.CarRepository;
import com.example.testoweapi.repository.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;


@Validated
@RestController
public class CarApi {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private SettingsRepository settingsRepository;


    @GetMapping("/getCars")
    public Page<Car> getCars(Pageable pageable){
        return carRepository.findAll(pageable);
    }

    @GetMapping(value = "/getCars/json/{id}")
    public Optional<Car> getCarsJson(@PathVariable("id") Long id){
        return carRepository.findById(id);
    }

    @GetMapping(value = "/getCars/xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public Optional<Car> getCarsXml(@PathVariable("id") Long id){
        return carRepository.findById(id);
    }

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
