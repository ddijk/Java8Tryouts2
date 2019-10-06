package com.mycompany.generics.szimon;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * https://e.printstacktrace.blog/java-type-inference-generic-methods-chain-call/
 */
public final class Some<T> {

    private final T value;

    private Some(final T t) {
        this.value = t;
    }

    static <T> Some<T> of(final Supplier<T> supplier) {
        return new Some<>(supplier.get());
    }

    public Some<T> peek(final Consumer<T> consumer) {
        consumer.accept(value);
        return this;
    }

    public T get() {
        return value;
    }
}
