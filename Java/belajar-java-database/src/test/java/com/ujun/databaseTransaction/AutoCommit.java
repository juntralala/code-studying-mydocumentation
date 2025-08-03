package com.ujun.databaseTransaction;

/** Auto Commit
 * Secara default, Connection yang kita buat menggunakan JDBC memiliki sifat auto commit
 * Auto commit artinya semua perintah SQL yang kita kirim akan langsung di commit secara otomatis
 * Karena dalam database transaction, kita biasanya melakukan commit transaction setelah semua proses selesai, maka kita
   perlu mematikan auto commit di JDBC
 * Untuk mematikan fitur auto commit di JDBC, kita bisa menggunakan method di Connection bernama setAutoCommit(false)
 * Setelah selesai melakukan proses, kita bisa melakukan commit transaction menggunakan method commit() milik Connection
 * Untuk membatalkan proses transaction (rollback), kita bisa menggunakan method rollback() milik Connection
 */

public interface AutoCommit {
}
