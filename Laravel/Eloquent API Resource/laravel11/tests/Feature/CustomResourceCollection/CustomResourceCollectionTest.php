<?php

namespace Tests\Feature\CustomResourceCollection;

use App\Models\Category;
use Database\Seeders\CategorySeeder;
use Tests\TestCase;

/** Custom Resource Collection
 * Kadang, kita ingin membuat class Resource Collection secara manual, tanpa menggunakan Resource Class yang sudah
   kita buat
 * Pada kasus ini, kita bisa membuat Resource, namun menggunakan tambahan parameter --collection :
   php artisan make:resource NamaCollection --collection
 * Secara otomatis class Resource adalah turunan dari class ResourceCollection
 * Untuk mengambil informasi collection nya, kita bisa menggunakan attribute $collection
*/

// php artisan make:resource CategoryResourceCollection --collection

class CustomResourceCollectionTest extends TestCase
{
  public function testCustomResourceCollection()
  {
    $this->seed([CategorySeeder::class]);
    $categories = Category::all();
    $this->get("/api/categories-custom")
      ->assertStatus(200)
      ->assertJson([
        'total' => 2,
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