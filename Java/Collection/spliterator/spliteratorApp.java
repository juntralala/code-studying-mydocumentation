package spliterator;

/**
 * Splterator adalah interface yang bisa digunakan untuk melakukan partisi data colection
 * biasanya ini digunakan ketika kita akan memproses collection dalam jumlah besar, lalu agar lebih cepat diplit mejadi
   beberapa dan diproses menjadi paralel agar lebih cepat
 * penggunaan spliterator biasanya erat kaitanya engan Java Thread atau java Corcurrency, namun di materi ini kita tidak bisa
   membahas tentang itu, hanya fokus tentang ke Spliterator
 */

/** inner interface splterator
 * OfPrimitive
 * OfInt
 * OfLong
 * OfDouble
 */

/** method Splterator
 * tryAdvance(Consumer<? super T>) : boolean
 * forEachRemaining(Consumer<? super T>) : void
 * trySplit() : Spliterator<T>
 * estimateSize() : Long
 * characteristics(int) : boolean
 * getComparator() : Comparator<? super T>
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/** field Spliterator
 * ORDERED
 * DISTINCT
 * SORTED
 * SIZED
 * NONNULL
 * IMMUTABLE
 * CONCURRENT
 * SUBSIZED
 */

public class spliteratorApp {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.addAll(List.of("UJUN", "ARIF", "DAYAT", "ALIA", "HATIM", "AMI"));

        Spliterator<String> splterator1 = names.spliterator();
        Spliterator<String> splterator2 = splterator1.trySplit();

        System.out.println(splterator1.estimateSize());
        System.out.println(splterator2.estimateSize());

        splterator1.forEachRemaining(new Consumer<String>() {
            public void accept(String s) {
                System.out.println(s);
            }
        });

        splterator2.forEachRemaining(new Consumer<String>() {
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println(splterator1.estimateSize());
        System.out.println(splterator2.estimateSize());
    }
}
