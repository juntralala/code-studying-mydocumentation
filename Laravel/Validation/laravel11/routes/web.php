<?php

use App\Http\Controllers\LoginController;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

Route::addRoute(['POST'] ,'/login', [LoginController::class, 'login']);
Route::get('/login/form', [LoginController::class, 'form']);
Route::post('/login/form', [LoginController::class, 'submitForm']);