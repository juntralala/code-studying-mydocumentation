<?php

namespace Database\Seeders;

use App\Models\Customer;
use App\Models\Image;
use App\Models\Product;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class ImageSeeder extends Seeder
{
    public function run(): void
    {
        {
            $image = new Image();
            $image->url = 'https://www.ujun.com/images/gambar1.jpg';
            $image->imageable_id = 'UJUN';
            // $image->imageable_type = Customer::class;
            $image->imageable_type = 'customer';
            $image->save();
        }
        {
            $image = new Image();
            $image->url = 'https://www.ujun.com/images/gambar2.jpg';
            $image->imageable_id = '1';
            // $image->imageable_type = Product::class;
            $image->imageable_type = 'product';
            $image->save();
        }
    }
}
