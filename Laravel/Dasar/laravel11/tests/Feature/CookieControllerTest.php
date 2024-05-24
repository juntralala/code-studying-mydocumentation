<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class CookieControllerTest extends TestCase
{
    /**
     * A basic feature test example.
     */
    public function testCreateCookie(): void
    {
        $this->get('/cookie/set')
            ->assertCookie("User-Id", 'UJUN')
            ->assertCookie("Is-Member", 'true');
    }

    public function testGetCookie(): void {
        $this->withCookie("User-Id", "UJUN")
            ->withCookie("Is-Member", "true")
            ->get("/cookie/get")
            ->assertJson([
                'userId' => "UJUN",
                'isMember' => "true"
            ]);
    }
}
