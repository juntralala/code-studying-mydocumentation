<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class FilterRequestInputControllerTest extends TestCase
{
    
    public function testFilterOnly(): void
    {
        $this->post('/filter/only', [
            'name' => [
                'first' => "Eko",
                'middle' => "Kurniawan",
                'last' => "Khannedy"
            ]
        ])->assertSeeText("Eko")
            ->assertSeeText('Khannedy')
            ->assertDontSeeText("Kurniawan");
    }

    public function testFilterExcept(): void {
        $this->post('/filter/except', [
            'username' => "ujun",
            'admin' => "true",
            'password' => 'rahasia'
        ])->assertSeeText('ujun')->assertSeeText('rahasia')
            ->assertDontSeeText('admin');
    } 

    public function testMergeInput(): void {
        $this->post('/filter/merge', [
            'username' => "ujun",
            'admin' => "true",
            'password' => 'rahasia'
        ])->assertSeeText('ujun')->assertSeeText('rahasia')
            ->assertSeeText('admin')->assertSeeText('false');
    }
}
