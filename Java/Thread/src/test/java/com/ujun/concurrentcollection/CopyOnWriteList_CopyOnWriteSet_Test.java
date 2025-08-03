package com.ujun.concurrentcollection;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Kelas khusus untuk thread safe tanpa synchronized, dengan cara melakukan copy jika terjadi operasi write
 * Keuntungannya memiliki operasi read-heavy dan tidak perlu banyak melakukan operasi write
 * Kekurangan memakan ruang memori lebih besar jika melakukan operasi write, write lebih lambat karna melakukan copy
 * Tidak melemparkan ConcurrentModificationException
 */

// alternatif gunakan synchronized collection (SynchronizedCollectionTest)

public class CopyOnWriteList_CopyOnWriteSet_Test {
    @Test
    public void testCopyOnWriteArrayList() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.addAll(List.of("Satu", "Dua", "Tiga"));

        list.forEach(System.out::println);
    }

    @Test
    public void testCopyOnWriteSet() {
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
        set.addAll(List.of("Satu", "Dua", "Tiga"));

        set.forEach(System.out::println);
    }
}
