package com.muhammad.junaidi;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class Infinite_Stream {

    @Test
    public void infiniteStream() {
        Stream<String> generate = Stream.generate(() -> "Ujun");
//        generate.forEach(System.out::println);
    }

    @Test
    public void infiniteStream2() {
        Stream<Integer> iterate = Stream.iterate(1, (value) -> value + 1);
//        iterate.forEach(System.out::println);
    }

}
