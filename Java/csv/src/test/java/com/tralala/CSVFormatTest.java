package com.tralala;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

/** CSV Format
 * Secara default, format file CSV itu dipisahkan menggunakan , (koma)
 * Tapi kadang ada  beberapa format CSV lain yang mungkin menggunakan pemisah dengan karakter tab, titik koma, atau yang lainnya
 * Bahkan beberapa Spreadsheet editor, memiliki aturan tertentu untuk membuat CSV file
 * Untungnya, Commons CSV mendukung beberapa format Spreadsheet editor
 * Kita bisa lihat di class CSVFormat, terdapat banyak sekali format yang didukung, selain DEFAULT
 * https://commons.apache.org/proper/commons-csv/apidocs/index.html
 */
public class CSVFormatTest {

    @Test
    void createCsvWithFormat() throws IOException {
        Writer writer = Files.newBufferedWriter(Path.of("with_tdf_format.csv"));

        CSVFormat format = CSVFormat.TDF.builder()
                .setHeader("First Name", "Last Name", "Value")
                .get();
        CSVPrinter printer = new CSVPrinter(writer, format);

        printer.printRecord("Jun", "Tralala", 100);
        printer.printRecord("Ozon", "Ozonun", 95);
        printer.flush();
    }

}
