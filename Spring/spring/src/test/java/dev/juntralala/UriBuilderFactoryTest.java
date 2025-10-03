package dev.juntralala;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;

import java.net.URI;

import static org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode.TEMPLATE_AND_VALUES;
import static org.springframework.web.util.UriComponentsBuilder.ParserType.RFC;

/**
 * buat bikin konfigurasi uri builder yang bisa disharing di banyak tempat
 */
public class UriBuilderFactoryTest {

    @Test
    public void test() {
        String baseUri = "http://localhost:8080";
        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(baseUri);
        uriBuilderFactory.setParserType(RFC);
        uriBuilderFactory.setEncodingMode(TEMPLATE_AND_VALUES);

        // biasanya digunakan untuk RestClient, RestTemplate dan WebClient, tapi nggak harus juga, boleh saja pakai instance dari UriBuilderFactory
        RestClient restClient = RestClient.builder()
                .uriBuilderFactory(uriBuilderFactory)
                .build();

        UriBuilder builder = uriBuilderFactory.builder();
        builder.path("/hello");
        builder.path("/btw");
        builder.path("/name");
        builder.queryParam("name", "ujun");

        URI uri = builder.build(); // Pakai UriBuilder tidak punya method yang mengasilkan UriComponent, URI saja
        System.out.println(uri);
        System.out.println(builder.getClass().getName());
    }
}
