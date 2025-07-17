<?php
// untuk mengambil cookie yang dikirim browser kita bisa gunakan variable $_COOKIE

$belajarCookie = $_COOKIE['X-BELAJAR-COOKIE'];
?>

<html>
    <body>
        <h1><?=$belajarCookie?></h1>
    </body>
</html>