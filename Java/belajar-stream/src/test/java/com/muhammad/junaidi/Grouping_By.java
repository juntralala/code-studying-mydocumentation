package com.muhammad.junaidi;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Collectors bisa juga digunakan untuk meng-grouping by sebuah Stream
 * Hasil dari grouping adalah Map<Group, List<Value>>
 */

public class Grouping_By {

    @Test
    public void testNumberGroupingby() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<String, List<Integer>> map1 = numbers.stream()
                .collect(Collectors.groupingBy(integer -> integer > 5 ? "Besar" : "Kecil"));
        System.out.println(map1);
    }

    @Test
    public void testNameGroupingby() {
        List<String> names = List.of("Adam", "Idris", "Nuh", "Hud", "Sholeh", "Sulaiman");
        Map<String, List<String>> map1 = names.stream()
                .collect(Collectors.groupingBy(name -> name.length() > 5 ? "Panjang" : "Pendek"));
        System.out.println(map1);
    }

}
