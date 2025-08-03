<?php
/** Router
 * Setelah kita mengerti cara kerja Router, saatnya kita membuat Router yang lebih kompleks
 * Router sebelumnya sangat sederhana, hanya meneruskan PATH_INFO ke file php yang dituju, sedangkan dalam
   MVC, Router seharusnya meneruskan PATH_INFO menuju class Controller yang dituju
 * Jadi sekarang kita akan coba buat class Router untuk melakukan manajement Routing 
 */





// Contoh kode Router
namespace UjunAlRantaui\Belajar\PHP\MVC\App;

class Router {
    private static array $routes = [];
    
    public static function add(string $method, string $path, string $controller, string $function): void{
        self::$routes[] = [
            'method' => $method,
            'path' => $path,
            'controller' => $controller,
            'function' => $function
        ];
    }

    public static function run(): void {
      $path = $_SERVER['PATH_INFO'] ?? "/";
      $method = $_SERVER['REQUEST_METHOD'];

      foreach(self::$routes as $route){
        if($path == $route['path'] && $method == $route['method']){
          echo "CONTROLLER : " . $route['controller']. ", FUNCTION : " . $route['function'];
          return;  
        }
      }

      http_response_code(404);
      echo "CONTROLLER NOT FOUND";
    }

}