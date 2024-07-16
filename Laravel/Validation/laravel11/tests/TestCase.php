<?php

namespace Tests;

use Illuminate\Foundation\Testing\TestCase as BaseTestCase;
use Illuminate\Support\Facades\Log;
use Psr\Log\LoggerInterface;

abstract class TestCase extends BaseTestCase
{
    protected LoggerInterface $logger;
    
    public function setUp(): void
    {
        parent::setUp();
        $this->logger = Log::build([
            'name' => $this::class,
            'driver' => 'single',
            'path' => base_path("tests/Feature/.log"),
            'replace_placeholder' => true
        ]);
    }
}
