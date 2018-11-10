package com.mycompany.java8.streams;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class GrouperTest {

    Grouper grouper = new Grouper();
    @Test
    public void testGroupByOccurence() {

        String sentence = "A simple Java example that explores what Java 10 has to offer";

        Map<String, Long> expectedResult = new HashMap<>();
        expectedResult.put("has", 1L);

        assertThat(grouper.groupByOccurence(sentence)).isEqualTo(expectedResult);

    }

    @Test
    public void groupByWordToItself() {

        String sentence = "de appel valt";

        Map<String, String> expectedResult = new HashMap<>();
        expectedResult.put("de", "de");
        expectedResult.put("appel", "appel");


        assertThat(grouper.groupByWordToItself(sentence)).isEqualTo(expectedResult);
    }
}