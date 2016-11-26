package com.mycompany;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by dickdijk on 21/11/16.
 */
public class ListSplitter {

    // input a,b,null,c,null,d,e
    public static List<List<String>> split(List<String> input) {

        String[] sa = input.toArray(new String[]{});

        IntStream is = IntStream.concat(IntStream.of(-1), IntStream.range(0, input.size()).filter(i -> input.get(i) == null));
        int[] indexes = IntStream.concat(is, IntStream.of(input.size())).toArray();


        return IntStream.range(0, indexes.length - 1).mapToObj(i -> input.subList(indexes[i] + 1, indexes[i + 1])).collect(toList());


    }

    static List<List<String>> splitStream(List<String> input) {
        int sz = input.size();
        int[] indexes =
                IntStream.rangeClosed(-1, sz)
                        .filter(i -> i == -1 || i == sz || input.get(i) == null)
                        .toArray();

        System.out.println(Arrays.toString(indexes));
        return IntStream.range(0, indexes.length - 1)
                .mapToObj(i -> input.subList(indexes[i] + 1, indexes[i + 1]))
                .collect(toList());
    }
}
