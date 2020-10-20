package com.example.testoweapi.other;

import java.util.Objects;

public class ClassToEquals {
    int liczba;
    String napis;

    public int getLiczba() {
        return liczba;
    }

    public void setLiczba(int liczba) {
        this.liczba = liczba;
    }

    public String getNapis() {
        return napis;
    }

    public void setNapis(String napis) {
        this.napis = napis;
    }

    public ClassToEquals(int liczba, String napis) {
        this.liczba = liczba;
        this.napis = napis;
    }
    /*
    public boolean equals(Object other){
        if(other instanceof ClassToEquals){
            ClassToEquals cte = (ClassToEquals) other;
            if(this.liczba.equals(cte.liczba)){
                if(this.napis.equals(cte.napis)){
                    return true;
                }
            }
        }
        return false;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassToEquals that = (ClassToEquals) o;
        return liczba == that.liczba && Objects.equals(napis, that.napis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(liczba, napis);
    }
}
