<?php

class Human {
  function __construct(
    public string $name,
    public string $crop,
    public int $fieldSize
  ) {}
  
  function __toString(){
    return "[name=$this->name, crop=$this->crop, fieldSize=$this->fieldSize]";
  }
  
  function __invoke(...$args) {
    $join = join(", ", $args);
    return "invoke human with argument $join";
  }
  
  function __debugInfo():array {
    return [
      "name" => $this->name,
      "crop" => $this->crop,
      "fieldSize" => $this->fieldSize,
      "author" => "ujun",
      "version" => "1.0.0"
    ];
  }
}