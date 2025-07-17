/**
 * Apa yang terjadi jika kita menguji sebuah fitur, namun fitur resebut tidak mengembalikan data apapun
 * Misalnya hanya melakukan echo saja
 * PHPUnit memiliki fitur untuk medeteksi output, dengan demikian kita bisa memastikan bahwa output yang
   dihasilkan sesuai dengan yang kita inginkan
 * Untuk melakukan kita kita bisa menggunakan Assert::expectOutputString('teks');
*/

// contoh ada di PersonTest.php