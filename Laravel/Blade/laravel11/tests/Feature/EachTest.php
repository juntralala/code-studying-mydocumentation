<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class EachTest extends TestCase {
    public function testEach(): void {
        $this->view('each-once', [
            'users' => [
                [
                    'name' => "ujun",
                    'hobbies' => ['Coding', 'Gaming']
                ],
                [
                    'name' => "ozon",
                    'hobbies' => ['Coding', 'Gaming']
                ]
            ]
        ])->assertSeeInOrder([
            '.red',
            'ujun',
            'Coding',
            'Gaming',
            'ozon',
            'Coding',
            'Gaming',
        ]);
    }
}
