package dev.juntralala.nio;

// Path adalah pengganti class File dari io tradisional (Path hanya representasi file atau folder (tidak ada syscall), sedangkan File representasi folder atau file serta membuka stream untuk melakukan baca tulis)
// Path tidak membuka stream sedangkan File sebaliknya, jadi lebih efisien
// Selain itu Path juga punya method utility lebih banyak

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.System.out;

public class PathTest {
    @Test
    public void path() {
        Path path = Path.of("writer.txt");

        out.println("path: " + path.toString());
        out.println("ada: " + Files.exists(path));
        out.println("is absolute path: " + path.isAbsolute());
        out.println("absolute path: " + path.toAbsolutePath());
        out.println("resolve sibling: " + path.resolveSibling("hello.txt"));
        // dll
    }
}
