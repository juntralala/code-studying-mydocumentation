package com.muhammad.junaidi;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * Berbeda dengan Java Collection, hal yang sangat menarik adalah fitur Stream Operations nya
 * Stream Operations adalah kumpulan operasi-operasi yangbisa kita gunakan untuk memanipulasi Stream itu sendiri
 * Adda banyak sekali jenis-jenis Stream Operations yang nanti akan kita bahas satu perd\ satu
 * Namun secara garis besar, Stream Operations tidak akan merubsh data aslinya, melainkan hasil dari Stream operaions
   adalah Stream baru
 */

public class Stream_Operation_Map {

    @Test
    public void mapOperationTest() {

        List<String> names = List.of("Ujun", "Muhammad", "Junaidi");

        Stream<String> namesStream = names.stream();
        Stream<String> namesStreamUpper = namesStream.map(name -> name.toUpperCase());

        namesStreamUpper.forEach(System.out::println);
        names.forEach(System.out::println);
    }
}
