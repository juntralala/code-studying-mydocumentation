package com.ujun.future;


/** Future<T>
 * Jika kita ingin mengeksekusi callable, kita bisa menggunakan method submit(Callable) pada ExecutorService, method
   submit(Callable) tersebut akan mengembalikan Future<T>
 * Future merupakan representasi data yang akan dikembalikan oleh proses asynchronous
 * Menggunakan Future, kita bisa mengecek apakah pekerjaan Callable sudah selesai atau belum, dan juga mendapat
   data hasil dari Callable
 */

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/** Future<T> Methods
 * | Future Method                  | Keterangan                                                                 |
 * |--------------------------------|---------------------------------------------------------------------------|
 * | T get()                        | Mengambil result data, jika belum ada, maka akan menunggu sampai ada       |
 * | T get(timeout, time unit)      | Mengambil result data, jika belum ada, maka akan menunggu sampai timeout   |
 * | void cancel(mayInterrupt)      | Membatalkan proses callable, dan apakah diperbolehkan di interrupt jika sudah terlanjur berjalan |
 * | boolean isCancelled()          | Mengecek apakah future dibatalkan                                          |
 * | boolean isDone()               | Mengecek apakah future telah selesai                                       |
 */

public class FutureTest {
    @Test
    public void createFuture() throws InterruptedException, ExecutionException {
        var executors = Executors.newSingleThreadExecutor();
        Future<String> future = executors.submit(() -> {
            Thread.sleep(3_000);
            return "Hi";
        });

        while (!future.isDone()) {
            System.out.println("Waiting result...");
            Thread.sleep(500);
        }

        System.out.println(future.get());

        executors.shutdown();
    }

    @Test
    public void cancelFuture() throws InterruptedException, ExecutionException {
        var executors = Executors.newSingleThreadExecutor();
        Future<String> future = executors.submit(() -> {
            Thread.sleep(3_000);
            return "Hi";
        });

        Thread.sleep(2000);
        future.cancel(true);
        System.out.println(future.get());

        executors.shutdown();
    }


}
