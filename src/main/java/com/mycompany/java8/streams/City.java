package com.mycompany.java8.streams;

public class City {
    String name;
    public City(String name) {
        this.name=name;
    }

    @Override
    public boolean equals(Object obj) {
        if ( obj instanceof City) {
            return ((City) obj).name.equals(this.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
