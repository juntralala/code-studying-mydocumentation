<?php

namespace UjunAlRantaui\PHP\Logging\Formatter;
use Monolog\Formatter\JsonFormatter;
use Monolog\Handler\StreamHandler;
use Monolog\Logger;
use PHPUnit\Framework\TestCase;

/*  Formatter 
 * Saat Handler mengirim log event ke tujuan (misal file atau console), Handler akan melakukan proses format
   log event terlebih dahulu
 * Setiap Handler biasanya memiliki default Formatter, contohnya StreamHandler menggunakan LineFormatter
 * Jika ingin membuat Formatter sendiri, kita bisa membuat class turunan dari FormatterInterface
 */

// lanjutannya MonologFormatter.php

class FormatterTest extends TestCase {
    
    function testFormatter(): void {
        $logger = new Logger(self::class);

        $handler = new StreamHandler("php://stderr");
        $handler->setFormatter(new JsonFormatter());

        $logger->pushHandler($handler);

        $logger->info("Belajar PHP Logging");
        $logger->info("Belajar PHP Logging Lagi");

        self::assertNotNull($logger);
        self::assertNotNull($handler);
    }

}