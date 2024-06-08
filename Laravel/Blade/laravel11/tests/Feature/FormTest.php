<?php

namespace Tests\Feature;

use Tests\TestCase;

class FormTest extends TestCase {
    public function testFormDirective(): void {
        $this->view('form', ['user' => [
            'premium' => true,
            'name' => "ujun",
            'admin' => true
        ]])
            ->assertSee('checked')
            ->assertSee('ujun')
            ->assertDontSee('readonly');

        $this->view('form', ['user' => [
            'premium' => false,
            'name' => "ujun",
            'admin' => false
        ]])
            ->assertDontSee('checked')
            ->assertSee('ujun')
            ->assertSee('readonly');
    }
}