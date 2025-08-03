package com.juntralala.cleanup;

import lombok.Cleanup;

import java.io.FileReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

    }

    public static String loadFile(String file) throws Exception {
        @Cleanup FileReader fileReader = new FileReader(file);
        @Cleanup Scanner scanner = new Scanner(file);

        StringBuilder builder = new StringBuilder();
        while (scanner.hasNext()) {
            builder.append(scanner.nextLine()).append("\n");
        }

        return builder.toString();
    }
}
