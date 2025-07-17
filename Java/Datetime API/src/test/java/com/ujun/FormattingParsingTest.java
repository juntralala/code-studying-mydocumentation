package com.ujun;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * Parsing dan Formatting
 * Sebelumnya di awal-awal kita sering sekali menggunakan method parse untuk melakukan parsing data String
 * menjadi objek Temporal
 * Sebenarnya proses parsing dan formatting tersebut dilakukan oleh class java.time.format.DateTimeFormatter
 * Pattern
 * Pattern untuk membuat DateTimeFormatter hampir mirip dengan pattern yang sudah pernah dibahas di course tentang Java Internationalization
 * Atau lebih detail bisa dilihat di halaman ini : https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/time/format/DateTimeFormatter.html
 * Atau lihat file
 * Pattern
 * Pattern untuk membuat DateTimeFormatter hampir mirip dengan pattern yang sudah pernah dibahas di course tentang Java Internationalization
 * Atau lebih detail bisa dilihat di halaman ini : https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/time/format/DateTimeFormatter.html
 * Atau lihat file
 * Pattern
 * Pattern untuk membuat DateTimeFormatter hampir mirip dengan pattern yang sudah pernah dibahas di course tentang Java Internationalization
 * Atau lebih detail bisa dilihat di halaman ini : https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/time/format/DateTimeFormatter.html
 * Atau lihat file
 * Parsing
 * Sebelumnya kita sudah bahas tentang default pattern untuk parsing semua tipe objek temporal
 * Jika kita ingin mengubah format pattern nya, kita bisa menggunakan DateTimeFormatter pada saat melakukan parsing, misal :
 * LocalDate.parse(“yyyy MM hh”, dateTimeFormatter)
 * Pattern
 * Pattern untuk membuat DateTimeFormatter hampir mirip dengan pattern yang sudah pernah dibahas di course tentang Java Internationalization
 * Atau lebih detail bisa dilihat di halaman ini : https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/time/format/DateTimeFormatter.html
 * Atau lihat file
 * Parsing
 * Sebelumnya kita sudah bahas tentang default pattern untuk parsing semua tipe objek temporal
 * Jika kita ingin mengubah format pattern nya, kita bisa menggunakan DateTimeFormatter pada saat melakukan parsing, misal :
 * LocalDate.parse(“yyyy MM hh”, dateTimeFormatter)
 */

/** Pattern
 * Pattern untuk membuat DateTimeFormatter hampir mirip dengan pattern yang sudah pernah dibahas di course tentang Java Internationalization
 * Atau lebih detail bisa dilihat di halaman ini : https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/time/format/DateTimeFormatter.html
 * Atau lihat file
 */

/** Parsing
 * Sebelumnya kita sudah bahas tentang default pattern untuk parsing semua tipe objek temporal
 * Jika kita ingin mengubah format pattern nya, kita bisa menggunakan DateTimeFormatter pada saat melakukan parsing, misal :
 * LocalDate.parse(“yyyy MM hh”, dateTimeFormatter)
 */

/** Formatting
 * Untuk formatting juga kita bisa menggunakan DateTimeFormatter
 * Untuk melakukan formatting, kita bisa menggunakan method format(DateTimeFormatter) milik objek temporal
 */


public class FormattingParsingTest {
    @Test
    public void parsingWithFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDate localDate = LocalDate.parse("2020 05 20", formatter); // kalau tidak menggunakan formatter, maka menggunakan default format
        System.out.println(localDate);
    }

    @Test
    public void formatting() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMMM dd");
        LocalDate localDate = LocalDate.now();

        System.out.println(localDate.format(formatter));
    }

    @Test
    public void internationalization(){
        Locale indonesiaLocale = Locale.of("id", "ID");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMMM dd", indonesiaLocale);
        LocalDate localDate = LocalDate.now();

        System.out.println(localDate.format(formatter));
    }

    /** Default Formatter
     * Selain kita bisa membuat formatter sendiri menggunakan pattern
     * Sudah disediakan juga formatter default, sehingga jika kita ingin menggunakan formatter misal yang sudah standar
       internasional, kita tidak perlu membuat ulang menggunakan pattern
     * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/time/format/DateTimeFormatter.html#predefined
     * Untuk melihat daftar default formatter bisa lihat link diatas atau buka file formatting.md
     */
    @Test
    public void defaultFormatter(){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate localDate = LocalDate.parse("2022-20-07");
        String formatted = localDate.format(formatter);

        System.out.println(formatted);
    }
}
