<?php

// liat isi file ServiceTest.php dulu
// bagian di function testDeleteFailed()

/**
 * Sekilas, unit test yang kita buat seperti tidak ada masalah
 * Tapi coba kita ubah implementasi class Servicenya (file Serivce.php)
 * Misal, kita panggil $this->repository->delete() lebih dari satu kali
 * Atau bahkan kita hapus baris kode $this->repository->delete()
 * Hasilnya, yang seharunya ada unit-test yang gagal, malah semua unit-test akan tetap sukses, dan artinya
   terdapat kesalahan dalam unit-test kita 
 */