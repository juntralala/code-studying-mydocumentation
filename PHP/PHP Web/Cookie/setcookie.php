<?php
/* penjelasan function setcookie()

setcookie(
    string $name,
    string $value = "",
    int $expires_or_options = 0,
    string $path = "",
    string $domain = "",
    bool $secure = false,
    bool $httponly = false
): bool

$name       -> menetukan key cookie nya apa
$value      -> menentukan value cookie nya apa, ini tidak wajib diisi karna defaultnya "" string kosong
$expires    -> menentukan expirednya kapan. Defaultnya 0, kalau 0 maka cookie akan langsung dihapus ketika browser ditutup  
$path       -> Menentukan path (jalur) di mana cookie akan tersedia. Secara default, cookie hanya tersedia untuk halaman yang membuatnya. Dengan parameter ini, Anda bisa membuat cookie tersedia untuk semua halaman di bawah path tertentu.
$domain     -> Menentukan domain di mana cookie akan tersedia. Secara default, cookie hanya tersedia untuk domain yang sama dengan situs web yang membuatnya. Dengan parameter ini, Anda bisa membuat cookie tersedia untuk subdomain atau domain lain.
$secure     -> Menentukan apakah cookie hanya ingin dikirim melalui koneksi HTTPS. Jika diaktifkan (true), maka cookie tidak akan bisa dikirim melalui koneksi HTTP.
$httponly   -> Menentukan apakah cookie bisa diakses oleh skrip JavaScript. Jika diaktifkan (true), maka cookie hanya bisa diakses oleh server dan tidak bisa diakses oleh skrip JavaScript
*/

setcookie("X-BELAJAR-COOKIE", "Muhammad Junaidi");
header('Location: $_COOKIE.php'); // redirect ke halaman menampilkan cookie