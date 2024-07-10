<?php

namespace Tests\Feature;

use App\Models\Category;
use Database\Seeders\CategorySeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class UpdateTest extends TestCase {
    public function testUpdate(): void {
        $this->seed(CategorySeeder::class);

        $category = Category::find('FOOD');
        $category->name = "Food Updated";
        $successful = $category->update();     // didalam update sebenarnya manggil ->save() juga 
        self::assertTrue($successful);
    }

    public function testUpdateWithSaveMethod(): void {// penjelasan ada di Update/Update.txt
        $this->seed(CategorySeeder::class);

        $category = new Category();
        $category->id = "FOOD";
        $category->name = "Food Updated With Save Method";

        $category->exists = true;

        $successful = $category->save();

        self::assertTrue($successful);

        $foodCategory = Category::find('FOOD');
        self::assertEquals("FOOD" ,$foodCategory->id);
        self::assertEquals("Food Updated With Save Method" ,$foodCategory->name);
        self::assertEquals("Food Category" ,$foodCategory->description);
    }
}
