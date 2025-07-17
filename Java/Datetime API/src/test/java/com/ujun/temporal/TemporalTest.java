package com.ujun.temporal;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.Temporal;

/** Temporal
 * Hampir semua tipe data tanggal dan waktu di Java Date & Time adalah implementasi dari interface Temporal
 * Maka dari itu, jika diperhatikan, hampir semua tipe data nya memiliki method-method yang hampir sama
 */

public class TemporalTest {
    @Test
    public void temporal(){ // beberapa class turunan/implements Temporal
        Temporal temporal1 = LocalDateTime.now();
        Temporal temporal2 = LocalDate.now();
        Temporal temporal3 = LocalTime.now();
        Temporal temporal4 = ZonedDateTime.now();
        Temporal temporal5 = OffsetDateTime.now();
        Temporal temporal6 = Instant.now();
    }
}
