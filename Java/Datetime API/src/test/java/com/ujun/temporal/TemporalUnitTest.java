package com.ujun.temporal;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * TemporalUnit
 * TemporalUnit adalah implementasi dari unit satuan waktu
 * Implementasi TemporalUnit adalah sebuah enum ChronoUnit
 * TemporalUnit selain sebagai informasi satuan waktu, bisa juga digunakan untun menghitung durasi waktu
 */

public class TemporalUnitTest {

    @Test
    public void temporalUnit() {
        TemporalUnit temporalUnit1 = ChronoUnit.DAYS;
        TemporalUnit temporalUnit2 = ChronoUnit.YEARS;
        TemporalUnit temporalUnit3 = ChronoUnit.MONTHS;

        System.out.println(temporalUnit1);
    }

    @Test
    public void someUsageOfTemporalUnit() {
        var start = LocalDateTime.now();
        var end = start.plusDays(10);

        long between1 = ChronoUnit.SECONDS.between(start, end);
        long between2 = ChronoUnit.MINUTES.between(start, end);
        long between3 = ChronoUnit.DAYS.between(start, end);

        System.out.println("between1 = " + between1);
        System.out.println("between2 = " + between2);
        System.out.println("between3 = " + between3);
    }
}
