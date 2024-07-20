<?php

namespace Tests\Feature\ResourceResponse;

use App\Models\Category;
use App\Models\Product;
use Database\Seeders\CategorySeeder;
use Database\Seeders\ProductSeeder;
use Tests\TestCase;

/** Resource Response
 * Di method toArray() terdapat parameter Request, yang artinya kita bisa mengambil informasi pada HTTP Request
   jika dibutuhkan
 * Resource juga memiliki method withResponse() yang bisa kita override untuk mengubah Http Response
*/

// penerapannya ada di ProductCollection

class ResourceResponseTest extends TestCase
{
    public function testResourceResponce()
    {
        $this->seed([CategorySeeder::class, ProductSeeder::class]);
        $products = Product::all();
        $response = $this->get('/api/products-response')
            ->assertSuccessful()
            ->assertHeader('X-Powered-By', 'juntralala');

        $names = $response->json('data.*.value.name');
        for ($i = 0; $i < 5; $i++) {
            self::assertContains("Product $i of Food", $names);
            self::assertContains("Product $i of Gadget", $names);
        }
    }
}