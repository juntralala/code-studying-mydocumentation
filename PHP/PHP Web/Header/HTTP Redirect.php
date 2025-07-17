<?php
/** HTTP Redirect
 * Redirect sendiri sudah merupakan sesuatu yang standard di HTTP
 * Untuk melakukan redirect, kita hanya butuh menggunakan response header Location yang berisi url redirect 
   kita, bisa dalam domain yang sama, atau ke domain yang berbeda, misal
 * Location: /admin.php artinya redirect ke halaman admin didomain yang sama
 * Location: https://www.youtube.com => artinya redirect ke halaman google  
 */

/* redirect ke domain yang sama */
// header("Location: /Header/HTTP%20Redirect.php");

/* redirect ke domain yang berbeda */
header("Location: https://www.youtube.com");
?>

<html>
<head>
    <title>HTTP Redirect</title>
</head>
<body>
    <h1>HTTP Redirect</h1>
</body>
</html>