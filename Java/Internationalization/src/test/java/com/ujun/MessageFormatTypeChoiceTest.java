package com.ujun;

import org.junit.jupiter.api.Test;

import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * ChoiceFormat class adalah class yang digunakan untuk menyematkan data dengan range number, biasanya ini digunakan
 * untuk kata plurals, misal jika 1 namanya file, jika banyak namanya files
 * Pembuatan pattern untuk ChoiceFormat sangat sederhana, cukup gunakan number#value atau number<value, dan
 * urutannya harus dari kecil ke besar, dan dipisahkan menggunakan tanda | (pagar), misal :
 * -1#negatif | 0#kosong | 1#satu | 1<banyak
 */

public class MessageFormatTypeChoiceTest {

    @Test
    public void testChoiceFormat() {
        String pattern = "-1#negatif | 0#kosong | 1#satu | 1<banyak";
        ChoiceFormat choiceFormat = new ChoiceFormat(pattern);

        String formatted = choiceFormat.format(3);
        System.out.println(formatted);
    }

    @Test
    public void testChoiceFormatOnResourceBundleIndonesia() {
        var locale = Locale.of("id", "ID");
        var bundle = ResourceBundle.getBundle("message", locale);
        String pattern = bundle.getString("message.balance");

        MessageFormat messageFormat = new MessageFormat(pattern, locale);
        String formatted = messageFormat.format(new Object[]{120_000_000.213, 20_999});
        System.out.println(formatted);
    }

    @Test
    public void testChoiceFormatOnResourceBundleAmerica() {
        var locale = Locale.of("en", "US");
        var bundle = ResourceBundle.getBundle("message", locale);
        String pattern = bundle.getString("balance");

        MessageFormat messageFormat = new MessageFormat(pattern, locale);
        String formatted = messageFormat.format(new Object[]{120_000_000.213});
        System.out.println(formatted);
    }
}
