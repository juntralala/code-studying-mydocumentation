package com.muhammad.junaidi;

import org.junit.jupiter.api.Test;

import java.util.List;

// peek itu intermediete operations  => jadi datanya tidak mengalir
/** For Each Operations
 * forEach(T -> void)       => Melakukan iterasi satu per satu data di Stream. ini adalah Terminal Operations
 * peek(T -> void)          => Melakukan iterasi satu per satu data di Stream, namun mengembalikan Stream lagi, dan
                               ini bukanlah Terminal Operations
 */

public class forEach_peek {

    @Test
    public void testPeek() {
        List.of("Ujun", "Muhammad", "Junaidi").stream()
                .peek(name -> System.out.println("Mr. " + name))
                .forEach(System.out::println);
    }

    @Test
    public void testPeek2() {
        List.of("Ujun", "Muhammad", "Junaidi").stream()
                .peek(name -> System.out.println("Mr. " + name));
//                .forEach(System.out::println);
    }

}
