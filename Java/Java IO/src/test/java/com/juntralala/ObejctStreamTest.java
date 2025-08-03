package com.juntralala;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/** Java Bean
 * Saat kita membuat program Java, kita sering membuat data dalam bentuk Java Bean (class dengan getter dan setter)
 * Pada kasus kita ingin menyimpan data object tersebut ke file, jika kita menggunakan Input/Output Stream, maka akan
   sangat menyulitkan, karena kita harus lakukan secara manual, dan melakukan konversi secara manual
 * Untungnya Java memiliki fitur Object Stream, dimana kita bisa menyimpan/membaca data Java Object dari file
 */

/** Seriallizable
 * Salah satu syarat ketika ingin membuat Java Bean Class yang bisa disimpan kedalam file hasil objectnya, kita harus
   membuat Java Bean Class turunan dari interface Serializable
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/Serializable.html
 * Setelah itu, kita harus memberi tahu versi dari class tersebut dengan menggunakan static attribute static final
   long serialVersionUID, dimana berisikan versi dari Java Class nya
 * Setiap kita melakukan perubahan di class nya, misal menambahkan attribute, menghapus attribute, maka kita harus
   mengubah versi nya, agar tidak terjadi masalah ketika melakukan Object Stream
 */

/** ObjectStream
 * Untuk menyimpan data object, kita bisa menggunakan ObjectOutputStream
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/ObjectInputStream.html
 * Dan untuk mengambil data object, kita bisa menggunakan ObjectInputStream
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/ObjectOutputStream.html
 */

/** Java Collection
 * Hampir semua class Java Collection seperti List, Set, Map merupakan turunan dari Serializable
 * Artinya kita bisa menyimpan data collection tersebut di file menggunakan Object Stream
 * Dengan syarat isi data nya adalah data Serializable juga
 */

public class ObejctStreamTest {

    @Test
    public void savePerson() {
        Orang person = new Orang("1", "UJUN");
        Path path = Path.of("ujun.orang");

        try (OutputStream stream = Files.newOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream)) {

            objectOutputStream.writeObject(person);

        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

    @Test
    public void getPerson() {
        Path path = Path.of("ujun.orang");

        try (InputStream stream = Files.newInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(stream)) {

            Orang ujun = (Orang) objectInputStream.readObject();

            System.out.println(ujun.getId());
            System.out.println(ujun.getName());
        } catch (IOException | ClassNotFoundException e) {
            Assertions.fail(e);
        }
    }
}
