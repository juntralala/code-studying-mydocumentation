<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class ExtendingTest extends TestCase{
    public function test_example(): void {
        $this->view('extending', ['name' => 'ujun'])
            ->assertSeeText("Hello ujun");
    }
}
