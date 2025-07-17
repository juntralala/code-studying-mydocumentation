package com.ujun.thread;

/** Thread State
 * Thread di Java memiliki state, state yaitu informasi state sebuah thread
 * State digunakan hanya untuk mendapat informasi
 * State akan berubah statusnya sesuai dengan apa yang terjadi di thread
 * Untuk mendapatkan data state, kita bisa menggunakan method getState() dan akan mengembalikan enum State
 */

/**
 | **State**         | **Deskripsi**                                                                    | **Kondisi Transisi**                                                                  |
 |-------------------|----------------------------------------------------------------------------------|---------------------------------------------------------------------------------------|
 | **NEW**           | Thread telah dibuat tetapi belum dijalankan (`start()` belum dipanggil).         | Thread baru dibuat menggunakan konstruktor `Thread`.                                  |
 | **RUNNABLE**      | Thread sedang berjalan atau siap untuk dijalankan oleh JVM.                      | Setelah `start()` dipanggil, thread masuk ke state `RUNNABLE`.                        |
 | **BLOCKED**       | Thread sedang menunggu untuk mendapatkan lock yang sedang dipegang thread lain.  | Ketika thread mencoba mengakses kode yang disinkronisasi (`synchronized`).            |
 | **WAITING**       | Thread sedang menunggu tanpa batas waktu hingga thread lain melakukan tindakan.  | Setelah memanggil `Object.wait()`, `Thread.join()`, atau `LockSupport.park()`.        |
 | **TIMED_WAITING** | Thread sedang menunggu dengan batas waktu tertentu.                              | Setelah memanggil `Thread.sleep()`, `Object.wait(timeout)`, atau `Thread.join(timeout)`.|
 | **TERMINATED**    | Thread telah selesai dieksekusi (metode `run()` selesai dijalankan).             | Setelah metode `run()` selesai atau thread dihentikan secara paksa.                   |
 */

import org.junit.jupiter.api.Test;

public class ThreadStateTest {
    @Test
    public void threadState() throws InterruptedException {
        var thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getState());
            System.out.println("Hello from thread: " + Thread.currentThread().getName());
        });
        System.out.println(thread.getState());

        thread.start();
        thread.join();

        System.out.println(thread.getState());
    }
}
