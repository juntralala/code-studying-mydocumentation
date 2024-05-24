<?php

namespace App\Providers;

use App\Data\Bar;
use App\Data\Foo;
use App\Services\HelloService;
use App\Services\HelloServiceIndonesia;
use Illuminate\Contracts\Support\DeferrableProvider;
use Illuminate\Support\ServiceProvider;

class FooBarServiceProvider extends ServiceProvider implements DeferrableProvider
{
    public $singletons = [
        HelloService::class => HelloServiceIndonesia::class
    ];

    public function register(): void
    {
        echo "<h1>FooBarServiceProvider</h1>" . PHP_EOL;
        $this->app->singleton(Foo::class, function() {
            return new Foo();
        });
        $this->app->singleton(Bar::class, function($app){
            return new Bar($app->make(Foo::class));
        });
    }

    /** 
     * Bootstrap services.
     */
    public function boot(): void
    {
        //
    }

    public function provides(): array {
        return [
            Foo::class,
            Bar::class
        ];
    } 
}
