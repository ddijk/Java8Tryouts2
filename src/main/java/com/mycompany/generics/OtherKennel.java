package com.mycompany.generics;

public class OtherKennel<T extends Animal> {

    T t;

    void add(T t) {
        this.t = t;
    }

    T get() {
        return t;
    }
}
