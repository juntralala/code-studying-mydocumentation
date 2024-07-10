<?php

namespace Tests\Feature;

use App\Models\Category;
use Database\Seeders\CategorySeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use PHPUnit\Framework\Attributes\TestDox;
use Tests\TestCase;

class DeleteTest extends TestCase
{
    #[TestDox("test delete after find method")]
    public function testDelete(): void
    {
        $this->seed(CategorySeeder::class);

        $category = Category::find('FOOD');

        $category->delete();

        $total = Category::count();
        self::assertEquals(0, $total);
    }
    
    public function testDeleteWithoutFind(): void 
    {
        $this->seed(CategorySeeder::class);
        
        $category = new Category();
        $category->id = "FOOD";
        $category->exists = true;
        
        $category->delete();

        $total = Category::count();
        self::assertEquals(0, $total);
    }
}
