<?php

namespace Database\Seeders;

use App\Models\Review;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class ReviewSeeder extends Seeder
{
    public function run(): void
    {
        $review = new Review();
        $review->product_id = '1';
        $review->customer_id = 'UJUN';
        $review->rating = 5;
        $review->comment = "Sangat Bagus";
        $review->save();


        $review = new Review();
        $review->product_id = '2';
        $review->customer_id = 'UJUN';
        $review->rating = 3;
        $review->comment = "Lumayan";
        $review->save();
    }
}
