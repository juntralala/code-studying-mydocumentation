<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class ConfigurationTest extends TestCase
{
    
    public function testConfig(): void {
        $first = config('contoh.name.first');
        $last = config('contoh.name.last');
        $email = config('contoh.email');
        $github = config('contoh.github');

        self::assertEquals('Muhammad', $first);
        self::assertEquals('Junaidi', $last);
        self::assertEquals('ujun@gmail.com', $email);
        self::assertEquals('https://github.com/UJUN-Al-Rantaui', $github);
    }
}
