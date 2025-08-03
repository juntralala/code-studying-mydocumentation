package dev.juntralala.passwordencoder;

import org.junit.jupiter.api.Test;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DelegatingPasswordEncoderTest {

    @Test
    public void factoryDelegatingPasswordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String plainPassword = "rahasia";
        String encodedPassword = encoder.encode(plainPassword);

        assertTrue(encoder.matches(plainPassword, encodedPassword));
        System.out.println(encodedPassword);

        /* default from factory:
        bcrypt - BCryptPasswordEncoder (Also used for encoding)
        ldap - LdapShaPasswordEncoder
        MD4 - Md4PasswordEncoder
        MD5 - new MessageDigestPasswordEncoder("MD5")
        noop - NoOpPasswordEncoder
        pbkdf2 - Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_5()
        pbkdf2@SpringSecurity_v5_8 - Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8()
        scrypt - SCryptPasswordEncoder.defaultsForSpringSecurity_v4_1()
        scrypt@SpringSecurity_v5_8 - SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8()
        SHA-1 - new MessageDigestPasswordEncoder("SHA-1")
        SHA-256 - new MessageDigestPasswordEncoder("SHA-256")
        sha256 - StandardPasswordEncoder
        argon2 - Argon2PasswordEncoder.defaultsForSpringSecurity_v5_2()
        argon2@SpringSecurity_v5_8 - Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8()
         */
    }

    @Test
    public void delegatingPasswordEncoderCustom() {
        String idForEncode = "bcrypt";

        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put(idForEncode, new BCryptPasswordEncoder(12));
        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        encoders.put("pbkdf2", Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8());
        encoders.put("scrypt", SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8());
        encoders.put("argon2", Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8());
        encoders.put("sha256", new StandardPasswordEncoder());

        PasswordEncoder encoder = new DelegatingPasswordEncoder(idForEncode, encoders);
        String plainPassword = "rahasia";
        String encodedPassword = encoder.encode(plainPassword);

        assertTrue(encoder.matches(plainPassword, encodedPassword));
        System.out.println(encodedPassword);
    }
}
