<?php

namespace Database\Seeders;

use App\Models\VirtualAcount;
use App\Models\Wallet;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class VirtualAcountSeeder extends Seeder
{

    public function run(): void
    {
        $wallet  = Wallet::query()->where('customer_id', "UJUN")->firstOrFail();

        $virtualAcount = new VirtualAcount();
        $virtualAcount->bank = "BCA";
        $virtualAcount->va_number = "112233445566";
        $virtualAcount->wallet_id = $wallet->id;
        $virtualAcount->save();
    }
}
