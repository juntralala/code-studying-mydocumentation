<?php

/**
 * Secara default saat kita membuat code program PHP, sebenarnya itu disimlan di global namespace
 * Global namespace adalah namespace yang tidak memiliki nama
 */
 
// echo "hello world" .PHP_EOL; // ini sebenarnya ada di Global namespace, jadi sama dengan kode di bawah
 
 namespace{ // code Global namespace
  echo "hello world" .PHP_EOL ;
 }
 
 