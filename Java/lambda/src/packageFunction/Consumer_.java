package packageFunction;

import java.util.function.Consumer;

public class Consumer_ {
    public static void main(String[] args) {
        // anonimous class
        Consumer<String> consumer = new Consumer<>() {
            public void accept(String value) {
                System.out.println(value);
            }
        };
        consumer.accept("Hairudin");

        // lambda
        Consumer<String> con = value -> System.out.println(value);
        con.accept("Junaidi");
    }
}
