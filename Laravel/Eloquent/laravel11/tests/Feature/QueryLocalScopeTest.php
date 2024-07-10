<?php

namespace Tests\Feature;

use App\Models\Voucher;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class QueryLocalScopeTest extends TestCase
{
    public function setUp(): void {
        parent::setUp();
        Voucher::query()->delete();
    }

    public function testQueryLocalScope(): void
    {
        $voucher = new Voucher();
        $voucher->name = "Voucher Sample";
        $voucher->is_active = true;
        $voucher->save();

        $total = Voucher::isActive()->count();
        self::assertEquals(1, $total);

        $total = Voucher::isNonActive()->count();
        self::assertEquals(0, $total);
    }
}
