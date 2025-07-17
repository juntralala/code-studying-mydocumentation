package com.ujun.connection;

/**
 * Connection adalah sebuah resource yang sangat mahal
 * Jika aplikasi sangat ketergantungn dengan database, maka buka tutup koneksi setiap ada request sangatlah mahal
 * Connection itu sangat lambat saat pertamakali dibuat, dan sangat mahal memakan memory
 * Oleh karena itu, melakukan management Connction sangatlah tidak disarankan saat kita membuat aplikasi
 */

public interface Masalah_Dengan_Connection {
}
