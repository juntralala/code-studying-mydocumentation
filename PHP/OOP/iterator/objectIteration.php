<?php
/**
 * Setelah kita telah membuat object dari sebuah class, kita bjsa melakukan iterasi kesemua propertiesnya
   menggunakan foreach
 * Hal ini memudahkan kita ketika ingin mengakses semua propertiesnya yang ada pada object
 * secara default, hanya properties yang public saja yang bisa diakses foreach
*/

class Data {
  var string $first = "First";
  public string $second = "Second";
  protected string $third = "Third";
  private string $forth = "Forth";
}

$data = new Data();

foreach ($data as $value) {
  echo $value .PHP_EOL;
}

foreach ($data as $property => $value) {
  echo "$property => $value" .PHP_EOL;
}