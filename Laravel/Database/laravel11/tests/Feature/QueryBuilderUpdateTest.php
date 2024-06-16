<?php

namespace Tests\Feature;

use Database\Seeders\CountersSeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Log;
use PHPUnit\Framework\Attributes\Depends;
use Tests\TestCase;

class QueryBuilderUpdateTest extends TestCase {

    protected function setUp(): void {
        parent::setUp();
        DB::table('categories')->delete();
    }

    public function insertSomeRecords(): void {
        DB::table('categories')
            ->insert(['id' => "SMARTPHONE", 'name' => 'Smartphone', 'created_at' => '2024-06-12 00:00:00']);
        DB::table('categories')
            ->insert(['id' => "FOOD", 'name' => 'Food', 'created_at' => '2024-06-12 00:00:00']);
        DB::table('categories')
            ->insert(['id' => "LAPTOP", 'name' => 'Laptop', 'created_at' => '2024-06-12 00:00:00']);
        DB::table('categories')
            ->insert(['id' => "FASHION", 'name' => 'Fashion', 'created_at' => '2024-06-12 00:00:00']);
    }

    public function testUpdate(): void {
        $this->insertSomeRecords();
        DB::table('categories')
            ->where('id', '=', 'SMARTPHONE')
            ->update(['name' => 'Handphone']);DB::table('');
        $collection = DB::table('categories')
            ->where('name', '=', 'Handphone')
            ->get();
        self::assertCount(1, $collection);
        $collection->each(function($item){
            Log::info(json_encode($item));
        });
    }

    public function testUpdateOrInsert(): void {
        $this->insertSomeRecords();
        DB::table('categories')
            ->updateOrInsert(
                [
                    'id' => "VOUCHER"
                ], [
                    'name' => 'Voucher',
                    'description' => 'Ticket and Voucher',
                    'created_at' => DB::raw('CURRENT_TIMESTAMP') // DB::raw() memungkinkan tidak di escape karena menghasilkan data yg dibungkus object dari Illuminate\Database\Query\Expression
                ]
            );

        $collection = DB::table('categories')->where('id', '=', 'VOUCHER')->get();
        self::assertCount(1, $collection);
        $collection->each(function($item){
            Log::info(json_encode($item));
        });
    }

    public function testIncrement(): void {
        $this->seed(CountersSeeder::class);

        DB::table('counters') 
            ->where('id', '=', 'sample')
            ->increment('counter', 1);          // <- melakukan increment
        $collection = DB::table('counters')
            ->where('id', '=', 'sample')
            ->get();
        self::assertCount(1, $collection);
        $data = $collection->first();
        Log::info(json_encode($data));
    }
}
