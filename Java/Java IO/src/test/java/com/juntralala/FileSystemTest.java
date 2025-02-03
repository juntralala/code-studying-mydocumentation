package com.juntralala;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;

/*
Sebenarnya ini materi diluar PZN tapi aku ngulik sendiri
FileSystem hanya untuk producer beberapa object (lihat docs untuk detail)
dan mendapatkan beberapa informasi seperti ukuran, ruang tersedia disk, atau tipe file system dll
 */

public class FileSystemTest {

    @Test
    void testFileSystem() {
        FileSystem fs = FileSystems.getDefault();
        fs.getRootDirectories().forEach(System.out::println);

        System.out.println(Files.isDirectory(fs.getPath("D:\\code")));
        fs.getFileStores().forEach(System.out::println);
        fs.getFileStores().forEach((fileStore -> {
            try {
                System.out.println(fileStore.getTotalSpace() / 1024 / 1024 + " MiB");
                System.out.println(fileStore.name());
                System.out.println(fileStore.type());
                System.out.println(fileStore.getBlockSize());
                System.out.println(fileStore.getUsableSpace() / 1024 / 1024 + " MiB");
            } catch (IOException e) {
                Assertions.fail(e);
            }
        }));
    }

}
