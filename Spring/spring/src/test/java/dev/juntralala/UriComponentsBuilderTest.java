package dev.juntralala;

import org.junit.jupiter.api.Test;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.web.util.UriComponentsBuilder.ParserType.WHAT_WG;


public class UriComponentsBuilderTest {

    @Test
    public void createInstance() throws URISyntaxException {
        UriComponentsBuilder builderFromString = UriComponentsBuilder.fromUriString("http://localhost:8080/hello"); // <- default diparsing secara standar RFC
        UriComponentsBuilder builderFromPath = UriComponentsBuilder.fromPath("/hello?name=salah"); // <- spesial character yang bukan bagian dari path akan diencode, kalau manggil .encode(), misal character `?` atau `#` dan kalau http://localhost makan akan jadi http:/localhost setelah encode
        UriComponentsBuilder builderFromUri = UriComponentsBuilder.fromUri(new URI(null, "/hello nama", null));
        UriComponentsBuilder builderFromStringNonDefaultParser = UriComponentsBuilder.fromUriString("/hello", WHAT_WG);
        UriComponentsBuilder builderEmpty = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .userInfo(null)
                .port(8080)
                .path("hello")
                .queryParam("name", "ujun")
                .fragment(null)
                .encode();

        assertEquals("/hello%3Fname=salah", builderFromPath.encode().toUriString());
        System.out.println(builderFromUri.encode().build(true)); // <- instnce URI sudah encoded, jadi saat build harus diberitahu sudah encoded atau belum. kalau true secara keseluruhan encode akan dibatalkan
        System.out.println(builderEmpty.build());
    }

    @Test
    public void withUrlVariable() {
        UriComponents uriComponents = UriComponentsBuilder.fromPath("/hello")
                .queryParam("name", "{name}")
                .encode()
                .build()
                .expand("ujun");

        System.out.println(uriComponents);
        System.out.println(uriComponents.toUri());
    }
}
