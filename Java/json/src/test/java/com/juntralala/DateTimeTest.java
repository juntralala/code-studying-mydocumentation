package com.juntralala;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.juntralala.data.Person;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/** DateTime
 * Saat kita membuat object Java, kita sering menambah field dengan tipe data Date Time, misal java.util.Date, java.util.Calendar, dan lain-lain
 * JSON tidak memiliki tipe data Date Time
 * Biasanya ketika menggunakan JSON, untuk menampilkan tipe data Date Time, kita memiliki beberapa pilihan, menampilkan dengan number (format milis) atau dengan string (misal format yyyy-MM-dd)
 * Jackson secara default akan menampilkan Date Time dalam format number (milis)
 */

public class DateTimeTest {

    @Test
    void dateTimeInMilis() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Person person = new Person();
        person.setId("3");
        person.setName("Ujun");
        person.setCreatedAt(new Date());
        person.setUpdatedAt(new Date());

        String json = mapper.writeValueAsString(person);
        System.out.println(json);
    }

    /** Datime Non Milis
     * Jika kita tidak ingin menggunakan milis ketika membuat atau membaca JSON, kita bisa gunakan juga string sebagai representasi Date Time nya
     * Namun kita perlu memberitahu Date Format yang akan digunakan oleh Jackson
     * Kita bisa ubah Date Formatter di ObjectMapper, dan menon-aktifkan fitur milis untuk Date Time
     */
    @Test
    void dateTimeNonMilis() throws JsonProcessingException {
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
