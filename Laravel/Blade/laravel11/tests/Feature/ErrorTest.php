<?php

namespace Tests\Feature;
use Tests\TestCase;

class ErrorTest extends TestCase {
    public function testError(): void {
        $errors = [
            'name' => "Name is required",
            'password' => "Password is required"
        ];

        $this->withViewErrors($errors)
            ->view('error', [])
            ->assertSeeText("Name is required")
            ->assertSeeText("Password is required");
    }
}