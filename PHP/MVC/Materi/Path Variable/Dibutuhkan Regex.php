/** Regex
 * Pada kelas PHP OOP, kita sudah belajar tentang Regex
 * Pada Path Variable ini, kita membutuhkan Regex agar Path pada Router bisa mendukung Path Variable 
 */

<?php
// contoh Kode : mencoba regex
$path = "/products/12345/category/abcdefg";
// awal dan akhir tidak menggunakan / karena / banyak digunakan di URL
$pattern = "#^/products/([0-9a-zA-Z]*)/categories/([0-9a-zA-Z]*)$#";
if(preg_match($pattern, $path, $variables)){
    echo var_dump($variables);
}

/*
// Kode: mengimplementasikan regex pada router untuk mendukung Parameter Path
public static function run(): void {
    $path = $_SERVER['PATH_INFO'] ?? "/";
    $method = $_SERVER['REQUEST_METHOD'];

    foreach(self::$routes as $route){
      $pattern = "#^" . $route['path'] . "$#";
      if(preg_match($pattern, $path, $variables) && $method == $route['method']){
        $controller = new $route['controller'];
        $function = $route['function'];
        $controller->$function();
        return;  
      }
    }

    http_response_code(404);
    echo "CONTROLLER NOT FOUND";
  }

*/