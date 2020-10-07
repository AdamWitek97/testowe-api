package com.example.testoweapi;

public enum Enum2 {
    L(60),
    M(40),
    S(30);

    public int diameter;

    private Enum2(int diameter){
        this.diameter=diameter;
    }

    public int getDiameter(){
        return diameter;
    }
}
