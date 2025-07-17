package lambdaDiOptional;

import java.util.Optional;

/**
 * di java 8, ava menyediakan sebuah class baru bernama Opsional yang berada di java.util
 * Class ini digunakan sebagai wrapper untuk value yang bisa bernilai null
 * Opsional didesain agar kita lebih muda ketika beroperasi dengan object yang bisa null
 * karena NullPointEception adalah salah satu hal yang sering di temui oleh programer java
 */

public class OpsionalApp {
    public static void main(String[] args) {

        String name = null;

        sayHello("Ujun");
        sayHello(null);
        sayHello(name);

    }

    public static void sayHello(String name) {

        String upperName = Optional.ofNullable(name)
                .map(String::toUpperCase)
                .orElse("DECK");

        System.out.println("Hallo " + upperName);

//        Optional.ofNullable(name)
//                .map(String::toUpperCase)
//                .ifPresentOrElse(
//                        value -> System.out.println("Hello " + value),
//                        () -> System.out.println("Hello ")
//                );

//        Optional<String> opsionalName = Optional.ofNullable(name);
//        Optional<String> opsionalNameUpper = opsionalName.map(value -> value.toUpperCase());
//        opsionalNameUpper.ifPresent(value -> System.out.println("Hello " + value));
    }

}

