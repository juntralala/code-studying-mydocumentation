package dev.juntralala.crypto;

import org.junit.jupiter.api.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.*;
import java.util.HexFormat;

public class KeyGeneratorTest {

    @Test
    public void providedKeyGenerators() {
        for (Provider provider : Security.getProviders()) {
            for (Provider.Service service : provider.getServices()) {
                if ("KeyGenerator".equalsIgnoreCase(service.getType())) {
                    System.out.println(provider.getName() + " => " + service.getAlgorithm());
                }
            }// <- rest of data and padding
        }
    }

    @Test
    public void generatingKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        int keyBitSize = 256;
        var random = new SecureRandom();

        keyGenerator.init(keyBitSize, random);

        SecretKey key = keyGenerator.generateKey();
        // setelah digenerate key bisa digunakan untuk encrypt dengan Cipher

        System.out.println(HexFormat.of().formatHex(key.getEncoded()));
        System.out.println(key.getFormat());
    }

    @Test
    public void generatingKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1028);

        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        System.out.println(HexFormat.of().formatHex(privateKey.getEncoded()));
        System.out.println(HexFormat.of().formatHex(publicKey.getEncoded()));
        System.out.println("private format: " + privateKey.getFormat());
        System.out.println("public format: " + publicKey.getFormat());
    }
}
