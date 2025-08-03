package com.muhammad.junaidi;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class Stream_Of {

    @Test
    public void testStreamOf() {
        Stream.of("ujun", "Junaidi")
                .forEach(System.out::println);
    }

}
