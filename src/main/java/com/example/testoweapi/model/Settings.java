package com.example.testoweapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "settings")
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long settings_id;

    @Min(14)
    @Max(28)
    protected int hitting_temperature;

    @Min(1)
    @Max(90)
    protected int sits_angle;

    @Min(14)
    @Max(90)
    protected int wheel_angle;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Long getSettings_id() {
        return settings_id;
    }

    public void setSettings_id(Long settings_id) {
        this.settings_id = settings_id;
    }

    public float getHitting_temperature() {
        return hitting_temperature;
    }

    public void setHitting_temperature(int hitting_temperature) {
        this.hitting_temperature = hitting_temperature;
    }

    public int getSits_angle() {
        return sits_angle;
    }

    public void setSits_angle(int sits_angle) {
        this.sits_angle = sits_angle;
    }

    public int getWheel_angle() {
        return wheel_angle;
    }

    public void setWheel_angle(int wheel_angle) {
        this.wheel_angle = wheel_angle;
    }
}
