<?php
/** Kode <?=
 * Kadang saat integrasi PHP dan HTML, kita sering sekali melakukan kode sederhana seperti ini :
   - <?php echo $title ?>
   - <?php echo $body ?>
   * hal itu bisa dipersingkat menggunakan tanda <?=, misalnya :
   - <?= $title ?>
   - <?= $body ?>
 */

$title = "Hello PHP dan HTML";
$body = "Ini adalah Body HTML";
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?= $title ?></title>
</head>
<body>
    <h1><?= $body ?></h1>
</body>
</html>