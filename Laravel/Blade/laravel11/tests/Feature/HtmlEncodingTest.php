<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class HtmlEncodingTest extends TestCase {
    public function testHtmlEncoding(): void {
        $response = $this->get('/html-encoding')
            ->assertSeeText('<h1>ujun</h1>');
    }
}
