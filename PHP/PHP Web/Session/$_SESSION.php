<?php
/*  $_SESSION
 * $_SESSION adalah global variable array yang berisi data session
 * Setelah session kita start, kita bisa menggunakan $_SESSION untuk menyimpan data session atau mengambil
   data di session (jadi jika belum kita start maka $_SESSION tidak bisa digunakan)
 * Jika session belum di start, perubahan yang kita lakukan di $_SESSION atau pengambilan data di $_SESSION,
   tidak akan berpengaruh apa-apa
 */

// $_SESSION.php sebegai page login
// mengambil-session.php sebegai page berhasil login
// menghapus-session.php sebagai script logout


session_start();

if(isset($_SESSION['login']) && $_SESSION['login'] == true){
  header('Location: /Session/mengambil-session.php');
  exit();
}

$error = "";
if($_SERVER['REQUEST_METHOD'] == "POST"){
  if($_POST['username'] == "ujun" && $_POST['password'] == 'ujun'){
    $_SESSION['login'] = true;
    $_SESSION['username'] = 'ujun';
    header('Location: /Session/mengambil-session.php');
    exit();
  } else {
    $error = "Login Gagal";
  }
}
?>

<html>
<body>
  <?php if($error != ""){ ?>
    <h1><?=$error?></h1>
  <?php } ?>
  <form action="/session/$_SESSION.php" method="POST">
    <label for="username">USERNAME: 
      <input type="text" name="username" id="username">
    </label><br>
    <label for="password">PASSWORD: 
      <input type="text" name="password" id="password">
    </label><br>
    <button type="submit">Login</button>
  </form>
</body>
</html>