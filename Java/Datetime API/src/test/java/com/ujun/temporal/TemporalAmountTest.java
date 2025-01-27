package com.ujun.temporal;


import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.TemporalAmount;

/** TemporalAmount
 * Duration dan Period adalah implementasi dari interface TemporalAmount
 * Salah satu method yang menggunakan TemporalAmount di Temporal adalah plus() da minus()
 * Artinya, dengan ini kita bisa meggunakan object TemporalAmount untuk melakukan penambahan/pengurangan tanggal dan waktu
 */

public class TemporalAmountTest {
    @Test
    public void temporalAmount() {
        TemporalAmount temporalAmount1 = Duration.ofHours(20);
        TemporalAmount temporalAmount2 = Period.of(2, 3, 20);
    }

    @Test
    public void oneOfTemporalAmountUsages(){
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = localDateTime1.plus(Duration.ofHours(2)); // menambah 2 jam pada representasi datetime
        LocalDateTime localDateTime3 = localDateTime1.minus(Period.ofDays(4)); // menambah 2 hari

        System.out.println("localDateTime1 = " + localDateTime1);
        System.out.println("localDateTime2 = " + localDateTime2);
        System.out.println("localDateTime3 = " + localDateTime3);
    }
}
