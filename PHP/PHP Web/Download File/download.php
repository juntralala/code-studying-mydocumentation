<?php
// penjelasan ada di 'Download File di PHP.php'

if(isset($_POST['key']) && $_POST['key'] == "rahasia"){
    header('Content-Disposition: attachment; filename="profile.jpg"');
    header('Content-Type: image/jpg');
    readfile(__DIR__.'/file/profile.jpg');
    exit();
} else if(isset($_POST['key']) && $_POST['key'] != "rahasia"){
    ?><script>alert('Key Salah')</script><?php
    ?><script>window.history.back()</script><?php
    exit();
}
?>

<html>
<body>
    <form method="post" action="download.php">
        Key:
        <input type="text" name="key">
        <button type="submit">DOWNLOAD</button>
    </form>
</body>
</html>