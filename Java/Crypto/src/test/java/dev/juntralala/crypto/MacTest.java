package dev.juntralala.crypto;

import org.junit.jupiter.api.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.HexFormat;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MacTest {

    @Test
    public void providedMacs() {
        for (Provider provider : Security.getProviders()) {
            for (Provider.Service service : provider.getServices()) {
                if ("Mac".equalsIgnoreCase(service.getType())) {
                    System.out.println(provider.getName() + " => " + service.getAlgorithm());
                }
            }
        }
    }

    @Test
    public void calculatingMac() throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKey key = KeyGenerator.getInstance("HmacSHA256").generateKey();

        mac.init(key);

        byte[] data = "Hello World".getBytes(UTF_8);
        byte[] macBates = mac.doFinal(data);

        System.out.println(HexFormat.of().formatHex(macBates));
    }
}
