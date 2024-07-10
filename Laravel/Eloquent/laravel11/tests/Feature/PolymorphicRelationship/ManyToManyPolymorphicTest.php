<?php

namespace Tests\Feature\PolymorphicRelationship;

use App\Models\Category;
use App\Models\Product;
use Database\Seeders\CategorySeeder;
use Database\Seeders\ProductSeeder;
use Database\Seeders\TagSeeder;
use Database\Seeders\VoucherSeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use PHPUnit\Framework\Attributes\DoesNotPerformAssertions;
use PHPUnit\Framework\Attributes\TestDox;
use Tests\TestCase;

class ManyToManyPolymorphicTest extends TestCase
{
    #[DoesNotPerformAssertions]
    public function testMenampilkanParameterMethodMorphToMany()
    {
        $this->seed([
            CategorySeeder::class,
            ProductSeeder::class
        ]);

        $product = Product::find("1");

        var_dump($product->tags()->getRelated()::class);
        var_dump($product->tags()->getForeignPivotKeyName()); // kolom ngerefrences ke id Product
        var_dump($product->tags()->getRelatedPivotKeyName()); // kolom ngerefrences ke id Tag
        var_dump($product->tags()->getParentKeyName()); // kolom primary di Product
        var_dump($product->tags()->getRelatedKeyName());// kolom primary di Tag
        var_dump($product->tags()->getRelationName()); // nama relasi
    }

    public function testManyToManyPolymorphic(): void
    {
        $this->seed([
            CategorySeeder::class,
            ProductSeeder::class,
            VoucherSeeder::class,
            TagSeeder::class
        ]);

        $product = Product::find('1');
        $productTags = $product->tags;
        self::assertNotNull($productTags); 
        self::assertCount(1, $productTags); 

        $productTags->each(function($tag){
            self::assertNotNull($tag->id);
            self::assertNotNull($tag->name);

            $vouchers = $tag->vouchers;
            self::assertNotNull($vouchers);
        });
    }
}
