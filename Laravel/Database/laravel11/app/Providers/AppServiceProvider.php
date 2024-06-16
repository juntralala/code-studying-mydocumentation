<?php

namespace App\Providers;

use Illuminate\Database\Events\QueryExecuted;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Log;
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
        DB::listen(function(QueryExecuted $query){
            // Log::
            // Log::pushProcessor(fn($record)=> $record['extra']['ujun'] = 'ujun');
            Log::debug($query->sql);
        });
    }
}
