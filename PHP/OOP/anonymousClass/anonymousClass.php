<?php

/**
 * Anonymous class atau class tanpa nama
 * Ini adalah sebuah kemampuan mendeklarasikan class, sekaligus menginstansiasi objectnya secara langsung
 * Anonymous class sangat cocok ketika kita berhadapan dengan kasus membuat implementasi interface atau abstract class
   sederhana, tanpa harus membuat implementasi class nya
*/

interface Hallo {
  function hallo(string $name):void;
}

// tanpa constructor
$sapa = new class implements Hallo {
  function hallo(string $name):void {
    echo "hallo $name" .PHP_EOL;
  }
};

$sapa->hallo("Ujun");

// pakai constructor
$sapa2 = new class("Muhammad Junaidi") implements Hallo {
  function __construct(public string $name) {
  }
  function hallo(string $name):void {
    echo "hallo $name, my name is $this->name" .PHP_EOL;
  }
};

$sapa2->hallo("OZON");