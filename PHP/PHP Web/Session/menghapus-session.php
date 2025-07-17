<?php
// $_SESSION.php sebegai page login
// mengambil-session.php sebegai page berhasil login
// menghapus-session.php sebagai script logout

session_start();
session_destroy();

header('Location: /Session/$_SESSION.php');
exit();