/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.java8.defaultMethod;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Dick
 */
public class MyDefault {
    
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("aap", "noot", "boer", "mies");
        
     
        for ( String i : myList) {
            System.out.println(i);
        }
        
        System.out.println("Na sorting");
        
        myList.sort((f, g)-> f.compareTo(g));
        
         for ( String i : myList) {
            System.out.println(i);
        }
        
        
    }
    
}
