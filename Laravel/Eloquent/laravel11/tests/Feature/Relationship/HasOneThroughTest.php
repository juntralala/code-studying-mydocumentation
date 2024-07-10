<?php

namespace Tests\Feature\Relationship;

use App\Models\Customer;
use Database\Seeders\CustomerSeeder;
use Database\Seeders\VirtualAcountSeeder;
use Database\Seeders\WalletSeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\DB;
use Tests\TestCase;

class HasOneThroughTest extends TestCase
{
    public function testHasOneThrough(): void
    {
        $this->seed([CustomerSeeder::class, WalletSeeder::class, VirtualAcountSeeder::class]);

        $customer = Customer::find("UJUN");
        self::assertNotNull($customer);

        $virtualAcount = $customer->vitualAcount;
        self::assertNotNull($virtualAcount);
        self::assertEquals("BCA", $virtualAcount->bank);
    }
}
