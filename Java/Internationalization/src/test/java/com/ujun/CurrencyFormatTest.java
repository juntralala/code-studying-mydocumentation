package com.ujun;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CurrencyFormatTest {

    @Test
    public void testCurrencyFormatIndonesia() {
        Locale locale = new Locale("id", "ID");
        var format = NumberFormat.getCurrencyInstance(locale);

        double money = 2_000_000.345;

        System.out.println(format.format(money));
    }

    @Test
    public void testCurrencyFormatAmerica() {
        Locale locale = new Locale("en", "US");
        var format = NumberFormat.getCurrencyInstance(locale);

        double money = 2_000_000.345;

        System.out.println(format.format(money));
    }

    @Test
    public void testCurrencyParseIndonesia() {
        Locale locale = new Locale("id", "ID");
        var format = NumberFormat.getCurrencyInstance(locale);

        String money = "Rp2.000.000,123";

        try {
            System.out.println(format.parse(money));
        } catch (ParseException e) {
            System.out.println("Parsing Error: " + e.getMessage());
        }
    }

    @Test
    public void testCurrencyParseAmerica() {
        Locale locale = new Locale("en", "US");
        var format = NumberFormat.getCurrencyInstance(locale);

        String money = "$2,000,000.123";

        try {
            System.out.println(format.parse(money));
        } catch (ParseException e) {
            System.out.println("Parsing Error: " + e.getMessage());
        }
    }
}
