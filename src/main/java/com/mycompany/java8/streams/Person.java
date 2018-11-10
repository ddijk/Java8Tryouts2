/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.java8.streams;

/**
 *
 * @author Dick
 */
public class Person {
 
    int age;
     Gender gender;
    int salary;
    City city;
    String lastName;

    public City getCity() {
        return city;
    }

    public String getLastName() {
        return lastName;
    }

    public enum Gender {
        MAN, VROUW;
    };

    public Person(City city, String name) {
        this.city = city;
        this.name = name;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
    
    public Person(int age, String name, Gender g, int sal) {
        this.age = age;
        this.name = name;
        this.gender = g;
        this.salary = sal;
    }

    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    String name;

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if ( obj != null && obj instanceof Person) {
            Person other = (Person) obj;
            return name.equalsIgnoreCase(other.name);
        }
        
        return false;
    }
    
      public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }



    @Override
    public String toString() {
      return "name="+name+", age="+age;
    }
    
    
    
    
    
 
    
}
