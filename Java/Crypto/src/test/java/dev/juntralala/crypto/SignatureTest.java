package dev.juntralala.crypto;

import org.junit.jupiter.api.Test;

import java.security.*;
import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SignatureTest {

    private final KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();

    public SignatureTest() throws NoSuchAlgorithmException {
    }

    @Test
    public void signatures() {
        for(Provider provider: Security.getProviders()) {
            for(Provider.Service service : provider.getServices()) {
                if ("Signature".equalsIgnoreCase(service.getType())) {
                    System.out.println(provider.getName() + " => " + service.getAlgorithm());
                }
            }
        }
    }

    @Test
    public void singing() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signature = Signature.getInstance("SHA256withRSA");
        SecureRandom random = new SecureRandom();

        signature.initSign(keyPair.getPrivate(), random);

        byte[] data = "Hello World".getBytes(UTF_8);
        signature.update(data, 0, data.length);
        byte[] digitalSignature = signature.sign();

        System.out.println(Base64.getEncoder().encodeToString(digitalSignature));
    }

    @Test
    public void verify() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signature = Signature.getInstance("SHA256withRSA");

        signature.initVerify(keyPair.getPublic());

        byte[] digitalSign = Base64.getDecoder().decode("uwIPsPkkZM6bL9ztl9fDj3qNuzJUw/4H4CP3d7Rzm5QcM/UYlvqZu/bry+BzwWbgZDTG7gQYcfkOE7yy7yv5xT43IHHFCHBLZALm++Ldp8DrRT6DukQKGsIwdaMSGppdyV6YhmQLYfOzjq/iQTlZMP+3FVK+D7SNTalmnp1zxJ5p/gJz6Z4b6DSQyUewEwX9ezpY9a2q9gvWB4NmhdPuqm/uQKOSDQm7uWGcdUSXdWnfc1xVyJ3PBAVbHd87SFEcTffHNfuRKcWHffXnelW770A5DvkbG1/IV4YaU4VNissCmvDK3o7TCmuqamQejuPfJwD8i5876+xxQwoWMRiMGzZ/7qB4WPRf/Gbl4CNn6HXukXH/QmUNsVAkKdSFgnxp3BVVu30QqskOddjd1XNCgeQEUzMBblmy2Y8sY4lZ5RHygB8RaQMKZsOnXEAwFoi1y5D+q8Up8CUEImnWut0HyLNdVrSYzPKhpUX9pxPujJn0P3RlTCbtIQQpmi4OZwgn");
        byte[] data = "Hello World".getBytes(UTF_8);
        signature.update(data, 0, data.length);
        boolean verified = signature.verify(digitalSign);

        System.out.println("verified = " + verified);
    }
}