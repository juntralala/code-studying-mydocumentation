<?php
/**
 * Kadang kita ada kebutuhan untuk menduplikasi object
 * Biasanya, untuk melakukan ini kita membuat object baru, lalu menyalin property object awal satu-persatu ke object baru
 * Untungnya PHP memiliki fitur object cloning
 * Kita bisa menggunakan perintah clone untuk menduplikasi object
 * Secara otomatis semua object awal akan diduplikasi ke object baru
*/

require_once "Student.php";

$student1 = new Student("22100", "Ujun", 19);

$student2 = clone $student1;