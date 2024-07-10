<?php

namespace Tests\Feature\Relations;

use App\Models\Customer;
use App\Models\Product;
use Database\Seeders\CustomerSeeder;
use Database\Seeders\ImageSeeder;
use Database\Seeders\ProductSeeder;
use Database\Seeders\WalletSeeder;
use Illuminate\Database\Events\QueryExecuted;
use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Illuminate\Support\Facades\DB;
use Tests\TestCase;

class EagerLoadingTest extends TestCase
{
    protected $executedQueries;

    public function setUp(): void
    {
        parent::setUp();
        $this->executedQueries = "";
    }

    public function testLazyLoading(): void
    {
        $this->seed([CustomerSeeder::class, WalletSeeder::class, ImageSeeder::class]);
        DB::listen(function (QueryExecuted $query) {
            $this->executedQueries .= $query->sql . "\n";
        });

        $customer = Customer::find("UJUN"); // <- tidak langsung melakukan query ke table wallets dan images

        self::assertStringNotContainsString("select * from `images`", $this->executedQueries);

        $image = $customer->image;   // melakukan query ke table images

        self::assertStringContainsString("select * from `images`", $this->executedQueries);
    }

    public function testEagerLoadingInQueryBuilder(): void
    {
        $this->seed([CustomerSeeder::class, WalletSeeder::class, ImageSeeder::class]);
        DB::listen(function (QueryExecuted $query) {
            $this->executedQueries .= $query->sql . "\n";
        });

        // nama relasinya berdasarkan deklarasi nama method relasinya
        $customer = Customer::with(['image'])->find("UJUN"); // langsung melakukan query ke table images

        self::assertStringContainsString('select * from `images`', $this->executedQueries);
    }

    public function testEagerLoadingInModel(): void
    {
        $this->seed([CustomerSeeder::class, WalletSeeder::class, ImageSeeder::class]);
        DB::listen(function (QueryExecuted $query) {
            $this->executedQueries .= $query->sql . "\n";
        });

        // pada property $with telah ditambahkan relasi 'wallet'
        $customer = Customer::find("UJUN"); // langsung melakukan query ke table wallets

        self::assertStringContainsString('select * from `wallets`', $this->executedQueries);
    }

}
