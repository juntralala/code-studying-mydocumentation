<?php
/*  Session & Cookie
 * Sebelumnya kita sudah belajar session di PHP, sebenarnya id session di PHP disimpan di cookie 
 * Ketika kita membuat session, PHP akan membuat session id, cookie session id tersebut digunakan sebagai
   id untuk file session di server PHP
 * Ketika web browser mengirim cookie berisi session id tersebut, PHP akan mengecek apakah nama file dengan
   session id tersebut ada atau tidak. Jika ada, otomatis session nya valid dan akan diambil semua data
   session di dalam file tersebut
 */