package com.ujun.temporal;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

/** TemporalField
 * TemporalField adalah informasi field yang terdapat dalam sebuah tipe data
 * Semua object Temporal memiliki method bernama get(TemporalField) atau getLong(TemporalField) untuk mendapatkan info seputar field pada object tersebut, sesuai dengan Field yang kita inginkan
 * Implementasi TemporalField adalah enum bernama ChronoField
 */
public class TemporalFieldTest {
    @Test
    public void temporalField(){
        LocalDateTime localDateTime = LocalDateTime.now();
        int year = localDateTime.get(ChronoField.YEAR);
        int month = localDateTime.get(ChronoField.MONTH_OF_YEAR);
        int day = localDateTime.get(ChronoField.DAY_OF_MONTH);
        int hour = localDateTime.get(ChronoField.HOUR_OF_DAY);
    }
}
