<?php

namespace Tests\Feature;
use Illuminate\Support\Facades\Blade;
use Tests\TestCase;

class InlineBladeTemplateTest extends TestCase {
    public function testInlineBladeTemplate(): void {
        $response = Blade::render('Hello {{$name}}', ['name' => 'ujun']);
        $this->assertEquals('Hello ujun', $response);
    }
}