<?php

namespace Tests\Feature;

use App\Models\Category;
use Illuminate\Database\Eloquent\Collection;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\Log;
use Tests\TestCase;

class SelectTest extends TestCase {
    public function testSelect(): Collection {
        $categories = [];
        for($i = 1 ; $i<=10 ; $i++){
            $categories[] = [
                'id' => "ID $i",
                'name' => "Category $i"
            ];
        }
        Category::insert($categories);

        $categoriesResult = Category::whereNull('description')->get();
        self::assertCount(10, $categoriesResult);
        $categoriesResult->each(function($item){
            self::assertNull($item->description);
        });

        return $categoriesResult;
    }

    public function testUpdateSelectResult(): void {
        $categories = [];
        for($i = 1 ; $i<=10 ; $i++){
            $categories[] = [
                'id' => "ID $i",
                'name' => "Category $i"
            ];
        }
        Category::insert($categories);
        $categoriesResult = Category::whereNull('description')->get();

        // Updating the result select
        $categoriesResult->each(function($item){
            $item->description = "Updated";
            $item->save();
        });

        $result = Category::where("description", 'Updated')->get();
        self::assertCount(10, $result);
        $result->each(function($item){
            self::assertEquals("Updated", $item->description);
            Log::debug(json_encode($item));
        });
    }
}
