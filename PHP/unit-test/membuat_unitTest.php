/**
 * Untuk membuat unit test, kita akan membuat class turunan dari PHPUnit\FrameWork\TestCase
 * Biasanya pembuatan unit test mengikuti class yang akan kita test
 * misal kita memiliki class Person, maka untuk unit testnya kita, akan membuat class PersonTest
 * Dan untuk skenario unit test nya, akan kita simpan dalam public function dengan awalan test*, misal 
   testCreate(), testXxx(), testZzz(). Atau jika tidak menggunakan awalan test*, kita juga bisa menambahkan
   @test pada function yang akan kita gunakan sebagai unit test
*/

// Contohya di CounterTest.php