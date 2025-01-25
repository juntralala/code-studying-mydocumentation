<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

Route::get('set-cookie', function(Request $request){
    return response("set cookie")
        ->withCookie('ujun', 'ujun', 10000, '/');
});

Route::get('get-cookie', function(Request $request){
    return response()->json($request->cookie());
});
