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

    
    public enum Gender {
        MAN, VROUW;
    };
    
   
  
    

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
