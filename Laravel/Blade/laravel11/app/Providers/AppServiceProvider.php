<?php

namespace App\Providers;

use App\Models\Orang;
use Illuminate\Support\Facades\Blade;
use Illuminate\Support\ServiceProvider;

class AppServiceProvider extends ServiceProvider {
    /**
     * Register any application services.
     */
    public function register(): void {
    }

    /**
     * Bootstrap any application services.
     */
    public function boot(): void {
        Blade::directive("hello", fn($expression) => "<?='Hello ' . $expression?>");       

        Blade::stringable(Orang::class, fn(Orang $orang) => "$orang->nama : $orang->umur");
    }
}
