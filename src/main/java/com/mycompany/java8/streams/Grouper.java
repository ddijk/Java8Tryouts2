package com.mycompany.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

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

    /**
     * This method splits an input sentence in its words and then creates
     * a map from this word to the length of this word.
     * @param sentence
     * @return a map from word to word length
     */
//    public Map<String, Long> groupByWordLength(String sentence) {
//     //   Collector<? super String, ?, Long> wordLength = Collectors.reducing((String s1, String s2)-> Long.valueOf(s1.length()));
//
//        Collector<? super String, ?, Long> wordLength = Collectors.maxBy(Comparator.comparingLong(String::length));
//        Collector<String, ?, Map<String, Long>> byWordLength = groupingBy(Function.identity(), wordLength);
//        return Arrays.stream(sentence.split(" ")).collect(byWordLength);
//    }

//    public Map<String, Long> groupByWordLength2(String sentence) {
//        //   Collector<? super String, ?, Long> wordLength = Collectors.reducing((String s1, String s2)-> Long.valueOf(s1.length()));
//
//        Collector<? super String, ?, Long> wordLength = Collectors.reducing();
//        Collector<String, ?, Map<String, Long>> byWordLength = groupingBy(Function.identity(), wordLength);
//        return Arrays.stream(sentence.split(" ")).collect(groupingBy(Function.identity(),  ).mapToLong(String::length).collect(byWordLength);
//    }

    public Map<String, String> groupByWordToItself(String sentence) {
        //   Collector<? super String, ?, Long> wordLength = Collectors.reducing((String s1, String s2)-> Long.valueOf(s1.length()));

        Supplier<String> supplier = () -> "";
        BiConsumer<String, String> biconsumer = (String s1, String s2 ) -> System.out.println(s1+","+s2);
        BinaryOperator<String> binaryOperator = ( String s1, String s2) -> s2;
        Collector<String, String, String> toItselfCollector = Collector.of(supplier, biconsumer, binaryOperator);
        Collector<String, ?, Map<String, String>> byWordLength = groupingBy(Function.identity(), toItselfCollector);
        return Arrays.stream(sentence.split(" ")).collect(byWordLength);
    }
}
