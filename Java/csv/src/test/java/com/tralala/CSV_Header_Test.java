package com.tralala;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

/** CSV Header
 * Seperti yang sempat dibahas di awal, kadang-kadang, saat kita membuat file CSV, biasanya kita menambahkan baris pertama sebagai Header
 * Saat menggunakan Commons CSV, kita harus memberi tahu CSVFormat jika baris pertama adalah kolom, jadi kita bisa menggunakan method setHeader() untuk memberitahu bahwa baris pertama adalah header
 * Keuntungan menggunakan header, kita bisa menggunakan nama header untuk mendapatkan nilai dari tiap kolom di CSV, jadi tidak perlu menggunakan nomor index lagi
 */

public class CSV_Header_Test {

    @Test
    void csvHeader() throws IOException {
        Reader reader = Files.newBufferedReader(Path.of("file.csv"));

        CSVFormat format =  CSVFormat.DEFAULT.builder().setHeader().get();
        CSVParser csvParser = new CSVParser(reader, format);

        for (CSVRecord record : csvParser) {
            System.out.println("First Name: " + record.get("First Name"));
            System.out.println("Last Name: " + record.get("Last Name"));
            System.out.println("Value: " + record.get("Value"));
        }
    }

    /** Menulis CSV Header
     * CSVFormat juga bisa digunakan untuk menulis CSV dengan Header
     * Kita cukup sebutkan saja nama-nama header dengan method setHeader()
     */
    @Test
    void createCsvHeader() throws IOException {
        Writer writer = Files.newBufferedWriter(Path.of("headed.csv"));

        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader("First Name", "Last Name", "Value")
                .get();
        CSVPrinter printer = new CSVPrinter(writer, format);

        printer.printRecord("Jun", "Tralala", 100);
        printer.printRecord("Ozon", "Ozonun", 95);
        printer.flush();
    }
}
