<?php

namespace Tests\Feature\DataWrapCollection;

use Database\Seeders\CategorySeeder;
use Database\Seeders\ProductSeeder;
use Tests\TestCase;

/** Data Wrap
 * Khusus untuk mengubah attribute $wrap untuk Collection, kita tidak bisa menggunakan NamaResource::collection(),
   hal ini karena kode tersebut sebenarnya akan membuat object AnonymousResourceCollection, bukan menggunakan 
   Resource yang kita buat
 * https://laravel.com/api/10.x/Illuminate/Http/Resources/Json/AnonymousResourceCollection.html 
 * Jika hasil result JSON di ResourceCollection.toArray() mengandung attribute yang terdapat di $wrap, maka Laravel
   tidak akan melakukan wrap, namun jika tidak ada, maka akan melakukan wrap
*/

/** $wrap bisa diubah untuk collection (trik ku sendiri)
 * lihat App\Http\Resources\CategoryResource::collection()
 */


class DataWrapCollectionTest extends TestCase
{
    public function testDataWrapCollection()
    {
        $this->seed([CategorySeeder::class, ProductSeeder::class]);
        $response = $this->get('/api/products')
            ->assertStatus(200);

        $porductNames = $response->json('data.*.value.name');
        for($i = 0 ; $i < 5 ; $i++){
            self::assertContains("Product $i of Food", $porductNames);
            self::assertContains("Product $i of Gadget", $porductNames);
        }
    }
}