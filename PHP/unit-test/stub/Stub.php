<?php

/**
 * Saat akan membuat test untuk sebuah class, dan ternyata class tersebut membutuhkan dependency object lain, 
   maka kita bisa membuat object pengganti yang bisa kita konfigurasi agar sesuai dengan keinginan kita 
 * Teknik ini dinamakan stubbing, dan object penggantii yang kita buat disebut stub
 * PHPUnit mendukung pebuatan object stub secara mudah menggunakan function createStup(className) yang 
   terdapat di class TestCase  
 * method createStub() secara otomatis akan membuat object class atau interface yang kita inginkan dengan
   default implementation dari stub nya
 */

#  contohnya ada di Product.php 
#  contohnya ada di ProductRepository.php 
#  contohnya ada di ProductService.php 
#  contohnya ada di ProductServiceTest.php 