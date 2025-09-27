package dev.juntralala.crypto;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.security.Provider;
import java.security.Security;

public class ProviderTest {

    @Test
    public void registeredSecurityProviders() {
        Provider[] providers = Security.getProviders();
        for (Provider provider : providers) {
            System.out.println(provider.getName() + " : " + provider.getClass().getName());
        }
    }

    @Test
    @Disabled("not realy implemented")
    public void registerProvider() {
//        Security.addProvider(new BouncyCastleProvider());
    }

}
