package dev.juntralala.io;

import org.junit.jupiter.api.Test;

import java.io.File;

// baca rangkuman penjelasan di dev.juntralala.PathTest

import static java.lang.System.out;

public class FIleTest {

    @Test
    public void test() {
        File file = new File("writer.txt");

        out.println("ada: " + file.getPath()); // return string
        out.println("ada: " + file.exists());
        out.println("ada: " + file.isAbsolute());
        out.println("ada: " + file.getAbsoluteFile().getPath());
        // nggak punya method resolve sibling
    }
}
