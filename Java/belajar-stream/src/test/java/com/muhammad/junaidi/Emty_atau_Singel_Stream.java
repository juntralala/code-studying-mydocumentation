package com.muhammad.junaidi;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class Emty_atau_Singel_Stream {

    Stream<String> emptyStream = Stream.empty();

    Stream<String> singelStream = Stream.of("Muhammad Junaidi");

    Stream<String> nullStream = Stream.ofNullable(null);

    // menjalankan Stream
    @Test
    public void alirkanSingleStream() {
        singelStream.forEach(System.out::println);
    }

}
