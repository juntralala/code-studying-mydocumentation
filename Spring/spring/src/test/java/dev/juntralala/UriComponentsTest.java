package dev.juntralala;

import org.junit.jupiter.api.Test;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;

import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * UriComponents hampir sama seperti URI, hanya untuk representasi URI dan menyediakan banyak method getter untuk ambil uri component
 */
public class UriComponentsTest {

    @Test
    public void uriComponentsGetters() {
        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString("http://myuser@localhost:8080/api/hello?name=ujun#sapa")
                .encode()
                .build();

        URI toUri = uriComponents.toUri();
        String toUriString = uriComponents.toUriString();
        String getScheme = uriComponents.getScheme();
        String getSchemeSpecificPart = uriComponents.getSchemeSpecificPart();
        String getUserInfo = uriComponents.getUserInfo();
        String getHost = uriComponents.getHost();
        int getPort = uriComponents.getPort();
        String getPath = uriComponents.getPath();
        String getQuery = uriComponents.getQuery();
        List<String> getPathSegments = uriComponents.getPathSegments();
        Map<String, List<String>> getQueryParams = uriComponents.getQueryParams();

        System.out.println("toUri = " + toUri);
        System.out.println("toUriString = " + toUriString);
        System.out.println("getScheme = " + getScheme);
        System.out.println("getSchemeSpecificPart = " + getSchemeSpecificPart);
        System.out.println("getUserInfo = " + getUserInfo);
        System.out.println("getHost = " + getHost);
        System.out.println("getPort = " + getPort);
        System.out.println("getPath = " + getPath);
        System.out.println("getQuery = " + getQuery);
        System.out.println("getPathSegments = " + getPathSegments);
        System.out.println("getQueryParams = " + getQueryParams);
    }

    @Test
    public void encodeExperiments() {
        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString("http://myuser@localhost:8080/api/../hello?name={name}&age={age}#sapa")
                .build();

        UriComponents encode = uriComponents.encode(); // <- UriComponents itu immutable, encode() return instance baru
        UriComponents normalize = uriComponents.normalize(); // <-return instance baru
        UriComponents expand = uriComponents.expand("ujun", 12);

        // with lambda, type class UriParameterTemplate
        uriComponents.expand(name -> {
            assert name != null;
            return switch (name.toLowerCase()) {
               case "name" -> "ujun";
               case "sapa" -> "hai";
               default -> "";
            };
        });

        System.out.println("uriComponents = " + uriComponents);
        System.out.println("normalize = " + normalize);
        System.out.println("encode = " + encode);
        System.out.println("exoand = " + expand);

        System.out.println(UriUtils.decode("/hello%41", "UTF-8"));
    }
}
