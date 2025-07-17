package com.muhammad.junaidi;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * Kadang kala kita ingin membuat Stream Builder secara manual, seperti menambahkan data nya secara manual misalnya
 * Java menyediakan Stream Builder untuk membuat Stream secara manual, dan kita bisa menggunakan nya seperti Collection
   kita bisa membuat Stream Builder, lalu menambahkan data ke Stream Builder, setelah selesai baru kita membuat Streamnya
 * https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/stream/Stream.Builder.html
 */

public class Stream_Builder {

    @Test
    public void builderTest() {
        Stream.Builder<String> buildernya = Stream.builder();
        buildernya.accept("Ujun");              // ini me-return void
        buildernya.add("Ujun2").add("Ujun3");     // ini me-return builder itu sendiri

        Stream<String> streamnya = buildernya.build();
        streamnya.forEach(System.out::println);
    }

    @Test
    public void builderTestSimplify() {
        Stream<Object> resultStream = Stream.builder()
                .add("Junaidi1").add("Junaidi2").add("Junaidi3").build();

        resultStream.forEach(System.out::println);
    }

}
