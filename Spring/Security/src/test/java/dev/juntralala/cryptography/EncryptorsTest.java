package dev.juntralala.cryptography;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;

import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;

public class EncryptorsTest {

    @Test
    public void encryptStronger() {
        String rawData = "My Kisah";
        String key = KeyGenerators.string().generateKey();
        BytesEncryptor encryptor = Encryptors.stronger("password123", key);
        byte[] encryptedData = encryptor.encrypt(rawData.getBytes(UTF_8));
        System.out.println(Arrays.toString(encryptedData));
    }

    @Test
    public void encryptStandard() {
        String rawData = "My Kisah";
        String key = KeyGenerators.string().generateKey();
        BytesEncryptor encryptor = Encryptors.standard("password123", key);
        byte[] encryptedData = encryptor.encrypt(rawData.getBytes(UTF_8));
        System.out.println(Arrays.toString(encryptedData));
    }

    @Test
    public void encryptText() { // for text, backed by Encryptors.standard()
        String rawText = "My Kisah";
        String key = KeyGenerators.string().generateKey();
        TextEncryptor textEncryptor = Encryptors.text("password123", key);
        String encryptedText = textEncryptor.encrypt(rawText);
        System.out.println(encryptedText);
    }

    @Test
    public void encryptDelux() { // for text, backed by Encryptors.stronger()
        String rawText = "My Kisah";
        String key = KeyGenerators.string().generateKey();
        TextEncryptor textEncryptor = Encryptors.delux("password123", key);
        String encryptedText = textEncryptor.encrypt(rawText);
        System.out.println(encryptedText);
    }

    @Test
    public void encryptNoOP() { // NoOp just for testting, dont use it
        String rawText = "My Kisah";
        TextEncryptor textEncryptor = Encryptors.noOpText();
        String encryptedText = textEncryptor.encrypt(rawText);
        System.out.println(encryptedText);
    }
}
