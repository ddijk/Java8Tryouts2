package com.mycompany.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Grouper {

    /**
     * This method splits an input sentence in its words and then
     * creates a map from word to the number of occurences of this word within
     * the sentence.
     *
     * @param sentence
     * @return a map from word to number of occurence of this word
     */
    public Map<String, Long> groupByOccurence(String sentence) {
        Collector<String, ?, Long> counting = counting();
        Collector<String, ?, Map<String, Long>> byOccurrence = groupingBy(Function.identity(), counting);

        Map<String, Long> wordFrequency = Arrays.stream(sentence.split(" ")).collect(byOccurrence);

        return wordFrequency;
    }

    public Map<String, String> groupByLetterToLongestWord(String input) {

        Function<String, String> firstLetter = s -> s.substring(0, 1).toUpperCase();
        Collector<String, ?, String> longestWordCollector =
                reducing("", BinaryOperator.maxBy(Comparator.comparing(String::length)));
        return Arrays.stream(input.split(" ")).collect(groupingBy(firstLetter, longestWordCollector));
    }

    /**
     * This method splits an input sentence in its words and then creates
     * a map from this word to the length of this word.
     *
     * @param sentence
     * @return a map from word to word length
     */
    public Map<String, Integer> groupByWordLength(String sentence) {
        Function<String, Integer> mapper = s -> s.length();
        BinaryOperator<Integer> binaryOp = (len1, len2) -> len2;
        Collector<String, ?, Map<String, Integer>> byWordLength = groupingBy(Function.identity(), reducing(0, mapper, binaryOp));

        return Arrays.stream(sentence.split(" ")).collect(byWordLength);
    }

    public Map<String, String> groupByWordToItself(String sentence) {

        Supplier<StringBuilder> supplier = () -> new StringBuilder();
        BiConsumer<StringBuilder, String> accumulator = (StringBuilder s1, String s2) -> s1.append(s2);
        BinaryOperator<StringBuilder> combiner = (StringBuilder s1, StringBuilder s2) -> {
            System.out.println("Deze wordt niet aangeroepen omdat er niet opgesplitst wordt (niet concurrent)");
            return null;
        };
        Function<StringBuilder, String> finisher = sb -> sb.toString();
        Collector<String, StringBuilder, String> toItselfCollector = Collector.of(supplier, accumulator, combiner, finisher);
        Collector<String, ?, Map<String, String>> byItself = groupingBy(Function.identity(), toItselfCollector);
        return Arrays.stream(sentence.split(" ")).collect(byItself);
    }

    public Map<City, String> groupByCity(List<Person> people) {
        BinaryOperator<String> binaryOp = (s1, s2) -> s1.length() > 0 ? String.join(",", s1, s2) : s2;
        Function<Person, String> mapper = p -> p.getName();
        Map<City, String> longestLastNameByCity =
                people.stream().collect(groupingBy((Person p) -> p.getCity(), reducing("", mapper, binaryOp)));
        return longestLastNameByCity;
    }

    public Map<City, String> groupByCityWithMapping(List<Person> people) {
        Map<City, String> longestLastNameByCity =
                people.stream().collect(groupingBy((Person p) -> p.getCity(), Collectors.mapping(Person::getName, Collectors.joining(","))));
        return longestLastNameByCity;
    }


    public Map<City, List<Person>> groupPersonsByCity(List<Person> people) {

        Map<City, List<Person>> cityToPersonMap = people.stream().collect(groupingBy(Person::getCity));

        return cityToPersonMap;
    }

}

