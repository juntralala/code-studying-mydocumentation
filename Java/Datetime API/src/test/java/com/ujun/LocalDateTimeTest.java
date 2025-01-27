package com.ujun;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * Local date time adalah gabungan dari LocalDate dan LocalTime
 * Sehingga method yang ada pada keduanya ada juga pada LocalDateTime, jadi semua operasinya sama saja
 * dan juga untuk format default untuk teks yang diparse adalah : yyyy-MM-ddTHH:mm:ss.nano
 */

public class LocalDateTimeTest {

    @Test
    public void create(){
        var localDateTime1 = LocalDateTime.now();
        var localDateTime2 = LocalDateTime.of(1990, Month.JANUARY, 14, 9, 30, 24, 123_000_000);
        var localDateTime3 = LocalDateTime.parse("1990-01-14T09:30:24.123");
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);
    }

    @Test
    public void with(){
        var localDateTime = LocalDateTime.now();

        System.out.println(localDateTime.withYear(2027));
        System.out.println(localDateTime.withHour(15));
    }

    @Test
    public void plus(){
        var localDateTime = LocalDateTime.now();

        System.out.println(localDateTime.plusYears(3));
        System.out.println(localDateTime.plusHours(4));
    }

    @Test
    public void minus(){
        var localDateTime = LocalDateTime.now();

        System.out.println(localDateTime.minusYears(3));
        System.out.println(localDateTime.minusHours(4));
    }

    @Test
    public void get(){
        var localDateTime = LocalDateTime.now();

        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getHour());
    }
}
