package com.ujun;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.*;


/** Management Thread itu Sulit
 * Thread merupakan object yang sangat mahal, pembuatan object thread bisa memakan memory 512kb - 1mb
 * Jika kita tidak mengatur pembuatan thread, bisa jadi aplikasi kita akan cepat kehabisan memory sehingga bisa menyebabkan error OutOfMemory
 * Selain itu, membuat object thread baru tidak semurah membuat object class biasa, oleh karena itu sebenarnya pembuatan thread secara manual tidaklah disarankan
 * Di versi Java moderen ini, lebih disarankan menggunakan Threadpool untuk management thread
 */

/** Thread Pool
 * Threadpool merupakan class yang digunakan untuk management thread
 * Dengan threadpool, kita tidak perlu membuat thread secara manual, karena semua sudah diatur oleh threadpool
 * Selain itu threadpool bisa melakukan reusable thread yang sudah selesai bekerja
 * Threadpool di Java direpresentasikan dalam class bernama ThreadPoolExecutor
 */

/** Pengaturan ThreadPool
 * Ada beberapa yang harus kita atur ketika membuat threadpool
 * core pool, minimal thread yang akan dibuat ketika threadpool dibuat
 * max pool, maximal thread yang akan dibuat
 * keep alive time, berapa lama thread akan dihapus jika tidak bekerja
 * queue, antrian untuk menampung pekerjaan yang dikirim ke threadpool
 * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/concurrent/ThreadPoolExecutor.html
 */

/** Eksekusi Runnable
 * Untuk melakukan eksekusi Runnable, kita bisa menggunakan method execute() milik threadpool
 * Secara otomatis data runnable akan dikirim ke queue threadpool untuk dieksekusi oleh thread yang terdapat di threadpool
 */

/** Menghentikan ThreadPool
 * Jika kita sudah selesai menggunakan threadpool, dan tidak akan menggunakannya lagi, ada baiknya kita hentikan dan matikan ThreadPool nya
 * Caranya kita bisa menggunakan method shutdown() untuk menghentikan threadpool, jika ada pekerjaan yang belum dikerjakan, maka akan di ignore
 * Atau gunakan shutdownNow() untuk menghentikan threadpool, namun pekerjaan yang belum dikerjakan akan dikembalikan/return (dalam bentuk List)
 * Atau jika kita ingin menunggu sampai threadpool selesai, kita bisa gunakan awaitTermination()
 */

/** Rejected Handler
 * Apa yang terjadi jika queue penuh dan thread juga semua sedang bekerja?
 * Maka secara otomatis akan di handle oleh object RejectedExecutionHandler
 * Secara default, implementasi rejected handler akan akan mengembalikan exception RejectedExecutionException ketika kita submit(Runnable) pada kondisi queue penuh dan thread sedang bekerja semua
 * Jika kita ingin mengubahnya, kita bisa membuat RejectedExecutionHandler sendiri
 */

public class ThreadPoolTest {

    @Test
    public void createThreadPool() {
        int minThread = 2;
        int maxThread = 16;
        int keepAliveTime = 1;
        TimeUnit timeUnit = TimeUnit.MINUTES;
        BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>(50);
        var threadPool = new ThreadPoolExecutor(minThread, maxThread, keepAliveTime, timeUnit, taskQueue);
    }

    @Test
    public void executeRunnable() {
        var executor = new ThreadPoolExecutor(2, 16, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(50));

        executor.execute(() -> {
            try {
                Thread.sleep(1_000);
                System.out.println("Hello from thred: " + Thread.currentThread().getName());
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        });
    }

    @Test
    public void stopThreadPool() throws InterruptedException {
        // Jumlah thread hanya akan bertambah jika kapasitas queue telah penuh
        // dan jika semua thread sibuk dan queue penuh maka Exception akan terjadi
        var executor = new ThreadPoolExecutor(4, 16, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(1000));

        for (int i = 0; i < 1000; i++) {
            final var task = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(1_000);
                    System.out.println("Task" + task + " from thread: " + Thread.currentThread().getName());
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }

//        executor.shutdown();
//        List<Runnable> runnables = executor.shutdownNow();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }

    /** ===========START Contoh Mengubah Rejected Execution Handler START=========== **/

    @Test
    public void costumRejectedHandler() throws InterruptedException {
        var rejectedHandler = new LogRejectedExecutionHandler();
        var executor = new ThreadPoolExecutor(2, 16, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(100), rejectedHandler);

        for (int i = 0; i < 1000; i++) {
            final var task = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(100);
                    System.out.println("Task" + task + " from thread: " + Thread.currentThread().getName());
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }

        executor.awaitTermination(1, TimeUnit.HOURS);
    }

    public static  class LogRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor){
            System.out.println("Task: " + r + " is rejected");
        }
    }
    /** ===========END Contoh Mengubah Rejected Execution Handler END=========== **/
}
