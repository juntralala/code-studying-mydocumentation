<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class IncludeTest extends TestCase {
    public function testInclude(): void {
        $this->view('include', [])
            ->assertSeeText("UJUN-Al-Rantaui")
            ->assertSeeText("Selamat data di website kami");
            
            $this->view('include', ['title' => "Belajar Laravel Blade"])
            ->assertSeeText("Belajar Laravel Blade")
            ->assertSeeText("Selamat data di website kami");
    }
}
