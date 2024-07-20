<?php

namespace Tests\Feature\ResourceResponse;

use App\Models\Product;
use Database\Seeders\CategorySeeder;
use Database\Seeders\ProductSeeder;
use Tests\TestCase;

/** method response()
 *  Atau saat membuat Resource object, terdapat method response() yang bisa kita gunakan juga untuk memanipulasi
    data response
*/

// contohnya ada di route /api/products-response-method

class ResponseMethodTest extends TestCase {
    public function testResponseMethod()
    {
        $this->seed([CategorySeeder::class, ProductSeeder::class]);
        $products = Product::all();
        $this->get('/api/products-response-method')
            ->assertSuccessful()
            ->assertHeader('X-Authored-By', 'juntralala');
    }
}