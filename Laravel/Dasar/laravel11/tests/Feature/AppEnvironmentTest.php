<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Env;
use Illuminate\Support\Facades\App;
use Tests\TestCase;

class AppEnvironmentTest extends TestCase
{
    
    public function testAppEnv(): void {
        if(App::environment(['testing', 'prod', 'dev', 'local'])) { // paramter nya array agar return nya boolean
            // kode program kita
            self::assertTrue(true);
        }
    }

    public function testMyTestEnv(): void {
        self::assertTrue(App::environment('local'));
    }
    
    public function testMyTestEnv2(): void {
        self::assertTrue(env("APP_ENV") == 'local');
    }

    public function testMyTestEnv3(): void {
        self::assertTrue(env("ZUN") == 'Muhammad Junaidi');
    }
}
