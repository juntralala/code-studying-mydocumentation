<?php

require_once __DIR__ . "/../vendor/autoload.php";

use UjunAlRantaui\PHP\Login\Management\App\Router;
use UjunAlRantaui\PHP\Login\Management\Config\Database;
use UjunAlRantaui\PHP\Login\Management\Controller\HomeController;
use UjunAlRantaui\PHP\Login\Management\Controller\UserController;
use UjunAlRantaui\PHP\Login\Management\Middleware\MustLoginMiddleware;
use UjunAlRantaui\PHP\Login\Management\Middleware\MustNotLoginMiddleware;

Database::getConnection("production");

Router::add("GET", '/', HomeController::class, "index", []);
Router::add("GET", '/users/register', UserController::class, "register", [MustNotLoginMiddleware::class]);
Router::add("POST", '/users/register', UserController::class, "postRegister", [MustNotLoginMiddleware::class]);
Router::add("GET", '/users/login', UserController::class, "login", [MustNotLoginMiddleware::class]);
Router::add("POST", '/users/login', UserController::class, "loginPost", [MustNotLoginMiddleware::class]);
Router::add("GET", '/users/logout', UserController::class, "logout", [MustLoginMiddleware::class]);
Router::add("GET", '/users/profile', UserController::class, "updateProfile", [MustLoginMiddleware::class]);
Router::add("POST", '/users/profile', UserController::class, "postUpdateProfile", [MustLoginMiddleware::class]);
Router::add("GET", '/users/password', UserController::class, "updatePassword", [MustLoginMiddleware::class]);
Router::add("POST", '/users/password', UserController::class, "postUpdatePassword", [MustLoginMiddleware::class]);

Router::run();