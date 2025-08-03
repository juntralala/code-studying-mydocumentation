package com.tralala;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Untuk membaca CSV, kita bisa menggunakan class CSVParser
 * CSVParser adalah turunan dari Iterable, sehingga otomatis kita bisa melakukan iterasi datanya menggunakan perulangan foreach
 * https://commons.apache.org/proper/commons-csv/apidocs/org/apache/commons/csv/CSVParser.html
 * Tiap perulangan, kita bisa ambil dataya dalam bentuk CSVRecord
 */
public class ReadCSVTest {

    @Test
    void readCsv() throws IOException {
        Reader reader = Files.newBufferedReader(Path.of("file.csv"));

        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

        for (CSVRecord record : csvParser) {
            System.out.println("First Name: " + record.get(0));
            System.out.println("Last Name: " + record.get(1));
            System.out.println("Value: " + record.get(2));
        }
    }

}
