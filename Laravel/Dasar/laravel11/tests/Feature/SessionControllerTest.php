<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class SessionControllerTest extends TestCase
{
    public function testCreateSession(): void {
        $this->get('/session/create')
            ->assertSessionHas('User-Id', "UJUN")
            ->assertSessionHas('Is-Member', true);
            //     'User-Id' => "UJUN",
            //     'Is-Member' => true
            // ]);
    }

    public function testGetSession(): void {
        $this->withSession([
            'User-Id' => 'UJUN',
            'Is-Member' => true
        ])->get('/session/get')
            ->assertSeeText('User Id : UJUN, Is Member : 1');
    }

    public function testGetSessionFailed(): void {
        $this->withSession([])->get('/session/get')
            ->assertSeeText('User Id : guest, Is Member :');
    }
}
