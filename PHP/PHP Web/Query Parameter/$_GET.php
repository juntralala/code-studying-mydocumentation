<?php
/** $_GET
 * $_GET adalah global variable berupa array berisikan key sesusai dengan nama query parameter, dan value
   sesuai dengan value query parameter
 * Jika kita mengirim query parameter name=Eko, artinya akan ada query parameter name di dalam $_GET 
   yang bernilai Eko
 * Perlu diperhatikan, query parameter adalah data yang dikirim oleh client, jadi pastikan sebelum
   menggunakannya kita harus cek apakah datanya ada atau tidak, karena bisa jadi datanya tidak dikirim oleh
   client
 */

$sapa = "halo " . $_GET['name']

?>

<html>
<head>
    <title>Global Variable 1_GET</title>
</head>
<body>
    <h1><?= $sapa ?></h1>
</body>
</html>