package com.ujun;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * Pada class LocalDateTime, secara default tidak ada informasi time zone sama sekali pada class tersebut
 * Jika kita ingin membuat tanggal dan waktu yang mendukung time zone, kita bisa menggunakan class ZonedDateTime
 * Class ZonedDateTime sama seperti LocalDateTime, perbedaannya hanyalah mendukung time zone
 * Format default untuk ZonedDateTime adalah yyyy-MM-ddTHH:mm:ss.nano(+/-)ZoneOffset[ZoneId], dimana ZoneId tidak wajib,
   dan jika ZoneId diisi, maka nilai ZoneOffset akan di hiraukan
 */

public class ZonedDateTimeTest {
    @Test
    public void create(){
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Jakarta"));
        ZonedDateTime zonedDateTime3 = ZonedDateTime.of(2020, 12, 20, 4,4,4,4, ZoneOffset.ofHours(7));
        ZonedDateTime zonedDateTime4 = ZonedDateTime.now(ZoneId.of("GMT"));
        ZonedDateTime zonedDateTime5 = ZonedDateTime.now(ZoneOffset.ofHours(-7));

        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);
        System.out.println(zonedDateTime3);
        System.out.println(zonedDateTime4);
        System.out.println(zonedDateTime5);

        System.out.println(ZonedDateTime.now(ZoneId.of("GMT+01")));
        System.out.println(ZonedDateTime.now(ZoneId.of("UTC+03")));
    }

    @Test
    public void parsing(){
        ZonedDateTime zonedDateTime1 = ZonedDateTime.parse("2024-06-20T11:30:40.213Z[Asia/Jakarta]"); // dengan zone id
        ZonedDateTime zonedDateTime2 = ZonedDateTime.parse("2024-06-20T11:30:40.213+08:00"); // dengan zone offsett
        ZonedDateTime zonedDateTime3 = ZonedDateTime.parse("2024-06-20T11:30:40.213+08:00[Asia/Jakarta]"); // kalau ada zoneoffsett dan zoneId yang digunakan hanya zoneId

        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);
        System.out.println(zonedDateTime3);
    }

    @Test
    public void changeZoneId(){
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(); // default Asia/Makassar
        var zone = ZoneId.of("UTC");

        var zonedDateTime2 = zonedDateTime1.withZoneSameInstant(zone); // mengubah time zone tanpa mengubah tanggal dan waktu
        var zonedDateTime3 = zonedDateTime1.withZoneSameLocal(zone); // mengubah time zone dengan mengubah tanggal dan waktu

        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);
        System.out.println(zonedDateTime3);

        System.out.println(zonedDateTime1.toEpochSecond());
        System.out.println(zonedDateTime2.toEpochSecond());
        System.out.println(zonedDateTime3.toEpochSecond());
    }
}
