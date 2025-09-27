package dev.juntralala.crypto;

import org.junit.jupiter.api.Test;

import java.security.Provider;
import java.security.Security;

// Certificate ya representasi Cryptographic Identity Certificate
// tanpa library, cuman bisa dapat instance certificate dari CertificateFactory dan KeyStore
// trus ada lagi class CertPath, untuk certificate yang pakai chaining (nggak ada contoh atau penjelasan yang aku tulis)
public class CertificateTest {

    // CertificateFactory ya buat load certificate yang sudah ada (contohnya nggak kubikin)
    @Test
    public void certificateFactories() {
        Provider[] providers = Security.getProviders();
        for (var provider : providers) {
            for (Provider.Service service : provider.getServices()) {
                if ("CertificateFactory".equalsIgnoreCase(service.getType())) {
                    System.out.println(provider.getName() + " => " + service.getAlgorithm());
                }
            }
        }
    }
}
