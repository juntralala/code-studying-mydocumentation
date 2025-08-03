<?php

namespace UjunAlRantaui\PHP\Logging\Handler;
use Monolog\Handler\StreamHandler;
use Monolog\Logger;
use Monolog\Test\TestCase;

/*  Handler
 * Monolog memiliki fitur yang namanya handler
 * Handler merupakan object yang bertugas mengirimkan aktivitas log event event yang kita kirim dari ke
   target yang kita tuju
 * Secara default, tidak ada Handler sama sekali ketika kita membuat Logger, kita perlu menambahkan Handler
   ke Logger secara manual 
 * Handler di Monoloh di representasikan dalam interface HandlerInterface
 * https://github.com/Seldaek/monolog/blob/main/src/Monolog/Handler/HandlerInterface.php
 */

//  lanjutan : ImplementasiHandler.php
//  lanjutan : StreamHandler_.php

class Handler_ extends TestCase {
    
    public function testHandler() {
        $logger = new Logger(Handler_::class);

        $logger->pushHandler(new StreamHandler("php://stderr"));                   // mengirim ke console
        $logger->pushHandler(new StreamHandler(__DIR__ . "/../application.log"));

        self::assertNotNull($logger);
        self::assertEquals(2, count($logger->getHandlers()));
    }

}