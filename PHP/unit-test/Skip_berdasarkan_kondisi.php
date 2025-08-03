<?php

/**
 * Ada banyak kondisi yang bisa di cek, seperti versi php, sistem operasi, dan lain-lain
 * PHPUnit mendukung melakukan skip unit test berdasarkan kondisi tertentu
 * Untuk melakukan skip berdasarkan kondisi, kita bisa menggunakan annotation @requires diikuti 
   dengan tipe kondisi
 * Beberapa kondisi mendukung operasi perbandingan
 */

// contohnya ada di CounterTest.php 

/*
 +===========+====================================================================================+
 | Type      | Possible Values                                                                    |
 +-----------+------------------------------------------------------------------------------------+
 | PHP       | Any PHP version identifier along with optional operator                            |
 | PHPUnit   | Any PHPUnit version identifier along with optional operator                        |
 | OS        | Aregexp maching PHP_OS                                                             |    
 | OSFAMILY  | Any OS Family                                                                      |    
 | function  | Any valid parameter to function_exists                                             |
 | extension | Any extention name along with an optional version identifier and optional operator |
 +===========+====================================================================================+
*/

