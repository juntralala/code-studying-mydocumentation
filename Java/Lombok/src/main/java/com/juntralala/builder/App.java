package com.juntralala.builder;

import java.util.List;

public class App {
    public static void main(String[] args) {
        withNoSingular();
        withSingular();
    }

    static void withNoSingular() {
        Person.PersonBuilder personBuilder = Person.builder()
                .id("12").name("ozon").age("17").hobbies(List.of("Coding", "Gaming"));

        Person person = personBuilder.build();

        System.out.println(person);
    }

    static void withSingular() {
        Person.PersonBuilder personBuilder = Person.builder()
                .id("12").name("ozon").age("17")
                .hobby("Coding").hobby("Gaming");

        Person person = personBuilder.build();

        System.out.println(person);
    }
}
