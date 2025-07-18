package dev.juntralala;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import com.nimbusds.jwt.SignedJWT;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;

public class JWTTest {

    @Test
    public void createJws() throws JOSEException {

        // 1. Buat payload JWT
        JWTClaimsSet claims = new JWTClaimsSet.Builder()
                .subject("user123")
                .issuer("https://example.com")
                .expirationTime(new Date(System.currentTimeMillis() + 3600000)) // 1 jam
                .claim("role", "admin")
                .build();

        // 2. Buat signed JWT (JWS) dengan HMAC
        JWSSigner signer = new MACSigner("rahasia-kunci-rahasia-minimal-32-byte".getBytes());
        SignedJWT signedJWT = new SignedJWT(
                new JWSHeader(JWSAlgorithm.HS256),
                claims
        );
        signedJWT.sign(signer);

        // 3. Dapatkan token dalam bentuk string
        String jwtToken = signedJWT.serialize();
        System.out.println("JWT: " + jwtToken);
    }

    @Test
    public void verifyJws() throws JOSEException, ParseException {
        String jwsToken = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2V4YW1wbGUuY29tIiwic3ViIjoidXNlcjEyMyIsInJvbGUiOiJhZG1pbiIsImV4cCI6MTc0NDg2MTQ1M30.9QO2kqIFzOCF6HHicK9d_mUEg6z20NXnI5p5A9b3sb0";

        // 1. Parse token
        SignedJWT parsedJWT = SignedJWT.parse(jwsToken);

        // 2. Verifikasi signature
        JWSVerifier verifier = new MACVerifier("rahasia-kunci-rahasia-minimal-32-byte".getBytes());
        boolean isValid = parsedJWT.verify(verifier);

        // 3. Baca payload
        if (isValid) {
            JWTClaimsSet payload = parsedJWT.getJWTClaimsSet();
            System.out.println("Subject: " + payload.getSubject());
        } else {
            System.out.println("Token tidak valid!");
        }
    }
}
