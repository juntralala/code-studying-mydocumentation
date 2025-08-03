<?php
/* Mengambil Session
 * untuk mengambil session kita tetap harus diawali session_start()
 * karna kalau tidak di start data didalam session tidak akan bisa diambil, kalau pun diambil tidak akan ada
   datanya
 */
// $_SESSION.php sebegai page login
// mengambil-session.php sebegai page berhasil login
// menghapus-session.php sebagai script logout

session_start();

if($_SESSION['login'] != true){
    header('Location: /Session/$_SESSION.php');
    exit();
}

$say = "Hello ".$_SESSION['username']
?>
<html>
    <head>
        <title>Berhasil Login</title>
    </head>
    <body>
        <h1><?= $say ?></h1>
        <a href="menghapus-session.php">Logout</a>
    </body>
</html>

