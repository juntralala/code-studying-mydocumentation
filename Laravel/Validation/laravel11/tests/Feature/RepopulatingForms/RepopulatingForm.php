<?php

/** Repopulating Form
 * Saat kita melakukan submit form, lalu terjadi error validasi, kadang kita tidak ingin menghapus data sebelumnya
   yang sudah di input 
 * Untungnya, ketika terjadi ValidationException, Laravel menyimpan data yang dikirim ke Session juga sementara
 * Kita bisa menggunakan method old() di Request, atau global function old di Blade template untuk mendapatkan data
   lama
*/

// contoh ada di resource/views/Login/form.blade.php