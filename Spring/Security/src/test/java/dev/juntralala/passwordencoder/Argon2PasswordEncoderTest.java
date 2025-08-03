package dev.juntralala.passwordencoder;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Argon2PasswordEncoderTest {

    // Implementasi Argon2 tidak secara default included di spring-security-core, harus install dependencynya
    @Test
    public void argon2() {
        PasswordEncoder encoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();
        String plainPassword = "rahasia";
        String encodedPassword = encoder.encode(plainPassword);

        assertTrue(encoder.matches(plainPassword, encodedPassword));
        System.out.println(encodedPassword);
    }

    @Test
    public void argon2_deprecated() {
        PasswordEncoder encoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_2();
        String plainPassword = "rahasia";
        String encodedPassword = encoder.encode(plainPassword);

        assertTrue(encoder.matches(plainPassword, encodedPassword));
        System.out.println(encodedPassword);
    }
}
