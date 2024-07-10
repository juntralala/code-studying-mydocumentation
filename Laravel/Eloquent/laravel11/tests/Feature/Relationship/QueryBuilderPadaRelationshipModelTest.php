<?php

namespace Tests\Feature\Relationship;

use App\Models\Category;
use App\Models\Customer;
use App\Models\Product;
use App\Models\Wallet;
use Database\Seeders\CategorySeeder;
use Database\Seeders\ProductSeeder;
use Database\Seeders\WalletSeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\DB;
use Tests\TestCase;

class QueryBuilderPadaRelationshipModelTest extends TestCase
{
    public function testOneToOneInsert(): void
    {
        // $this->seed(CustomerSeeder::class); // cara 1
        // $customer = Customer::find("UJUN");
        // self::assertNotNull($customer);  

        $customer = new Customer();  // cara 2
        $customer->id = "OZON";
        $customer->name = "Ozon";
        $customer->email = "ozon@email.com";
        $customer->save();


        $wallet = new Wallet();
        $wallet->amount = 10_000_000;
        $customer->wallet()->save($wallet);
        // customer_id nya terisi otomatis
        self::assertNotNull($wallet->customer_id);
    }

    public function testOneToManyInsert(): void
    {
        $category = new Category();
        $category->id = "FOOD";
        $category->name = "Food";
        $category->description = "Food Category";
        $category->is_active = true;
        $category->save();

        $product = new Product();
        $product->id = '1';
        $product->name = 'Product 1';
        $product->description = 'Product 1 Description';
        $product->price = 10_000;
        $product->stock = 25;
        // category_id nya terisi otomatis
        $category->products()->save($product);

        self::assertNotNull($product->category_id);
    }

    public function testSearchProductOnCategoryModel(): void
    {
        $this->seed([CategorySeeder::class, ProductSeeder::class]);

        $category = Category::find("FOOD");
        $products = $category->products;
        self::assertCount(1, $products);

        $outOfStockProducts = $category->products()->where('stock', '<=', '0')->get();

        self::assertCount(1, $outOfStockProducts);
    }
}
