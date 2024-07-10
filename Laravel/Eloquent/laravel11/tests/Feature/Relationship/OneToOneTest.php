<?php

namespace Tests\Feature\Relationship;

use App\Models\Customer;
use App\Models\Wallet;
use Database\Seeders\CustomerSeeder;
use Database\Seeders\WalletSeeder;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class OneToOneTest extends TestCase
{
    public function testOneToOneFromProduct(): void
    {
        $this->seed([CustomerSeeder::class, WalletSeeder::class]);

        $customer = Customer::find("UJUN");
        self::assertNotNull($customer);

        // Wallet::where("customer_id", $cutomer->id)->first();
        $wallet = $customer->wallet;

        self::assertEquals(1_000_000, $wallet->amount);
    }

    public function testOneToOneFromWallet(): void
    {
        $this->seed([CustomerSeeder::class]);

        $wallet = new Wallet();
        $wallet->customer_id = "UJUN";
        $wallet->amount = 1_000_000;
        $wallet->save();
        self::assertNotNull($wallet->id);

        // Product::where("id", $wallet->customer_id)->first();
        $customer = $wallet->customer;

        self::assertEquals("UJUN", $customer->id);
    }
}
