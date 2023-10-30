package com.muhammad.junaidi;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * Stream secara default bersifat Lazy
 * Dia tidak akan mengalirkan data jika belum menggunakan terminal operation
 * Selain itu, data akan dialirkan seperlunya saja, teragantung terminal operation nya
 */

public class Lazy_Evaluation {

    @Test
    public void lazyTest() {
        List<String> names = List.of("Ujun", "Ajid", "Udin");

        Stream<String> namesUpper = names.stream()
                .map(name -> {
                    System.out.printf("Change %s to Uppercase\n",name);
                    return name.toUpperCase();
                });

        namesUpper.forEach(System.out::println);
    }

}
