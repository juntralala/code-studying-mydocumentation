package dev.juntralala.passwordencoder;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoOpPasswordEncoderTest {

    @Test
    public void noop() {
        PasswordEncoder encoder = NoOpPasswordEncoder.getInstance();
        String plainPassword = "rahasia";
        String encodedPassword = encoder.encode(plainPassword);

        assertTrue(encoder.matches(plainPassword, encodedPassword));
        System.out.println(encodedPassword);
    }
}
