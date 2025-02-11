package com.juntralala;


/** JacksonAnnotation
 * Jackson secara default akan membuat JSON dari Java Class, dari membaca field yang ada, sampai membuat attribute di JSON nya
 * Jackson menyediakan beberapa annotation yang bisa kita gunakan untuk mengubah behaviour default dari Jackson dengan cara menambahkan Jackson Annotation pada class Java nya
 * https://fasterxml.github.io/jackson-annotations/javadoc/2.7/com/fasterxml/jackson/annotation/package-summary.html
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.juntralala.data.Person;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/** Dafar Jackson Annotation
 * @JsonIgnore, untuk menandai field yang akan di-ignore ketika proses serialization dan deserialization
 * @JsonFormat, untuk mengubah format data (misal date time) ketika proses serialization dan deserialization
 * @JsonProperty, untuk mengubah attribute ketika proses serialization dan deserialization
 */

public class JacksonAnnotationTest {

    @Test
    void jsonAnnotation() throws JsonProcessingException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        ObjectMapper mapper = new ObjectMapper()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .setDateFormat(dateFormat);

        Person person = new Person();
        person.setId("4");
        person.setName("Hiro");
        person.setCreatedAt(new Date());
        person.setUpdatedAt(new Date());

        String json = mapper.writeValueAsString(person);
        System.out.println(json);
    }

}
