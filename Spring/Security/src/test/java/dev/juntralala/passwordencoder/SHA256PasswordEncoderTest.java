package dev.juntralala.passwordencoder;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SHA256PasswordEncoderTest {

    @Test
    public void sha256() {
        @Deprecated
        PasswordEncoder encoder = new StandardPasswordEncoder();
        String plainPassword = "rahasia";
        String encodedPassword = encoder.encode(plainPassword);

        assertTrue(encoder.matches(plainPassword, encodedPassword));
        System.out.println(encodedPassword);
    }
}
