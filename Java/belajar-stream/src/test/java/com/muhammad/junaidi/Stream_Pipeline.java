package com.muhammad.junaidi;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * Saat kita membuat Stream, biasanya kita akan banyak membuat operasi terhadap Stream tersebut
 * Dan biasanya kita akan membuat Stream Pipeline
 * Stream pipiline terdari dari sebuah sumber Stream(array, colllection, dll), lalu diikuti dengan kosong atau lebih
   stream operations dan diakhiri dengan operasi akhir, misalnya forEach
 * Saat menggunakan Stream, hampir kebanyakan kita pasti akan membuat Stream Pipeline
 */

public class Stream_Pipeline {

    @Test
    public void pipelineTest() { // jarang digunakan seperti ini
        List<String> names = List.of("Ujun", "Udin", "Amat");

        Stream<String> namesStream = names.stream();
        Stream<String> namesUpperStream = namesStream.map(String::toUpperCase);
        Stream<String> namesUpperStreamAdd = namesUpperStream.map(upper -> "Mr. " + upper);

        namesUpperStreamAdd.forEach(System.out::println);
    }

    @Test
    public void pipelineTestOk() { // jarang digunakan seperti ini
        List<String> names = List.of("Ujun", "Ipul", "Amang");

        names.stream()
                .map(String::toUpperCase)
                .map(upper -> "Mr. " + upper)
                .forEach(System.out::println);
    }

}
