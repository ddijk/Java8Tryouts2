/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.java8.streams;

import com.mycompany.java8.streams.Person.Gender;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Dick
 */
public class PersonTest {
    
  List<Person> persons;
    
    @Before
    public void setUp() {
         persons = Arrays.asList(new Person(41, "dick", Gender.MAN, 50000), new Person(37, "patricia", Gender.VROUW, 1000), new Person(8, "jens", Gender.MAN, 1000), new Person(5, "lieve", Gender.VROUW, 2000));
       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getGender method, of class Person.
     */
    @Test
    public void testAverageMaleSalary() {
        System.out.println("getGender");
       
        
        
        // average salary van males: 51000/2
    double expResult = 51000/2;
        double result = persons.stream().filter(p->p.getGender()==Gender.MAN).mapToInt(p->p.getSalary()).average().getAsDouble();
        assertEquals(expResult, result, 1);
       
    }

    
     @Test
    public void testAverageFemaleSalary() {
        System.out.println("getGender");
       
        
        
        // average salary van females: 51000/2
    double expResult = 3000/2;
        double result = persons.stream().filter(p->p.getGender()==Gender.VROUW).mapToInt(p->p.getSalary()).average().getAsDouble();
        assertEquals(expResult, result, 1);
       
    }
    
    
      @Test
    public void testAverageAgePerGender() {
        System.out.println("getGender");
       
        // average age male: (41+8) /2
        
        Map<Gender, Double> expected = new HashMap<>();
        expected.put(Gender.MAN, new Double((41d+8)/2));
        expected.put(Gender.VROUW, new Double((37+5)/2) );
  
         Map<Gender, Double> result = persons.stream().collect(groupingBy(Person::getGender, averagingInt(Person::getAge)));
          assertEquals(expected, result);
    }     
}
