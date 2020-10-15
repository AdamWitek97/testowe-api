package com.example.testoweapi;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 1000
    )
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 3)
    private String mark;

    @NotBlank
    private int production_date;
    private int mileage;
    private boolean izofix;
    private boolean usedcar;

    public boolean isUsedcar() {
        return usedcar;
    }

    public void setUsedcar(boolean usedcar) {
        this.usedcar = usedcar;
    }

    public boolean isIzofix() {
        return izofix;
    }

    public void setIzofix(boolean izofix) {
        this.izofix = izofix;
    }

    public Car(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
