<?php

use App\Livewire\Counter;
use App\Livewire\ModelLive;
use App\Livewire\Data;
use App\Livewire\Submit;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});


Route::get('/counter', Counter::class); 
Route::get('/model-live', ModelLive::class); 
Route::get('/submit', Submit::class);
Route::get('/datas/{id}', Data::class);