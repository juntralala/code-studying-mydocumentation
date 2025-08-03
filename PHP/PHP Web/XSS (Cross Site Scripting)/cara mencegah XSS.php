<?php
/** Cara mencegah XSS
 * Cara mencegah XSS adalah, kita perlu berhati-hati ketika ingin menampilkan teks yang inputnya berasal
   dari user
 * Jika kita tidak berharap sebuah text berisi tag HTML, kita bisa gunaan function 
   htmlspecialchars(value)
 * Function htmlspecialchars(value) secara otomatis akan melakukan encode special character di html agar
   agar di renser menjadi text biasa
 * https://www.php.net/manual/en/function.htmlspecialchars.php
 */

// localhost:8080/XSS (Cross Site Scripting)/cara mencegah XSS.php?name=ujun</h1><h1><script>alert("kamu telah di hack")</script>

$name = htmlspecialchars($_GET['name'])
?>

<html>
<head>
    <title>Cross Site Scripting</title>
</head>
<body>
    <h1>Name : <?= $name ?></h1>
</body>
</html>