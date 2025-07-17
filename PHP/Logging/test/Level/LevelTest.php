<?php

namespace UjunAlRantaui\PHP\Logging\Level;
use Monolog\Handler\StreamHandler;
use Monolog\Logger;
use PHPUnit\Framework\TestCase;

/*  Level
 * Saat kita mengirim log event, kita bisa menetukan level dari log event tersebut
 * Monolog mendukung banyak sekali level, dimana cara kerja level itu bertingkat, dari paling rendah kepaling
   tinggi
 * Biasanya Level digunakan untuk menentukan jenis log event, misal jika log event berupa informasi, kita
   gunakan level info, jika berupa masalah kita bisa gunakan level error, jika berupa informasi untuk proses
   debugging dan lain-lain
 */

/** Daftar Level
    +===========+===============+===========+
    | Level     | Logger Method | Value     |
    +-----------+---------------+-----------+
    | DEBUG     | debug()       | 100       |
    | INFO      | info()        | 200       |
    | NOTICE    | notice()      | 250       |
    | WARNING   | warning()     | 300       |
    | ERROR     | error()       | 400       |
    | CRITICAL  | critical()    | 500       |
    | ALERT     | alert()       | 550       |
    | EMERGENCY | emergency     | 600       |
    +===========+===============+===========+
 */

class LevelTest extends TestCase {

    public function testLevel(): void {

        $logger = new Logger(LevelTest::class);
        $logger->pushHandler(new StreamHandler("php://stderr"));
        $logger->pushHandler(new StreamHandler(__DIR__ . "/../../application.log"));
        $logger->pushHandler(new StreamHandler(__DIR__ . "/../../error.log", Logger::ERROR));

        $logger->debug("This is debug");
        $logger->info("This is info");
        $logger->notice("This is notice");
        $logger->warning("This is warning");
        $logger->error("This is error");
        $logger->critical("This is critical");
        $logger->alert("This is alert");
        $logger->emergency("This is emergency");

        self::assertNotNull($logger);
    }

}