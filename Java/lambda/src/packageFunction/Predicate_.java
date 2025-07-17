package packageFunction;

import java.util.function.Predicate;

public class Predicate_ {
    public static void main(String[] args) {

        // anonymous function
        Predicate<String> isBlank = new Predicate<>() {
            public boolean test(String teks) {
                return teks.isBlank();
            }
        };
        System.out.println( isBlank.test("") );

        // lamda
        Predicate<String> blank = teks -> teks.isBlank();
        System.out.println( blank.test("") );

    }
}
