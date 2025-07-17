<?php

namespace UjunAlRantaui\PHP\Logging\Logger;
use Monolog\Logger;
use PHPUnit\Framework\TestCase;

/** Logger
 * Logger merupakan class yang digunakan untuk melakukan logging
 * Untuk membuat object Logger sangat mudah, kita cukup gunakan nama logger yang kita inginkan di parameter 
   contructor
 */

class Logger_ extends TestCase {

    public function testLogger() {
        $logger = new Logger("MuhammadJunaidi");

        self::assertNotNull($logger);
    }
}