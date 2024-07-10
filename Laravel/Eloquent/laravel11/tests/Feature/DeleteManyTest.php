<?php

namespace Tests\Feature;

use App\Models\Category;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class DeleteManyTest extends TestCase
{
    public function testDeleteMany(): void // pakai Query Builder kaya biasanya
    {
        $categories = [];
        for ($i = 1; $i <= 10; $i++) {
            $categories[] = [
                'id' => "ID $i",
                'name' => "Category $i"
            ];
        }
        $successful = Category::insert($categories);
        self::assertTrue($successful);

        Category::query()->whereNull('description')->delete();

        $total = Category::count();
        self::assertEquals(0, $total);
    }
}
