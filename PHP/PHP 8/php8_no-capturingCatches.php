<?php
/**
 * Saat terjadi error di PHP, biasanya kita akan menggunakan try catch
 * Lalu didalam catch kita akan menangkap error dan menyimpannya kedalam variable exception 
 * Walaupun sebenarnya variablenya tidak kita gunakan, kita tetap harus membuat variable exception-nya
 * Di PHP 8, sudah tidak diwajibkan lagi membuat variable exception nya kalau tidak digunakan
 * https://wiki.php.net/rfc/non-capturing_catches
*/

function sapa(?string $nama) {
    if($nama == null) {
        throw new Exception("tidak boleh null");
    }

    echo "Hai $nama" . PHP_EOL;
}

try {
    sapa("UJUN");
    
    sapa(null);
} catch (Exception) {
    echo "ada error" . PHP_EOL;
}