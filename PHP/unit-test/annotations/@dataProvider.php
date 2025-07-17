/**
 * Dalam membuat Unit test, sering terdapat kasus dimana kita ingin mengkombinasikan beberapa input data
 * Sebenarnya ini bisa dilakukan secara manual satu persatu
 * Hanya saja akan terlalu banyak hal yang harus kita tulis
 * PHPUnit mendukung fitur data provider, dimana kita membuat unit test dengan parameter, dan datanya di
   provide dari function lain 
 * Untuk melakukan ini, kita bisa gunakan annotation @dataProvider _providerFunction_
*/

// Contoh ada di MathTest.php