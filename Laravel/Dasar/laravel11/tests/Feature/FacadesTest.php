<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\Config;
use Tests\TestCase;

class FacadesTest extends TestCase
{
    public function testConfig(): void
    {
        $firstName1 = config("contoh.name.first");
        $firstName2 = Config::get("contoh.name.first");

        self::assertEquals($firstName1, $firstName2);

        // var_dump(Config::all());
    }
    
    public function testConfigDependency(): void {
        $firstName1 = config("contoh.name.first");
        $firstName2 = Config::get("contoh.name.first");
        $config = $this->app->make("config");
        $firstName3 = $config->get("contoh.name.first");

    
        self::assertEquals($firstName1, $firstName2);
        self::assertEquals($firstName1, $firstName3);
    
        // var_dump(Config::all());
    }

    public function testFacadeMock(): void {
        Config::shouldReceive('get')
            ->with('contoh.name.first')
            ->andReturn('Muhammad');
        
        $firstName = Config::get('contoh.name.first');

        self::assertEquals('Muhammad', $firstName);
    }


}
