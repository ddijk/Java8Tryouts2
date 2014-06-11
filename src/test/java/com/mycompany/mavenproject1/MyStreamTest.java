/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dick
 */
public class MyStreamTest {

    public MyStreamTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of filterA method, of class MyStream.
     */
    @Test
    public void testFilterA() {
        System.out.println("filterA");
        List<String> list = new ArrayList<>();
        list.add("aap");
        list.add("noot");
        list.add("mies");
        list.add("abc");
        MyStream instance = new MyStream();
        List<String> expResult = new ArrayList<>();
        expResult.add("aap");
        expResult.add("abc");

        List<String> result = instance.filterA(list);
        assertEquals(expResult, result);

    }

}
