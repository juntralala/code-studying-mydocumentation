<?php

namespace UjunAlRantaui\PHP\Logging\Processor;
use Monolog\Handler\StreamHandler;
use Monolog\Logger;
use Monolog\Processor\GitProcessor;
use Monolog\Processor\MemoryUsageProcessor;
use Monolog\Test\TestCase;

/*  Processor 
 * Processor merupakan cara lain jika ingin menambahkan informasi ke log event
 * Jika informasi Context harus dikirim setiap kali kita melakukan logging, pada Processor, kita bisa
   membuat class Processor yang akan dieksekusi tiap kali log event dikirim
 * Dengan Processor, kita bisa menambahkan informasi tambahan pada log event yang kita kirim
 * Untuk membuat Processor, kita bisa langsung menggunakan Callable atau class turunan dari ProcessorInteface 
 */

//  lanjutannya : MonologProcessor_.php

class ProcessorTest extends TestCase {

    function testProcessor(): void {
        $logger = new Logger(ProcessorTest::class);
        $logger->pushHandler(new StreamHandler("php://stderr"));
        $logger->pushProcessor(new GitProcessor());
        $logger->pushProcessor(new MemoryUsageProcessor());
        $logger->pushProcessor(function ($record) {
            $record['extra']['pzn'] = [
                'author'    => "Eko Kurniawan Khannedy",
                'app'       => "Belajar PHP Logging"
            ];
            return $record;
        });

        $logger->info("This is Processor message");

        self::assertNotNull($logger);
    } 

} 