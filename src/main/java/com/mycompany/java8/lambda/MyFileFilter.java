/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.java8.lambda;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author Dick
 */
public class MyFileFilter {
    
    public static void main(String[] args) {
        File[] fa =  listDirectoriesJava8Way2();
        
         int i=0;
        for ( File f : fa ) {
            System.out.println(i++ +" "+f);
        }
    }

 
     private static File[] listDirectoriesJava8Way() {
         
      
        return new File("/").listFiles((File f) -> f.isDirectory());
        
        // of met Type Inference: new File("/").listFiles((f -> f.isDirectory());
        
    }
     
      private static File[] listDirectoriesJava8Way2() {
             // using Method Reference
        return new File("/").listFiles(File::isDirectory);
        
        
    }
    
        private static File[] listDirectoriesJava7Way() {
        return new File("/").listFiles(new FileFilter(){
            public boolean accept(File f) {
                return f.isDirectory();
            }
        });
       
    }
        
       
    
        
     private static File[] listFilesJava7Way() {
        return new File("/").listFiles(new FileFilter(){
            public boolean accept(File f) {
                return f.isFile();
            }
        });
        
       
    }
   
}
