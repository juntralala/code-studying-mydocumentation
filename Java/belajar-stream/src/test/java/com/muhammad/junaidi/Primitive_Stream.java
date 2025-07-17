package com.muhammad.junaidi;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/** Primitive Stream
 * Sebelumnya kita sudah tahu bahwa implementasi Stream di Java adalah java.util.stream.Stream<T>
 * Namun, bagaimana jika kita butuh melakukan stream terhadap data primitive seperti int, long atau double
 * Karena, Generic hanya bisa menampung tipe data Object, maka Java Stream, dibuat implementasi Stream khusus
   tipe data primitive
 */

/**
 * java.util.stream.IntStream           => stream untuk tipe data int
 * java.util.stream.LongStream          => stream untuk tipe data long
 * java.util.stream.DoubleStream        => stream untuk tipe data double
 */

/** Primitive Stream Operations
 * Hampir semua stream operator yang pernah kita bahas, ada juga di primitive stream class
 * Bahkan ada beberapa operator yang lebih sederhana, seperti untuk aggregate, kita tidak perlu menggunakan operator
   lagi, bahkan ada operator everange() untuk menghitung rata-rata di primitive stream
 * Cara pembuatan Primitive Stream pun hampir mirip dengan Stream biasa, kita bisa menggunakan static method di class-nya,
   misal IntStream.of(), IntStream.builder(), dll
 */

public class Primitive_Stream {

    @Test
    public void testIntStream() {
        IntStream intStream = IntStream.range(10, 20);
        intStream.forEach(System.out::println);
    }

    @Test
    public void testLongStream() {
        LongStream longStream = LongStream.of(100, 200, 300, 400, 500);
        longStream.forEach(System.out::println);
    }

    @Test
    public void testDoubleStream() {
        DoubleStream doubleStreamBuilder = DoubleStream.builder().add(0.1).add(0.2).build();
        doubleStreamBuilder.forEach(System.out::println);
    }

    @Test
    public void testAverange() {
        IntStream intStream = IntStream.of(100, 200, 300, 400, 500);
        OptionalDouble optionalDouble = intStream.average();
        optionalDouble.ifPresent(System.out::println);
    }

    @Test
    public void testMapToObj() {
        IntStream.of(100, 200, 300, 400, 500)
                .mapToObj(number -> "Number : " + number)
                .forEach(System.out::println);
    }

}
