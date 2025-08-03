package dev.juntralala.cryptography;

import org.junit.jupiter.api.Test;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.keygen.StringKeyGenerator;

import java.util.Arrays;

public class KeyGeneratorTest {

    @Test
    public void keyGeneratorString() {
        StringKeyGenerator keyGenerator = KeyGenerators.string();
        String key = keyGenerator.generateKey();
        System.out.println(key);
    }

    @Test
    public void keyGeneratorSecureRandom() {
        BytesKeyGenerator keyGenerator1 = KeyGenerators.secureRandom(); // default keylenght = 8
        BytesKeyGenerator keyGenerator2 = KeyGenerators.secureRandom(16);
        byte[] key1 = keyGenerator1.generateKey();
        byte[] key2 = keyGenerator2.generateKey();
        System.out.println(Arrays.toString(key1));
        System.out.println(Arrays.toString(key2));
    }

    @Test
    public void keyGeneratorShared() {
        BytesKeyGenerator keyGenerator = KeyGenerators.shared(16);
        byte[] key1 = keyGenerator.generateKey();
        byte[] key2 = keyGenerator.generateKey();
        System.out.println(Arrays.toString(key1));
        System.out.println(Arrays.toString(key2));
    }
}
