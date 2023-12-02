<?php
/** Trait Conflict
 * Jika menggunakan lebih dari satu trait lalu ada function yang sama pada trait-trait tersebut,
   Maka hal tersebut akan menyebabkan conflict
 * Kalau terjadi konflik seperti ini, kita bisa mengatasinya menggunakan keyword insteadof
*/

trait A {
  function doSomething() {echo "A - Do something" .PHP_EOL;}
  function doAnything() {echo "A - Do Anything" .PHP_EOL;}
}

trait B {
  function doSomething() {echo "B - Do something" .PHP_EOL;}
  function doAnything() {echo "B - Do Anything" .PHP_EOL;}
}

class Sample {
  use A, B {
    A::doSomething insteadof B;
    B::doAnything insteadof A;
  }
}

// ========================================================

$contoh = new Sample();
$contoh->doSomething();
$contoh->doAnything();

