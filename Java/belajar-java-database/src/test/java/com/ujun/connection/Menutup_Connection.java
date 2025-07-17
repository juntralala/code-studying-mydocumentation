package com.ujun.connection;

/** Menutup Connection
 * Saat kita menggunakan Connection, disarankan untuk selalu menutup Connection tersebut
 * Jika sebuah Connection tidak ditutup, maka sepanjang aplikasi berjalan, koneksi ke database akan selalu terbuka
 * Jika Connection yang terbuka ke database terlalu banyak, ditakutkan kita tidak akan bisa lagi membuka koneksi ke
 database dikarenakan sudah mencapai nilai maksimum koneksi yang bisa ditangani oleh databasenya
 * Contohnya, maksimum Connection di MySQL adalah 151 (default)
 * https://dev.mysql.com/doc/refman/8.0/en/server-system-variables.html#sysvar max connections
 */

public interface Menutup_Connection {
}
