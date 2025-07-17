package com.ujun;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class LocalDateTest {

    @Test
    public void create() {
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2025, Month.JANUARY, 20);
        LocalDate localDate3 = LocalDate.ofYearDay(2025, 46);
        LocalDate localDate4 = LocalDate.parse("2024-05-20");

        System.out.println(localDate1);
        System.out.println(localDate2);
        System.out.println(localDate3);
        System.out.println(localDate4);
    }

    /**
     * INFO
     * LocalDate Bersifat immutable oleh karena itu ketika kita melkukan perubahan tanggal sebenarnya
     * yang terjadi adalah membuat LocalDate baru bukan mengubah LocalDate.
     * Oleh karena itu LocalDate Thread Safe, beda dengan Date dan Calendar yang tidak Thread Safe
     */
    @Test
    public void with() { // memodifikasi tanggal
        var localDate1 = LocalDate.now();
        var localDate2 = localDate1.withYear(2024);
        var localDate3 = localDate1.withMonth(5);
        var localDate4 = localDate1.withDayOfYear(213);
        var localDate5 = localDate1.withDayOfMonth(20);

        System.out.println(localDate1);
        System.out.println(localDate2);
        System.out.println(localDate3);
        System.out.println(localDate4);
        System.out.println(localDate5);
    }

    @Test
    public void plus(){ // semua operasi disini membuat isntance localDate baru
        var localDate = LocalDate.now();
        System.out.println(localDate.plusYears(2));
        System.out.println(localDate.plusMonths(13));
        System.out.println(localDate.plusWeeks(20));
        System.out.println(localDate.plusDays(200));
        System.out.println("Tanggal asal: " + localDate);
    }

    @Test
    public void minus(){ // semua operasi disini membuat isntance localDate baru
        var localDate = LocalDate.now();
        System.out.println(localDate.minusYears(2));
        System.out.println(localDate.minusMonths(13));
        System.out.println(localDate.minusWeeks(20));
        System.out.println(localDate.minusDays(200));
        System.out.println("Tanggal asal: " + localDate);
    }

    @Test
    public void get(){
        var localDate = LocalDate.now();
        int year = localDate.getYear();
        Month month = localDate.getMonth();
        int monthValue = localDate.getMonthValue();
        int dayOfYear = localDate.getDayOfYear();
        int dayOfmonth = localDate.getDayOfMonth();
        var dayOfWeek = localDate.getDayOfWeek();
        var dayOfWeekValue = localDate.getDayOfWeek().getValue();

        System.out.println(year);
        System.out.println(month);
        System.out.println(monthValue);
        System.out.println(dayOfYear);
        System.out.println(dayOfmonth);
        System.out.println(dayOfWeek);
        System.out.println(dayOfWeekValue);
    }
}
