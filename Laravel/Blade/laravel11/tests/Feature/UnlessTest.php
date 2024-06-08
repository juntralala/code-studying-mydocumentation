<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class UnlessTest extends TestCase {
    public function testUnless(): void {
        $this->view("unless", ['isAdmin' => false])
            ->assertSeeText("You are not an admin");
    
        $this->view("unless", ['isAdmin' => true])
            ->assertSeeText("You are an admin");
    }
}
