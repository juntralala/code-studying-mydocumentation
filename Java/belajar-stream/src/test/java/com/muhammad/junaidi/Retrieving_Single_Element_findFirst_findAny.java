package com.muhammad.junaidi;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

/** Retrieving Single Element
 * Stream juga memiliki kemampuan untuk menagmbil satu element saja
 * Namun operasi jenis ini merupakan operasi terminal, sehingga akan secara otomatis menjalanakn aliran data di Strean
 */

/**
 * findFirst()          => mengambil satu element
 * findAny()            => mengambil satu element secara random
 */

public class Retrieving_Single_Element_findFirst_findAny {

    @Test
    public void testFindFirst() {
        Optional<String> optional = Arrays.stream(new String[] {"Ujun", "Dawi", "Madan", "Barizi", "Unai", "Syarwani", "Udin"})
                .findFirst();

        optional.ifPresent(name -> System.out.println(name));
    }

    @Test
    public void testFindAny() {
        Optional<String> optional = Arrays.stream(new String[] {"Ujun", "Dawi", "Madan", "Barizi", "Unai", "Syarwani", "Udin"})
                .findAny();

        optional.ifPresent(System.out::println);
    }



}
