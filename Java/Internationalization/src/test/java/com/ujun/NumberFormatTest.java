package com.ujun;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest {

    @Test
    public void testNumberFormatIndonesia() {
        Locale locale = new Locale("id", "ID");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);

        System.out.println(numberFormat.format(2_000_000));
        System.out.println(numberFormat.format(2403120.3231));
    }

    @Test
    public void testNumberFormatAmerica() {
        Locale locale = new Locale("en", "US");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);

        System.out.println(numberFormat.format(2_000_000));
        System.out.println(numberFormat.format(2403120.3231));
    }

    @Test
    public void testNumberParseIndonesia() {
        Locale locale = new Locale("id", "ID");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);

        String nomer = "2.000.000";
        String desimal = "4.232.000,1232";

        try {
            System.out.println(numberFormat.parse(nomer));
            System.out.println(numberFormat.parse(desimal));
        } catch (ParseException e) {
            System.out.println("Parsing Error: " + e.getMessage());
        }
    }

    @Test
    public void testNumberParseAmerica() {
        Locale locale = new Locale("en", "US");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);

        String number = "2,000,000";
        String decimal = "4,232,000.1232";

        try {
            System.out.println(numberFormat.parse(number));
            System.out.println(numberFormat.parse(decimal));
        } catch (ParseException e) {
            System.out.println("Parsing Error: " + e.getMessage());
        }
    }
}
