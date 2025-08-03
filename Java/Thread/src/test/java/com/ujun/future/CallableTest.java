package com.ujun.future;


/** Callable<T>
 * Sebelumnya kita selalu menggunakan Runnable untuk mengirim perintah ke thread, namun pada Runnable, setelah
   pekerjaan selesai, tidak ada data yang dikembalikan sama sekali, karena method nya return void
 * Callable mirip dengan Runnable, namun Callable mengembalikan data
 * Selain itu Callable merupakan generic type, sehingga kita bisa tentukan tipe return data nya
 */

// contohnya ada di FutureTest

public class CallableTest {
}
