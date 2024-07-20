<?php

use App\Http\Resources\CategoryCollection;
use App\Http\Resources\CategoryResource;
use App\Http\Resources\CategoryResourceCollection;
use App\Http\Resources\ProductCollection;
use App\Http\Resources\ProductDebugResource;
use App\Http\Resources\ProductResource;
use App\Http\Resources\ProductResourceCollection;
use App\Models\Category;
use App\Models\Product;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

Route::get('/user', function (Request $request) {
    return $request->user();
})->middleware('auth:sanctum');

// url route disini secara otomatis memiliki prefix /api
// contoh : /api/user ketika memanggil route /user diatas

Route::get("/categories/{id}", function ($id) {
    $category = Category::findOrFail($id);
    return new CategoryResource($category);
});

Route::get('/categories', function () {
    $categories = Category::all();
    // CategoryResource::collection(collect())::wrap('categories'); // mengganti wrap dari hasil ::collection()
    return CategoryResource::collection($categories);
});

Route::get('/categories-custom', function () {
    $categories = Category::all();
    return new CategoryResourceCollection($categories);
});

Route::get('/nested/resource/categories', function () {
    $categories = Category::all();
    return new CategoryCollection($categories);
});

Route::get('/products/{id}', function ($id) {
    $product = Product::find($id);
    $product = $product->load('category');      // <- penjelasan: Conditional Attributes 
    return new ProductResource($product);
});

Route::get('/products', function () {
    $product = Product::all();
    return new ProductResourceCollection($product);
});

Route::get('/products-paging', function (Request $request) {
    $page = $request->integer('page', 1);
    $products = Product::paginate(perPage: 2, page: $page);
    return new ProductResourceCollection($products);
});

Route::get('/products-debug/{id}', function($id){
    $product = Product::find($id);
    return new ProductDebugResource($product);
});

Route::get('/products-response', function(){
    $products = Product::all();
    return new ProductCollection($products);
});

Route::get('/products-response-method', function(){
    $products = Product::all();
    return (new ProductCollection($products))
        ->response()
        ->header('X-Authored-By', 'juntralala');
});