<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class IncludeConditionTest extends TestCase {
    public function testIncludeWhen(): void {
        $this->view('include-condition', [
            'user' =>[
                'name' => 'ujun',
                'owner' => true
            ] 
        ])
            ->assertSeeText("Selamat datang owner")
            ->assertSeeText("Selamat datang ujun");

        $this->view('include-condition', [
            'user' =>[
                'name' => 'ozon',
                'owner' => false
            ]
        ])
            ->assertDontSeeText("Selamat datang owner")
            ->assertSeeText("Selamat datang ozon");

    }
}
