<?php

require_once __DIR__."/vendor/autoload.php";

use Monolog\Logger;
use Monolog\Handler\StreamHandler;

$log = new Logger("UJUN-Al-Rantaui");
$log->pushHandler(new StreamHandler("aplication.log", Logger::INFO));

$log->info("Hello World");
$log->info("Selamat Belajar Composer");