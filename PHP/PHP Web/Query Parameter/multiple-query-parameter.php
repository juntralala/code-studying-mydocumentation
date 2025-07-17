<?php
/** Multiple Query Parameter
 * Query parameter URL bisa memiliki banyak parameter
 * Jika kita ingin mengirim banyak query parameter, kita cukup gunakan tanda & diikuti dengan query parameter
   selanjutnya
 */

$sapa = "halo {$_GET['firstName']} {$_GET['lastName']}";
?>

<html>
<head>
    <title>Global Variable 1_GET</title>
</head>
<body>
    <h1><?= $sapa ?></h1>
</body>
</html>