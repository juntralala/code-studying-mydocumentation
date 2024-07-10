<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('virtual_acounts', function (Blueprint $table) {
            $table->integerIncrements('id')->nullable(false);
            $table->string('bank', 100)->nullable(false);
            $table->string('va_number', 100)->nullable(false);
            $table->integer('wallet_id')->nullable(false)->unsigned();
            $table->foreign('wallet_id')->on('wallets')->references('id');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('virtual_acounts');
    }
};
