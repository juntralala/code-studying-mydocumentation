<?php
/**
 * Saat kita membuat aplikasi, kita tidak akan terhindar dengan yang namanya error
 * Di PHP, error di representasikan dengan istilah exception, dan semua direpresentasikan dalam bentuk class exception
 * Kita bisa menggunakan class exception buatan kita sendiri, atau yang sudah disediakan oleh php
 * Jika ingin embuat exception, maka kita harus membuat class yang implement interdace Thowable atau turunannya 
   tapi ini tidak disarankan, karna banyak sekali method yang harus di override, jadi kita akan mengunakan turunannya saja
*/

/** Membuat Exception
 * Exception biasanya terjadi di function
 * Didalam kode program kita untuk membuat exception kita cukup menggunakan kata kunci throw, diikuti dengan object exception nya
*/

require_once "LoginRequest.php";
require_once "Validation.php";

$loginRequest = new LoginRequest();
// $loginRequest->username = "UJUN";
// $loginRequest->password = "UJUN";

try {
    validateLoginRequest($loginRequest);
    echo "VALID" . PHP_EOL;
} catch (ValidationException $e) {
    echo "Validation Error : {$e->getMessage()}" . PHP_EOL;
} catch (Exception $e) {
    echo "Error : {$e->getMessage()}" . PHP_EOL;
}


echo "\n\nmengabung exception dalam 1 catch\n"; 
try {
    validateLoginRequest($loginRequest);
    echo "VALID" . PHP_EOL;
} catch (ValidationException | Exception $e) {
    echo "Validation Error : {$e->getMessage()}" . PHP_EOL;

    var_dump( $e->getTrace());                              // conth getTrace() 
    echo $e->getTraceAsString();                              // conth getTraceAsString() 

} finally {
    echo "ini selalu di eksekusi mau terjadi error atau tidak\n";
}