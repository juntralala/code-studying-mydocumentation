package lambdaDiCollection;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Iterable_forEach {
    public static void main(String[] args) {

        List<String> names = List.of("Ujun", "Arif", "Dayat");

        // for-each loop
        for (var val : names) {
            System.out.println(val);
        }

        // anonymous class
        names.forEach(new Consumer<>() {
            public void accept(String value) {
                System.out.println(value);
            }
        });

        // lamda
        names.forEach(value -> System.out.println(value));

        // lamda method references
        names.forEach(System.out::println);

    }
}
