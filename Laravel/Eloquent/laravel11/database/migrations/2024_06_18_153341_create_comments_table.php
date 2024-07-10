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
        Schema::create('comments', function (Blueprint $table) {
            // $table->id();
            // $table->bigInteger('id')->autoIncrement();  // <-proses sebenarnya yg terjadu ketika memanggil $table->id()
            $table->integer('id')->autoIncrement();     // jika kita menggunakan method autoIncrement(), secara otomatis dia jadi Primary Key
            $table->string('email', 100)->nullable(false);
            $table->string('title', 200)->nullable(false);
            $table->text('comment')->nullable(true);
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('comments');
    }
};
