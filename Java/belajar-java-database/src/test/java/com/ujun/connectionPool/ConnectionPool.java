package com.ujun.connectionPool;

/**
 * Connection Pool adalah konsep dimana dibanding kita membuat koneksi baru setiap ada request ke yang membutuhkan databse
 * Lebih baik dari awal kita buatkan banyak Connection terlebih dahulu, sehingga hanya lambat diawal ketika aplikasi berjalan
 * Selanjutnya ketika ada request yang membutuhkan koneksi, kita hanya cukup menggunakan salah satu connection, kemudian
   setelah selesai, kita kembalikan lagi connection nya
 * Jika semua connection sedang terpakai semua, ketika ada request yang butuh koneksi lagi, request tersebut diminta
   menunggu terlebih dahulu. Dengan demikian penggunaan memory untk Connection tidak akan terlalu bengkak
 * Connection Pool JDBC direpresentasikan dengan interface javax.sql.DataSource
 */

public interface ConnectionPool {
}
