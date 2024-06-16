<?php

namespace Tests\Feature;

use Illuminate\Database\QueryException;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\DB;
use Tests\TestCase;

class TransactionTest extends TestCase {

    public function setUp(): void {
        parent::setUp();
        DB::delete("DELETE FROM categories");
    }

    public function testTransactionSuccess(): void { 
        DB::transaction(function(){
            DB::insert("INSERT INTO categories(id, name, description, created_at) VALUES (?, ?, ?, ?)", [
                'GAWAI', 'Gawai', 'Gawai Category', '2024-06-12 00:00:00'
            ]);
            DB::insert("INSERT INTO categories(id, name, description, created_at) VALUES (?, ?, ?, ?)", [
                'BOOK', 'Book', 'Book Category', '2024-06-12 00:00:00'
            ]); 
        });

        $result = DB::select("SELECT * FROM categories");
        self::assertCount(2, $result);
    }

    public function testTransactionFailed(): void { 
        try{
            DB::transaction(function(){
                DB::insert("INSERT INTO categories(id, name, description, created_at) VALUES (?, ?, ?, ?)", [
                    'GAWAI', 'Gawai', 'Gawai Category', '2024-06-12 00:00:00'
                ]);
                DB::insert("INSERT INTO categories(id, name, description, created_at) VALUES (?, ?, ?, ?)", [
                    'GAWAI', 'Book', 'Book Category', '2024-06-12 00:00:00'
                ]); // kita pakai id yg duplicate
            });
        } catch(QueryException $e){

        }

        $result = DB::select("SELECT * FROM categories");
        self::assertCount(0, $result);
    }

    public function testManualTransactionSuccess(): void { 
        try{
            DB::beginTransaction();
            DB::insert("INSERT INTO categories(id, name, description, created_at) VALUES (?, ?, ?, ?)", [
                'GAWAI', 'Gawai', 'Gawai Category', '2024-06-12 00:00:00'
            ]);
            DB::insert("INSERT INTO categories(id, name, description, created_at) VALUES (?, ?, ?, ?)", [
                'BOOK', 'Book', 'Book Category', '2024-06-12 00:00:00'
            ]); 
            DB::commit();
        } catch(QueryException $e) {
            DB::rollBack();
        }

        $result = DB::select("SELECT * FROM categories");
        self::assertCount(2, $result);
    }

    public function testManualTransactionFailed(): void { 
        try{
            DB::beginTransaction();
            DB::insert("INSERT INTO categories(id, name, description, created_at) VALUES (?, ?, ?, ?)", [
                'GAWAI', 'Gawai', 'Gawai Category', '2024-06-12 00:00:00'
            ]);
            DB::insert("INSERT INTO categories(id, name, description, created_at) VALUES (?, ?, ?, ?)", [
                'GAWAI', 'Book', 'Book Category', '2024-06-12 00:00:00'
            ]); // duplicate id menyebabkan error
            DB::commit();
        } catch(QueryException $e) {
            DB::rollBack();
        }

        $result = DB::select("SELECT * FROM categories");
        self::assertCount(0, $result);
    }
}
