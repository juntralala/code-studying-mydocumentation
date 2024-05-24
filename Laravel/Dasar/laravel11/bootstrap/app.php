<?php

use App\Exceptions\ValidationException;
use App\Http\Middleware\ContohMiddleware;
use Illuminate\Foundation\Application;
use Illuminate\Foundation\Configuration\Exceptions;
use Illuminate\Foundation\Configuration\Middleware;
use Illuminate\Http\Request;

return Application::configure(basePath: dirname(__DIR__))
    ->withRouting(
        web: __DIR__.'/../routes/web.php',
        commands: __DIR__.'/../routes/console.php',
        health: '/up',
    )
    ->withMiddleware(function (Middleware $middleware) {
        $middleware->alias([
            "contoh" => ContohMiddleware::class,
        ]);
        $middleware->appendToGroup("UJUN", [
            "contoh:UJUN,401",
        ]);
    })
    ->withExceptions(function (Exceptions $exceptions) {
        $exceptions->dontReport([
            ValidationException::class
        ]);

        $exceptions->renderable(function(ValidationException $e, Request $request){
            return response("Bad Request", 400);
        });

        $exceptions->reportable(function (Throwable $e) {
            // var_dump($e);
            print("<br><br><br><h1>Report Error 1</h1>");
            return false; // semua reportable di bawahnya tidak akan di eksekusi
        });
        $exceptions->reportable(function (Throwable $e) {
            print("<h1>Report Error 2</h1>");
        });
        $exceptions->reportable(function (Throwable $e) {
            print('<h1>Report Error 3</h1>');
        });
    })->create();
