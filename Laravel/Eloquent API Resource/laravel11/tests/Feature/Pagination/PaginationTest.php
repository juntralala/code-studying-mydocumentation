<?php

namespace Tests\Feature\Pagination;

use App\Models\Category;
use Database\Seeders\CategorySeeder;
use Database\Seeders\ProductSeeder;
use Tests\TestCase;

/** PaginationTest
 * Jika kita mengirim data Pagination ke dalam Resource Collection, secara otomatis Laravel akan menambahkan
    informasi link dan juga meta (paging) secara otomatis
 * Attribute links berisi informasi link menuju page sebelum dan setelahnya
 * Attribute meta berisi informasi paging
*/

class PaginationTest extends TestCase {
    public function testPagination()
    {
        $this->seed([CategorySeeder::class, ProductSeeder::class]);
        $response = $this->get('/api/products-paging')
            ->assertStatus(200);

        self::assertNotNull($response->json('links'));
        self::assertNotNull($response->json('meta'));
        self::assertNotNull($response->json('data'));
    }
}