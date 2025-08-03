/** SKIP TEST
 * Kadang ada masalah ketika membuat unit test, sehingga kita ingin men-disabled unit test yang 
   sudah ada
 * Saat ingin men-disabled unit test, kadang kita melakukan hal seperti, mengubah nama function 
   sehingga tidak diawali dengan test atau menghapus @test jika menggunakan annotation
 * Hanya saja masalahnya jika itu kita lakukan, secara otomatis unit test akan hilang dari laporan 
   PHPUnit, dan jika kita lupa, bisa saja unit test tersebut akan ter-disabled selamanya
 * Cara yang baik jika ada unit test yang memang ingin kita disabled adalah dengan menggunakan 
   Assert::markTestSkipped(), dimana nanti akan terdapat laporan dari PHPUnit bahwa unit test 
   tersebut kita skip
 */

//contohnya ada di CounterTest.php 
/**
 * Menggunakan function markTestSkipped() akan menghasilkan error SkippedTestError
 * Oleh karena itu, kode dibawahnya tidak akan dieksekusi
 */