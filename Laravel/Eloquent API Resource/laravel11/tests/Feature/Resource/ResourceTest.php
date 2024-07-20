<?php

namespace Tests\Feature\Resource;

use App\Models\Category;
use Database\Seeders\CategorySeeder;
use Illuminate\Support\Carbon;
use Tests\TestCase;

/** Resource
 * Resource merupakan representasi dari cara melakukan transformasi dari Model menjadi Array / JSON yang kita
   inginkan
 * Untuk membuat Resource, kita bisa menggunakan perintah :
   > php artisan make:resource NamaResource
 * Class Resource adalah class turunan dari class JsonResource, dan kita perlu mengubah implementasi dari method
   toArray nya
*/

/** Cara kerja Resource
 * Resource adalah representasi dari single object data yang ingin kita transform menjadi Array / JSON
 * Semua data attribute di model, bisa kita akses menggunakan $this, hal ini karena Resource akan melakukan proxy
   call ke model yang sedang digunakan
 * Setelah resource dibuat, kita bisa kembalikan di Controller atau di Route, dan Laravel secara otomatis mengerti
  bahwa response ini berupa Resource
*/

// php artisan make:resource CategoryResource

/** Contoh penerapannya di
 * App\Http\Resources\CategoryResource
 * route\web.php url : /api/categories/id
 */

class ResourceTest extends TestCase
{
    public function testResource()
    {
        $this->seed([CategorySeeder::class]);
        $category = Category::first();

        $this->get("/api/categories/$category->id")
            ->assertStatus(200)
            ->assertJson([
                'category' => [                // untuk mengetahui cara mengganti nama wrapper nya disini baca '$wrap Attribute.txt'
                    'id' => $category->id,
                    'name' => $category->name,
                    'created_at' => $category->created_at->toJSON(),
                    'updated_at' => $category->updated_at->toJSON()
                ]
            ]);
    }
}