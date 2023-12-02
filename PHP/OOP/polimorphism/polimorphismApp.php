<?php

require_once "Manager.php";
require_once "Programmer.php";

$manager = new Manager();
$manager = new VisePresident();
$manager = new President();

$programmer = new Programmer("ujun");
$programmer = new ProgrammerFrontend("ujun");
$programmer = new ProgrammerBackend("ujun");

// Polimorphisme pada property didalam class
$com = new Company();
$com->programmer = new Programmer("Junaidi");
$com->programmer = new ProgrammerFrontend("Junaidi");
$com->programmer = new ProgrammerBackend("Junaidi");

// Polimorphisme pada argument/parameter
sapa(new Programmer("Muhammad Junaidi"));
sapa(new ProgrammerFrontend("Muhammad Junaidi"));
sapa(new ProgrammerBackend("Muhammad Junaidi"));

echo "Semua sukses" .PHP_EOL;