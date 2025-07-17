package com.ujun;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Tipe data Date menggunakan Timzone juga namun timzonenya tidak bisa diatur hanya menggunakan default timezone saja
 */
public class TimeZoneTest {

    @Test
    public void showDefaultTimeZone(){
        System.out.println(TimeZone.getDefault());
    }

    @Test
    public void showAvailableTimezones(){
        Arrays.stream(TimeZone.getAvailableIDs())
                .forEach(System.out::println);
    }

    @Test
    public void modifyCalendarTimezone(){
        var calendar1 = Calendar.getInstance(); // default timezone saat ini (Asia/Makassar)
        var calendar2 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jakarta"));

        System.out.println(calendar1.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar2.get(Calendar.HOUR_OF_DAY));
    }

    @Test
    public void changeDefaultTimezone(){
        System.out.println(new Date());

        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Jakarta"));

        System.out.println(new Date());
    }

}
