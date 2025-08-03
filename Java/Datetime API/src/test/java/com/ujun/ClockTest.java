package com.ujun;


import org.junit.jupiter.api.Test;

import java.time.*;

/**
 * Clock
 * Seperti nama class nya, Clock adalah representasi tanggal dan waktu saat ini mengikuti time zone yang kita pilih
 * Best practice nya sebenarnya jika kita ingin menggunakan tipe data di Date & Time API yang multi time zone adalah
 * menggunakan Clock, sehingga jika kita ingin membuat data baru, kita bisa memanfaatkan Clock
 */

/** Mendapatkan Instant dari Clock
 * Kita sudah tahu bahwa Clock itu akan selalu berjalan, tidak pernah berhenti
 * Dan representasi milliseconds di Date & Time API baru adalah Instant
 * Oleh karena itu, untuk mendapatkan tanggal dan waktu saat ini sesuai dengan time zone di Clock, kita bisa menggunakan
 * method instant(), dan otomatis akan mengembalikan Instant saat ini sesuai dengan Clock nya
 * Perlu diingat, karena Instant itu selalu menggunakan time zone UTC, jadi jika clock nya tidak menggunakan UTC,
 * maka akan secara otomatis dikonversi ke time zone UTC
 */

/** Membuat Tanggal Dan Waktu dari Clock
 * Karena jika menggunakan Instant kita harus melakukan konversi secara manual ke LocalDateTime atau ZonedDateTime, karena bisa saja time zone nya berbeda
 * Untungnya, kita juga bisa membuat tipe data tanggal dan waktu langsung menggunakan Clock, caranya menggunakan method now(Clock)
 * Secara otomatis informasi time zone Clock akan dibawa di tipe data tanggal dan waktu yang kita buat
 */

public class ClockTest {
    @Test
    public void create() {
        Clock clockUTC = Clock.systemUTC();
        Clock clockSystem = Clock.systemDefaultZone();
        Clock clockJakarta = Clock.system(ZoneId.of("Asia/Jakarta"));

        System.out.println(clockJakarta);
    }

    @Test
    public void getInstantFromClock() throws InterruptedException {
        // data clock selalu berubah tiap nano detik
        Clock clock = Clock.system(ZoneId.of("Asia/Jakarta"));

        Instant instant1 = clock.instant();
        System.out.println(instant1);

        Thread.sleep(1_000);
        System.out.println(clock.instant());

        Thread.sleep(1_000);
        System.out.println(clock.instant());
    }

    @Test
    public void getDateTimeFromClock() {
        Clock clock = Clock.system(ZoneId.of("Asia/Jakarta"));

        LocalDateTime localDateTime = LocalDateTime.now(clock);
        LocalTime localTime = LocalTime.now(clock);
        ZonedDateTime zonedDateTime = ZonedDateTime.now(clock);
    }
}
