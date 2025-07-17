package com.juntralala;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/** Scanner
 * Scanner adalah class mirip seperti PrintStream, namun khusus untuk membaca dari InputStream
 * Dengan menggunakan Scanner, kita bisa membaca dan melakukan konversi tipe data secara otomatis
 * Method dengan awalan next() digunakan untuk membaca data
 * Method dengan awalan has() digunakan untuk mengecek apakah masih ada data
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html
 */

/** Scanner Console
* Scanner juga banyak digunakan untuk membaca input dari console
* Dimana System.in merupakan tipe data InputStream, yang bisa kita gunakan sebagai input untuk Scanner
*/ // contohnya ada di InputApp.java di folder src, bukan disini (test)

public class ScannerTest {

    @Test
    public void scanner() {
        Path path = Path.of("print.txt");
        try (InputStream stream = Files.newInputStream(path);
             Scanner scanner = new Scanner(stream)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

}
