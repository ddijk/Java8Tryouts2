package com.mycompany.java8.streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GrouperTest {
    Grouper grouper = new Grouper();

    @Test
    public void testGroupByOccurence() {

        String sentence = "A simple Java example that explores what Java 10 has to offer";

        Map<String, Long> expectedResult = new HashMap<>();
        expectedResult.put("has", 1L);
        expectedResult.put("Java", 2L);

        assertThat(grouper.groupByOccurence(sentence)).containsAllEntriesOf(expectedResult);
    }

    @Test
    public void testMapOfLongestWordPerLetter() {

        Map<String, String> expectedResult = new HashMap<>();
        expectedResult.put("A", "afrika");
        expectedResult.put("D", "denmark");
        expectedResult.put("C", "citroen");

        String input ="aap afrika appel dos denmark citroen";
        assertThat(grouper.groupByLetterToLongestWord(input)).containsAllEntriesOf(expectedResult);
    }

    @Test
    public void testCreateMapFromWordToWordlength() {

        String input = "aap noot aap";

        Map<String, Integer> expectedResult  = new HashMap<>();
        expectedResult.put("aap", 3);
        expectedResult.put("noot", 4);
        assertThat(grouper.groupByWordLength(input)).isEqualTo(expectedResult);

    }

    @Test
    public void testGroupPersonsByCityPersonAsCommaSeparatedString() {

        List<Person> people = Arrays.asList(new Person(new City("vleuten"), "dick"), new Person(new City("bodegraven"), "hans"),
                new Person(new City("bodegraven"), "henny"), new Person(new City("vleuten"), "jens"));

        Map<City, String> expectedResult = new HashMap<>();
        expectedResult.put(new City("vleuten"), "dick,jens");
        expectedResult.put(new City("bodegraven"), "hans,henny");
        assertThat(grouper.groupByCity(people)).isEqualTo(expectedResult);
    }


    @Test
    public void testgroupByCityWithMapping() {

        List<Person> people = Arrays.asList(new Person(new City("vleuten"), "dick"), new Person(new City("bodegraven"), "hans"),
                new Person(new City("bodegraven"), "henny"), new Person(new City("vleuten"), "jens"));

        Map<City, String> expectedResult = new HashMap<>();
        expectedResult.put(new City("vleuten"), "dick,jens");
        expectedResult.put(new City("bodegraven"), "hans,henny");
        assertThat(grouper.groupByCityWithMapping(people)).isEqualTo(expectedResult);
    }

    @Test
    public void testGroupPersonsByCity() {

        Map<City, List<Person>> expectedResult = new HashMap<>();

        List<Person> people = Arrays.asList(new Person(new City("vleuten"), "dick"), new Person(new City("bodegraven"), "hans"),
                new Person(new City("bodegraven"), "henny"), new Person(new City("vleuten"), "jens"));

        expectedResult.put(new City("vleuten"), Arrays.asList(new Person(44, "dick"), new Person(12, "jens")));
        expectedResult.put(new City("bodegraven"), Arrays.asList(new Person(75, "hans"), new Person(76, "henny")));

        assertThat(new City("aap")).isEqualTo(new City("aap"));
        assertThat(new Person(new City("vleuten"), "dick")).isEqualTo(  new Person(new City("vleuten"), "dick"));


        assertThat(grouper.groupPersonsByCity(people)).isEqualTo(expectedResult);
    }

    @Test
    public void groupByWordToItself() {

        String sentence = "de appel valt";

        Map<String, String> expectedResult = new HashMap<>();
        expectedResult.put("de", "de");
        expectedResult.put("appel", "appel");
        expectedResult.put("valt", "valt");


        assertThat(grouper.groupByWordToItself(sentence)).isEqualTo(expectedResult);
    }
}