<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class ForeachTest extends TestCase {
    public function test_example(): void {
        $this->view('foreach', 
            ['hobbies' => [
                "Makan",
                "Minum",
                "Tidur"
                ]
            ]
        )->assertSeeText("Makan")
            ->assertSeeText("Minum")
            ->assertSeeText("Tidur");
    }
}
