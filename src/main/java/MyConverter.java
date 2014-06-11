/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.dijkrosoft;

/**
 *
 * @author Dick
 */
public class MyConverter {
    
    public static void main(String[] args) {
        MyConverter converter = new MyConverter();
        Integer converted = converter.convert("134");
        System.out.println(converted);
    }
    
    public Integer convert(String f) {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        return converter.convert(f);
        
    }
}
