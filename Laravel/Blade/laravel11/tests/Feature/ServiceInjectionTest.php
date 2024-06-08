<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class ServiceInjectionTest extends TestCase {
    public function testServiceInjection(): void {
        $this->view('service-injection', ['name' => 'ujun'])
            ->assertSeeText('Hello ujun');
    }
}
