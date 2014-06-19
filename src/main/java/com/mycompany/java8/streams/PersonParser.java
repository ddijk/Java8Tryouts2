/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.java8.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Dick
 */
public class PersonParser {
    
    public static void main(String[] args) throws IOException {
             
    //   List<Person> persons = filterPersons(, person->person.getAge() > 35);
     
    }
    
    public static Person parse(String csvLine) {
        String[] items = csvLine.split(",");
        
        return new Person(Integer.parseInt(items[1]),items[0]);
    }
    
    public static List<Person> filterPersons(InputStream is, Predicate<Person> filter) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        
        return br.lines().map(PersonParser::parse).filter(filter).collect(Collectors.toList());
    }
}
