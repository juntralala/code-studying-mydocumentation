<?php

namespace Tests\Feature\NestedResource;

use App\Models\Category;
use Database\Seeders\CategorySeeder;
use Tests\TestCase;

/** Nested Resource
 * Saat kita menggunakan Resource, contoh pada Resource Collection, kita juga bisa menggunakan Resource lainnya
 * Secara default, method toArray() akan dikonversi menjadi JSON
 * Namun, kita bisa menggunakan Resource lain jika kita mau
 */

// php artisan make:resource CategorySimpleResource
// php artisan make:resource CategoryCollection

/*
Penerapan ada di CategorySimpleResource 
           dan di CategoryCollection
*/

// php artisan make:resource ProductReource

class NestedResourceTest extends TestCase
{
    public function testUnit()
    {
        $this->seed([CategorySeeder::class]);
        $categories = Category::all();

        $this->get("/api/nested/resource/categories")
            ->assertStatus(200)
            ->assertJson([
                'total' => 2,
                'data' => [
                    [
                        'id' => $categories[0]->id,
                        'name' => $categories[0]->name
                    ],
                    [
                        'id' => $categories[1]->id,
                        'name' => $categories[1]->name
                    ]
                ]
            ]);

    }
}