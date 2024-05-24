<?php

namespace Tests\Feature;

use Illuminate\Support\Facades\App;
use Tests\TestCase;

class RoutingTest extends TestCase {

    public function testError(): void {
        $this->get('/tidakada')
            ->assertSeeText("404 by UJUN-Al-Rantaui");
    }

    public function testEnv(): void {
        $this->assertTrue(App::environment("local"));
    }

}