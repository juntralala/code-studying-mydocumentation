/** Test Dependency
 * Pada saat membuat unit test, kadang kita ingin melanjutkan unit test sebelumnya atau bahkan tergantung
   dengan unit test sebelumnya 
 * Untk melakukan itu, kita bisa gunakan annotations :  @depends _namaUnitTest_
*/

/** Perhatian
 * Unit test yang baik harus independen, tidak bergantung dengan unit test lainnya
 * Jika kita memebuat unit test yang tergantung dengan unit test lain, maka jika unit test sebelumnya error
   maka unit test selanjutnya akan error juga
*/