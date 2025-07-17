package com.muhammad.junaidi;

// ini terminal operations
/**
 * Check Opeartions adalah operasi yang digunakan untuk melakukan pengecekan data didalam Stream
 * Ada banyak sekali operasi yang bisa digunakan untuk melakukan pengecekan
 * Dan hasil operasi check adalah boolean
 */

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * anyMatch(T -> Boolean)           => Apakah ada salah satu data yang match dengan kondisi
 * allMatch(T -> Boolean)           => Apakah setiap data yang match dengan kondisi
 * noneMatch(T -> Boolean)          => apakah semua data tidak ada yang cocok dengan kondisi
 */

public class Check_Operations {

    @Test
    public void testAnyMatch() {
        boolean isMatch = List.of(1,4,8,10).stream()
                .anyMatch(number -> number == 10 );

        System.out.println(isMatch);
    }

    @Test
    public void testAllMatch() {
        boolean isMatch = List.of(1,4,8,10).stream()
                .allMatch(number -> number == 10 );

        System.out.println(isMatch);
    }

    @Test
    public void testNoneMatch() {
        boolean isMatch = List.of(1,4,8,10).stream()
                .noneMatch(number -> number == 10 );

        System.out.println(isMatch);
    }

}
