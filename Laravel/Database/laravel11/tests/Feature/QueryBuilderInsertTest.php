<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\DB;
use PHPUnit\Framework\Attributes\Before;
use Tests\TestCase;

class QueryBuilderInsertTest extends TestCase {

    protected function setUp(): void {
        parent::setUp();
        DB::delete("DELETE FROM categories");
    }

    public function testInsert(): void {
        $builder = DB::table("categories");
        $builder->insert([
            'id' => "GADGET",
            'name' => "Gadget"
            ]);
            
            DB::table('categories')->insert([
                'id' => "FOOD",
                'name' => "Food"
        ]);

        $result = DB::select("SELECT COUNT(*) AS total FROM categories");
        self::assertEquals(2, $result[0]->total);
    }
}
