package com.muhammad.junaidi;

// membuat stream dari array

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Stream_dari_Array {

    @Test
    public void arrayStream() {
        String[] names = new String[] {"Ujun","Rifani","Jailani","Muhammad", "Waji", "Amin"};

        Stream<String> streamFromArray =  Arrays.stream(names);
        streamFromArray.forEach(System.out::println);
    }

    @Test
    public void collectionStream() {
        Collection<String> collection = List.of("Ujun", "Muhammad", "Junaidi");

        Stream<String> streamFromArray = collection.stream();
        streamFromArray.forEach(System.out::println);
//        streamFromArray.forEach(System.out::println); // stream tidak bisa dijalankan 2 kali
    }

}
