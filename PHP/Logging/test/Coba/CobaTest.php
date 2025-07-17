<?php

namespace Test\Coba;
use Monolog\Handler\StreamHandler;
use PHPUnit\Framework\TestCase;
use Monolog\Logger;

class CobaTest extends TestCase {
    public function testCoba(): void {
        $log = new Logger(CobaTest::class);
        $log->pushHandler(new StreamHandler(__DIR__ . "/data.log"));

        $log->info("Ini data");

        self::assertTrue(true);
    }
}