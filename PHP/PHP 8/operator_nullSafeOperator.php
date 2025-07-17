<?php
/**
 * PHP sekarang memiliki nullsafe operator seperti bahasa pemrograman lain seperti kotlin, typescript, atau dart
 * Biasanya ketika kia ingin mengakses sesuatu dari object yang bisa memungkinkan null, maka kita akan melakukan pengecekan apakah 
   object tersebut null atau tidak, jika tidak baru kita akses object tersebut
 * Dengan nullsafe operator kita tidak perlu melakukan itu, kita hanya perlu menggunakan operator ?, secara otomatis PHP akan
   melakukan pengecekkan null tersebut
 * https://wiki.php.net/rfc/nullsafe_operator 
*/

class Alamat{
  public ?string $negara;
}

class Pengguna{
  public ?Alamat $alamat;
}

// contoh kode tanpa nullsafe operator
function getNegara1(?Pengguna $pengguna): ?string{
  if(!is_null($pengguna)) {
    if(!is_null($pengguna->alamat)) {
      return $pengguna->alamat->negara;
    }
  }
  return null;
}

// contoh kode pakai nullsafe operator
function getNegara2(?Pengguna $pengguna):?string {
  return $pengguna?->alamat?->negara;
}

$pengguna = new Pengguna();
$pengguna->alamat = new Alamat(); 
$pengguna->alamat->negara = "Indonesia"; 

echo getNegara1($pengguna) . PHP_EOL;
echo getNegara2($pengguna) . PHP_EOL;

$pengguna->alamat = null;
echo getNegara1($pengguna) . PHP_EOL;
echo getNegara2($pengguna) . PHP_EOL;


