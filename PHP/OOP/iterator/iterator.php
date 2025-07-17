<?php

/**
 * Sebelumnya kota menge-iterasi data properties secara otomatis menggunakan foreach
 * Jika ingin menangani hal ini secara manual, kita bisa menggunakan iterator
 * Iterator adalah interface yang digunakan untuk iterasi, namun membuat Iterator secara manual lumayan cukup ribet,
   oleh karna itu kita sekarang akan menggunakan ArrayIterator, yaitu iterator yang menggunakan array sebagai data iterasinya
 * Dana agar class bisa di iterasi secara manual, kita bisa menggunakan IteratorAgregate, disana kita hanya butuh meng-override
   function getIterator() yang me-return data iterator
*/

class Data implements IteratorAggregate{
  var string $first = "First";
  public string $second = "Second";
  protected string $third = "Third";
  private string $forth = "Forth";
  
  public function getIterator() {
    /* // membuat iterator secara manual tanpa yield
    $array = [
      "first" => $this->first,
      "second" => $this->second,
      "third" => $this->third,
      "forth" => $this->forth,
    ];
    return new ArrayIterator($array);
    */ 
    yield "first" => $this->first;
    yield "second" => $this->second;
    yield "third" => $this->third;
    yield "forth" => $this->forth;
  }
}


$data = new Data();

foreach ($data as $value) {
  echo $value .PHP_EOL;
}

foreach ($data as $property => $value) {
  echo "$property => $value" .PHP_EOL;
}
