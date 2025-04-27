<?php

namespace App\Providers;

use App\Http\Guards\TokenGuard;
use Illuminate\Foundation\Application;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Blade;
use Illuminate\Support\ServiceProvider;

class AppServiceProvider extends ServiceProvider
{
    /**
     * Register any application services.
     */
    public function register(): void
    {
    }

    /**
     * Bootstrap any application services.
     */
    public function boot(): void
    {
        Auth::extend('token', function(Application $app, string $name, array $config){
            $guard = new TokenGuard(Auth::createUserProvider($config['provider']), $app->make(Request::class));
            // $app->refresh('request', $guard, 'setRequest'); // <- ini dilakukan Pake Eko tapi katanya tidak Claude AI diperlukan
            return $guard;
        });
    }
}
