<?php

require_once __DIR__ . "/../vendor/autoload.php";

use UjunAlRantaui\Belajar\PHP\MVC\App\Router;
use UjunAlRantaui\Belajar\PHP\MVC\Controller\AuthController;
use UjunAlRantaui\Belajar\PHP\MVC\Controller\HomeController;
use UjunAlRantaui\Belajar\PHP\MVC\Controller\ProductController;
use UjunAlRantaui\Belajar\PHP\MVC\Middleware\AuthMiddleware;
use UjunAlRantaui\Belajar\PHP\MVC\Middleware\LoginMiddleware;

Router::add('POST', '/login', AuthController::class, 'login', [LoginMiddleware::class]);
Router::add('GET', '/login', AuthController::class, 'login', [LoginMiddleware::class]);
Router::add('GET', '/', HomeController::class, 'index');
Router::add('GET', '/hello', HomeController::class, 'hello', [AuthMiddleware::class]);
Router::add('GET', '/sapa', HomeController::class, 'sapa', [AuthMiddleware::class]);
Router::add('GET', '/products/([0-9a-zA-Z]*)/categories/([0-9a-zA-Z]*)', ProductController::class, 'categories', [AuthMiddleware::class]);

Router::run();