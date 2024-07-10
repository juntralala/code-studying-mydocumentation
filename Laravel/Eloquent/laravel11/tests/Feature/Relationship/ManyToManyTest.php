<?php

namespace Tests\Feature\Relationship;

use App\Models\Customer;
use Database\Seeders\CategorySeeder;
use Database\Seeders\CustomerSeeder;
use Database\Seeders\Product2Seeder;
use Database\Seeders\ProductSeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use PHPUnit\Framework\Attributes\DoesNotPerformAssertions;
use PHPUnit\Framework\Attributes\TestDox;
use Tests\TestCase;

class ManyToManyTest extends TestCase
{
    #[DoesNotPerformAssertions]
    public function testInsertManyToMany(): void
    {
        $this->seed([
            CustomerSeeder::class,
            CategorySeeder::class,
            ProductSeeder::class,
            Product2Seeder::class
        ]);
        $customer = Customer::find("UJUN");
        $customer->likeProducts()->attach('1'); // attach productId = memasangkan id produk (didalam attach() melakukan insert ke table customers_likes_products)
    }

    public function testQueryManyToMany(): void 
    {
        $this->testInsertManyToMany();

        $customer = Customer::query()->find("UJUN");
        $products = $customer->likeProducts;

        self::assertNotNull($products);
        self::assertCount(1, $products);
        self::assertEquals('1', $products[0]->id);
        self::assertEquals('Product 1', $products[0]->name);
    }

    public function testRemoveManyToMany(): void 
    {
        $this->testInsertManyToMany();

        $customer = Customer::find("UJUN");
        $customer->likeProducts()->detach('1');

        $products = $customer->likeProducts;

        self::assertNotNull($products);
        self::assertCount(0, $products);
    }

    public function testPivotAttribute(): void {
        $this->testInsertManyToMany();

        $customer = Customer::find('UJUN');
        $products = $customer->likeProducts;
        foreach($products as $product) {
            $pivot = $product->pivot;
            print($pivot::class);
            $this->assertNotNull($pivot);
            $this->assertNotNull($pivot->created_at);
            $this->assertNotNull($pivot->customer_id);
            $this->assertNotNull($pivot->product_id);
        }
    }

    #[TestDox("Pivot Atribute With Condition")]
    public function testFilteringViaPivotAttribute(): void {
        $this->testInsertManyToMany();

        $customer = Customer::find('UJUN');
        $products = $customer->likeProductsLastWeek;
        foreach($products as $product) {
            $pivot = $product->pivot;
            $this->assertNotNull($pivot);
            $this->assertNotNull($pivot->created_at);
            $this->assertNotNull($pivot->customer_id);
            $this->assertNotNull($pivot->product_id);
        }
    }
}
