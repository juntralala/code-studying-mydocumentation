package dev.juntralala.crypto;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.HexFormat;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MessageDigestTest {

    @Test
    public void messageDigests() {
        for(Provider provider: Security.getProviders()) {
            for (Provider.Service service: provider.getServices()) {
                if ("MessageDigest".equalsIgnoreCase(service.getType())) {
                    System.out.println(provider.getName() + " => " + service.getAlgorithm());
                }
            }
        }
    }

    @Test
    public void digestWithUpdateMethod() throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        byte[] data1 = "0123456789".getBytes(UTF_8);
        byte[] data2 = "abcdefghijklmnopqrstuvxyz".getBytes(UTF_8);

        messageDigest.update(data1); // update for digest parts of data
        messageDigest.update(data2);
        byte[] digest = messageDigest.digest();

        System.out.println(HexFormat.of().formatHex(digest));
    }

    @Test
    public void digestWholeData() throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] data = "Hello World".getBytes(UTF_8);
        byte[] digest = messageDigest.digest(data);

        System.out.println(HexFormat.of().formatHex(digest));
    }

}