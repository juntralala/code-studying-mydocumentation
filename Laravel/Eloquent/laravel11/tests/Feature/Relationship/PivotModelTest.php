<?php

namespace Tests\Feature\Relationship;

use App\Models\Customer;
use Database\Seeders\CategorySeeder;
use Database\Seeders\CustomerSeeder;
use Database\Seeders\Product2Seeder;
use Database\Seeders\ProductSeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class PivotModelTest extends TestCase
{

    public function setUp(): void {
        parent::setUp();
        $this->seed([
            CustomerSeeder::class,
            CategorySeeder::class,
            ProductSeeder::class,
            Product2Seeder::class
        ]);

        Customer::find("UJUN")->likeProducts()->attach(1); // attach productId = memasangkan id produk (didalam attach() melakukan insert ke table customers_likes_products)
    }

    public function testPivotModel(): void
    {
        $customer = Customer::find("UJUN");
        $products = $customer->likeProducts;
         foreach($products as $product){
            $pivot = $product->pivot;
            self::assertNotNull($pivot);    
            
            $customer = $pivot->customer;
            self::assertNotNull($customer);    
            
            $product = $pivot->product; 
            self::assertNotNull($product);    
         }
    }
}
