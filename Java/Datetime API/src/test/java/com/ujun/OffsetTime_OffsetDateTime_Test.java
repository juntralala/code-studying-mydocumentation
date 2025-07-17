package com.ujun;


import org.junit.jupiter.api.Test;

import java.time.*;

/**
 * Java Date & Time API memiliki class yang bernama OffsetTime dan OffsetDateTime
 * Class OffsetTime adalah seperti LocalTime, namun memiliki time zone offset
 * Dan Class OffsetDateTime adalah seperti LocalDateTime, namun memiliki time zone offset
 * Sekilas OffsetDateTime mirip dengan ZonedDateTime, yang membedakan adalah kalo OffsetDateTime hanya bisa menggunakan
   ZoneOffset, tidak bisa menggunakan ZoneId
 * Format default OffsetTime adalah HH:mm:ss(+/-)ZoneOffset
 * Format default OffsetDateTime adalah yyyy-MM-ddTHH:mm:ss(+/-)ZoneOffset
 */

// Saya sudah mengetes, ternyata ZonedDateTime masih bisa menggunaakn ZoneOffset

public class OffsetTime_OffsetDateTime_Test {
    @Test
    public void createOffsetDateTime(){
        OffsetDateTime offsetDateTime1 = OffsetDateTime.now();
        OffsetDateTime offsetDateTime2 = OffsetDateTime.now(ZoneOffset.of("+07:00"));
        OffsetDateTime offsetDateTime3 = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.ofHours(7));

        OffsetDateTime offsetDateTime4 = OffsetDateTime.parse("2024-04-20T09:20:30.000+08:00");
    }

    @Test
    public void createOffsetTime(){
        OffsetTime offsetTime1 = OffsetTime.now();
        OffsetTime offsetTime2 = OffsetTime.now(ZoneOffset.of("+07:00"));
        OffsetTime offsetTime3 = OffsetTime.of(LocalTime.now(), ZoneOffset.ofHours(7));

        OffsetTime offsetTime4 = OffsetTime.parse("09:20:30.000+08:00");
    }

    @Test
    void nonOffsetToOffsetCompertion(){
        LocalTime time1 = LocalTime.now(); // time
        OffsetTime time2 = time1.atOffset(ZoneOffset.ofHours(3));

        LocalDateTime dateTime1 = LocalDateTime.now(); // date time
        OffsetDateTime dateTime2 = dateTime1.atOffset(ZoneOffset.ofHours(4));
    }

    @Test
    void offsetToNonOffsetCompertion(){
        OffsetTime time1 = OffsetTime.now(); // time
        LocalTime time2 = time1.toLocalTime();

        OffsetDateTime offsetDateTime = OffsetDateTime.now(); // date time
        LocalDateTime localDateTime = offsetDateTime.toLocalDateTime();
        LocalDate localDate = offsetDateTime.toLocalDate();
        LocalTime localTime = offsetDateTime.toLocalTime();
    }
}
