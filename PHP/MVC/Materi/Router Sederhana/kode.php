<?php

// ini diletakkan di file public/index.php
$path = "/index";

if(isset($_SERVER['PATH_INFO'])){
    $path = $_SERVER['PATH_INFO'];
}

require __DIR__.'/../app/View'.$path.'.php';





?>
<!-- Ini diletakkan di file app/View/index.php -->
<html>
<head>
    <title>Berhasil Porting</title>
</head>
<body>
    <h1>Index</h1>
</body>
</html>