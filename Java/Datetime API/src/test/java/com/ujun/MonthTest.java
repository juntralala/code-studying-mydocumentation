package com.ujun;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Month
 * Month adalah Enum yang merepresentasikan bulan dalam setahun, dari JANUARY sampai DECEMBER.
 * Ada sejak java versi 8
 */

public class MonthTest {
    @Test
    public void test() {
        Month month1 = Month.JANUARY;
        Month month2 = Month.of(1);
        Month month3 = Month.from(LocalDate.now());
        System.out.println("month1 = " + month1);
    }

    @Test
    public void plus_minus() {
        Month bulanIni = Month.APRIL;
        Month bulanDepan = bulanIni.plus(1);
        Month bulanSebelumnya = bulanIni.minus(1);

        System.out.println("bulanIni = " + bulanIni);
        System.out.println("bulanDepan = " + bulanDepan);
        System.out.println("bulanSebelumnya = " + bulanSebelumnya);
    }

    @Test
    public void internationalization() {
        Locale indonesia = Locale.of("id", "ID");
        Month month = Month.MAY;

        System.out.println(month.getDisplayName(TextStyle.FULL, indonesia));
    }
}
