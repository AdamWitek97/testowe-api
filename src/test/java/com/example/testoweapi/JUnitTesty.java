package com.example.testoweapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class JUnitTesty {
    Car cr = new Car();
    CarManager crm = new CarManager();

    public void values(){
        cr.setId(2);
        cr.setName("Auto");
        cr.setMark("Marka");
        cr.setProduction_date(2003);
        cr.setMileage(1500);
        cr.setIzofix(true);
        cr.setUsedcar(true);

    }

    @Test
    void addCar_Created_After_2000_Without_Izofix_Should_Throw_RuntimeException(){
        //given
        values();
        cr.setIzofix(false);

        //then
        Assertions.assertThrows(RuntimeException.class, () -> crm.addCar(cr));
    }

    @Test
    void addCar_Created_After_2000_With_Izofix(){

        //given
        values();

        //then
        Assertions.assertDoesNotThrow( () -> crm.addCar(cr));
    }

    @Test
    void addCar_Which_Was_Not_Used(){

        //given
        values();
        cr.setMileage(0);
        cr.setUsedcar(false);

        //then
        Assertions.assertDoesNotThrow( () -> crm.addCar(cr));
    }

    @Test
    void addCar_Which_Was_Not_Used_But_With_High_Mileage_Should_Throw_RuntimeException(){

        //given
        values();
        cr.setMileage(5000);
        cr.setUsedcar(false);

        //then
        Assertions.assertThrows(RuntimeException.class, () -> crm.addCar(cr));
    }
}
