<?php

class Programmer {
  var string $name;
  
  function __construct(string $name) {
    $this->name = $name;
  }
}

class ProgrammerFrontend extends Programmer{}

class ProgrammerBackend extends Programmer{}

class Company {
  public Programmer $programmer;
}

function sapa(Programmer $programmer) {
    echo "Apa kabar $programmer->name" . PHP_EOL ;
} 