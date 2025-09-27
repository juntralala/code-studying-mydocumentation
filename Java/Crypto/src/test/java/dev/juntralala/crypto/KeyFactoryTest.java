package dev.juntralala.crypto;

import org.junit.jupiter.api.Test;

import java.security.Provider;
import java.security.Security;

/**
 * keyFactory untuk load publickey atau secretkey yang sudah ada.
 * kalau nanya, loh kok KeyFactory cuman buat keypair doang? ya karna SecretKey nggak butuh factory, tinggal new SecretKeySpec(keyBytes);
 */
public class KeyFactoryTest {

    @Test
    public void keyFactories() {
        Provider[] providers = Security.getProviders();
        for (var provider : providers) {
            for (Provider.Service service : provider.getServices()) {
                if ("KeyFactory".equalsIgnoreCase(service.getType())) {
                    System.out.println(provider.getName() + " => " + service.getAlgorithm());
                }
            }
        }
    }

}
