<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class If_Else_Elseif_EndifTest extends TestCase {
    public function testPercabangan(): void {
        $this->get("if-else-elseif-endif?hobbies[]=makan")
            ->assertSeeText("I have a hobby");

        $this->get("if-else-elseif-endif?hobbies[]=makan&hobbies[]=tidur")
            ->assertSeeText("I have some hobbies");

        $this->get("if-else-elseif-endif")
            ->assertSeeText("I have no hobby");
    }
}
