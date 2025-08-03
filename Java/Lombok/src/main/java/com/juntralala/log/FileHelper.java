package com.juntralala.log;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.util.Scanner;

@Log
public class FileHelper {

    @SneakyThrows
    public static String loadFile(String file) {
        log.info("Load file: {}".replace("{}", file));
        @Cleanup FileReader fileReader = new FileReader(file);
        @Cleanup Scanner scanner = new Scanner(file);

        StringBuilder builder = new StringBuilder();
        while (scanner.hasNext()) {
            builder.append(scanner.nextLine()).append("\n");
        }

        return builder.toString();
    }
}
