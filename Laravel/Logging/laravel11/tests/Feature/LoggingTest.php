<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Log;
use Tests\TestCase;

class LoggingTest extends TestCase {
    public function testLogging(): void {

        Log::info("Hello info");
        Log::warning("Hello warning");
        Log::error("Hello error");
        Log::critical("Hello critical");

        $this->assertTrue(true);
    }

    public function testContext(): void {
        Log::info("Hello Info", ['name' => "UJUN"]);

        $this->assertTrue(true);
    }

    public function testWithContext(): void {
        Log::withContext(['username' => 'ujun']);
        Log::info("Hello info");

        $this->assertTrue(true);
    }

    public function testWithChannel(): void { // penjelansanya di 'Selected Channel.txt'
        $slackLogger = Log::channel('slack');
        $slackLogger->alert("With Channel"); // kirim dengan slack channel

        Log::error("Default Channel"); // kirim dengan default channel (stack)

        $this->assertTrue(true);
    }

    public function testFileChannel(): void { // penjelasannya di Handler.txt
        $logger = Log::channel('file');
        $logger->info("Hello File Channel");

        $this->assertTrue(true);
    }

    public function testDiscordWebhook(): void {
        self::markTestSkipped("Supaya tidak mengirim pesan ke Discord");
        $logger = new \Monolog\Logger("Discord");
        $logger->pushHandler(new \Tests\Handlers\DiscordHandler("https://discord.com/api/webhooks/1248793056313081908/28vFg7Qik6YbZhc73ATWn2IUhR8e-C1z6AQJTQoLbV3ssIzXAD_l1H342Jf_KK6dfgxy"));

        $logger->info("Monolog PHP");

        $this->assertTrue(true);
    } 
}
