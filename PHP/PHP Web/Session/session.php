<?php
/*  Session
 * Session adalah mekanisme yang biasa digunakan untuk mengingat interaksi sebelumnya dari Client
 * Di spesifikasi HTTP, tidak dikenal yang namanya session, karena HTTP didesain stateless (tidak menyimpan
   state, data, atau informasi apapun)
 * Session adalah teknik dimana kita menyimpan informasi client di server, sehingga ketika ada request dari
   client yang sama, kita bisa tahu dari server
 * Contohnya session biasanya digunakan ketika proses login, setelah login sukses, kita akan membuat session,
   dan request selanjutnya dari client akan membawa informasi session tersebut
 */