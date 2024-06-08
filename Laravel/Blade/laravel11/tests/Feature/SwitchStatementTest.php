<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class SwitchStatementTest extends TestCase {
    public function testSwitch(): void {
        $this->view('switch-statement', ['value' => "A"])
            ->assertSeeText("Memuaskan");

        $this->view('switch-statement', ['value' => "B"])
            ->assertSeeText("Bagus");

        $this->view('switch-statement', ['value' => "C"])
            ->assertSeeText("Cukup");

        $this->view('switch-statement', ['value' => "D"])
            ->assertSeeText("Tidak lulus");
    }
}
