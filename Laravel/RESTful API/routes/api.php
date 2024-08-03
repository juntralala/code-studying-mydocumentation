<?php

use App\Http\Controllers\AddressController;
use App\Http\Controllers\ContactController;
use App\Http\Controllers\UserController;
use App\Http\Middleware\ApiAuthMiddleware;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

// Route::get('/user', function (Request $request) {
//     return $request->user();
// })->middleware('auth:sanctum');

Route::prefix('/users')->group(function () {
    Route::post('/', [UserController::class, 'register']);
    Route::post('/login', [UserController::class, 'login']);
    Route::middleware(ApiAuthMiddleware::class)->group(function () {
        Route::get('/current', [UserController::class, 'get']);
        Route::patch('/current', [UserController::class, 'update']);
        Route::delete('/logout', [UserController::class, 'logout']);
    });
});

Route::prefix('/contacts')->middleware(ApiAuthMiddleware::class)->group(function () {
    Route::post('/', [ContactController::class, 'create']);
    Route::get('/', [ContactController::class, 'search']);
    Route::get('/{contactId}', [ContactController::class, 'get']);
    Route::patch('/{contactId}', [ContactController::class, 'update'])->where('contactId', '^[0-9]+$');
    Route::delete('/{contactId}', [ContactController::class, 'delete'])->where('contactId', '^[0-9]+$');
});

Route::prefix('/contacts/{contactId}/addresses')->middleware(ApiAuthMiddleware::class)->group(function () {
    Route::post('/', [AddressController::class, 'create']);
    Route::get('/', [AddressController::class, 'list']);
    Route::get('/{addressId}', [AddressController::class, 'get'])->where('addressId', '^[0-9]+$');
    Route::patch('/{addressId}', [AddressController::class, 'update'])->where('addressId', '^[0-9]+$');
    Route::delete('/{addressId}', [AddressController::class, 'delete'])->where('addressId', '^[0-9]+$');
})->where(['contactId' => '^[0-9]+$']);