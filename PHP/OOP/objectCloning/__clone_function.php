<?php
/**
 * Kadang menyalin semua properties bukanlah yang kita inginkan
 * Misal kita hanya ingin menyalin beberapa properties saja, bukan semuanya
 * Jika ingin memodifikasi cara PHP makukan clone, kota bisa menambahkan kedalam
   class nya function dengan nama __clone();
 * function __clone() akan dipanggail di object hasil duplikasi setelah duplikasi selesai
 * Jika kita ingin menghapus beberapa properties, kita bisa lakukan di function _clone()
*/

class Account {
  function __construct(
    public string $id,
    public string $username,
    public string $password,
    public string $email
  ) {}
  
  function __clone() {
    unset($this->id);
    unset($this->password);
  }
}


// =======================≠============
$akun = new Account("A0001", "Ozon", "rahasia", "ozon@mail.com");
echo var_dump($akun);

$akun2 = clone $akun;
echo var_dump($akun2);