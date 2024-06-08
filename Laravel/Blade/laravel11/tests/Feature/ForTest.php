<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class ForTest extends TestCase {
    public function testFor(): void {
        $this->view('for', ['limit' => 10])
            ->assertSeeText('0')
            ->assertSeeText('5')
            ->assertSeeText('9');
    }
}
