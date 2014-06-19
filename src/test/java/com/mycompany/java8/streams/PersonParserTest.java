  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.java8.streams;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dick
 */
public class PersonParserTest {
    
    public PersonParserTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class PersonParser.
     */
  

    /**
     * Test of parse method, of class PersonParser.
     */
    @Test
    public void testParse() {
        System.out.println("parse");
        String csvLine = "Marc,35";
        Person expResult = new Person(35,"Marc");
        Person result = PersonParser.parse(csvLine);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of filterPersons method, of class PersonParser.
     */
    @Test
    public void testFilterOnePerson() throws Exception {
        System.out.println("filterPersons");
        InputStream is = PersonParser.class.getResourceAsStream("/one_person.txt");
       
        assertNotNull("InputStream is null", is);
       
        List<Person> expResult = Arrays.asList(new Person(40, "Dick"));
        
        Predicate<Person> pred = (Person p) -> true;
        List<Person> result = PersonParser.filterPersons(is, pred);
        assertEquals(expResult, result);
        
    }
    
     @Test
    public void testFilterPersons() throws Exception {
        System.out.println("filterPersons");
        
        InputStream is  = getClass().getResourceAsStream("/persons.txt");
         assertNotNull("InputStream is null", is);
     
        List<Person> expResult = Arrays.asList(new Person(40, "Dick"), new Person(42, "Erik"), new Person(38, "Ro"), new Person(36, "Marc"));
        
        Predicate<Person> pred = (Person p) -> true;
        List<Person> result = PersonParser.filterPersons(is, pred);
        assertEquals(expResult, result);
        
    }
    
       @Test
    public void testFilterPersonsOver40() throws Exception {
        System.out.println("filterPersons");
        
        InputStream is  = getClass().getResourceAsStream("/persons.txt");
         assertNotNull("InputStream is null", is);
     
        List<Person> expResult = Arrays.asList(new Person(40, "Dick"), new Person(42, "Erik"));
        
        Predicate<Person> pred = (Person p) -> p.getAge()>39;
        List<Person> result = PersonParser.filterPersons(is, pred);
        assertEquals(expResult, result);
        
    }
    
         @Test
    public void testFilterPersonsStartingWithR() throws Exception {
        System.out.println("filterPersons");
        
        InputStream is  = getClass().getResourceAsStream("/persons.txt");
         assertNotNull("InputStream is null", is);
     
        List<Person> expResult = Arrays.asList(new Person(38, "Ro"));
        
        Predicate<Person> pred = (Person p) -> p.getName().startsWith("r");
        List<Person> result = PersonParser.filterPersons(is, pred);
        assertEquals(expResult, result);
        
    }
    
}
