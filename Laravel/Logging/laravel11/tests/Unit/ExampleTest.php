<?php

namespace Tests\Unit;

use PHPUnit\Framework\Attributes\DoesNotPerformAssertions;
use PHPUnit\Framework\TestCase;
use GuzzleHttp\Client;

class ExampleTest extends TestCase {

    #[DoesNotPerformAssertions]
    public function testMessageDiscord(): void {
        self::markTestSkipped('cuman test tas tus aja');
        $webhookUrl = "https://discord.com/api/webhooks/1248793056313081908/28vFg7Qik6YbZhc73ATWn2IUhR8e-C1z6AQJTQoLbV3ssIzXAD_l1H342Jf_KK6dfgxy";

        $client = new Client();
        $client->post($webhookUrl, [
            'json' => ['content' => "Loop "]
        ]);
    }

    #[DoesNotPerformAssertions]
    public function testRequestLocalhost(): void {
        self::markTestSkipped('Cuman test tas tus aja');
        $webhookUrl = "http://localhost";

        $client = new Client();
        $response = $client->post($webhookUrl, [
            'json' => ['message' => "ujun"]
        ]);

        var_dump($response);
        echo $response->getBody()->getContents();

        /* kode index.php untuk menerima request
            <?php

            $message = json_decode(file_get_contents('php://input'));

            header("X-Message: Kamu mengirim pesan {$message->message}");
            ?>
            Hallo Dunia
        */
    }
}
