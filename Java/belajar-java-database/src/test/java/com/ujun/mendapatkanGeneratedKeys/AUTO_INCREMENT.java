package com.ujun.mendapatkanGeneratedKeys;

/**
 * Kadang setelah melakukan INSERT data ke database yang memiliki PRIMARY KEY auto increment, kita ingin mengambil data
   id terbarunya/yang terakhir kali digenerate
 * Di MySQL sebenarnya kita bisa melakukan query SELECT LAST_INSERT_ID(), namun berarti kita harus melakukan query ulang
   dengan Statement dan melakkan iterasi lagi dengan ResultSet
 * Untungnya di JDBC, ada kemampuan untk mendapatkan auto increment dengan method getGenerateKeys() yang menrembalikan
   ResultSet
 * Selanjutnya kita bisa melakukan iterasi terhadap ResultSet tersebut
 */

public interface AUTO_INCREMENT {
}
