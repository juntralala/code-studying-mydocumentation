<?php

namespace Tests\Feature\PolymorphicRelationship;

use App\Models\Product;
use Database\Seeders\CategorySeeder;
use Database\Seeders\CommentSeeder;
use Database\Seeders\ProductSeeder;
use Database\Seeders\VoucherSeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class OneOfManyPolymorphicTest extends TestCase
{
    public function testOneOfManyPolymorphic(): void
    {
        $this->seed([
            CategorySeeder::class,
            ProductSeeder::class,
            VoucherSeeder::class,
            CommentSeeder::class,
        ]);

        $product = Product::first();
        self::assertNotNull($product);

        $latestComment = $product->latestComment();
        self::assertNotNull($latestComment);

        $oldestComment = $product->oldestComment();
        self::assertNotNull($oldestComment);
    }
}
