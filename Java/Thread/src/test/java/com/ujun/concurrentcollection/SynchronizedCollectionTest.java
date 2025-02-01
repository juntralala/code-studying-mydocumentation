package com.ujun.concurrentcollection;


import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/** Konversi dari Java Collection
 * Pada kasus tertentu, kadang kita tetap butuh menggunakan Java Collection, namun butuh menggunakan multiple thread
 * Untuk kasus seperti itu, disarankan merubah Java Collection menjadi synchronized menggunakan helper method Collections.synchronized…(collection)
 */

// Gunakan cara ini jika read-write balance
// dan ingin menghindari overhead memory dibanding CopyOnWriteList dan CopyOnWriteSet

public class SynchronizedCollectionTest {

    @Test
    public void test() {
        List list = Collections.synchronizedList(List.of(1, 2, 5, 7));
        Set set = Collections.synchronizedSet(Set.of(1, 2, 5, 7));
    }

}
