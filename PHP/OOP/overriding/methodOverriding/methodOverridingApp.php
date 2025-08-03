<?php

// ketika mengoverride method yang ada di parentClass, child tidak boleh mengubah parameter parentnya
// karna bisa menimbulkan masalah pada pengembangan code, PHP akan memberikan warning jika kita melakukan perubahan pada parameter childnya

require_once "User.php";

$user = new User();
$user->intro();

$sp = new SuperUser();
$sp->intro();