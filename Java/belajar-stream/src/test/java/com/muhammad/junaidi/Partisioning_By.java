package com.muhammad.junaidi;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Selain grouping by, Collctors juga bisa digunakan untuk partisioning by
 * Hanya saja hasil dari partisioning by hanyalah 2 buah group boolean (true, false)
 * Hal ini berarti partisioning by hanya akan menghasilkan Map<Boolean, List<Value>>
 */

public class Partisioning_By {

    @Test
    public void testPartitioningBy() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> map1 = numbers.stream()
                .collect(Collectors.partitioningBy(number -> number > 5));
        System.out.println(map1);
    }

    @Test
    public void testPartitioningBy2() {
        List<String> names = List.of("Adam", "Idris", "Nuh", "Hud", "Sholeh", "Sulaiman");
        Map<Boolean, List<String>> map1 = names.stream()
                .collect(Collectors.groupingBy(name -> name.length() > 4));
        System.out.println(map1);
    }
}
