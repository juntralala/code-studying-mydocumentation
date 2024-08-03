<?php

namespace Tests\Feature\AdditionalMetadata;

use App\Models\Product;
use Database\Seeders\CategorySeeder;
use Database\Seeders\ProductSeeder;
use Tests\TestCase;

/** Meta Data
 * Kadang, kita ingin menambahkan attribute tambahan selain “data”
 * Untuk attribute tambahan yang statis, kita bisa tambahkan di Resource dengan meng-override properties $additional
*/

// php artisan make:resource ProductDebugResource

class AdditionalMetadataTest extends TestCase {
    public function testAdditionalMetadata()
    {
        $this->seed([CategorySeeder::class, ProductSeeder::class]);
        $product = Product::first();
        $response = $this->get("/api/products-debug/$product->id")
            ->assertStatus(200)
            ->assertJson([
                'author' => 'juntralala',
                'app' => 'Belajar Eloquent API Resource',
                'data' => [
                    'id' => $product->id,
                    'name' => $product->name,
                    'price' => $product->price
                ]
            ]);
        
        self::assertNotNull($response->json('server_time'));
    }
}