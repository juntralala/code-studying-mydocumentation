<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class ContohMiddlewareTest extends TestCase
{
    public function testInvalid(): void
    {
        $this->get('/middleware/api')
            ->assertStatus(401)
            ->assertSeeText("Access Denied");
    }

    public function testValid(): void
    {
        $this->withHeader("X-API-KEY", "UJUN")
            ->get('/middleware/api')
            ->assertStatus(200)
            ->assertSeeText("OK");
    }

    public function testGroupInvalid(): void
    {
        $this->get('/middleware/group')
            ->assertStatus(401)
            ->assertSeeText("Access Denied");
    }

    public function testGroupValid(): void
    {
        $this->withHeader("X-API-KEY", "UJUN")
            ->get('/middleware/group')
            ->assertStatus(200)
            ->assertSeeText("OK");
    }
}
