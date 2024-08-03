<?php

namespace Tests\Feature\DataWrap;

use App\Http\Resources\CategorySimpleResource;
use App\Models\Product;
use Database\Seeders\CategorySeeder;
use Database\Seeders\ProductSeeder;
use PHPUnit\Framework\Attributes\TestDox;
use Tests\TestCase;

/** Data Wrap
 * Secara default, data JSON yang dibuat oleh Resource akan disimpan dalam attribute “data”
 * Jika kita ingin menggantinya, kita bisa ubah attribute $wrap di Resource dengan nama attribute yang kita mau
 * Secara default, jika dalam toArray() kita mengembalikan array yang terdapat attribute sama dengan $wrap, maka 
  data JSON tidak akan di wrap
*/

// lihat App\Http\Resources\PorductResource

class DataWrapTest extends TestCase {

    #[TestDox('tidak di bungkus lagi karna mengembalikan array yg sama dengan $wrap')]
    public function testDataWrap()
    {
        $this->seed([CategorySeeder::class, ProductSeeder::class]);
        $product = Product::first(); 
        $categoryResource = new CategorySimpleResource($product->category);
        $this->get("/api/products/$product->id")
            ->assertStatus(200)
            ->assertJson([
                'value' => [
                    'id' => $product->id,
                    'name' => $product->name,
                    'category' => $categoryResource->toArray(request()),
                    'price' => $product->price,
                    'created_at' => $product->created_at->toJSON(),
                    'updated_at' => $product->updated_at->toJSON()
                ]
            ]);
    }
}