<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class LoopVariabelTest extends TestCase {
    public function test_example(): void {
        $this->view("loop-variable", ['hobbies' => ['Makan', 'Minum', 'Tidur']])
            ->assertSeeText("1. Makan")
            ->assertSeeText("2. Minum")
            ->assertSeeText("3. Tidur");
    }
}
