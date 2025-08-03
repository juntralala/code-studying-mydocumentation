<?php

function increment(&$nomer) {
  $nomer++;
}


$angka = 0;

increment($angka);
echo $angka;