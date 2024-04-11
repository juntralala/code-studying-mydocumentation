<?php

namespace UjunAlRantaui\PHP\Logging\RotatingFileHandler;
use Monolog\Handler\RotatingFileHandler;
use Monolog\Handler\StreamHandler;
use Monolog\Logger;
use Monolog\Test\TestCase;

/*  Rotating File Handler
 * Saat menggunakan file sebagai penyimpanan log, kadang semakin lama, ukuran file akan semakin besar
 * StreamHandler secara default akan selalu mengirim log event ke file yang sama terus menerus
 * Untungnya ada class turunan StreamHandler bernama RotatingFileHandler
 * Class ini digunakan untuk mengirim log event ke file, namun bisa secara otomatis membuat file baru setiap
   hari, sehingga semua log tidak akan disimpan didalam satu file
 * Ini bagus untuk memastikan ukuran log tidak terlalu besar, dan mudah untuk menghapus log lama yang sudah
   tidak kita gunakan lagi
 */

class RotatingFileHandlerTest extends TestCase {

    function testRotatingFileHandler(): void {
        $logger = new Logger(self::class);
        $logger->pushHandler(new StreamHandler("php://stderr"));
        $logger->pushHandler(new RotatingFileHandler(__DIR__ . "/application.log", 10, Logger::INFO));

        $logger->info("Belajar PHP Dasar");
        $logger->info("Belajar PHP OOP");
        $logger->info("Belajar PHP StandardLiblary");
        $logger->info("Belajar PHP Database Mysql");

        self::assertNotNull($logger);
    }
}