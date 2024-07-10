<?php

namespace Tests\Feature;

use App\Models\Voucher;
use Database\Seeders\VoucherSeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class SoftDeletesTest extends TestCase
{
    protected function setUp(): void {
        parent::setUp();
        Voucher::query()->forceDelete();
    }

    public function testSoftDeletes(): void
    {
        $this->seed(VoucherSeeder::class);

        $voucher = Voucher::where('name', '=', 'Voucher')->first();
        $voucher->delete();
        
        $voucher = Voucher::where('name', '=', 'Voucher')->first();
        self::assertNull($voucher);
    }

    public function testWithTrashed(): void
    {
        $this->seed(VoucherSeeder::class);
        $this->seed(VoucherSeeder::class);
        $this->seed(VoucherSeeder::class);

        $voucher = Voucher::where('name', '=', 'Voucher')->first();
        $voucher->delete();
        
        $voucher = Voucher::withTrashed()->where('name', '=', 'Voucher')->first();
        self::assertNotNull($voucher);
    }
}
