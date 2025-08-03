package packageFunction;

import java.util.function.Function;

public class Funcion_ {
    public static void main(String[] args) {

        // anonymous class
        Function<String, Integer> length = new Function<>() {
            public Integer apply(String value) {
                return value.length();
            }
        };
        System.out.println( length.apply("Muhammmad junaidi") );

        // lambda
        Function<String, Integer> len = val -> val.length();
        System.out.println( len.apply("Humaidi") );

    }
}
