package com.ujun;


/** Parallel Stream
 * Salah satu fitur yang menarik di Java Stream adalah, Stream bisa dijalankan secara parallel
 * Secara default, Parallel Stream akan dijalankan di ForkJoinPool, dimana akan di running secara default menggunakan
   Thread sejumlah maksimal total CPU kita
 * Agar stream bisa berjalan parallel, kita cukup gunakan method parallel()
 */

/** Custom ForkJoinPool
 * Method parallel() di Java Stream tidak memiliki parameter ForkJoinPool sama sekali, lantas bagaimana jika kita
   ingin menggunakan ForkJoinPool yang kita buat?
 * Kita bisa mengeksekusi parallel stream nya dalam task nya ForkJoinPool
 */

public class ParallelStreamTest {
}
