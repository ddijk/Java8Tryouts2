package com.mycompany;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;

/**
 * Created by dickdijk on 21/11/16.
 */
public class ListSplitterTest {
    @Test
    public void split() throws Exception {

        List<String> input = Arrays.asList("a", "b", null, "c", null, "d", "e");

        List<List<String>> expected = Arrays.asList(Arrays.asList("a","b"), Arrays.asList("c"),Arrays.asList("d","e"));
        List<List<String>> expected2 = Arrays.asList(Arrays.asList("a","b"), Arrays.asList("c"),Arrays.asList("d","e"));

        assertEquals(expected, ListSplitter.split(input));


    }

    @Test
    public void split2() throws Exception {

        List<String> input = Arrays.asList("a", "b", null, "c", null, "d", "e");

        List<List<String>> expected = Arrays.asList(Arrays.asList("a","b"), Arrays.asList("c"),Arrays.asList("d","e"));

        System.out.println(expected);
        assertEquals(expected, ListSplitter.splitStream(input));


    }


    @Test
    public void test() {

        String str = "abc";

        System.out.println("subst:"+        str.substring(0, 3));

     //  List<Tuple> lt = IntStream.range(10,12).mapToObj(j->new Tuple(1,j)).collect(toList());
    //  Stream<Tuple> stream =   IntStream.range(1,3).mapToObj(i-> new Tuple(i,i));
    //    List<Tuple> myList =   IntStream.range(1,3).flatMap(i-> IntStream.range(10,12).mapToObj(j-> new Tuple(j,i))).collect(toList());
        //    List<Stream<Tuple>> myList =  IntStream.range(1,3).mapToObj(i-> stream ).collect(toList());
        List<Tuple> myList = IntStream.range(1,3).mapToObj(i-> IntStream.range(10,12).mapToObj(j-> new Tuple(j,i)) ).flatMap(k->k).collect(toList());
///          List<Tuple> myList = IntStream.range(1,3).mapToObj(i-> IntStream.range(10,12).mapToObj(j-> new Tuple(j,i)) ).collect(toList());



        System.out.println(myList);
    }


    class Tuple {
        int i;
        int j;
        Tuple(int i, int j) {
         this.i =i;
            this.j=j;
        }

        @Override
        public String toString() {
            return "(i="+i+"; j="+j+")";
        }
    }
}