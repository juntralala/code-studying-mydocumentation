<?php

namespace Tests\Feature;

use App\Models\Category;
use App\Models\Product;
use Database\Seeders\CategorySeeder;
use Database\Seeders\Product2Seeder;
use Database\Seeders\ProductSeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\Log;
use Tests\TestCase;

class SerializationTest extends TestCase
{
    protected $logger;

    public function setUp(): void
    {
        parent::setUp();
        $this->logger = Log::build([
            'driver' => 'single',
            'path' => base_path('tests/Feature/.log'),
            'level' => env('LOG_LEVEL', 'debug'),
            'replace_placeholders' => true,
        ]);
    }

    public function testSerializeToJson(): void
    {
        $this->seed([CategorySeeder::class, ProductSeeder::class, Product2Seeder::class]);
        $products = Product::get();
        self::assertCount(2, $products);

        $json = $products->toJson(JSON_PRETTY_PRINT);

        $this->logger->info($json, ['class' => self::class]);
    }

    public function testSerializationRelation(): void
    {
        $this->seed([CategorySeeder::class, ProductSeeder::class, Product2Seeder::class]);
        $products = Product::get();
        $products->load('category');

        self::assertCount(2, $products);

        $json = $products->toJson(JSON_PRETTY_PRINT);
        $this->logger->info($json);
    }
}
