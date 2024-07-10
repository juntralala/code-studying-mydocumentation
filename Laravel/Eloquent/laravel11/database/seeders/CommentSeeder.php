<?php

namespace Database\Seeders;

use App\Models\Comment;
use App\Models\Product;
use App\Models\Voucher;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class CommentSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $this->createCommentForProduct();
        $this->createCommentForVoucher();
    }

    private function createCommentForProduct(): void 
    {
        $product = Product::find('1');
        $comment = new Comment();
        $comment->email = 'ujun@email.com';
        $comment->title = 'Title';
        $comment->comment = 'Comment Product';
        $comment->commentable_id = $product->id;
        $comment->commentable_type = 'product';

        $comment->save();
    }

    private function createCommentForVoucher(): void 
    {
        $voucher = Voucher::first();
        $comment = new Comment();
        $comment->email = 'ozon@email.com';
        $comment->title = 'Title';
        $comment->comment = 'Comment Voucher';
        $comment->commentable_id = $voucher->id;
        $comment->commentable_type = 'voucher';

        $comment->save();
    }
}
