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

    public static List<List<String>> split(List<String> input) {

        // indexes of nulls
        IntStream indexesOfNulls = IntStream.concat(IntStream.of(-1), IntStream.range(0, input.size()).filter(i->input.get(i)==null));

         IntStream indexes =        IntStream.concat(indexesOfNulls, IntStream.of(input.size()));

        int[] indexArrayOfNull = new int[] {-1,2,4,7};//indexes.toArray();

        // (-1,2) (3,4)  (5, size+1)


      //  indexesOfNulls.forEach(i-> System.out.println(i));

       return indexes.mapToObj(i->input.subList(i+1, indexArrayOfNull[i+1])).collect(toList());


    }

    static List<List<String>> splitStream(List<String> input) {
        int sz = input.size();
        int[] indexes =
                IntStream.rangeClosed(-1, sz)
                        .filter(i -> i == -1 || i == sz || input.get(i) == null)
                        .toArray();

        System.out.println(Arrays.toString(indexes));
        return IntStream.range(0, indexes.length-1)
                .mapToObj(i -> input.subList(indexes[i]+1, indexes[i+1]))
                .collect(toList());
    }
}
