<?php

namespace App\Providers;
use App\Services\SayHello;
use Illuminate\Support\ServiceProvider;

class SayHelloProvider extends ServiceProvider {
    public function register(): void {
        $this->app->singleton(SayHello::class, fn() => new SayHello());
    }
}