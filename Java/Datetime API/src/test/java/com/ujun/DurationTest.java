package com.ujun;


import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

/** Duration
 * Class Duration adalah representasi dari data durasi waktu
 * Durasi waktu yang terdapat di class Duration
 * Dengan menggunakan Duration, kita bisa dengan mudah mengkonversi durasi ke waktu yang kita inginkan, misal hour,
   minute, second dan nano second
 */

// catatan tambahan: value waktunya bisa negatif

public class DurationTest {

    @Test
    public void create(){
        Duration duration1 = Duration.ofDays(10);
        Duration duration2 = Duration.ofHours(10);
        Duration duration3 = Duration.ofSeconds(10);
        Duration duration4 = Duration.ofMillis(10);
        Duration duration5 = Duration.ofNanos(10);
        Duration duration6 = Duration.ofNanos(10);
        Duration durationZero = Duration.ZERO; // 0 hari 0 jam 0 detik 0 nanodetik
        Duration parsed = Duration.parse("PT52H10M"); // 4 hari 7 jam 10 menit

        System.out.println(duration1);
    }

    @Test
    public void get(){
        Duration duration = Duration.ofHours(26);

        long days = duration.toDays(); // karna nggak nyampe 1 hari
        long hours = duration.toHours();
        long minutes = duration.toMinutes();
        long seconds = duration.toSeconds();
        long nano = duration.toNanos();

        long daysPart = duration.toDaysPart();
        long hoursPart = duration.toHoursPart(); // <- mengambil part jam, yg sisa dikurangi hari (tidak lebih dari 24)

        System.out.println("days = " + days);
        System.out.println("hours = " + hours);
        System.out.println("minutes = " + minutes);
        System.out.println("seconds = " + seconds);
        System.out.println("nano = " + nano);

        System.out.println("daysPart = " + daysPart);
        System.out.println("hoursPart = " + hoursPart);
    }

    @Test
    public void between(){
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusDays(1);

        Duration duration = Duration.between(start, end);
        System.out.println("duration = " + duration);

        System.out.println(Duration.between(LocalTime.now(), LocalTime.now().plusMinutes(20)));
    }
}
