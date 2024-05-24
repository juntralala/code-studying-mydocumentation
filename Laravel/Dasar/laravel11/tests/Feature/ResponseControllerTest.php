<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class ResponseControllerTest extends TestCase
{
    
    public function testResponse(): void
    {
        $this->get('/response/hello')
            ->assertSeeText("Hello Response");
    }

    public function testHeader(): void {
        $this->get('/response/header')
            ->assertStatus(200)
            ->assertSeeText("name")
            ->assertSeeText("Muhammad")
            ->assertSeeText("Junaidi")
            ->assertHeader("Author", "UJUN-Al-Rantaui")
            ->assertHeader("App", "Belajar Laravel");
    }

    public function testResponseView(): void {
        $this->get('/response/type/view')
            ->assertSeeText("Hello UJUN");
    }

    public function testResponseJson(): void {
        $this->get('/response/type/json')
            ->assertJson([
                'name' => [
                    'first' => "Muhammad",
                    'last'  => "Junaidi"
                ]
            ]);
    }

    public function testResponseFile(): void {
        $this->get('/response/type/file')
            ->assertHeader('Content-Type', 'image/png');
    }

    public function testResponseDownload(): void {
        $this->get('/response/type/download')
            ->assertDownload("ujun.png");
    }
}
