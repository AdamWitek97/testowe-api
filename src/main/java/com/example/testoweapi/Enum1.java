package com.example.testoweapi;

public enum Enum1 {
    L(60),
    M(40),
    S(30);

    public int diameter;

    private Enum1(int diameter){
        this.diameter=diameter;
    }

    public int getDiameter(){
        return diameter;
    }
}

// == może porównać dwie wartości ( i to bez nullpointera), a equals nie (nie próbowałem nadpisywać metody)
// equals na razie nie dział przy liczbach, a equals w enumach jest ,,prywatny" nie do dziedziczenia