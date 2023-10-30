package packageFunction;

import java.util.function.Supplier;

public class Suplier_ {
    public static void main(String[] args) {

        // anonymous class
        Supplier<String> supplier = new Supplier<>() {
            public String get() {
                return "Muhammad Junaidi";
            }
        };
        System.out.println( supplier.get() );

        Supplier<String> supp = () -> "Muhammad Hidayat";
        System.out.println( supp.get() );
    }
}
