<?php

namespace Tests\Feature;

use Illuminate\Database\Query\Builder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Log;
use Tests\TestCase;

class QueryBuilderWhereTest extends TestCase {

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

    public function testWhere(): void {
        $this->insertSomeRecords();

        $collection = DB::table('categories')->where(function(Builder $builder){ // argumet fungsi berguna untuk meng-group operasi logika pada WHERE
            $builder->where("id", "=", "SMARTPHONE");
            $builder->orWhere("id", "=", "LAPTOP");
            // builded Query: SELECT * FROM categories WHERE (id='SMARTPHONE' OR id='LAPTOP'); 
        })->get();

        self::assertCount(2, $collection);
        $collection->each(function($item){
            Log::info(json_encode($item));
        });
    }

    public function testWhereBetween(): void {
        $this->insertSomeRecords();

        $collection = DB::table('categories')
            ->whereBetween('created_at', ["2024-06-11 23:59:59", "2024-06-12 00:00:01"]) 
            ->get(); // hasil query: SELECT * FROM categories WHERE created_at BETWEEN "2024-06-11 23:59:59" AND "2024-06-12 00:00:01"
        self::assertCount(4, $collection);
        $collection->each(function($item){
            Log::info(json_encode($item));
        });
    }

    public function testWhereIn(): void {
        $this->insertSomeRecords();

        $collection = DB::table('categories')
            ->whereIn('id', ['SMARTPHONE', 'LAPTOP'])
            ->get(); // Query hasil : SELECT * FROM categories WHERE id in ('SMARTPHONE', 'LAPTOP');

        self::assertCount(2, $collection);
        $collection->each(function($item){
            Log::info(json_encode($item));
        });
    }

    public function testWhereNull(): void {
        $this->insertSomeRecords();
        $collection = DB::table('categories')
            ->whereNull('description')
            ->get();
        self::assertCount(4, $collection);
        $collection->each(function($item){
            Log::info(json_encode($item));
        });
    }

    public function testWhereDate(): void {
        $this->insertSomeRecords();
        $collection = DB::table('categories')
            ->whereDate('created_at', "2024-06-12")
            ->get();
        self::assertCount(4, $collection);
        $collection->each(function($item){
            Log::info(json_encode($item));
        });
    }
}
