package com.juntralala;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juntralala.data.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/** Konversi JSON ke Object
 * Untuk melakukan konversi JSON ke dalam object class Java Bean, kita bisa melakukan dengan cara hal yang sama ketika melakukan konversi ke Map atau List
 * Hanya saja, parameternya tidak perlu menggunakan TypeReference lagi, kita bisa langsung sebutkan nama class Java Bean nya
 */

public class Konversi_JSON_Ke_Object {

    @Test
    void konversiJsonKeObject() throws JsonProcessingException {
        String json = """
                {
                  "id" : "1",
                  "name" : "udin",
                  "hobbies" : [ "Ngoding", "Mancing" ],
                  "address" : {
                    "street" : "Jalan melati",
                    "city" : "Cendana",
                    "country" : "Imaginasia"
                  }
                }""";

        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);

        Assertions.assertEquals("1", person.getId());
        Assertions.assertEquals("udin", person.getName());
        Assertions.assertEquals(List.of("Ngoding", "Mancing"), person.getHobbies());
        Assertions.assertEquals("Jalan melati", person.getAddress().getStreet());
        Assertions.assertEquals("Cendana", person.getAddress().getCity());
        Assertions.assertEquals("Imaginasia", person.getAddress().getCountry());
    }

}
