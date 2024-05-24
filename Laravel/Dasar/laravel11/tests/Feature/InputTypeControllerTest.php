<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class InputTypeControllerTest extends TestCase
{
        public function testInputType(): void
    {
        $this->post('/input-type/input-type', [
            'name' => "ujun",
            'married' => true,
            'birth_day' => '2024-05-09'
        ])->assertSeeText("ujun")
            ->assertSeeText('true')
            ->assertSeeText('09-05-2024');
    }
}
