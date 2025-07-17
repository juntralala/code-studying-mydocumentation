<?php
/*
require dan include fungsinya sama seperti import di python

perbedaannya :
require program akan BERHENTI jika file tidak ditemukan
include program TIDAK BERHENTI meskipun file tidak ditemukan
*/

require "lib/myFunction.php";
include "lib/myFunction.php";

echo sayHello("UJUN");