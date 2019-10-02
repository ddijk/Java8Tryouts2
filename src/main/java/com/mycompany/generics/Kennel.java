package com.mycompany.generics;

import java.util.ArrayList;
import java.util.List;

public  class Kennel<T extends Animal> {

    List<T> animals = new ArrayList<>();

    public void add(T animal) {

        animals.add(animal);
    }

    public void list() {

        animals.forEach(a -> System.out.println(a.sound()));

    }

    public String meth(T animal) {
        return animal.sound();
    }
    public <T extends Animal>  String meth2(T animal) {
        return animal.sound();
    }

    public String doit() {

        Dog a = new Dog();

        return meth2(a);

    }

//    public String doit2() {
//
//        Dog a = new Dog();
//
//        animals.add(a);
//        return meth(a);
//    }
    public String doit3() {

       // T a = (T) new Dog();
        Dog a = new Dog();
        return meth2(a);
    }


    public static void main(String[] args) {
        Kennel<Animal> kennel = new Kennel<>();
        kennel.add(new Cat());
        kennel.add(new Dog());
        kennel.list();

        System.out.println("****");
//        System.out.println(kennel.doit2());
        System.out.println(kennel.doit3());
    }
}
