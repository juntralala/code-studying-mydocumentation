<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

Route::view('/hello', 'hello', ['name' => "UJUN"]);

Route::get('/html-encoding', function(Request $request){
    $name = $request->input("name");

    return view('html-encoding', [
        'name' => $name
    ]);
});

Route::view("/disabled", "disabled", ['name' => "ujun"]);
Route::get("/if-else-elseif-endif", function(Request $request){
    $hobbies = $request->input("hobbies") ?? [];
    return view("if-else-elseif-endif", [
        'hobbies' => $hobbies
    ]);
});

Route::view('/each', 'each-once', ['users' => [
    [
        'name' => 'ujun',
        'hobbies' => ["Coding", "Gaming"]
    ],
    [
        'name' => 'ozon',
        'hobbies' => ["Makan", "Rebahan"]
    ]
]]);

Route::view('/template-inheritance', 'inheritance.template.child');