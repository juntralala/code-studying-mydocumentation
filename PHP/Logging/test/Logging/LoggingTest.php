<?php

namespace UjunAlRantaui\PHP\Logging\Logging;
use Monolog\Handler\HandlerInterface;
use Monolog\Handler\StreamHandler;
use Monolog\Logger;
use PHPUnit\Framework\TestCase;

/** Logging
 * Setelah kita membuat Logger dan menambahkan Handler ke Logger
 * Kita bisa mulai melakukan Logging
 * Ada banyak method di Logger yang bisa kita gunakan untuk melakukan logging, dan akan kita bahas detail
   di bab Level
 */

class LoggingTest extends TestCase {

    public function testLogging(): void {
        $logger = new Logger(LoggingTest::class); 

        $logger->pushHandler(new StreamHandler("php://stderr"));
        $logger->pushHandler(new StreamHandler(__DIR__ . "/../../application.log"));

        $logger->info("Belajar Pemrograman PHP Logging");
        $logger->info("Selamat datang di Programmer Zaman Now");
        $logger->info("Ini informasi aplikasi Logging");

        self::assertNotNull($logger);
    }

}