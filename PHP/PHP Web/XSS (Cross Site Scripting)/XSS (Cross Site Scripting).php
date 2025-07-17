<?php
/** Cross Site Scripting
 * XSS adalah celah keamanan yang biasanya di exploitasi oleh penyerang dengan cara mengirim script pada parameter
 * Jika sampai membuat kode salah merender halaman web, maka script tersebut akan di render di halaman web,
   dan bisa menyebabkan penyerang bisa mengirimkan kode JavaScript
 * Hal ini sangat berbahaya, karena penyerang bisa mencuri session pengguna yang sedang login di web kita
 */
// http://localhost:8080/XSS (Cross Site Scripting)/XSS (Cross Site Scripting).php?name=ujun</h1><h1><script>alert("kamu telah di hack")</script>

$name = $_GET['name']
?>

<html>
<head>
    <title>Cross Site Scripting</title>
</head>
<body>
    <h1>Name : <?= $name ?></h1>
</body>
</html>