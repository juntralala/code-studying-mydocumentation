<?php

use App\Exceptions\ValidationException;
use App\Http\Controllers\CookieController;
use App\Http\Controllers\FileController;
use App\Http\Controllers\FilterRequestInputController;
use App\Http\Controllers\FormController;
use App\Http\Controllers\HelloController;
use App\Http\Controllers\InputController;
use App\Http\Controllers\InputTypeController;
use App\Http\Controllers\RedirectController;
use App\Http\Controllers\ResponseController;
use App\Http\Controllers\SessionController;
use App\Http\Middleware\VerifyCsrfToken;
use Illuminate\Support\Facades\Route;
use PHPUnit\Event\Code\Throwable;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/ujun', function() {
    return "<h1>Hello UJUN-Al-Rantaui</h1>";
});

Route::redirect('/youtube', '/ujun');

Route::view('/hello', 'hello', ['name' => "Ujun"]);

Route::get('/hello-again', function(){
    return view("hello", ['name'=> "ujun"]);
});

Route::fallback(function(){
    return '<h1>404 by UJUN-Al-Rantaui</h1>';
});

Route::get("/hello/world", function () {
    return view("hello.world");
});

Route::get("/products/{id}", function($productId){
    return "<h1>Product : $productId</h1>";
})->name("product.detail");

Route::get("/products/{id}/items/{item}", function($productId, $itemId){
    return "<h1>Product : $productId , Item : $itemId</h1>";
})->name("product.item.detail ");

Route::get("/categories/{id}", function($categoriesId){
    return "<h1>Category : $categoriesId</h1>";
})->where('id', "[0-9]+");

Route::get("/categories/{id}/status/{status}", function($categoryId, $categoryStatus){
    return "<h1>Category : $categoryId , Status : $categoryStatus</h1>";
})->setWheres([
    'id' => "[0-9]+",
    'status' => "[a-z]+"
]);

Route::get("/users/{id?}", function($userId = "404"){
    return "<h1>User : $userId</h1>";
});

Route::get("/conflict/{name}", function($name) {
    return "Conflict : $name";
});

Route::get("/conflict/ujun", function(){
    return "Conflict : Muhammad Junaidi";
});

Route::get(('produk/{id}'), function($id) {
    $link = route('product.detail', ['id' => $id]);
    return "Link $link";
});

Route::get('produk-redirect/{id}', function ($id) {
    return redirect()->route('product.detail', ['id' => $id]);
});

Route::get('/hello/request', [HelloController::class, 'request']);
Route::get('/hello/{name}', [HelloController::class, 'hello']);
Route::get('/input/hello', [InputController::class, "hello"])->withoutMiddleware([\Illuminate\Foundation\Http\Middleware\VerifyCsrfToken::class]);
Route::post('/input/hello', [InputController::class, "hello"])->withoutMiddleware([\Illuminate\Foundation\Http\Middleware\VerifyCsrfToken::class]);
Route::get('/input/hello/first-last', [InputController::class, "helloFirstLast"])->withoutMiddleware([\Illuminate\Foundation\Http\Middleware\VerifyCsrfToken::class]);
Route::post('/input/hello/first-last', [InputController::class, "helloFirstLast"])->withoutMiddleware([\Illuminate\Foundation\Http\Middleware\VerifyCsrfToken::class]);
Route::post('/input/hello/input', [InputController::class, "helloInput"])->withoutMiddleware([\Illuminate\Foundation\Http\Middleware\VerifyCsrfToken::class]);
Route::post('/input/hello/array', [InputController::class, "helloArray"])->withoutMiddleware([\Illuminate\Foundation\Http\Middleware\VerifyCsrfToken::class]);
Route::get('/input/hello/dynamic-properties', [InputController::class, "helloDynamicProperties"]);
Route::post('/input-type/input-type', [InputTypeController::class, 'inputType'])->withoutMiddleware([\Illuminate\Foundation\Http\Middleware\VerifyCsrfToken::class]);
Route::post('/filter/only', [FilterRequestInputController::class, 'filterOnly'])->withoutMiddleware([\Illuminate\Foundation\Http\Middleware\VerifyCsrfToken::class]);
Route::post('/filter/except', [FilterRequestInputController::class, 'filterExcept'])->withoutMiddleware([\Illuminate\Foundation\Http\Middleware\VerifyCsrfToken::class]);
Route::post('/filter/merge', [FilterRequestInputController::class, 'mergeInput'])->withoutMiddleware([\Illuminate\Foundation\Http\Middleware\VerifyCsrfToken::class]);
Route::post('/file/upload', [FileController::class, 'upload'])->withoutMiddleware([\Illuminate\Foundation\Http\Middleware\VerifyCsrfToken::class]);
Route::get('/response/hello', [ResponseController::class, 'response']);
Route::get('/response/hello/{name}', [ResponseController::class, 'hello']);
Route::get('/response/header', [ResponseController::class, 'header']);
Route::get('/response/type/view', [ResponseController::class, 'responseView']);
Route::get('/response/type/json', [ResponseController::class, 'responseJson']);
Route::get('/response/type/file', [ResponseController::class, 'responseFile']);
Route::get('/response/type/download', [ResponseController::class, 'responseDownload']);
Route::get('/cookie/set', [CookieController::class, 'createCookie']);
Route::get('/cookie/get', [CookieController::class, 'getCookie']);
Route::get('/cookie/clear', [CookieController::class, 'clearCookie']);
Route::get('/redirect/from', [RedirectController::class, 'redirectFrom']);
Route::get('/redirect/to', [RedirectController::class, 'redirectTo']);

Route::get("/redirect/name", [RedirectController::class, 'redirectName']);
Route::get("/redirect/name/{name}", [RedirectController::class, 'redirectHello'])->name("redirect-hello");
Route::get("/redirect/action", [RedirectController::class, 'redirectAction']);
Route::get("/redirect/away", [RedirectController::class, 'redirectAway']);

Route::get('/middleware/api', function(){
    return "OK";
})->middleware("contoh:UJUN,401"); // menggunakan alias dari middleware
// ->middlware(App\Http\Middleware\ContohMiddleware::class);  menggunakan class midlewarenya langsung

Route::get('/middleware/group', function(){
    return "OK Group";
})->middleware("UJUN"); // menggunakan nama group dari kumpulan middleware

Route::get('/form', [FormController::class, 'form']);
Route::post('/form', [FormController::class, 'submitForm']);

Route::prefix('group/route/response')->group(function() {  // semua route didalam group sini hasil copy yg diatas
    Route::get('/hello', [ResponseController::class, 'response']);
    Route::get('/hello/{name}', [ResponseController::class, 'hello']);
    Route::get('/header', [ResponseController::class, 'header']);
    Route::get('/type/view', [ResponseController::class, 'responseView']);
    Route::get('/type/json', [ResponseController::class, 'responseJson']);
    Route::get('/type/file', [ResponseController::class, 'responseFile']);
    Route::get('/type/download', [ResponseController::class, 'responseDownload']);
});

Route::middleware(["contoh:UJUN,401"])->group(function() {
    Route::get('/group/route/middleware/middleware/api', function(){
        return "OK";
    });
    Route::get('/group/route/middleware/middleware/group', function(){
        return "OK Group";
    });
});


Route::controller(CookieController::class)->group(function() {
    Route::get('/group/route/controller/cookie/set', 'createCookie');
    Route::get('/group/route/controller/cookie/get', 'getCookie');
    Route::get('/group/route/controller/cookie/clear', 'clearCookie');
});

Route::middleware(['contoh:UJUN,401'])->prefix("multiple-route-group/middleware")->group(function(){
    Route::get('/api', function(){
        return "OK";
    });
});

Route::get('/url/current', function() {
    return Illuminate\Support\Facades\URL::full();
});
Route::get('/url/current2', function() {
    return url()->full();
});

Route::get('/url/named', function(){
    return route('redirect-hello', ['name' => 'UJUN']);
});

Route::get('/url/action', function(){
    return action([FormController::class, 'form'], []);
});

Route::get('/session/create', [SessionController::class, 'createSession']);
Route::get('/session/get', [SessionController::class, 'getSession']);

Route::get('error/sample', function() {
    throw new Exception('Error Sederhana');
});

Route::get('/error/report', function() {
    report(new Exception("Error Manual Report"));
    return "NICE";
});

Route::get('/error/validation', function(){
    throw new ValidationException("Validation Error");
});

Route::get('/abort/400', function(){
    abort(400, "Bad Request 400");
});
Route::get('/abort/401', function(){
    abort(401);
});
Route::get('/abort/500', function(){
    abort(500);
});