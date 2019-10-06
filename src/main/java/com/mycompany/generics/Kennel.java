package com.mycompany.generics;

import java.util.ArrayList;
import java.util.List;

public  class Kennel<T extends Animal> {

    List<T> animals = new ArrayList<>();

    public void add(T animal) {

        animals.add(animal);
    }

//    public void list() {
//
//        animals.forEach(a -> System.out.println(a.sound()));
//
//    }
//
//    public String meth(T animal) {
//        return animal.sound();
//    }
    public  String meth2(T animal) {
        //return animal.sound();
        animals.add(animal);
        return "";
    }

    public String doit() {

        Dog a = new Dog();

//        return meth2(a);

//        animals.add(a);

        return "";
    }

    public T get() {
        return animals.get(0);
    }

    public T getFromOtherKennel() {
        OtherKennel<T> otherKennel = new OtherKennel<>();
//        T k = new Konijn();
//        otherKennel.add(new Konijn());
        final T animal = otherKennel.get();
        animal.sound();
        T a = animals.get(0);

        return a;
    }

    public   <U extends Animal> U createKonijn() {
        return new Konijn();
    }

    public void get2() {
        OtherKennel<Animal> otherKennel = new OtherKennel<>();
        Konijn k = new Konijn();
        otherKennel.add(k);
        System.out.println(  otherKennel.get().sound());
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
        Kennel<Dog> k2 = new Kennel<>();
        k2.meth2(a);
//        k2.meth2(new Cat());
//        return meth2(a);
        return "";
    }


    public static void main(String[] args) {
        Kennel<Animal> kennel = new Kennel<>();
        final Dog dog = new Dog();
        kennel.add(dog);

        kennel.meth2(dog);
        kennel.add(new Cat());
//        kennel.list();

        System.out.println("****");
//        System.out.println(kennel.doit2());
        System.out.println(kennel.doit3());
        System.out.println(kennel.get().sound());
//        kennel.getFromOtherKennel();

        OtherKennel<Animal> otherKennel = new OtherKennel<>();
        Konijn k = new Konijn();
        otherKennel.add(k);
        System.out.println(  otherKennel.get().sound());
        kennel.get2();
    }
}
