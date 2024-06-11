<?php

namespace Tests\Handlers;

use Monolog\Handler\AbstractProcessingHandler;
use Monolog\Logger;
use GuzzleHttp\Client;

class DiscordHandler extends AbstractProcessingHandler
{
    private $webhookUrl;

    public function __construct($webhookUrl, $level = Logger::DEBUG, $bubble = true)
    {
        $this->webhookUrl = $webhookUrl;
        parent::__construct($level, $bubble);
    }

    protected function write(\Monolog\LogRecord $record): void
    {
        $message = [
            'content' => $record->message
        ];

        $client = new Client();
        $client->post($this->webhookUrl, [
            'json' => $message
        ]);
    }
}
