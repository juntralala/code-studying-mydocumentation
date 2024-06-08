<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class WhileTest extends TestCase {
    public function testWhile(): void {
        $test = $this->view("while", ['i' => 0]);
        for($i = 0; $i < 10 ; $i++){
            $test->assertSeeText("the current value is $i");
        }
    }
}
