package dev.juntralala;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;
import java.text.ParseException;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;

@SpringBootTest
public class MainTest {

    @Value("${server.port}")
    private String port;

    @Test
    public void p() throws JOSEException, ParseException {
        JWTClaimsSet claims = new JWTClaimsSet.Builder()
                .issuer("http://localhost:" + port)
                .expirationTime(Date.from(ZonedDateTime.now().plusMinutes(60).toInstant()))
                .issueTime(new Date())
                .subject("username_junaidi")
                .claim("email", "jun@gmail.com")
                .build();

        JWSSigner signer = new MACSigner("amsoiqejroeihfaushciujNXckuah8e32ueAASAS");
        SignedJWT signedJWT = new SignedJWT(
                new JWSHeader(JWSAlgorithm.HS256),
                claims
        );

//        System.out.println(signedJWT.serialize());

        signedJWT.sign(signer);

        System.out.println(signedJWT.serialize());
    }

    @Test
    public void p3() throws JOSEException, ParseException {
        JWTClaimsSet claims = new JWTClaimsSet.Builder()
                .issuer("http://localhost:" + port)
                .expirationTime(Date.from(ZonedDateTime.now().plusMinutes(60).toInstant()))
                .issueTime(new Date())
                .subject("username_junaidi")
                .claim("email", "jun@gmail.com")
                .build();

        JWSSigner signer = new MACSigner("amsoiqejroeihfaushciujNXckuah8e32ueAASAS");
        SignedJWT signedJWT = new SignedJWT(
                JWSHeader.parse(Map.of(
                        "alg", "HS256",
                        "type", "jwt",
                        "metadata3", "value meta data"
                )),
                claims
        );

//        System.out.println(signedJWT.serialize());

        signedJWT.sign(signer);

        System.out.println(signedJWT.serialize());
    }

    @Test
    public void p2() throws JOSEException, ParseException {
        JWTClaimsSet claims = new JWTClaimsSet.Builder()
                .issuer("http://localhost:" + port)
                .expirationTime(Date.from(ZonedDateTime.now().plusMinutes(60).toInstant()))
                .issueTime(new Date())
                .subject("username_junaidi")
                .claim("email", "jun@gmail.com")
                .build();

        JWSSigner signer = new MACSigner("amsoiqejroeihfaushciujNXckuah8e32ueAASAS");
        SignedJWT signedJWT = new SignedJWT(
                Base64URL.encode("{\"alg\": \"HS256\", \"type\": \"jwt\"}"),
                claims.toPayload().toBase64URL(),
                signer.sign(new JWSHeader(JWSAlgorithm.HS256), claims.toPayload().toBase64URL().toString().getBytes())
        );

//        System.out.println(signedJWT.serialize());

//        signedJWT.sign(signer);

        System.out.println(signedJWT.serialize());
    }
}