package com.ujun.temporal;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.*;

/**
 * TemporalAdjuster adalah strategi untuk menyesuaikan objek temporal.
 * Kita bisa melakukan implementasi penyesuaian object sendiri, atau kita juga bisa menggunakan helper class beranam
   TemporalAdjusters
 * Terdapat banyak static method di TemporalAdjusters yang bisa kita gunakan untuk mempermudah melakukan penyesuaian
   objek temporal
 */

public class TemporalAdjusterTest {
    @Test
    public void temporalAdjuster(){
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = localDate1.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate localDate3 = localDate1.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate localDate4 = localDate1.with(TemporalAdjusters.firstDayOfYear());
        LocalDate localDate5 = localDate1.with(TemporalAdjusters.lastDayOfYear());

        LocalDate localDate6 = localDate1.with(new TemporalAdjuster() {
            @Override
            public Temporal adjustInto(Temporal temporal) {
                return temporal.plus(2, ChronoUnit.YEARS)
                        .plus(20, ChronoUnit.DAYS);
            }
        });
    }
}
