<?php

namespace App\Providers;

use App\Services\HelloService;
use App\Services\HelloServiceIndonesia;
use Illuminate\Contracts\Support\DeferrableProvider;
use Illuminate\Support\ServiceProvider;

class HelloServiceProvider extends ServiceProvider implements DeferrableProvider
{
    /**
     * Register services.
     */
    public function register(): void
    {
        $this->app->bind(HelloService::class, HelloServiceIndonesia::class);
    }

    /**
     * Bootstrap services.
     */
    public function boot(): void
    {
        
    }

    public function provides(): array {
        return [
            HelloService::class
        ];
    }
}
