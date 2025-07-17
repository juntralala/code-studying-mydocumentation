/** PATH_INFO
 * PATH_INFO marupakan key yang terdapat didalam global variable $_SERVER
 * PATH_INFO merupakan informasi path yang terdapat pada URL ketika kita mengakses file PHP
 * Misal jika URL nya adalah http://contoh.com/index.php , maka tidak ada PATH_INFO
 * Jika URL nya http://contoh.com/index.php/test , maka PATH_INFO nya adalah /test
 * Jika URL nya adalah http://contoh.com/index.php/products/123 , maka PATH_INFO nya adalah /products/123
 * Dan juka URL nya http://contoh.com/index.php/category?id=123 , maka PATH_INFO nya adalah /category
 */

<?php
if(isset($_SERVER['PATH_INFO'])){
    echo $_SERVER['PATH_INFO'];
} else {
    echo "Tidak ada PATH_INFO";
}

// atau                 <!- Kode diatas dan dibawah hasilnya sama tapi yang diatas dari PZN yang bawah buatan sendiri
echo $_SERVER['PATH_INFO'] ?? "Tidak ada PATH_INFO";
?>