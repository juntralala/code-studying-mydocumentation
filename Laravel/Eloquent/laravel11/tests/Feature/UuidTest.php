<?php

namespace Tests\Feature;

use App\Models\Voucher;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use PHPUnit\Framework\Attributes\TestDox;
use Tests\TestCase;

class UuidTest extends TestCase 
{
    protected function setUp(): void
    {
        parent::setUp();
        Voucher::query()->forceDelete();
    }

    #[TestDox("test untuk pembuatan UUID")]
    public function testCreateUuid(): void
    {
        $voucher = new Voucher();
        $voucher->name = "Sample Voucher";
        $voucher->voucher_code = "V0001";
        $voucher->save();

        self::assertNotNull($voucher->id);
    }

    #[TestDox("test untuk pembuatan UUID pada selain Primary Key")]
    public function testCreateUuidOtherPrimariKey(): void
    {
        $voucher = new Voucher();
        $voucher->name = "Sample Voucher";
        $voucher->save();

        self::assertNotNull($voucher->id);
        self::assertNotNull($voucher->voucher_code);
    }
}
