<?php

/** Test Exception
 * Saat Membuat unit test, pastika kita tidak hanya membuat unit test dengan skenario benar
 * Kita jua ajib membuat unit test dengan skenario salah atau gagal
 * Salah satunya saat kita membuat skenario salah, kita sering menggunakan Exception
 * PHPUnit memiliki fitur assertion untuk memastikan bahwa sebuah exception harus terjadi
 * Jika terjadi, maka unit test akan gagal
 * Kita bisa menggunakan function Assert::expectExcpetion(ClassException::class) jika ingin memastikan
   bahwa sebuah exception yang kita perikirakan terjadi pada unit test
 */

// contohnya ada di class PersonTest.php