/**
 * Pada kode unit test kita sebelumnya, terdapat peringantan bahwa bahaw unit test tidak memiliki assertions
 * Apa itu Assertions?
 * Assertion adalah pengecekan apakah sebuah kondisi sudah terpenuhi, jika kondisi tidak terpenuhi maka,
   unit testnya kita anggap gagal
*/

/** Class Assert 
 * Untuk melakukan assertions, kita tidak perlu melakukan nya secara manual menggunakan if else, kita bisa
   kita bisa manfaatkan class yang sudah disediakan oleh PHPUnit, yaitu PHPUnit\Framework\Assert
 * Class Assert berisi banyak sekali static function, dan kita gunakan sesuai kebutuhan
 * Saat kondisi pada assertions tidak terpenuhi, secara otomatis akan terjadi error, dan unit test dianggap 
   gagal
 * detailnya di : https://phpunit.readthedocs.io/en/9.5/assertions.html
*/ 

// contoh penggunaan assrtion ada di CounterTest.php 