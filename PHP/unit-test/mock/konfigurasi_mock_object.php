<?php

/**
 * Konfigurasi mock object sama seperti dengan object, kita bisa menggunakan function method(name)
 * Hanya saja, sebelum  kita menggunakan function method(name), kita bisa menambahkan expects(invocationValue)
   sebagai ekspektasi / perikiraan berapa kali function dipanggil
 */

// contohnya ada di file ProductServiceMockTest.php

/* Invocation Rule
 +===================================+======================================+
 | TestCase InvocationRule Functions | Keterangan                           |
 +-----------------------------------+--------------------------------------+
 | any()                             | Berapa kali pun dipanggil            |
 | never()                           | Tidak pernah dipanggil               |
 | atLeast(number)                   | Minimal dipanggil                    |
 | atLeastOnce()                     | Minimal sekali dipanggil             |
 | once()                            | Satu kali dipanggil                  |
 | exactly(number)                   | Harus dipanggil sejunlah number      |
 | atMost(number)                    | Maksimal dipanggal sejumlah number   |
 +===================================+======================================+
*/