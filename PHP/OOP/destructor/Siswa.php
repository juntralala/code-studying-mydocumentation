<?php

class Siswa {
  var string $nim;
  var string $name;
  
  function __construct(string $nim,string $name) {
    $this->nim = $nim;
    $this->name = $name;
  }
  
  function __destruct() {
    echo "$this->name object had destroyed\n";
  }
}