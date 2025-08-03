<?php
/* Masalah dengan Session di PHP
 * PHP menyimpan session di File
 * Hal ini tidak direkomendasikan untuk menyimpan data yang terlalu besar disession, karena setiap kita
   melakukan session_start(), maka secara otomatis session akan diload dari file, dan setelah request
   selesai, session akan disave di file
 * Selain itu penggunaan File juga menyebabkan masalah scalability, karena jika kita menjalankan 2 WEB PHP
   secara bersamaan di server yang berbeda, bisa jadi session nya menghilang ketika request cient masuk ke
   server yang berbeda
 * Oleh karena itu, penggunaan session di PHP sebenarnya jarang sekali digunakan di WEB yang sudah besar,
   Biasanya, akan akan menggunakan alternatif lain untuk manajement session, seperi Secure Cookie atau
   JWT (Json Web Token)
 * Oleh karena itu juga, framework seperti Laravel dan CodeIgniter tidak menggunakan session management
   bawaan PHP, tetapi membuat session mereka sendiri
 */