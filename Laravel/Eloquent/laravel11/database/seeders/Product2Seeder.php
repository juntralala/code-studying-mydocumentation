<?php

namespace Database\Seeders;

use App\Models\Product;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class Product2Seeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $product = new Product();
        $product->id = '2';
        $product->name = 'Product 2';
        $product->description = 'Description 2';
        $product->category_id = 'FOOD';
        $product->price = 200;
        $product->save();
    }
}
