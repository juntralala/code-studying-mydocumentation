<?php

namespace UjunAlRantaui\PHP\Logging\App;

class Router {

    private static array $routes = [];

    public static function add(
            string $method,
            string $path,
            string $controller,
            string $function,
            array $middlewares =  []
    ) {
        self::$routes[] = [
            'method'    => $method,
            'path'      => $path,
            'controller'=> $controller,
            'function'  => $function,
            'middleware'=> $middlewares
        ];
    }

    public static function run(): void {
        $path = $_SERVER['PATH_INFO'] ?? "/";
        foreach(self::$routes as $route) {
            $pattern = "#^". $route['path'] ."$#";
            if(preg_match($pattern, $path, $variables) && $route['method'] == $_SERVER['REQUEST_METHOD']) {

                $controller = new $route['controller'];
                $function = $route['function'];
                
                array_shift($variables);
                call_user_func_array([$controller, $function], $variables);
                return;
            }
        }

        echo "PAGE NOT FOUND!";
        http_response_code(404);
    }

}