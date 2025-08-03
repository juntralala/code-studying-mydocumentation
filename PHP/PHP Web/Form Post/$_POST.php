<?php
/** $_POST
 * $_POST adalah variable yang berisikan data array yang dikirim dari Client ke Server dalam bentuk form post
 * Cara penggunaannya sama seperti $_GET
 */
?>

<html>

<head>
    <title>$_POST</title>
</head>

<body>
    <form method="POST" action="$_POST.php">
        <h1>LOGIN</h1>
        <label for="username">Username: 
            <input type="text" name="username" id="username">
        </label>
        <br><br>
        <label for="password">Password: 
            <input type="text" name="password" id="password">
        </label><br>
        <button type="submit" id="kirim">Kirim</button>
    </form>
    <?php if($_SERVER['REQUEST_METHOD'] === "POST"){
        foreach($_POST as $key => $value) {?>
        <h1><?= "$key : $value" ?></h1>
    <?php }} ?>
</body>

</html>