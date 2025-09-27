package dev.juntralala.crypto;

import org.junit.jupiter.api.Test;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.HexFormat;

public class CipherTest {

    @Test
    public void ciphers() {
        Provider[] providers = Security.getProviders();
        for (var provider : providers) {
            for (Provider.Service service : provider.getServices()) {
                if ("Cipher".equalsIgnoreCase(service.getType())) {
                    System.out.println(provider.getName() + " => " + service.getAlgorithm());
                }
            }
        }
    }

    @Test
    public void encryptWithCipher() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] keyBytes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 , 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
        SecretKey key = new SecretKeySpec(keyBytes, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key); // encrypt encrypt mode

        byte[] data = "Hello World".getBytes(StandardCharsets.UTF_8);
        byte[] encryptedData = cipher.doFinal(data);
        System.out.println(HexFormat.of().formatHex(encryptedData));
    }

    @Test
    public void decryptWithCipher() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES");
        byte[] keyBytes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 , 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
        SecretKey key = new SecretKeySpec(keyBytes, "AES");
        cipher.init(Cipher.DECRYPT_MODE, key); // init mode decrypt

        byte[] encryptedData = HexFormat.of().parseHex("00a36d44f437939ccfc7d7e27ee19af4");
        byte[] decryptedData = cipher.doFinal(encryptedData);
        System.out.println(new String(decryptedData));
    }

}
