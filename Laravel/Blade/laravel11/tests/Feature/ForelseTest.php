<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class ForelseTest extends TestCase {
    public function testForelse(): void {
        $this->view('foreach', 
            ['hobbies' => ["Makan", "Minum", "Tidur"]])
            ->assertSeeText("Makan")
            ->assertSeeText("Minum")
            ->assertSeeText("Tidur")
            ->assertDontSeeText("Have no hobby");

        $this->view('forelse', ['hobbies' => []])
            ->assertSeeText("Have no hobby");
    }
}
