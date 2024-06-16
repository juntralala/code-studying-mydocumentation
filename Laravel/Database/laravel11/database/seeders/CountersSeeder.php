<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class CountersSeeder extends Seeder {
    public function run(): void {
        DB::table('counters')->updateOrInsert(['id' => 'sample'], ['counter' => 0, 'description' => "Pnegujian Increment"]);
    }
}
