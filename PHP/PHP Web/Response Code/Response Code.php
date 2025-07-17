<?php
/*  Response Code
 * Dalam spesifikasi HTTP, response dari server biasanya memiliki code, atau dikenal HTTP Response Code
 * Secara default, di PHP, response code adalah 200 OK
 * Ada banyak sekali HTTP Response Code : https://developer.mozilla.org/id/docs/Web/HTTP/Status
 * Dalam pembuatan website mungkin kita jarang sekali melakukan perubahan response code, namun jika kita
   nanti ingin membuat API menggunakan PHP, response code sangat penting digunakan 
 */
// http://localhost/Response%20Code/Response%20Code.php?name=Junaidi

// Contoh kode response code
if(!isset($_GET['name']) || $_GET['name'] == ""){
    http_response_code(400);
    echo "NAME is Required";
    exit();
}

$sapa = "halo " . htmlspecialchars($_GET['name']);
?>

<html>
    <body>
        <h1><?= $sapa ?></h1>
    </body>
</html>