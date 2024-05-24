<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Env;
use Tests\TestCase;

class EnvironmentTest extends TestCase
{
    
    public function testGetEnv(): void {
        $latihanNgoding = Env::get('UJUN');
        // $latihanNgoding = env('UJUN');
        
        self::assertEquals("Latihan Ngoding", $latihanNgoding);
    }
    
    public function testDefaultValue(): void {
        $author = Env::get('AUTHOR', 'UJUN');
        // $author = env("AUTHOR", "UJUN");

        self::assertEquals("UJUN", $author);
    }
    
}
