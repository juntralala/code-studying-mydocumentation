<?php
 /**
  * Sebelumnya, kita telah mengenal konversi tipe data bukan class
  * Kusus tipe data object kita tidak perlu melakukan konversi tipedata secara explisit
  * Namun agar aman, sebelum melakukan cast, kita lakukan type check (pengecekan tipe data) dengan menggunakan keyword instanceof
  * Hasil instanceof adalah boolean, true jika benar dan false jika salah
 */
 
 require_once "./polimorphism/Programmer.php";
 
 function intro(Programmer $programmer) {
   if($programmer instanceof ProgrammerFrontend) {
     echo "I am ProgrammerFrontend" .PHP_EOL;
   } else if($programmer instanceof ProgrammerBackend) {
     echo "I am ProgrammerBackend" .PHP_EOL ;
   } else if($programmer instanceof Programmer) {
     echo "I am Programmer" .PHP_EOL ;
   } else {
     echo "Bukan Programmer" .PHP_EOL;
   }
 }
 
 intro(new ProgrammerFrontend("ujun"));
 intro(new ProgrammerBackend("ujun"));
 intro(new Programmer("ujun"));
 