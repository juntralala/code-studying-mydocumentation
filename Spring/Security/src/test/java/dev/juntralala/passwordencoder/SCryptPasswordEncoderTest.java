package dev.juntralala.passwordencoder;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SCryptPasswordEncoderTest {

    // Harus install dependency implementasi algo SCrypt
    @Test
    public void scrypt() {
        PasswordEncoder encoder = SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8();
        String plainPassword = "rahasia";
        String encodedPassword = encoder.encode(plainPassword);

        assertTrue(encoder.matches(plainPassword, encodedPassword));
        System.out.println(encodedPassword);
    }

    @Test
    public void scrypt_deprecated() {
        PasswordEncoder encoder = SCryptPasswordEncoder.defaultsForSpringSecurity_v4_1();
        String plainPassword = "rahasia";
        String encodedPassword = encoder.encode(plainPassword);

        assertTrue(encoder.matches(plainPassword, encodedPassword));
        System.out.println(encodedPassword);
    }
}
