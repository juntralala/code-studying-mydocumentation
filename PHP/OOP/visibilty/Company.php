<?php

class Company {
  protected string $name;
  private string $founder;
  
  public function  __construct(string $name, string $founder) {
    $this->name = $name;
    $this->founder = $founder;
  }
  
  public function getName(): string {
  return $this->name;
}

  public function setName(string $name): void {
    $this->name = $name;
  }
  
  public function getFounder(): string {
  return $this->founder;
}

  public function setFounder(string $founder): void {
    $this->founder = $founder;
  }
  
}

class CompanyDummy extends Company {
  public function info(): void {
    echo "Company Name : ".$this->name.PHP_EOL;
//    echo "Founder Name : ".$this->founder.PHP_EOL; // error karena founder visibilitynya berupa protected
  }
}