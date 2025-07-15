package com.ujun;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleFormatTest {

    @Test
    public void testResourceBundleFormatIndonesia() {
        Locale locale = Locale.of("id", "ID");
        var bundle = ResourceBundle.getBundle("message", locale);

        String pattern = bundle.getString("message.balance");
        var messageFormat = new MessageFormat(pattern, locale);
        System.out.println(messageFormat.format(new Object[]{"Ujun", 2_000_000}));
    }

    @Test
    public void testResourceBundleFormatAmerica() {
        Locale locale = Locale.of("en", "US");
        var bundle = ResourceBundle.getBundle("message", locale);

        String pattern = bundle.getString("message.balance");
        var messageFormat = new MessageFormat(pattern, locale);
        System.out.println(messageFormat.format(new Object[]{"Ujun", 2_000_000}));
    }
}
