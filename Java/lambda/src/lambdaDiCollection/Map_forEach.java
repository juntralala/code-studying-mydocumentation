package lambdaDiCollection;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Map_forEach {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.putAll(Map.of(
                "name", "Muhammad Junaidi",
                "age", "18",
                "address", "Handil Labuan Amas"
        ));

        // loop
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // anonymous class
        map.forEach(new BiConsumer<String, String>() {
            public void accept(String k, String v) {
                System.out.println(k + " : " + v);
            }
        });

        // lamda
        map.forEach((k, v) -> System.out.println(k + " : " + v));

    }
}
