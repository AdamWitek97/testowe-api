package com.example.testoweapi.controller;

import com.example.testoweapi.exception.ResourceNotFoundException;
import com.example.testoweapi.model.Settings;
import com.example.testoweapi.repository.CarRepository;
import com.example.testoweapi.repository.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.List;


@Validated
@RestController
public class SettingsApi {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private SettingsRepository settingsRepository;


    @GetMapping("/getCars/settings")
    public List<Settings> getCars(){
        return settingsRepository.findAll();
    }

    @GetMapping(value = "/getCars/{id}/settings/json")
    public List<Settings> getSettingsJson(@PathVariable Long id){
        return settingsRepository.findByCarId(id);
    }

    @GetMapping(value = "/getCars/{id}/settings/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Settings> getSettingsXml(@PathVariable Long id){
        return settingsRepository.findByCarId(id);
    }

    @PostMapping("/addCar/{id}/settings")
    public Settings addSettings(@PathVariable Long id,
                                @Valid @RequestBody Settings settings){
        return carRepository.findById(id)
                            .map(car -> {
                                settings.setCar(car);
                                return settingsRepository.save(settings);
                            }).orElseThrow(()-> new ResourceNotFoundException("Settings not found with id"+id));
    }

    @DeleteMapping("/deleteCar/{id}/settings/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id,
                                       @PathVariable Long settings_id){
        if(!carRepository.existsById(id)){
            throw new ResourceNotFoundException("Car not found with id "+settings_id);
        }

        return settingsRepository.findById(settings_id)
                            .map(settings -> {
                                settingsRepository.delete(settings);
                                return ResponseEntity.ok().build();
                            }).orElseThrow(() -> new ResourceNotFoundException("Settings not found with id "+settings_id));
    }

}
