<?php

use App\Events\MessageEvent;
use Illuminate\Support\Facades\Route;
use Illuminate\Http\Request;

Route::get('/', function () {
    return view('welcome');
});

Route::view('/message', 'message');
Route::get('/message/trigger', function(Request $request) {
    $message = $request->input('message', "Hello world");
    MessageEvent::dispatch($message);
    return "OK";
});
