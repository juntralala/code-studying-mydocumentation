<?php

namespace Tests\Feature\ConditionalAttributes;

use App\Models\Category;
use App\Models\Product;
use Database\Seeders\CategorySeeder;
use Database\Seeders\ProductSeeder;
use Tests\TestCase;

/** Conditional Attributes
 * Pada beberapa kasus, ketika kita mengakses relation pada model di Resource, secara otomatis Laravel akan
   melakukan query ke database
 * Kadang hal ini berbahaya kalo ternyata relasinya sangat banyak, sehingga ketika mengubah menjadi JSON, akan
   sangat lambat
 * Kita bisa melakukan pengecekan conditional attribute, bisa kita gunakan untuk pengecekan boolean ataupun relasi
*/

// contoh penerapannya ada di App\Http\Resources\ProductResource

class ConditionalAttributesTest extends TestCase {
    public function testConditionalAttributes()
    {
        $this->seed([CategorySeeder::class, ProductSeeder::class]);
        /**
         * @var Product
         */
        $product = Product::first();
        $this->get("/api/products/$product->id")
            ->assertSuccessful()
            ->assertJson([
                'value' => [
                    'id' => $product->id,
                    'name' => $product->name,
                    'category' => [
                        'id' => $product->category->id,
                        'name' => $product->category->name
                    ],
                    'price' => $product->price,
                    'is_expensive' => $product->price > 1000,
                    'created_at' => $product->created_at->toJSON(),
                    'updated_at' => $product->updated_at->toJSON(),
                ]
            ]);
    }
}