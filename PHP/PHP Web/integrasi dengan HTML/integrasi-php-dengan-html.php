<?php
/** Integrasi dengan HTML
 * PHP adalah bahasa pemrograman yang terintegrasi dengan baik dengan bahasa pemrograman markup HTML
 * Dengan integrasi PHP dan HTML, kita bisa membuat web HTML yang dinamis, dalam artian tidak statis dan
   bisa berubah-ubah sesuai logika kode program kita
 * Secara default saat kita menggunakan kode <?php dan diakhiri ?>, artinya didalamnya kita bisa memasukkan 
   kode PHP, namun diluar kode tersebut, kita bisa memasukkan kode HTML seperti biasa 
 */

 $title = "Hello PHP dan HTML";
 $body = "Ini adalah Body HTML";
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?= $title ?></title>
</head>
<body>
    <h1><?= $body ?></h1>
</body>
</html>