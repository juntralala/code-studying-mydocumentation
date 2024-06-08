<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class InheritanceTest extends TestCase {
    public function testInheritance(): void {
        $this->view('inheritance.template.child')
            ->assertSeeText("Nama Aplikasi - Inheritance Template")
            ->assertSeeText("Deskripsi header")
            ->assertSeeText("Ini adalah halaman utama");
        }
        
    public function testInheritanceWithoutOverride(): void {
        $this->view('inheritance.show.child-default')
            ->assertSeeText("Nama Aplikasi - Inheritance Template")
            ->assertSeeText("Default header")
            ->assertSeeText("Default content");
    }
        
    public function testInheritanceWithOverride(): void {
        $this->view('inheritance.show.child-default')
            ->assertSeeText("Nama Aplikasi - Inheritance Template")
            ->assertSeeText("Default header")
            ->assertSeeText("Deskripsi header")
            ->assertDontSeeText("Default content")
            ->assertSeeText("Ini adalah halaman utama");
    }
}
