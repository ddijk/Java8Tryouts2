/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mavenproject1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Dick
 */
public class MyStream {
    
    
   public List <String> filterA(List<String> list) {
       return list.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());
   }
}
