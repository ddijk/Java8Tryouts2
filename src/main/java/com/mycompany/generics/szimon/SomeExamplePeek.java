package com.mycompany.generics.szimon;

import java.util.Arrays;
import java.util.List;

public class SomeExamplePeek {

    public static void main(String[] args) {
        Some<List<? extends CharSequence>> some =
                Some.of(() -> Arrays.asList("a", "b", "c"));//.peek(System.out::println);
        some.peek(System.out::println);
    }
}
