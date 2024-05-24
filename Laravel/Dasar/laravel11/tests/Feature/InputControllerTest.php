<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class InputControllerTest extends TestCase
{
    
    public function testInput(): void
    {
        $this->get("/input/hello?name=ujun")
            ->assertSeeText("Hello ujun");
            
        $this->post("/input/hello", ['name' => "ujun"])
            ->assertSeeText("Hello ujun");
    }

    public function testNestedInput(): void { 
        $this->post("/input/hello/first-last", [
            "name" => [
                'first' => "Muhammad",
                'last' => "Junaidi",
            ]
        ])
            ->assertSeeText("Hello Muhammad Junaidi");
    }

    public function testInputAll(): void { 
        $this->post("/input/hello/input", [
            "name" => [
                'first' => "Muhammad",
                'last' => "Junaidi",
            ]
        ])->assertSeeText("name")
            ->assertSeeText("first")
            ->assertSeeText("last")
            ->assertSeeText("Muhammad")
            ->assertSeeText("Junaidi");
    }

    public function testInputArray(): void { 
        $this->post("/input/hello/array", [
            "products" => [
                [ 
                    'name' => "Apple Mac Book Pro",
                    'price'=> 30_000_000
                ],
                [
                    'name' => "Thinkpad X1 Nano",
                    'price'=> 36_000_000
                ]
            ]
        ])->assertSeeText("Apple Mac Book Pro")
            ->assertSeeText("Thinkpad X1 Pro");
    }

    public function testDynamicProperties(): void {
        $this->get("/input/hello/dynamic-properties?first_name=Muhammad&last_name=Junaidi")
            ->assertSeeText("Hello Muhammad Junaidi");
    }
}
