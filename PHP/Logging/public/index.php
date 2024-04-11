<?php

require_once __DIR__ . "/../vendor/autoload.php";

use UjunAlRantaui\PHP\Logging\App\Router;
use UjunAlRantaui\PHP\Logging\Controller\HomeController;


Router::add("GET", "/", HomeController::class, "index");
Router::add("GET", "/ujun", HomeController::class, "ujun");

Router::run();