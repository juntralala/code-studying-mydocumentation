<?php

namespace Tests\Feature\PolymorphicRelationship;

use App\Models\Comment;
use App\Models\Customer;
use App\Models\Product;
use App\Models\Voucher;
use Database\Seeders\CategorySeeder;
use Database\Seeders\CommentSeeder;
use Database\Seeders\ProductSeeder;
use Database\Seeders\VoucherSeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use PHPUnit\Framework\Attributes\TestDox;
use Tests\TestCase;

class OneToManyPolymorphicTest extends TestCase
{
    #[TestDox('create OneToManyPolymorphic relation from comments to products')]
    public function testOneToManyPolymorphicProduct(): void
    {
        $this->seed([
            VoucherSeeder::class,
            CategorySeeder::class,
            ProductSeeder::class,
            CommentSeeder::class
        ]);

        $product = Product::find('1');
        self::assertNotNull($product);

        $comments = $product->comments;
        self::assertNotNull($comments);

        foreach ($comments as $comment) {
            self::assertEquals('ujun@email.com', $comment->email);
            self::assertEquals('1', $comment->commentable_id);
        }
    }

    #[TestDox('create OneToManyPolymorphic relation from comments to vouchers')]
    public function testOneToManyPolymorphicVoucher(): void
    {
        $this->seed([
            VoucherSeeder::class,
            CategorySeeder::class,
            ProductSeeder::class,
            CommentSeeder::class
        ]);

        $voucher = Voucher::first();
        self::assertNotNull($voucher);

        $comments = $voucher->comments;
        self::assertNotNull($comments);

        foreach ($comments as $comment) {
            self::assertEquals('ozon@email.com', $comment->email);
            self::assertEquals($voucher->id, $comment->commentable_id);
        }
    }
}
