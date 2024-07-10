<?php

namespace Tests\Feature;

use App\Models\Category;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class UpdateManyTest extends TestCase
{
    public function testUpdateMany(): void
    {
        $categories = [];
        for ($i = 1; $i <= 10; $i++) {
            $categories[] = [
                'id' => "ID $i",
                'name' => "Category $i"
            ];
        }
        $succeessful = Category::insert($categories);
        self::assertTrue($succeessful);

        Category::whereNull('description')->update([
            'description' => "Updated"
        ]);
        $total = Category::where('description', "Updated")->count();
        self::assertEquals(10, $total);
    }
}
