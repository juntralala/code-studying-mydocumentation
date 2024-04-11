<?php

namespace UjunAlRantaui\PHP\Logging\Context;
use Monolog\Handler\StreamHandler;
use Monolog\Logger;
use Monolog\Test\TestCase;

/*  Context
 * Selain mengirim informasi log event berupa string, kita juga menambahkan informasi lainnya berupa array
   ketika melakukan logging
 * Informasi tambahan ini dinamakan Context
 * Context ini sangat bermanfaat jika kita ingin menambahkan informasi yang berhubungan dengan log event 
   tersebut, sehingga kita tidak perlu membuat format pesan secara manual, cukup kirim data Context berupa
   Array pada parameter kedua, pada method logging nya  
 */

class ContextTest extends TestCase{

    public function testContext(): void {
        $logger = new Logger(ContextTest::class);
        $logger->pushHandler(new StreamHandler("php://stderr"));
        
        $logger->info("This is Context message", ["username"=> "Zaid"]);
        $logger->info("Try login user", ["username"=> "Zaid"]);
        $logger->info("Success login user", ["username"=> "Zaid"]);

        self::assertNotNull($logger);
    }
    
}