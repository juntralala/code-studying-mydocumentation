package com.tralala;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Membuat CSV
 * Untuk membuat CSV, kita bisa menggunakan class CSVPrinter yang terdapat di library Commons CSV
 * Saat membuat CSVPrinter, kita perlu tentukan output tujuan dari CSV
 * Di class CSVPrinter, terdapat method printRecord() yang bisa kita gunakan untuk menambah data ke CSV
 * https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVPrinter.html
 */

public class CreateCSVTest {

    @Test
    public void createCSV() throws IOException {
        StringWriter writer = new StringWriter();

        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
        printer.printRecord("Jun", "Tralala", 100);
        printer.printRecord("Ozon", "Ozonun", 95);
        printer.flush();

        System.out.println(writer.getBuffer().toString());
    }

    @Test
    public void createCSVToFile() throws IOException {
        Writer writer = Files.newBufferedWriter(Path.of("file.csv"));

        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
        printer.printRecord("Jun", "Tralala", 100);
        printer.printRecord("Ozon", "Ozonun", 95);
        printer.flush();
    }

}
