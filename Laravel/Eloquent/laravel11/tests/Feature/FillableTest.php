<?php

namespace Tests\Feature;

use App\Models\Category;
use Database\Seeders\CategorySeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class FillableTest extends TestCase
{
    public function testFillableAttributes(): void
    {
        $request = [
            'id' => "ELEKTRONIK",
            'name' => "Elektronik",
            'description' => "elektronik description"
        ];

        $category = new Category($request);
        $category->save();

        self::assertEquals("ELEKTRONIK", $category->id);
        self::assertEquals("Elektronik", $category->name);
        self::assertEquals("elektronik description", $category->description);
    }

    public function testCreateMethod(): void
    {
        $request = [
            'id' => "ELEKTRONIK",
            'name' => "Elektronik",
            'description' => "elektronik description"
        ];

        // $category = Category::query()->create($request);
        $category = Category::create($request); // create() langsung  melakukan save() ke database

        self::assertEquals("ELEKTRONIK", $category->id);
        self::assertEquals("Elektronik", $category->name);
        self::assertEquals("elektronik description", $category->description);
    }

    public function testUpdateModel(): void
    {
        $this->seed(CategorySeeder::class);

        $request = [
            'name' => 'Food Updated',
            'description' => "Food Category Updated"
        ];
        
        $category = Category::find("FOOD");
        $category->fill($request);
        $category->save();

        $updatedCategory = Category::find("FOOD");
        self::assertNotNull($updatedCategory);
        self::assertEquals("Food Updated", $updatedCategory->name) ;
        self::assertEquals("Food Category Updated", $updatedCategory->description); 
    }
}
