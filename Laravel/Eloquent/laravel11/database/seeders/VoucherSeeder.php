<?php

namespace Database\Seeders;

use App\Models\Voucher;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class VoucherSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $voucher = new Voucher(); // kolom id dan voucher_code digerate otomatis menggunakan UUID
        $voucher->name = "Voucher"; 
        $voucher->save();
    }
}
