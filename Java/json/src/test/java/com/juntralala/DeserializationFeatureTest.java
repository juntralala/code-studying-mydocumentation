package com.juntralala;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juntralala.data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/** DeserializationFeature
 * Jackson memiliki fitur yang bisa di aktifkan atau di nonaktifkan untuk proses deserialization (membaca JSON menjadi Java Object)
 * Ada banyak sekali fitur yang terdapat di Jackson Deserialization, kita bisa lihat di link berikut :
 * https://github.com/FasterXML/jackson-databind/wiki/Deserialization-Features
 */

public class DeserializationFeatureTest {

    @Test
    void deserializationFeature() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String json = """
                {"id": "1", "name": "ucup", "age": 18, "hobbies": "Coding"}
                """;

        Person person = mapper.readValue(json, Person.class);
        Assertions.assertEquals("1", person.getId());
        Assertions.assertEquals("ucup", person.getName());
        Assertions.assertEquals(List.of("Coding"), person.getHobbies());
    }

}
