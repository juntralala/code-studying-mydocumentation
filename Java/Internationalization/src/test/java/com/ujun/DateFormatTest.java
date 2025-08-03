package com.ujun;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {

    @Test
    public  void testDateFormatIndonesia(){
        Locale locale = new Locale("id", "ID");
        DateFormat simpleDateFormat = new SimpleDateFormat("EEEE, dd-MMMM-yyyy", locale);
        Date date = new Date();
        String formatted = simpleDateFormat.format(date);
        System.out.println(formatted);
    }

    @Test
    public  void testDateFormatAmerica(){
        Locale locale = new Locale("en", "US");
        DateFormat simpleDateFormat = new SimpleDateFormat("EEEE, MMMM-dd-yyyy", locale);
        Date date = new Date();
        String formatted = simpleDateFormat.format(date);
        System.out.println(formatted);
    }

    @Test
    public void testDateParseIndonesia(){
        Locale locale = new Locale("id", "ID");
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy", locale);
        String stringDate = "26-Januari-2025";
        try {
            Date parsed = simpleDateFormat.parse(stringDate);
            System.out.println(parsed);
        } catch (ParseException e){
            System.out.println("Parsing Error: " + e.getMessage());
        }
    }

    @Test
    public void testDateParseAmerica(){
        Locale locale = new Locale("en", "US");
        DateFormat simpleDateFormat = new SimpleDateFormat("MMMM-dd-yyyy", locale);
        String stringDate = "January-26-2025";
        try {
            Date parsed = simpleDateFormat.parse(stringDate);
            System.out.println(parsed);
        } catch (ParseException e){
            System.out.println("Parsing Error: " + e.getMessage());
        }
    }
}
