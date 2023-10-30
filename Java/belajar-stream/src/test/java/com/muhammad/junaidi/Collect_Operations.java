package com.muhammad.junaidi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Collector Operations
 * Stream memiliki sebuah operator bernama collect(Collector), function ini biasanya digunakan untuk meng-collect data
   stream dan kita ubah menjadi struktur data yang kita inginkan, biasanya kebanyakan developer menggunakan operator
   collect() untuk mengubah Stream menjadi Collection
 * Operator collect() membutuhkan paramter Collector, namun biasanya kitajarang sekali membuat implementasi interface
   Collector, karena iya terlalu kompleks
 * https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/stream/Collector.html
 * Untungnya Java Stream sudah menyediakan class helper untuk membuat Collector, bernama Collectors
 */

/** Collectors
 * Collectors adalah class helper yang bisa kita gunakan untuk membuat Collector
 * Ini mempermudah kita ketika ingin melakukan operasi collect terhadap sebuah Stream
 * Ada banyak sekali static method yang terdapat di class Collectors, dan nanti kita akan coba bahas bebearpa method
   yang sering digunakan
 * https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/stream/Collector.html
 */

/** Membuat Map dengan Collectiors
 * Selain Collection, Collectors juga bisa digunakan untuk membuat Map dari String
 * Yang membedakan dengan List dan Set, kita harus tentukan function untuk membuat Key dan Value nya jika ingin
   membuat Map
 * Ada banyak function yang bisa kita gunakan untuk membuat Map sesuai kebutuhan, seperti :
   Collectors.toMap(...),
   Collectors.toUnmodifiableMap(...),
   Collectors.toConcurrentMap(...),
 */

public class Collect_Operations {

    Stream<String> namesStream;

    @BeforeEach
    public void makeStream() {
        namesStream = Stream.of("Ujun", "Muhammad", "Junaidi");
    }

    @Nested
    public class CollectionCollectors {

        @Test
        public void testSet() {
            Set<String> set = namesStream.collect(Collectors.toSet());
//            Set<String> imutableSet = namesStream.collect(Collectors.toUnmodifiableSet());      // membuat imutable nya
            set.forEach(System.out::println);
        }

        @Test
        public void testList() {
            List<String> list = namesStream.collect(Collectors.toList());
//            List<String> imutableList = namesStream.collect(Collectors.toUnmodifiableList());      // membuat imutable nya
        }
    }

    @Nested
    public class MapCollectors {

        @Test
        public void testMap() {
            Map<String,Integer> map = namesStream.collect(Collectors.toMap(name -> name, name -> name.length()));
            map.forEach((key, value) -> System.out.println(key + "\t: " + value));
        }



    }

}
