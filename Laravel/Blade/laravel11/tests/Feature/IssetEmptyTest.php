<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class IssetEmptyTest extends TestCase {
    public function testIssetEmpty(): void {
        $this->view('isset-empty', [])
            ->assertDontSeeText("Hello");

        $this->view('isset-empty', ['name' => "ujun"])
            ->assertSeeText("Hello my name is ujun")
            ->assertSeeText("I have no hobby");

        $this->view('isset-empty', ['name' => "ujun", 'hobbies' => "sleep"])
            ->assertSeeText("Hello my name is ujun")
            ->assertDontSeeText("I have no hobby");
    }
}
