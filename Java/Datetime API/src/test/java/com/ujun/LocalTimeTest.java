package com.ujun;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class LocalTimeTest {

    @Test
    public void create(){
        var localTime1 = LocalTime.now();
        var localTime2 = LocalTime.of(10, 10); // yang wajib hanya jam dan menit seterusnya optional
        var localTime3 = LocalTime.of(10, 10, 10, 300);
        var localTime4 = LocalTime.parse("10:10:10.100204");

        System.out.println(localTime1);
        System.out.println(localTime2);
        System.out.println(localTime3);
        System.out.println(localTime4);
    }

    @Test
    public void with(){
        var localTime1 = LocalTime.now();
        System.out.println(localTime1.withHour(14));
        System.out.println(localTime1.withMinute(30));
        System.out.println(localTime1.withSecond(20));
        System.out.println(localTime1.withNano(20_000_000));
        System.out.println("Waktu asal: " + localTime1);
    }

    @Test
    public void plus(){
        var localTime1 = LocalTime.now();
        System.out.println(localTime1.plusHours(14));
        System.out.println(localTime1.plusMinutes(30));
        System.out.println(localTime1.plusSeconds(20));
        System.out.println(localTime1.plusNanos(20_000_000));
        System.out.println("Waktu asal: " + localTime1);
    }

    @Test
    public void minus(){
        var localTime1 = LocalTime.now();
        System.out.println(localTime1.minusHours(14));
        System.out.println(localTime1.minusMinutes(30));
        System.out.println(localTime1.minusSeconds(20));
        System.out.println(localTime1.minusNanos(20_000_000));
        System.out.println("Waktu asal: " + localTime1);
    }

    @Test
    public void get(){
        var localTime1 = LocalTime.now();
        System.out.println(localTime1.getHour());
        System.out.println(localTime1.getMinute());
        System.out.println(localTime1.getSecond());
        System.out.println(localTime1.getNano());
    }
}
