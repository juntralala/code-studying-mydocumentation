package com.ujun;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

public class CalendarTest {

    @Test
    public void create(){
        Calendar calendar = Calendar.getInstance();
    }

    @Test
    public void modify(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2024);
        calendar.set(Calendar.MONTH, Calendar.MAY);
        calendar.set(Calendar.WEEK_OF_MONTH, 3);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        calendar.set(Calendar.DAY_OF_MONTH, 20);
        calendar.set(Calendar.HOUR, 6);
        calendar.set(Calendar.AM_PM, Calendar.PM);

        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.getTime());
    }

    @Test
    public void add(){ // opearasi penambahan waktu
        var calendar = Calendar.getInstance();

        calendar.add(Calendar.YEAR, 2);
        System.out.println(calendar.getTime());

        calendar.roll(Calendar.MONTH, 4);
        System.out.println(calendar.getTime());

        calendar.roll(Calendar.DAY_OF_MONTH, 5);
        System.out.println(calendar.getTime());
    }

    @Test
    public void roll(){ // pengurangan waktu
        var calendar = Calendar.getInstance();

        calendar.roll(Calendar.YEAR, 1);
        System.out.println(calendar.getTime());

        calendar.roll(Calendar.MONTH, 2);
        System.out.println(calendar.getTime());

        calendar.roll(Calendar.DAY_OF_MONTH, 2);
        System.out.println(calendar.getTime());
    }

    @Test
    public void get(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR); // 12 jam am/pm
        int hourOfDay = calendar.get(Calendar.HOUR); // 24jam
        int amPm = calendar.get(Calendar.AM_PM);
        int firstDay = calendar.getFirstDayOfWeek(); // Minggu di US dan Monday di perancis
    }
}
