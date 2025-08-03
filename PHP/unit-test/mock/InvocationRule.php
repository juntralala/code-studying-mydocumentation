<?php

/**
 * InvocationRule digunakan untuk menjadi prameter bagi function expects yang ada didalam Mock Object 
 */

/*
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