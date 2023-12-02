<?php
/**
 * Sebelumnya kita tahu bahwa untuk membuat object yang bisa di iterasi, kita menggunakan Iterator
 * Namun pembuatan Iterator secara manual sangatlah rumit/ribet
 * Untungnya di PHP terdapat fitur generator yang bisa kota gunakan untuk membuat Iterator secara otomatis
   hanya dengan menggunakan keyword yield
*/

// contoh membuat iteraor pakai array
function getGenap(int $angka) {
  for ($i=1 ; $i<=$angka ; $i++) {
    if($i % 2 == 0) $array[] = $i;
  }
  return new ArrayIterator($array);
}

// contoh membuat iterator pakai yield
function getGanjil(int $angka):iterator {
  for ($i=1 ; $i<=$angka ; $i++) {
    if($i % 2 == 1) yield $i;
  }
}



foreach(getGenap(10) as $genap) {
  echo "Genap : $genap" .PHP_EOL;
}

foreach(getGanjil(10) as $ganjil) {
  echo "Ganjil : $ganjil" .PHP_EOL;
}

