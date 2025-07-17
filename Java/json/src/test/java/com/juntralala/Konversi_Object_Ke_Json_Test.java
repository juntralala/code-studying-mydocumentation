package com.juntralala;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juntralala.data.Address;
import com.juntralala.data.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

/** Konversi Object ke JSON
 * Salah satu kekurangan menggunakan Map ketika membuat JSON Object adalah, kita harus melakukan input data secara manual satu per satu ke dalam Map nya
 * Di Java, biasanya tipe data akan dibuat dalam bentuk class Java Bean (getter setter)
 * Jackson juga bisa otomatis melakukan konversi Object menjadi JSON secara otomatis, dimana attribute JSON nya akan menggunakan nama field di class nya
 * Jika Object tersebut memiliki field dengan tipe data Object lain, Jackson juga akan otomatis membuat embedded Object atau Array secara otomatis
 */

public class Konversi_Object_Ke_Json_Test {

    @Test
    void testKonversiObjectKeJson() throws JsonProcessingException {
        Address alamat = new Address("Jalan melati", "Cendana", "Imaginasia");
        Person orang = new Person("1", "udin", List.of("Ngoding", "Mancing"), alamat);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(orang);
        System.out.println(json);
    }

}
