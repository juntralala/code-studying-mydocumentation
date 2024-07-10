<?php

namespace Tests\Feature;

use App\Models\Category;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class InsertTest extends TestCase
{
    public function testInsert(): void
    {
        $category = new Category();
        $category->id = "GAWAI";
        $category->name = "Gawai";
        $successful = $category->save();

        self::assertTrue($successful);
    }
}
