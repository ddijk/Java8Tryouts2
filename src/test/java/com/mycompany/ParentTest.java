package com.mycompany;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;

/**
 * Created by dickdijk on 21/11/16.
 */
public class ParentTest {


    @Test
    public void test() {


        Child c1 = new Child("Jens");
        Child c2  = new Child("Lieve");

        Parent p1 = new Parent("Dick", Arrays.asList(c1,c2));

        Child c3 = new Child("Lasse");
        Child c4  = new Child("Loek");

        Parent p2 = new Parent("Wes", Arrays.asList(c3,c4));

       List<Child> childList = Arrays.asList(p1,p2).stream().flatMap(p->p.getChildren().stream()).collect(toList());

        System.out.println(childList);
    }

}