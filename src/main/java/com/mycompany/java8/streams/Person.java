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

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
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
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if ( obj != null && obj instanceof Person) {
            Person other = (Person) obj;
            return age==other.age && name.equalsIgnoreCase(other.name);
        }
        
        return false;
    }

    @Override
    public String toString() {
      return "name="+name+", age="+age;
    }
    
    
    
    
    
 
    
}
