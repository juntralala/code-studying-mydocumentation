package dev.juntralala;

import com.nimbusds.jose.util.Base64URL;
import org.junit.jupiter.api.Test;

import java.util.Base64;

public class Base4Test {

    @Test
    void test() {
        System.out.println(new String(Base64.getDecoder().decode("eyJhbGciOiJIUzI1NiJ9".getBytes())));
        System.out.println(new String(Base64.getDecoder().decode("eyJhbGciOiAiSFMyNTYiLCAidHlwZSI6ICJqd3QifQ".getBytes())));
        System.out.println(new String(Base64.getDecoder().decode("eyJ0eXBlIjoiand0IiwibWV0YWRhdGEzIjoidmFsdWUgbWV0YSBkYXRhIiwiYWxnIjoiSFMyNTYifQ".getBytes())));
    }
}
