package com.juntralala.profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

/**
 * Default profile spring ada `default`, jadi jika tidak disebutkan profile apapun yang aktif pada file
 * application.properties makan kedua class @Comoponent di bawah tidak akan ada yang dijalankan keduanya
 * karna 1 menggunakan profile `local` dan satunya `production`, bukan `default`
 */

@SpringBootTest(classes = ProfileApp.class)
@ActiveProfiles({"local"}) // <- untuk unittest, memilih profile untuk test
public class ProfileTest {

    @Autowired
    private SayHello sayHello;
    @Autowired
    private Environment env;

    @Test
    public void testProfile() {
        // kalau profile active nya diubah ke production atau default maka assertion dibawah error
        Assertions.assertEquals("Hello ujun from Local", sayHello.sayHello("ujun"));
    }

    @Test
    public void getActiveProfiles() {
        System.out.println(Arrays.toString(env.getActiveProfiles()));
    }

    @Test
    public void checkActiveProfiles() {
        Assertions.assertTrue(env.matchesProfiles("local"));
    }
}

@SpringBootApplication
// app
class ProfileApp {

}


interface SayHello {
    String sayHello(String name);
}

// component 1
@Component
@Profile({"local"})
class SayHelloLocal implements SayHello {
    @Override
    public String sayHello(String name) {
        return "Hello " + name + " from Local";
    }
}

// component 2
@Component
@Profile({"production"})
class SayHelloProduction implements SayHello {
    @Override
    public String sayHello(String name) {
        return "Hello " + name + " from Production";
    }
}