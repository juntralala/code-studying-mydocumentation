<?php

use App\Events\AlertEvent;
use Illuminate\Support\Facades\Route;
use Inertia\Inertia;

Route::get('/', function () {
    return Inertia::render('Welcome');
})->name('home');

Route::inertia('/alerts', 'Alert');

Route::get('/alerts/trigger', function() {
    $message = request()->input('message', 'Hello wrold');
    AlertEvent::dispatch($message);
    return "OK";
});
