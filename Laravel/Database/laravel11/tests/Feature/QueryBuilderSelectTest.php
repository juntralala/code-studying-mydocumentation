<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Log;
use Tests\TestCase;

class QueryBuilderSelectTest extends TestCase {

    public function setUp(): void {
        parent::setUp();
        DB::table('categories')->delete();
    }

    private function insertData(): void {
        DB::table('categories')->insert([
            'id' => "LAPTOP",
            'name' => 'Lapop'
        ]);
        DB::table('categories')->insert([
            'id' => "BOOK",
            'name' => 'Book'
        ]);
    }

    public function testSelect(): void {
        $this->insertData();

        $collection = DB::table('categories')->select(['id' ,'name'])->get();
        self::assertNotNull($collection);

        $collection->each(function($item){
            Log::info(json_encode($item));
        });
    }
}
