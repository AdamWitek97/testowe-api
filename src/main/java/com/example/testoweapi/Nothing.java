package com.example.testoweapi;

public class Nothing extends SomeClass {

    final int a1 = 5;

//    int mnozenie() {
//        return a1*a1;
//    }

    void wypiszCar(){

    }

    final static Car cr = new Car(5,"bmw", "polonez", 2010, 10000, true, true);

    static int en1d = Enum1.L.diameter;
    static int en2d = Enum2.S.diameter;

    private static boolean en = en1d == en2d;

    public static void main(String[] args){


        System.out.println("Car before changing values: " + cr.getId());

        cr.setId(6);


        System.out.println("Car after changing values: " + cr.getId());

        System.out.println("Czy jeden enum rowna sie drugiemu? " + en);

        System.out.println("Enum1: " + en1d);
        System.out.println("Enum2: " + en2d);
        System.out.println("Czy jeden enum rowna sie drugiemu? " + en);

        ClassToEquals eq1 = new ClassToEquals(5,"cos");
        ClassToEquals eq2 = new ClassToEquals(5,"cos");

        System.out.println("Czy jedna klasa równa się drugiej? " + eq1.equals(eq2));

        //a1=4;

        String a = "a";

        String b = new String("a");
        System.out.println("Czy a == b? " + a==b);
        System.out.println("Czy a equals b? " + a.equals(b));

    }
}
