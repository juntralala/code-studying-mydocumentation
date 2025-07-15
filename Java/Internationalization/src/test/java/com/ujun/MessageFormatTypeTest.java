package com.ujun;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageFormatTypeTest {

    @Test
    public void testTypeFormatIndonesia(){
        var locale = new Locale("id", "ID");
        var bundle = ResourceBundle.getBundle("message", locale);
        String pattern = bundle.getString("status");

        MessageFormat messageFormat = new MessageFormat(pattern, locale);
        System.out.println(messageFormat.format(new Object[]{"Ujun", new Date(), 12_000.908}));
    }

    @Test
    public void testTypeFormatAmerica(){
        var locale = new Locale("en", "US");
        var bundle = ResourceBundle.getBundle("message", locale);
        String pattern = bundle.getString("status");

        MessageFormat messageFormat = new MessageFormat(pattern, locale);
        System.out.println(messageFormat.format(new Object[]{"Ujun", new Date(), 12_000.908}));
    }
}
