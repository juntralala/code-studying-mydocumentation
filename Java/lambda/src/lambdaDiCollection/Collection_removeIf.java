package lambdaDiCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Collection_removeIf {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.addAll(List.of("UJUN", "DAWI", "Humaidi", "Khairudin"));

        // tidak bisa menggunakn loop

        // anonymous class
//        names.removeIf(new Predicate<String>() {
//            public boolean test(String value) {
//                return value.length() > 5;
//            }
//        });

        // lamda
        names.removeIf(value -> value.length() > 5);

        System.out.println(names); // print

    }
}
