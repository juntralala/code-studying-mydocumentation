package com.muhammad.junaidi;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

/** Transformation Opeartions
 * Ada Banyak Stream Operationsdi Java Stream, Kita akan mulai bahas dari Tranformations Operations
 * Transformation Operations adalah operasi yang digunakan untuk mungubah bentukStream
 * Ada banyak function yang bisa kita gunakan untuk mengubah Stream menjadi Stream baru, contohnya map dan flatMap
 */

public class Tranformation_Operations_map_flatMap {

    @Test
    public void testMap() {
        List.of("Ujun", "Muhammad", "Junaidi").stream()
                .map(String::toUpperCase)
                .map(String::length)
                .forEach(System.out::println);
    }

    @Test
    public void testFlatMap() {
        List.of("Ujun", "Muhammad", "Junaidi").stream()
                .map(String::toUpperCase)
                .flatMap(upperName -> Stream.of(upperName, upperName.length()))
                .forEach(data -> System.out.println(data));

    }

}
