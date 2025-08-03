package dev.juntralala.passwordencoder;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BCryptPasswordEncoderTest {

    @Test
    public void bcrypt() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String plainPassword = "rahasia";
        String encodedPassword = encoder.encode(plainPassword);

        assertTrue(encoder.matches(plainPassword, encodedPassword));
        System.out.println(encodedPassword);
    }
}
