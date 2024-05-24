<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class ViewTest extends TestCase
{
    public function testView(): void {
        $this->get('/hello')
            ->assertSeeText('Hello Ujun');

        $this->get('/hello-again')
            ->assertSeeText('Hello ujun');
    }

    public function testNested(): void {
        $this->get('/hello/world')
            ->assertSeeText("Hello/World");
    }

    public function testTemplate(): void {
        $this->view('hello', ['name' => 'UJUN'])
            ->assertSeeText('Hello UJUN');

        $this->view('hello/world')
            ->assertSeeText('Hello/World');
    }
}
