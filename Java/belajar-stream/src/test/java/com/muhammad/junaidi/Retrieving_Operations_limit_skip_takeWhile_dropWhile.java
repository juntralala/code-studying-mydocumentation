package com.muhammad.junaidi;

/**
 * Retrieving Operations adalah operasi pada Stream untuk melakukan pengambilan sebagian data
 * Secara garis besar, cara kerjanya hampir mirip dengan filtering
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * limit(n)
 * skip(n)
 * takeWhile(T -> Boolean)
 * dropWhile(T -> Boolean)
 */

public class Retrieving_Operations_limit_skip_takeWhile_dropWhile {

    @BeforeEach
    public void setUp(){System.out.println();}

    @Test
    public void testLimit() {
        Arrays.stream(new String[] {"Ujun", "Dawi", "Madan", "Barizi", "Unai", "Syarwani"})
                .limit(3)
                .forEach(System.out::println);
    }

    @Test
    public void testSkip() {
        Arrays.stream(new String[] {"Ujun", "Dawi", "Madan", "Barizi", "Unai", "Syarwani"})
                .skip(3)
                .forEach(System.out::println);
    }

    @Test
    public void testTakeWhile() {
        Arrays.stream(new String[] {"Ujun", "Dawi", "Madan", "Barizi", "Unai", "Syarwani", "Udin"})
                .takeWhile(name -> name.length() <= 4)
                .forEach(System.out::println);
    }

    @Test
    public void testDropWhile() {
        Arrays.stream(new String[] {"Ujun", "Dawi", "Madan", "Barizi", "Unai", "Syarwani", "Udin"})
                .dropWhile(name -> name.length() <= 4)
                .forEach(System.out::println);
    }

}
