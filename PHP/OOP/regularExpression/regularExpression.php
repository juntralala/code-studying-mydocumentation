<?php
/**
 * PHP mendukung regular expression yang komatible dengan bahasa pemrograma Perl
 * Regular expression merupakan fitur yang digunakan untuk melakukan pencarian string menggunakan pola tertentu
 * Materi reguler expression ini sebenarnya materi yang sangat panjang, sehingga disini kita hanya akan membahas pengenalanya saja
 * Untuk membuat pattern di regular expression, detailnya bisa di baca disini :
 * https://www.php.net/manual/en/pcre.pattern.php 
*/

/** Function Regular Expression
 * preg_match($patterm, $subject)       <- digunakan untuk mencari match patern     <- mendapatkan 1  
 * preg_match_all($patterm, $subject)                                               <- mendapatkan semua
 * preg_replace($pattern, $replacement, $subject) <- digunakan untuk mereplace semua pattern dengan replacement
 * preg_split($pattern, $subject)                 <- digunakan untuk memotong menggunakan pattern menjadi array 
*/

$matches = [];
$result = (bool) preg_match_all("/muhammad|junai/i","Muhammad Junaidi", $matches);
// /i pada pattern di atas berarti incaseSensitive

var_dump($matches);
var_dump($result);

// preg_replace
$result = preg_replace("/anjing|tai/i", "***", "Dasar lu anjing tai");
var_dump($result);

// preg_split()
$result = preg_split("/[\s,-]/", "UJUN, Muhammad Junaidi-Al-Rantaui");
var_dump($result);




