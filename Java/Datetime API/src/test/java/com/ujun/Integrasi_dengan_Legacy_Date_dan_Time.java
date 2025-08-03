package com.ujun;


import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Legacy Date dan Time
 * Saat fitur Java Date & Time API baru keluar, Java juga menambahkan integrasi dengan fitur legacy date dan time
 * yang menggunakan Date, Calendar dan TimeZone
 * Kita bisa melakukan konversi dari tipe temporal legacy ke tipe temporal baru ataupun sebaliknya
 */
public class Integrasi_dengan_Legacy_Date_dan_Time {
    @Test
    public void fromLegacy() { // untuk konversi dari legacy kita bisa gunakan Instance
        Date date = new Date();
        Instant instantDate = date.toInstant();

        Calendar calendar = Calendar.getInstance();
        Instant instantCalendar = calendar.toInstant();

        TimeZone timeZone = TimeZone.getDefault();
        ZoneId zoneId = timeZone.toZoneId();
    }

    @Test
    public void toLegacy() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        Date date = Date.from(zonedDateTime.toInstant());
        Calendar calendar = GregorianCalendar.from(zonedDateTime);

        ZoneId zonedId = ZoneId.systemDefault();
        TimeZone timeZone = TimeZone.getTimeZone(zonedId);
    }
}