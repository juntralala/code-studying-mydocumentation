package collectionDefaultMethod;

/**
 * di java 8 ada fitur bernama Default Method, dimana kita bisa menambahkan konkrit method di interface
 * fitur ini banyak sekali digunakan di java Collection, karena kita tahu semua collection di java memiliki kontrak interface
   sehingga di java bisa dengan mudah meng-improve kemampuan semua collection hanya dengan menambahkan default method
   di interface collectionnya
 */

/** Default Mthod di Collection
 * Iterable.forEach(consumer)         melakukan iterasi seluruh data collection
 * List.removeIf(predicate)           menghapus data collection menggunbakan predicate
 * List.replaceAll(operator)          mengubah seluruh data collection
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class CollectionDefaultMethodApp {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(25);
        for(int i=1 ; i<=25 ; i++){
            numbers.add(i);
        }
        System.out.println(numbers);

        numbers.replaceAll(new UnaryOperator<Integer>() {
            public Integer apply(Integer integer) {
                return integer + 2;
            }
        });
        System.out.println(numbers);

        numbers.forEach(new Consumer<Integer>() {
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        numbers.removeIf(new Predicate<Integer>() {
            public boolean test(Integer integer) {
                if (integer % 2 == 1) {
                    return true;
                }
                return false;
            }
        });
        System.out.println(numbers);

    }
}
