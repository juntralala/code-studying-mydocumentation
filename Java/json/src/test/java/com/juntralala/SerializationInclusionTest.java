package com.juntralala;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juntralala.data.Address;
import com.juntralala.data.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

/** SerializationInclusion
 * Secara default, saat kita membuat JSON dari Java Object, semua field akan di-include, termasuk yang nilai field nya null
 * Kita bisa mengubah cara Jackson melakukan include field mana saja yang akan dibuat sebagai attribute di JSON dengan menggunakan attribute Serialization Inclusion
 * https://fasterxml.github.io/jackson-annotations/javadoc/2.7/com/fasterxml/jackson/annotation/JsonInclude.Include.html
 */

public class SerializationInclusionTest {

    @Test
    void serializationInclusion() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);

        Person orang = new Person();
        orang.setId("2");
        orang.setName("ozon");

        String json = mapper.writeValueAsString(orang);
        System.out.println(json);
    }

}
