package com.ujun;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.Date;

/**
 * Sebelumnya, milliseconds direpresentasikan dengan tipe data long, di Java Date & Time API baru, implementasi
   milliseconds direpresentasikan dalam class Instant
 * Instant juga sama seperti class Date, dia menggunakan milliseconds  setelah Unix EPOCH 1970-01-01T00:00:00Z
 * Artinya secara time zone, Instant menggunakan time zone UTC (00:00)
 */

/** Konversi data Instant
 * Karena Instant berisikan milisecond, jadi kita bisa lakukan konversi ke tipe data lainnya, seperti LocalDate, LocalTime dan ZonedLocalTime
 * Namu karena Instant menggunakann time zone UTC, jadi kita perlu memberi tahu time zone apa yang akan kita gunakan ketika kita lakukan konversi
 * Untuk melakuka konversi dari Instant ke tipe data lainnya, kita bisa menggunakan method ofInstant(instant, zone) ketika membuat object nya
 */

/** Konversi ke Instant
 * Selain itu konversi juga bisa dilakukan ke Instant, dari tipe data LocalDateTime dan ZonedDateTime
 * Namun karena Instant menggunakan time zone UTC, jadi kita perlu menambahkan ZoneOffset jika konversi dari tipe data yang tidak memiliki time zone
 */

public class InstantTest {
    @Test
    public void create(){
        Instant instant1 = Instant.now();
        Instant instant2 = Instant.ofEpochMilli(System.currentTimeMillis());
        Instant instant3 = Instant.ofEpochSecond(instant1.getEpochSecond());
        Instant instant4 = Instant.ofEpochSecond(instant1.getEpochSecond(), instant1.getNano()); // dari data waktu dengan nano second
        Instant epoch = Instant.EPOCH; // instance dari Instant untuk 1970-01-01T00:00:00.000
        // Untuk dari string parsing menggunakan format UTC

        System.out.println(instant1);
        System.out.println(instant1.getEpochSecond() + " " + instant1.getNano());
    }

    @Test
    public void get(){
        Instant instant = Instant.now();

        System.out.println(instant.getEpochSecond());
        System.out.println(instant.getNano());
        System.out.println(instant.toEpochMilli());
    }

    @Test
    public void plus(){ // disini semuanya menambah 1000 detik
        Instant instant = Instant.now();

        System.out.println(instant.plusMillis(1_000_000)); // milisecond
        System.out.println(instant.plusNanos(1_000_000_000_000L)); // nano second
        System.out.println(instant.plusSeconds(1_000));
    }

    @Test
    public void minus(){ // disini semuanya menambah 1000 detik
        Instant instant = Instant.now();

        System.out.println(instant.minusMillis(1_000_000));
        System.out.println(instant.minusNanos(1_000_000_000_000L));
        System.out.println(instant.minusSeconds(1_000));
    }

    @Test
    public void convertFromInstant(){
        Instant instant = Instant.now(); // <- UTC+0
        ZoneId zone = ZoneId.of("Asia/Makassar");

        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone); // karna <- UTC+0 maka harus diberitahu disesuaian ke timezone apa
        LocalDate localDate = LocalDate.ofInstant(instant, zone);
        LocalTime localTime = LocalTime.ofInstant(instant, zone);

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zone);
        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(instant, zone);
        OffsetTime offsetTime = OffsetTime.ofInstant(instant, zone);
    }

    @Test
    public void convertToInstant(){
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        OffsetDateTime offsetDateTime = OffsetDateTime.now();

        Instant instant1 = localDateTime.toInstant(ZoneOffset.ofHours(8)); // harus dikasih ZonedOffset karna tidak LocalDateTime tidak menyimpan ZoneId ataupun ZoneOffset sedangkan Instant itu selalu berdasarkan offset UTC+0
        Instant instant2 = zonedDateTime.toInstant();
        Instant instant3 = offsetDateTime.toInstant();
    }
}
