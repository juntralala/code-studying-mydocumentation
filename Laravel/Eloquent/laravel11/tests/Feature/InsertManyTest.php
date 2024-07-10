<?php

namespace Tests\Feature;

use App\Models\Category;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class InsertManyTest extends TestCase
{
    public function testInsertMany(): void
    {
        $categories = [];

        for($i = 1 ; $i<=10 ; $i++){
            $categories[] = [
                'id' => "ID $i",
                'name' => "Category $i"
            ];
        }

        // $successful = Category::query()->insert($categories);
        $successful = Category::insert($categories); // <- sebenarnya, manggil query() kemudian ->insert()

        self::assertTrue($successful);

        // $result = Category::query()->count();
        $result = Category::count(); // <- sebenarnya, manggil query() kemudian ->insert()
        self::assertEquals(10, $result);
    }
}
