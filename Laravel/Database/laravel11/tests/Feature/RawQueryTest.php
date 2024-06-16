<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\DB;
use Tests\TestCase;

class RawQueryTest extends TestCase {
    protected function setUp(): void {
        parent::setUp();
        DB::delete("DELETE FROM categories");
    }

    public function testRawQuery(): void {
        DB::insert("INSERT INTO categories(id, name, description, created_at) VALUES (?, ?, ?, ?)", [
            "GAWAI", "Gawai", "Gawai Categories", '2004-05-20 00:00:00'
        ]);

        $result = DB::select("SELECT * FROM categories WHERE id=?", ["GAWAI"]);

        self::assertCount(1, $result);
        self::assertEquals("GAWAI", $result[0]->id);
        self::assertEquals("Gawai", $result[0]->name);
        self::assertEquals("Gawai Categories", $result[0]->description);
        self::assertEquals("2004-05-20 00:00:00", $result[0]->created_at);
    }

    public function testRawQueryNamedBindingParameter(): void {
        DB::insert("INSERT INTO categories(id, name, description, created_at) VALUES (:id, :name, :description, :created_at)", [
            'id' => "GAWAI",
            'name' => "Gawai",
            'description' => "Gawai Categories",
            'created_at' => '2004-05-20 00:00:00'
        ]);

        $result = DB::select("SELECT * FROM categories WHERE id=:id", ['id' => "GAWAI"]);

        self::assertCount(1, $result);
        self::assertEquals("GAWAI", $result[0]->id);
        self::assertEquals("Gawai", $result[0]->name);
        self::assertEquals("Gawai Categories", $result[0]->description);
        self::assertEquals("2004-05-20 00:00:00", $result[0]->created_at);
    }
}
