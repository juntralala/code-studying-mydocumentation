package com.ujun;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAmount;

/** Period
 * Class Period mirip dengan Duration, yang membedakan adalah Period adalah durasi untuk tanggal
 * Cara penggunaan Period hampir mirip dengan Duration
 */

// catatan tambahan: value waktunya bisa negatif

public class PeriodTest {

    @Test
    public void create(){
        Period period = Period.of(1, 6, 20);
        Period period2 = Period.ofYears(2);
        Period period3 = Period.ofMonths(3);
        Period period4 = Period.ofDays(10);
        Period period5 = Period.ofWeeks(4);
        Period period7 = Period.parse("P1Y2M15D"); // 1 tahun, 2 bulan, 15 hari

        Period periodZero = Period.ZERO; // 0 tahun, 0 bulan, 0 hari

        System.out.println(period);
    }

    @Test
    public void get(){
        Period period = Period.of(2, 6, 12);

        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }

    @Test
    public void between(){
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 10, 5);
        Period periodBetween = Period.between(startDate, endDate);

        System.out.println("periodBetween = " + periodBetween);
    }
}
