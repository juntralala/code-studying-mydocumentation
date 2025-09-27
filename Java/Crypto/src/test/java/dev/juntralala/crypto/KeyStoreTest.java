package dev.juntralala.crypto;

import org.junit.jupiter.api.Test;

import java.security.Provider;
import java.security.Security;

/**
 * KeyStore itu adalah fitur database untuk nyimpan password dijava
 * tidak ku contohkan tapi ada 4 konsep utama:
 * 1. load keystore
 * 2. set key
 * 3. get key
 * 4. store keystore
 */
public class KeyStoreTest {

    @Test
    public void keystores() {
        for (Provider provider : Security.getProviders()) {
            for (Provider.Service service : provider.getServices()) {
                if ("KeyStore".equalsIgnoreCase(service.getType())) {
                    System.out.println(provider.getName() + " => " + service.getAlgorithm());
                }
            }
        }
    }
}
