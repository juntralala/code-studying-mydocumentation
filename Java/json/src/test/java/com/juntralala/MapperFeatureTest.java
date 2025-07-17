package com.juntralala;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juntralala.data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** MapperFeature
 * Saat kita membuat object dari class ObjectMapper, terdapat konfigurasi yang bisa kita lakukan pada ObjectMapper tersebut
 * Kita bisa melihat daftar konfigurasi yang tersedia di ObjectMapper di halaman :
 * https://github.com/FasterXML/jackson-databind/wiki/Mapper-Features
 */

public class MapperFeatureTest {

    @Test
    public void testMapperFeature() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        String json = """
                {"ID": "1", "name": "ucup"}
                """;

        Person person = mapper.readValue(json, Person.class);
        Assertions.assertEquals("1", person.getId());
        Assertions.assertEquals("ucup", person.getName());
    }

}
