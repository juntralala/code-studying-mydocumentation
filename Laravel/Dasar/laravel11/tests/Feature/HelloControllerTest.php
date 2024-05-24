<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class HelloControllerTest extends TestCase
{
    /**
     * A basic feature test example.
     */
    public function testHello(): void
    {
        $this->get("/hello/ujun")
                ->assertSeeText("Hello ujun");
    }

    public function testRequest(): void
    {
        $this->get("/hello/request", [
            "Accept" => "plain/text"
        ])->assertSeeText("/hello/request")
            ->assertSeeText("http://localhost/hello/request")
            ->assertSeeText("http://localhost/hello/request")
            ->assertSeeText("GET")
            ->assertSeeText("plain/text");
    }
}
