package com.mycompany.generics.szimon;

import java.util.Arrays;
import java.util.List;

final class SomeExample {

    public static void main(String[] args) {
        Some<List<? extends CharSequence>> some =
                Some.of(() -> Arrays.asList("a", "b", "c"));

        final List<? extends CharSequence> x = some.get();
        System.out.println(x);
    }
}
