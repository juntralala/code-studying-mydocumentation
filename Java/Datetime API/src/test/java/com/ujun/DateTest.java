package com.ujun;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class DateTest {
    // method untuk manipulasi value date sudah di depracated semua
    // oleh karena itu digunakan Calendar

    // Date menggunakan milisecond setelah UNIX epoch (January 1, 1970 00:00:00 UTC)
    @Test
    public void create() {
        Date date1 = new Date();
        Date date2 = new Date(1737799122179L);
    }

    @Test
    public void get() {
        Date date = new Date();
        long milis = date.getTime();
    }
}
