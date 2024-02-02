/**
 * Sekarang pertanyaannya, bagaimana cara menginisialisasi data static tersebut? Karena kita tidak 
   bisa menggunakan setUp() method, karena bukan static function
 * Untungnya PHPUnit mendukung sharing fixture seperti ini, nama function nya adalah :
 * static function setUpBeforeClass() untuk setup diawal ketika class unit test dieksekusi, atau 
   menggunakan @beforeClass
 * static function tearDownAfterClass() untuk dipanggil diakhir ketika class unit test selesai, atau 
   menggunakan @afterClass
 * Sharing fixture hanya dieksekusi sekali diawal dan diakhir, walaupun di class unit test terdapat 
   banyak function unit test
 */

// contohnya ada di CounterStaticTest.php
