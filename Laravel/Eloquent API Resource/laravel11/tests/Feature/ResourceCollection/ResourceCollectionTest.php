<?php

namespace Tests\Feature\ResourceCollection;

use App\Models\Category;
use Database\Seeders\CategorySeeder;
use Tests\TestCase;

/** Resource Collection
 * Secara default, Resource yang sudah kita buat, bisa kita gunakan untuk menampilkan data multiple object atau 
   dalam bentuk JSON Array
 * Kita bisa menggunakan static method collection() ketika membuat Resource tersebut, dan gunakan parameter berisi data
    collection
*/

class ResourceCollectionTest extends TestCase
{
    public function testResourceCollection()
    {
        $this->seed([CategorySeeder::class]);
        $categories = Category::all();

        $this->get("/api/categories")
            ->assertStatus(200)
            ->assertJson([
                'data' => [
                    [
                        'id' => $categories[0]->id,
                        'name' => $categories[0]->name,
                        'created_at' => $categories[0]->created_at->toJSON(),
                        'updated_at' => $categories[0]->updated_at->toJSON()
                    ],
                    [
                        'id' => $categories[1]->id,
                        'name' => $categories[1]->name,
                        'created_at' => $categories[1]->created_at->toJSON(),
                        'updated_at' => $categories[1]->updated_at->toJSON()
                    ]
                ]
            ]);
    }
}