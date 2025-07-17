package com.juntralala;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.juntralala.data.Address;
import com.juntralala.data.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

/** SerializationFeature
 * Jackson memiliki fitur yang bisa di aktifkan atau di nonaktifkan untuk proses serialization (menulis Java Object menjadi JSON)
 * Ada banyak sekali fitur yang terdapat di Jackson Serialization, kita bisa lihat di link berikut :
 * https://github.com/FasterXML/jackson-databind/wiki/Serialization-Features
 */

public class SerializationFeatureTest {

    @Test
    void serializationFeature() throws JsonProcessingException {
        Address alamat = new Address("Jalan melati", "Cendana", "Imaginasia");
        Person orang = new Person("1", "udin", List.of("Ngoding", "Mancing"), alamat);

        ObjectMapper mapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true);
        String json = mapper.writeValueAsString(orang);
        System.out.println(json);
    }

}
