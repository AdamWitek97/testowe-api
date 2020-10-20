package com.example.testoweapi;

import com.example.testoweapi.model.Car;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertTrue;


class JUnitTesty {

    static private Validator validator;
    static private ValidatorFactory validatorFactory;
    private Car car;

    public JUnitTesty(){

    }

    @BeforeClass
    public static void setUpClass(){
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }
    @AfterClass
    public void close() {
        validatorFactory.close();
    }

    @Before
    public void setUp(){

    }

    @After
    public void tearDown(){

    }


    void Values(){
    }

    @Test
    void CarValues(){
        car = new Car();
        car.setName("car");
        car.setMark("ABC");
        car.setProduction_date(2002);
        car.setMileage(50000);
        car.setIzofix(true);
        car.setUsedcar(true);
        car.setVin("01234567890123456");
        Set<ConstraintViolation<Car>> violations = validator.validateProperty(car,"name");
        assertTrue(violations.isEmpty());
    }

    @Test
    void shouldSetCarName(){


    }
}
