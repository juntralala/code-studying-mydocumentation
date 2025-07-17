<?php

namespace UjunAlRantaui\PHP\Logging\Logger;
use Monolog\Logger;
use PHPUnit\Framework\TestCase;
use UjunAlRantaui\PHP\Logging\Controller\HomeController;

/*  Nama Logger dengan Nama Class
 * Salah satu kebiasaan ketika membuat object Logger adalah menggunakan nama Logger dengan nama class
   lokasi Logger nya 
 * Misal jika kita membuat object Logger di class ProductController, maka kita akan menggunakan nama logger
   dengan nama ProductController::class
 * Salah satu kegunaannya adalah kita bisa tahu lokasi kita melakukan logging dari nama Logger
 */

class NamaLoggerDenganNamaClass extends TestCase{

    public function testLoggerWithName(): void {
        $logger = new Logger(HomeController::class);

        self::assertNotNull($logger);
    }

} 