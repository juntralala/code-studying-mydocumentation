<?php

namespace Tests;

use Illuminate\Foundation\Testing\TestCase as BaseTestCase;
use Illuminate\Support\Facades\DB;

abstract class TestCase extends BaseTestCase
{
    protected function setUp(): void {
        parent::setUp();
        DB::delete("DELETE FROM taggables");
        DB::delete("DELETE FROM tags");
        DB::delete("DELETE FROM customers_likes_products");
        DB::delete("DELETE FROM images");
        DB::delete("DELETE FROM reviews");
        DB::delete("DELETE FROM products");
        DB::delete("DELETE FROM categories");
        DB::delete("DELETE FROM virtual_acounts");
        DB::delete("DELETE FROM wallets");
        DB::delete("DELETE FROM customers");
        DB::delete("DELETE FROM employees");
    }
}
