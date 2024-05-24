<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class URLGenerationTest extends TestCase
{
    public function testURLCurrent(): void {
        $this->get('/url/current')
            ->assertSeeText('/url/current');
    }

    public function testURLCurrent2(): void {
        $this->get('/url/current2')
            ->assertSeeText('/url/current2');
    }

    public function testNamedRoute(): void {
        $this->get('/url/named')
            ->assertSeeText('/redirect/name/UJUN');
    }

    // public function 
}
